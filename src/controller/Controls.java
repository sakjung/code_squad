package controller;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public enum Controls {
	U(CommandComponents.U.getCommandComponent(), Arrays.asList(CommandComponents.F.getCommandComponent(), CommandComponents.R.getCommandComponent(), CommandComponents.B.getCommandComponent(), CommandComponents.L.getCommandComponent()), "U"),
	D(CommandComponents.D.getCommandComponent(), Arrays.asList(CommandComponents.F.getCommandComponent(), CommandComponents.R.getCommandComponent(), CommandComponents.B.getCommandComponent(), CommandComponents.L.getCommandComponent()), "D"),
	B(CommandComponents.B.getCommandComponent(), Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.L.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.R.getCommandComponent()), "U"),
	F(CommandComponents.F.getCommandComponent(), Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.R.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.L.getCommandComponent()), "D"),
	L(CommandComponents.L.getCommandComponent(), Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.F.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.B.getCommandComponent()), "U"),
	R(CommandComponents.R.getCommandComponent(), Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.B.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.F.getCommandComponent()), "D");

	private final String command;
	private final List<String> sidesToControl;
	private final String partOfSide;

	Controls(String command, List<String> sidesToControl, String partOfSide) {
		this.command = command;
		this.sidesToControl = sidesToControl;
		this.partOfSide = partOfSide;
	}

	public String getCommand() {
		return command;
	}

	public List<String> getSidesToControl() {
		return sidesToControl;
	}

	public String getPartOfSide() {
		return partOfSide;
	}

	public static Controls getControl(String fullCommand) {
		return Arrays.stream(values())
				.filter(control -> control.command.equalsIgnoreCase(CommandComponents.getControlCommand(fullCommand)))
				.findAny()
				.orElseThrow(() -> new NoSuchElementException());
	}
}
