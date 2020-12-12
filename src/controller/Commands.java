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

	private String option;

	Commands(String option) {
		this.option = option;
	}

	public String getCommand() {
		return option;
	}

	public static List<String> commands() {
		return Arrays.stream(values()).map(Commands::getCommand)
				.collect(Collectors.toUnmodifiableList());
	}
}
