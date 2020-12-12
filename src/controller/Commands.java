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

	public String getCommand() {
		return command;
	}

	public static List<String> commands() {
		return Arrays.stream(values())
				.map(Commands::getCommand)
				.collect(Collectors.toUnmodifiableList());
	}
}
