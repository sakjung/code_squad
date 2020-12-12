package controller;

import domain.Side;

import java.util.*;

public class CubeController {
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

	private static void runCommand(Side side, String command) {
		side.changeCube(command);
		side.showCube();
	}

	public static void playCube(Side side, Scanner scanner) {
		List<String> commands = getCommands(scanner);
		for (String command : commands) {
			runCommand(side, command);
		}
		System.out.println();
	}
}
