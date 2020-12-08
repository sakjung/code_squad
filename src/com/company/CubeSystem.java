package com.company;

import java.util.*;

public class CubeSystem {
	private static final String CLI = "CUBE JOA> ";

	public static void playCube(Cube cube, Scanner scanner) {
		List<String> commands = getCommands(scanner);
		for (String command : commands) {
			// each command implemented
		}

	}

	private static Queue<String> getCommandComponents(Scanner scanner) {
		char[] commandComponents = scanner.nextLine().toCharArray();
		Queue<String> commandComponentsQueue = new LinkedList<String>();
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
			command = command + commandComponents.poll();
		}
		return command;
	}

	private static List<String> getCommands(Scanner scanner) {
		System.out.print(CLI);
		Queue<String> commandComponents = getCommandComponents(scanner);
		List<String> commands = new ArrayList<String>();
		while (!commandComponents.isEmpty()) {
			String command = createSingleCommand(commandComponents);
			commands.add(command);
		}
		return commands;
	}

	private static void runCommand(Cube cube, String command) {
		System.out.println(command);
		// get 3 length string
		// left or right
		// change cube
		// print cube status
		cube.showCube();
	}
}
