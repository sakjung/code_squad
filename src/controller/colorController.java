package controller;

import domain.Cube;
import domain.Side;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class colorController {
	private static final int QUARTER_ROTATE = 3;
	private static final int HALF_ROTATE = 6;
	private static final int ONCE = 1;
	private static final int TWICE = 2;

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

	public static String pushString(String fullCommand, String concatenatedColors) {
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

	private static List<Side> rotateOrder(List<Side> sides, String fullCommand) {
		if (CommandComponents.isClockWise(fullCommand)) {
			if (CommandComponents.isHalfRotate(fullCommand)) {
				Collections.rotate(sides,TWICE);
				return sides;
			}
			Collections.rotate(sides,ONCE);
			return sides;
		}
		if (CommandComponents.isHalfRotate(fullCommand)) {
			Collections.rotate(sides,-TWICE);
			return sides;
		}
		Collections.rotate(sides,-ONCE);
		return sides;
	}

	public static void renewColorsOfSides(Cube cube, String fullCommand, String pushedColors) {
		String partOfSide = Controls.getControl(fullCommand).getPartOfSide();
		// 사이드 순서 2번 밀고 set
		// 사이드 order 1번 밀고 set


	}
}