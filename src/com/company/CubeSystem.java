package com.company;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class CubeSystem {
	private static final String CLI = "CUBE JOA> ";

	public static void playCube(Cube cube, Scanner scanner) {
	}

	private static Stream<Character> getCommands(Scanner scanner) {
		System.out.print(CLI);
		return scanner.nextLine()
				.chars()
				.mapToObj(command -> (char) command);
	}
}
