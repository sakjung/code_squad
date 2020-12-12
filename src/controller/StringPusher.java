package controller;

import domain.Side;

import java.util.List;

public class StringPusher {
	private static final int QUARTER_ROTATE = 3;
	private static final int HALF_ROTATE = 6;

	private String string;
	private int numberOfPush;
	private String direction;

	// concat colors
	private String concatenateColors(String command, List<Side> sides) {

		if (Commands.isLeft()) {

		}
	}

	private boolean isLeft() {
		// positive + l || negative + r
		return !direction.equalsIgnoreCase(Commands.TO_RIGHT.command());
	}

	public void pushString() {
		int cut = Math.abs(numberOfPush) % string.length();
		if (cut == 0) {
			return;
		}
		if (isLeft()) {
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