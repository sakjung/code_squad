package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Commands {
	F("F"),
	R("R"),
	U("U"),
	B("B"),
	L("L"),
	D("D"),
	TO_RIGHT("'"),
	TWICE("2");

	private String command;

	Commands(String command) {
		this.command = command;
	}

	public String command() {
		return command;
	}

	public static List<String> commands() {
		return Arrays.stream(values())
				.map(Commands::command)
				.collect(Collectors.toList());
	}

	public static List<String> commandsToLowerCase() {
		return Arrays.stream(values())
				.map(Commands::command)
				.map(String::toLowerCase)
				.collect(Collectors.toList());
	}

	public static String getFirstCommandComponent(String command) {
		return Character.toString(command.charAt(0));
	}

	public static boolean isLeft(String command) {
		return !command.contains(TO_RIGHT.command);
	}

	public static boolean isQuarterRotate(String command) {
		return !command.contains(TWICE.command);
	}

	public static List<String> getLocationsToChange(String command) {
		if (getFirstCommandComponent(command).equals(U.command)
				|| getFirstCommandComponent(command).equals(D.command)) {
			return Arrays.asList(F.command, B.command, L.command, R.command);
		}
		if (getFirstCommandComponent(command).equals(F.command)
				|| getFirstCommandComponent(command).equals(B.command)) {
			return Arrays.asList(U.command, D.command, L.command, R.command);
		}
		return Arrays.asList(F.command, B.command, U.command,D.command);
	}
}
