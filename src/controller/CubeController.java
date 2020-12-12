package controller;

import domain.Side;
import view.Messages;
import view.View;

import java.util.*;

public class CubeController {
	private static final String CLI = "CUBE JOA> ";

	private static Queue<String> getCommandComponents(Scanner scanner) {
		char[] commandComponents = View.getUserInput(scanner).toCharArray();
		Queue<String> commands = new LinkedList<>();
		for (char commandComponent : commandComponents) {
			commands.add(String.valueOf(commandComponent));
		}
		return commands;
	}

	private static boolean hasAdditionalCommandComponent(Queue<String> commands) {
		return !commands.isEmpty() &&
				(commands.peek().equals(Commands.TO_RIGHT.getCommand()) || commands.peek().equals(Commands.TWICE.getCommand()));
	}

	private static String createSingleCommand(Queue<String> commands) {
		String command = commands.poll();
		if (hasAdditionalCommandComponent(commands)) {
			command += commands.poll();
			if (hasAdditionalCommandComponent(commands)) {
				command += commands.poll();
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
