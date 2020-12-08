package com.company;

import java.util.*;

public class CubeSystem {
	private static final String CLI = "CUBE JOA> ";

	private static Queue<String> getCommandComponents(Scanner scanner) {
		char[] commandComponents = scanner.nextLine().toCharArray();
		Queue<String> commandComponentsQueue = new LinkedList<>();
		for (char commandComponent : commandComponents) {
			commandComponentsQueue.add(String.valueOf(commandComponent));
		}
		return commandComponentsQueue;
	}

	private static boolean hasAdditionalCommandComponent(Queue<String> commandComponents) {
		return !commandComponents.isEmpty() && commandComponents.peek().equals("'");
	}

	private static String createSingleCommand(Queue<String> commandComponents) {
		String command = commandComponents.poll();
		if (hasAdditionalCommandComponent(commandComponents)) {
			command += commandComponents.poll();
		}
		return command;
	}

	private static List<String> getCommands(Scanner scanner) {
		System.out.print(CLI);
		Queue<String> commandComponents = getCommandComponents(scanner);
		List<String> commands = new ArrayList<>();
		while (!commandComponents.isEmpty()) {
			String command = createSingleCommand(commandComponents);
			commands.add(command);
		}
		return commands;
	}

	private static void runCommand(Cube cube, String command) {
		cube.changeCube(command);
		cube.showCube();
	}

	public static void playCube(Cube cube, Scanner scanner) {
		List<String> commands = getCommands(scanner);
		for (String command : commands) {
			runCommand(cube, command);
		}
		System.out.println();
	}
}
