package controller;

import domain.Side;

import java.util.List;

public class StringPusher {
	private static final int QUARTER_ROTATE = 3;
	private static final int HALF_ROTATE = 6;

	private String string;
	private int numberOfPush;
	private String direction;

	// what we need
	// direction -> which part of side

	// concat colors
	private String concatenateColors(String command, List<Side> sides) {
		// wow
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