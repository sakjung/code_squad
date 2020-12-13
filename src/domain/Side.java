package domain;

import controller.CommandComponents;

public class Side {
	private static final int SIZE = 3;
	private static final int CHANGE = 1;
	private static final String QUIT_MESSAGE = "Bye~";

	/* CUBE
	 * R R W
	 * G C W
	 * G B B */

	private final String locationInCube;
	private final String[][] side;

	public Side(String locationInCube, String color) {
		this.locationInCube = locationInCube;
		this.side = createSide(color);
	}

	public String getLocationInCube() {
		return locationInCube;
	}

	private String[][] createSide(String color) {
		String[][] side = new String[3][3];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				side[i][j] = color;
			}
		}
		return side;
	}

	public void showSide() {
		for (String[] row : side) {
			System.out.println(String.join(" ", row));
		}
	}

	private String getRightString() {
		String string = "";
		for (String[] row : side) {
			string += row[2];
		}
		return string;
	}

	private void setRightString(String stringPushed) {
		char[] newStrings = stringPushed.toCharArray();
		for (int row = 0; row < SIZE; row++) {
			side[row][2] = String.valueOf(newStrings[row]);
		}
	}

	private String getLeftString() {
		String string = "";
		for (String[] row : side) {
			string += row[0];
		}
		return string;
	}

	private void setLeftString(String stringPushed) {
		char[] newStrings = stringPushed.toCharArray();
		for (int row = 0; row < SIZE; row++) {
			side[row][1] = String.valueOf(newStrings[row]);
		}
	}

	private String getUpperString() {
		return String.join("", side[0]);
	}

	private void setUpperString(String stringPushed) {
		char[] newStrings = stringPushed.toCharArray();
		for (int col = 0; col < SIZE; col++) {
			side[0][col] = String.valueOf(newStrings[col]);
		}
	}

	private String getBottomString() {
		return String.join("", side[2]);
	}

	private void setBottomString(String stringPushed) {
		char[] newStrings = stringPushed.toCharArray();
		for (int col = 0; col < SIZE; col++) {
			side[2][col] = String.valueOf(newStrings[col]);
		}
	}

	public String getString(String partOfSide) {
		// U B R L Q
		if (partOfSide.equalsIgnoreCase(CommandComponents.U.getCommandComponent())) {
			return getUpperString();
		}
		if (partOfSide.equalsIgnoreCase(CommandComponents.D.getCommandComponent())) {
			return getBottomString();
		}
		if (partOfSide.equalsIgnoreCase(CommandComponents.R.getCommandComponent())) {
			return getRightString();
		}
		if (partOfSide.equalsIgnoreCase(CommandComponents.L.getCommandComponent())) {
			return getLeftString();
		}
		if (partOfSide.equalsIgnoreCase("Q")) {
			System.out.println(QUIT_MESSAGE);
			System.exit(0);
		}
		throw new IllegalArgumentException();
	}

	public void setString(String command, String stringPushed) {
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
}
