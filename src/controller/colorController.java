package controller;

import domain.Cube;
import domain.Side;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class colorController {
	private static final int QUARTER_ROTATE = 3;
	private static final int HALF_ROTATE = 6;

	private static String joinFourSides(List<Side> sides, String partOfSide) {
		return sides.stream()
				.map(side -> side.getString(partOfSide))
				.collect(Collectors.joining(""));
	}

	public static String createConcatenatedColors(Cube cube, String fullCommand) {
		List<Side> sides = cube.getSidesToChange(fullCommand);
		String partOfSide = Controls.getControl(fullCommand).getPartOfSide();
		return joinFourSides(sides, partOfSide);
	}

	private static int getNumberOfPush(String fullCommand) {
		if (CommandComponents.isHalfRotate(fullCommand)) {
			return HALF_ROTATE;
		}
		return QUARTER_ROTATE;
	}

	public static String push(String fullCommand, String concatenatedColors) {
		int cut = Math.abs(getNumberOfPush(fullCommand)) % concatenatedColors.length();
		if (cut == 0) {
			return concatenatedColors;
		}
		if (CommandComponents.isClockWise(fullCommand)) {
			// push to right
			return concatenatedColors.substring(concatenatedColors.length() - cut) + concatenatedColors.substring(0, concatenatedColors.length() - cut);
		}
		// push to left
		return concatenatedColors.substring(cut) + concatenatedColors.substring(0, cut);
	}

	private static List<String> cutColors(String pushedColors) {
		return Arrays.asList(pushedColors.split("(?<=\\G.{3})")); // cut colors by 3
	}

	public static void renewSides(Cube cube, String fullCommand, String pushedColors) {
		String partOfSide = Controls.getControl(fullCommand).getPartOfSide();
		List<Side> sidesToChange = cube.getSidesToChange(fullCommand);
		List<String> colorChunks = cutColors(pushedColors);
		for (int i = 0; i < sidesToChange.size(); i++) {
			sidesToChange.get(i).setString(partOfSide, colorChunks.get(i));
		}
	}
}