package controller;

import domain.Cube;
import domain.Side;

import java.util.List;
import java.util.stream.Collectors;

public class colorPusher {
	private static final int QUARTER_ROTATE = 3;
	private static final int HALF_ROTATE = 6;

	private String joinFourSides(List<Side> sides, String colorPosition) {
		return sides.stream()
				.map(side -> side.getString(colorPosition))
				.collect(Collectors.joining(""));
	}

	private String createConcatenatedColors(Cube cube, String fullCommand) {
		List<Side> sides = cube.getSidesToChange(fullCommand);
		String colorPosition = Controls.getControl(fullCommand).getColorPosition();
		return joinFourSides(sides, colorPosition);
	}

	private int getNumberOfPush(String fullCommand) {
		if (CommandComponents.isHalfRotate(fullCommand)) {
			return HALF_ROTATE;
		}
		return QUARTER_ROTATE;
	}

	public String pushString(String fullCommand, String concatenatedColors) {
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
}