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

	private final String command;

	Commands(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}

	public static List<String> commands() {
		return Arrays.stream(values())
				.map(Commands::getCommand)
				.collect(Collectors.toList());
	}

	public static List<String> commandsToLowerCase() {
		return Arrays.stream(values())
				.map(Commands::getCommand)
				.map(String::toLowerCase)
				.collect(Collectors.toList());
	}

	public static String getFirstCommandComponent(String command) {
		return Character.toString(command.charAt(0));
	}

	public static boolean isClockWise(String command) {
		return !command.contains(TO_RIGHT.command);
	}

	public static boolean isQuarterRotate(String command) {
		return !command.contains(TWICE.command);
	}

	public static List<String> getLocationsToChange(String command) {
		if (getFirstCommandComponent(command).equals(U.command)
		|| getFirstCommandComponent(command).equals(D.command)) {
			return Arrays.asList(F.command, L.command, B.command, R.command);
		}
		if (getFirstCommandComponent(command).equals(F.command)
		|| getFirstCommandComponent(command).equals(B.command)) {
			return Arrays.asList(U.command, R.command, D.command, L.command);
		}
		return Arrays.asList(U.command, F.command, D.command, B.command);
	} // 나중에 수정하기

}
