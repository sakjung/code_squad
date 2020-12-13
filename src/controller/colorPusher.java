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

	public void pushString(String command, String string) {
		int cut = Math.abs(numberOfPush) % string.length();
		if (cut == 0) {
			return;
		}
		if (CommandComponents.isClockWise(command)) {
			// push to left
			string = string.substring(cut) + string.substring(0, cut);
			return;
		}
		// push to right
		string = string.substring(string.length() - cut) + string.substring(0, string.length() - cut);
	}

	public String getString() {
		return string;
	}
}