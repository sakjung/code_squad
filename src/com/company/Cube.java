package com.company;

public class Cube {
	private static final int SIZE = 3;
	private static final int CHANGE = 1;
	private static final String QUIT_MESSAGE = "Bye~";

	/* CUBE
	 * R R W
	 * G C W
	 * G B B */

	private final String[][] cube = {
			{"R", "R", "W"},
			{"G", "C", "W"},
			{"G", "B", "B"}
	};

	public void showCube() {
		for (String[] row : cube) {
			System.out.println(String.join(" ", row));
		}
	}

	private String getRightString() {
		String string = "";
		for (String[] row : cube) {
			string += row[2];
		}
		return string;
	}

	private void setRightString(String stringPushed) {
		char[] newStrings = stringPushed.toCharArray();
		for (int row = 0; row < SIZE; row++) {
			cube[row][2] = String.valueOf(newStrings[row]);
		}
	}

	private String getLeftString() {
		String string = "";
		for (String[] row : cube) {
			string += row[0];
		}
		return string;
	}

	private void setLeftString(String stringPushed) {
		char[] newStrings = stringPushed.toCharArray();
		for (int row = 0; row < SIZE; row++) {
			cube[row][1] = String.valueOf(newStrings[row]);
		}
	}

	private String getUpperString() {
		return String.join("", cube[0]);
	}

	private void setUpperString(String stringPushed) {
		char[] newStrings = stringPushed.toCharArray();
		for (int col = 0; col < SIZE; col++) {
			cube[0][col] = String.valueOf(newStrings[col]);
		}
	}

	private String getBottomString() {
		return String.join("", cube[2]);
	}

	private void setBottomString(String stringPushed) {
		char[] newStrings = stringPushed.toCharArray();
		for (int col = 0; col < SIZE; col++) {
			cube[2][col] = String.valueOf(newStrings[col]);
		}
	}

	private String getString(String command) {
		// U B R L Q
		String firstCommandComponent = String.valueOf(command.charAt(0));
		if (firstCommandComponent.equalsIgnoreCase("U")) {
			return getUpperString();
		}
		if (firstCommandComponent.equalsIgnoreCase("B")) {
			return getBottomString();
		}
		if (firstCommandComponent.equalsIgnoreCase("R")) {
			return getRightString();
		}
		if (firstCommandComponent.equalsIgnoreCase("L")) {
			return getLeftString();
		}
		if (firstCommandComponent.equalsIgnoreCase("Q")) {
			System.out.println(QUIT_MESSAGE);
			System.exit(0);
		}
		throw new IllegalArgumentException();
	}

	private boolean isLeft(String command) {
		// if char comes with ' = right -> if string length is 2 = right / 1 = left
		return command.length() == 1;
	}

	private String pushString(String command) {
		String string = getString(command);
		int cut = Math.abs(CHANGE) % SIZE; // cut = 1
		if (isLeft(command)) {
			return string.substring(cut) + string.substring(0, cut);
		}
		return string.substring(string.length() - cut) + string.substring(0, string.length() - cut);
	}

	private void setString(String command, String stringPushed) {
		System.out.println();
		System.out.println(command);
		String firstCommandComponent = String.valueOf(command.charAt(0));
		if (firstCommandComponent.equalsIgnoreCase("U")) {
			setUpperString(stringPushed);
			return;
		}
		if (firstCommandComponent.equalsIgnoreCase("B")) {
			setBottomString(stringPushed);
			return;
		}
		if (firstCommandComponent.equalsIgnoreCase("R")) {
			setRightString(stringPushed);
			return;
		}
		if (firstCommandComponent.equalsIgnoreCase("L")) {
			setLeftString(stringPushed);
			return;
		}
		throw new IllegalArgumentException();
	}

	public void changeCube(String command) {
		// push string according to command
		String stringPushed = pushString(command);
		// put it back to cube
		setString(command, stringPushed);
	}
}
