package controller;

import domain.Side;
import view.Messages;
import view.View;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CubeController {
	private static void validateAvailableCommandComponents(String userInput) throws IllegalArgumentException {
		for (char commandComponent : userInput.toCharArray()) {
			if (!Commands.commands().contains(Character.toString(commandComponent)) &&
			!Commands.commandsToLowerCase().contains(Character.toString(commandComponent))) {
				throw new IllegalArgumentException(Messages.NOT_AVAILABLE_INPUT_ERROR.getMessage());
			}
		}
	}

	private static void validateMalformedCommand(String userInput) {
		Pattern consecutivePattern = Pattern.compile("2{2}|'{2}"); // consecutive 2 or '
		Pattern wrongPositionPattern = Pattern.compile("2'"); // ' after 2

		if (consecutivePattern.matcher(userInput).find() || wrongPositionPattern.matcher(userInput).find()) {
			throw new IllegalArgumentException(Messages.MALFORMED_INPUT_ERROR.getMessage());
		}
	}

	private static String getValidCommandInput(Scanner scanner) {
		try {
			String input = View.getUserInput(scanner);
			validateAvailableCommandComponents(input);
			validateMalformedCommand(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getValidCommandInput(scanner);
		}
	}

	private static Queue<String> getCommandComponents(Scanner scanner) {
		char[] userCommandInput = getValidCommandInput(scanner).toCharArray();
		Queue<String> commandComponents = new LinkedList<>();
		for (char commandComponent : userCommandInput) {
			commandComponents.add(Character.toString(commandComponent));
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
