package controller;

import domain.Cube;
import domain.Side;
import view.Messages;
import view.View;

import java.util.*;
import java.util.regex.Pattern;

public class CubeController {
	private static List<String> commands = new ArrayList<>();

	private static void validateAvailableCommandComponents(String userInput) throws IllegalArgumentException {
		for (char commandComponent : userInput.toCharArray()) {
			if (!CommandComponents.commandComponents().contains(Character.toString(commandComponent)) &&
			!CommandComponents.commandsToLowerCase().contains(Character.toString(commandComponent))) {
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
				(commands.peek().equals(CommandComponents.ANTI_CLOCKWISE.getCommandComponent()) || commands.peek().equals(CommandComponents.TWICE.getCommandComponent()));
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

	private static List<String> createCommands(Scanner scanner) {
		Queue<String> commandComponents = getCommandComponents(scanner);
		while (!commandComponents.isEmpty()) {
			String command = createSingleCommand(commandComponents);
			commands.add(command);
		}
		return commands;
	}

	private static void changeCube(Cube cube, String fullCommand) {
		// concat colors of four sides
		String concatenatedColors = colorController.createConcatenatedColors(cube, fullCommand);
		// push colors
		String pushedColors = colorController.push(fullCommand, concatenatedColors);
		// renew colors of four sides
		colorController.renewSides(cube, fullCommand, pushedColors);
	}

	private static void runCommand(Cube cube, String fullCommand) {
		// show command
		System.out.println(fullCommand);
		// change cube
		changeCube(cube, fullCommand);
		// show cube status
		View.showCube(cube);
		System.out.println();
	}

	public static void playCube(Cube cube, Scanner scanner) {
		createCommands(scanner);
		for (String command : commands) {
			if (command.equalsIgnoreCase(CommandComponents.Q.getCommandComponent())) {
				System.out.println(Messages.QUIT_MESSAGE.getMessage());
				return;
			}
			runCommand(cube, command);
		}
		playCube(cube, scanner);
	}
}
