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
	CLOCKWISE("'"),
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

	private static String getFirstCommandComponent(String wholeCommand) {
		return Character.toString(wholeCommand.charAt(0));
	}

	public static boolean isClockWise(String wholeCommand) {
		return wholeCommand.contains(CLOCKWISE.commandComponent);
	}

	public static boolean isHalfRotate(String wholeCommand) {
		return !wholeCommand.contains(TWICE.commandComponent);
	}

	public static String getFullCommand(String wholeCommand) {
		if (isClockWise(wholeCommand)) {
			return getFirstCommandComponent(wholeCommand) + "'";
		}
		return getFirstCommandComponent(wholeCommand);
	}
}
