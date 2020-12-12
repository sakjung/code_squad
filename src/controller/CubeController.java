package controller;

import domain.Side;
import view.View;

import java.util.*;

public class CubeController {
	// check inputs (not in the option list) -> exception
	private static void validateAvailableCommandComponents(Queue<String> commandComponents) throws IllegalArgumentException {
		for (String commandComponent : commandComponents) {
			if (!Commands.commands().contains(commandComponent)) {
				throw new IllegalArgumentException();
			}
		}
	}

	private static Queue<String> getCommandComponents(Scanner scanner) {
		char[] userCommandInput = View.getUserInput(scanner).toCharArray();
		Queue<String> commandComponents = new LinkedList<>();
		for (char commandComponent : userCommandInput) {
			commandComponents.add(String.valueOf(commandComponent));
		}
		return commandComponents;
	}

	private static boolean hasAdditionalCommandComponent(Queue<String> commands) {
		return !commands.isEmpty() &&
				(commands.peek().equals(Commands.TO_RIGHT.getCommand()) || commands.peek().equals(Commands.TWICE.getCommand()));
	}

	private static String createSingleCommand(Queue<String> commands) {
		String command = commands.poll();
		if (hasAdditionalCommandComponent(commands)) {
			command += commands.poll(); // add '
			if (hasAdditionalCommandComponent(commands)) {
				command += commands.poll(); // add 2
			}
		}
		return command;
	}

	private static List<String> getCommands(Scanner scanner) {
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
