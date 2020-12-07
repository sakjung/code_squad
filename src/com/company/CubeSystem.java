package com.company;

import java.util.List;
import java.util.Scanner;

public class CubeSystem {
	private static final String CLI = "CUBE JOA> ";

	public static void playCube(Cube cube, Scanner scanner) {
	}

	private static char[] getCommands(Scanner scanner) {
		System.out.print(CLI);
		return scanner.nextLine().toCharArray();
	}
}
