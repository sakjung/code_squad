package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CubeSystem {
	private static final String CLI = "CUBE JOA> ";

	public static void playCube(Cube cube, Scanner scanner) {
		List<String> commands = getCommands(scanner);

	}

	private static List<String> getCommands(Scanner scanner) {
		System.out.print(CLI);
		char[] commandComponents = scanner.nextLine().toCharArray();
		List<String> commands = new ArrayList<String>();
		for (char commandComponent : commandComponents) {
			String thisCommand = Character.toString(commandComponent);
			if (commandComponent == "'".charAt(0)) {
				thisCommand = thisCommand + commandComponent;
				commands.add(thisCommand);
				continue;
			}
			commands.add(thisCommand);
		}
		return commands;
	}
}
