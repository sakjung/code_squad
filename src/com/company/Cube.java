package com.company;

public class Cube {
	private static final int CUBE_SIZE = 3;
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
}
