package controller;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public enum Controls {
	UR("U", Arrays.asList(CommandComponents.F.getCommandComponent(), CommandComponents.R.getCommandComponent(), CommandComponents.B.getCommandComponent(), CommandComponents.L.getCommandComponent()), "U"),
	UL("U'", Arrays.asList(CommandComponents.F.getCommandComponent(), CommandComponents.L.getCommandComponent(), CommandComponents.B.getCommandComponent(), CommandComponents.R.getCommandComponent()), "U"),
	DR("D", Arrays.asList(CommandComponents.F.getCommandComponent(), CommandComponents.R.getCommandComponent(), CommandComponents.B.getCommandComponent(), CommandComponents.L.getCommandComponent()), "D"),
	DL("D'", Arrays.asList(CommandComponents.F.getCommandComponent(), CommandComponents.L.getCommandComponent(), CommandComponents.B.getCommandComponent(), CommandComponents.R.getCommandComponent()), "D"),
	BR("B", Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.L.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.R.getCommandComponent()), "U"),
	BL("B'", Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.R.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.L.getCommandComponent()), "U"),
	FR("F", Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.R.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.L.getCommandComponent()), "D"),
	FL("F'", Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.L.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.R.getCommandComponent()), "D"),
	LR("L", Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.F.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.B.getCommandComponent()), "U"),
	LL("L'", Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.B.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.F.getCommandComponent()), "U"),
	RR("R", Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.B.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.F.getCommandComponent()), "D"),
	RL("R'", Arrays.asList(CommandComponents.U.getCommandComponent(), CommandComponents.F.getCommandComponent(), CommandComponents.D.getCommandComponent(), CommandComponents.B.getCommandComponent()), "D");

	private final String command;
	private final List<String> order;
	private final String partOfSide;

	Controls(String command, List<String> order, String partOfSide) {
		this.command = command;
		this.order = order;
		this.partOfSide = partOfSide;
	}

	public String getCommand() {
		return command;
	}

	public List<String> getOrder() {
		return order;
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
