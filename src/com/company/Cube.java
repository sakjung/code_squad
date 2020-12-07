package com.company;

public class Cube {
	private static final int SIZE = 3;
	private static final int CHANGE = 1;

	/* CUBE
	* R R W
	* G C W
	* G B B */

	String[][] cube = {
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

	public void pushString() {
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
