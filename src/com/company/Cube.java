package com.company;

public class Cube {
	private static final int SIZE = 3;
	private static final int CHANGE = 1;

	/* CUBE
	* R R W
	* G C W
	* G B B */

	private String[][] cube = {
			{"R", "R", "W"},
			{"G", "C", "W"},
			{"G", "B", "B"}
	};

	public String[][] getCube() {
		return cube;
	}

	public void showCube() {
		for (String[] row : cube) {
			System.out.println(String.join(" ", row));
		}
	}

	private boolean isLeft() {
		// if char comes with ' = right -> if string length is 2 = right

	}

	public void pushString(String string) {
		int cut = Math.abs(CHANGE) % SIZE;
		if (isLeft()) {
			// push to left
			string = string.substring(cut) + string.substring(0, cut);
			return;
		}
		// push to right
		string = string.substring(string.length() - cut) + string.substring(0, string.length() - cut);
	}

}
