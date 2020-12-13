package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CommandComponents {
	F("F"),
	R("R"),
	U("U"),
	B("B"),
	L("L"),
	D("D"),
	Q("Q"),
	ANTI_CLOCKWISE("'"),
	TWICE("2");

	private final String commandComponent;

	CommandComponents(String commandComponent) {
		this.commandComponent = commandComponent;
	}

	public String getCommandComponent() {
		return commandComponent;
	}

	public static List<String> commandComponents() {
		return Arrays.stream(values())
				.map(CommandComponents::getCommandComponent)
				.collect(Collectors.toList());
	}

	public static List<String> commandsToLowerCase() {
		return Arrays.stream(values())
				.map(CommandComponents::getCommandComponent)
				.map(String::toLowerCase)
				.collect(Collectors.toList());
	}

	private static String getFirstCommandComponent(String fullCommand) {
		return Character.toString(fullCommand.charAt(0));
	}

	public static boolean isClockWise(String fullCommand) {
		return !fullCommand.contains(ANTI_CLOCKWISE.commandComponent);
	}

	public static String getControlCommand(String fullCommand) {
		if (isClockWise(fullCommand)) {
			return getFirstCommandComponent(fullCommand);
		}
		return getFirstCommandComponent(fullCommand) + "'";
	}

	public static boolean isHalfRotate(String fullCommand) {
		return fullCommand.contains(TWICE.commandComponent);
	}
}
