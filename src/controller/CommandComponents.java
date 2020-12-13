package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CommandComponents {
	F("F",0,1/6),
	R("R",1/6,2/6),
	U("U",2/6,3/6),
	B("B",3/6,4/6),
	L("L",4/6,5/6),
	D("D",5/6,6/6),
	Q("Q",-1,-1),
	ANTI_CLOCKWISE("'",0,1/2),
	TWICE("2",0,1/2);

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
				.filter(command -> command.lowerBoundForRandomPick <= randomToken || randomToken < command.upperBoundForRandomPick)
				.map(CommandComponents::getCommandComponent)
				.findFirst()
				.orElseThrow();
	}

	public static String generateRandomAdditionalComponents(double randomToken) {
		return Arrays.stream(values())
				.skip(7)
				.filter(command -> command.lowerBoundForRandomPick <= randomToken || randomToken < command.upperBoundForRandomPick)
				.map(CommandComponents::getCommandComponent)
				.collect(Collectors.joining(""));
	}
}
