package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CommandComponents {
	F("F", 0,(double) 1/6),
	R("R",(double) 1/6,(double) 2/6),
	U("U",(double) 2/6,(double) 3/6),
	B("B",(double) 3/6,(double) 4/6),
	L("L",(double) 4/6,(double) 5/6),
	D("D",(double) 5/6,1),
	Q("Q",-1,-1),
	ANTI_CLOCKWISE("'",0,(double) 1/2),
	TWICE("2",0,(double) 1/2);

	private final String commandComponent;
	private final double lowerBoundForRandomPick;
	private final double upperBoundForRandomPick;

	CommandComponents(String commandComponent, double lowerBoundForRandomPick, double upperBoundForRandomPick) {
		this.commandComponent = commandComponent;
		this.lowerBoundForRandomPick = lowerBoundForRandomPick;
		this.upperBoundForRandomPick = upperBoundForRandomPick;
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

	public static String getFirstCommandComponent(String fullCommand) {
		return Character.toString(fullCommand.charAt(0));
	}

	public static boolean isClockWise(String fullCommand) {
		return !fullCommand.contains(ANTI_CLOCKWISE.commandComponent);
	}

	public static boolean isHalfRotate(String fullCommand) {
		return fullCommand.contains(TWICE.commandComponent);
	}

	public static String generateRandomFirstCommandComponent(double randomToken) {
		return Arrays.stream(values())
				.limit(6)
				.filter(command -> Double.compare(command.lowerBoundForRandomPick, randomToken) <= 0
						&& Double.compare(command.upperBoundForRandomPick, randomToken) > 0)
				.map(CommandComponents::getCommandComponent)
				.findFirst()
				.orElseThrow();
	}

	public static String generateClockWiseCommandComponent(double randomToken) {
		if (Double.compare(ANTI_CLOCKWISE.lowerBoundForRandomPick, randomToken) <= 0
				&& Double.compare(ANTI_CLOCKWISE.upperBoundForRandomPick, randomToken) > 0) {
			return ANTI_CLOCKWISE.commandComponent;
		}
		return "";
	}

	public static String generateRotationCommandComponent(double randomToken) {
		if (Double.compare(TWICE.lowerBoundForRandomPick, randomToken) <= 0
				&& Double.compare(TWICE.upperBoundForRandomPick, randomToken) > 0) {
			return TWICE.commandComponent;
		}
		return "";
	}
}
