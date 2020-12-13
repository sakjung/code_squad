package controller;

import domain.Cube;
import domain.Side;
import view.Messages;
import view.View;

import java.util.*;
import java.util.regex.Pattern;

public class CubeController {
	public static int NUMBER_OF_CONTROLS = 0;
	private static final int NUMBER_OF_MIX = 50;

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
		Pattern wrongPositionPattern = Pattern.compile("2'"); // ' comes after 2

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
		List<String> commands = new ArrayList<>();
		while (!commandComponents.isEmpty()) {
			String command = createSingleCommand(commandComponents);
			commands.add(command);
		}
		return commands;
	}

	private static void changeCube(Cube cube, String fullCommand) {
		String concatenatedColors = colorController.createConcatenatedColors(cube, fullCommand);
		String pushedColors = colorController.push(fullCommand, concatenatedColors);
		colorController.renewSides(cube, fullCommand, pushedColors);
	}

	private static void runCommand(Cube cube, String fullCommand) {
		System.out.println(fullCommand.toUpperCase());
		changeCube(cube, fullCommand);
		NUMBER_OF_CONTROLS++;
		View.showCube(cube);
		System.out.println();
	}

	public static boolean isCorrect(Cube playerCube, Cube answerCube) {
		List<Side> playerSides = playerCube.getSides();
		List<Side> answerSides = answerCube.getSides();
		for (int i = 0; i < Cube.NUMBER_OF_SIDES; i++) {
			if (!Arrays.deepEquals(playerSides.get(i).getSide(), answerSides.get(i).getSide())) {
				return false;
			}
		}
		return true;
	}

	public static void playCube(Cube playerCube, Cube answerCube, Scanner scanner) {
		for (String command : createCommands(scanner)) {
			if (command.equalsIgnoreCase(CommandComponents.Q.getCommandComponent())) {
				View.printQuitMessages(playerCube);
				return;
			}
			runCommand(playerCube, command);
			if (isCorrect(playerCube, answerCube)) {
				System.out.println(Messages.CONGRATULATIONS.getMessage());
				View.printQuitMessages(playerCube);
				return;
			}
		}
		playCube(playerCube, answerCube, scanner);
	}

	private static String getRandomCommand(double randomToken1, double randomToken2, double randomToken3) {
		return CommandComponents.generateRandomFirstCommandComponent(randomToken1)
				+ CommandComponents.generateClockWiseCommandComponent(randomToken2)
				+ CommandComponents.generateRotationCommandComponent(randomToken3);
	}

	private static void mixCube(Cube playerCube) {
		for (int mix = 1; mix <= NUMBER_OF_MIX; mix++) {
			changeCube(playerCube, getRandomCommand(Math.random(), Math.random(), Math.random()));
		}
	}

	public static Cube generatePlayerCube(Cube answerCube) {
		Cube playerCube = new Cube();
		mixCube(playerCube);
		if (!isCorrect(playerCube, answerCube)) {
			return playerCube;
		}
		return generatePlayerCube(answerCube);
	}
}
