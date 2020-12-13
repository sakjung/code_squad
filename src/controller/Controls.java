package controller;

import java.util.Arrays;
import java.util.List;

public enum Controls {
	UR(Arrays.asList(Commands.F.getCommand(), Commands.R.getCommand(), Commands.B.getCommand(), Commands.L.getCommand()), "U"),
	UL(Arrays.asList(Commands.F.getCommand(), Commands.L.getCommand(), Commands.B.getCommand(), Commands.R.getCommand()), "U"),
	DR(Arrays.asList(Commands.F.getCommand(), Commands.L.getCommand(), Commands.B.getCommand(), Commands.R.getCommand()), "D"),
	DL(Arrays.asList(Commands.F.getCommand(), Commands.R.getCommand(), Commands.B.getCommand(), Commands.L.getCommand()), "D"),
	BR(Arrays.asList(Commands.U.getCommand(), Commands.R.getCommand(), Commands.D.getCommand(), Commands.L.getCommand()), "U"),
	BL(Arrays.asList(Commands.U.getCommand(), Commands.L.getCommand(), Commands.D.getCommand(), Commands.R.getCommand()), "U"),
	FR(Arrays.asList(Commands.U.getCommand(), Commands.L.getCommand(), Commands.D.getCommand(), Commands.R.getCommand()), "D"),
	FL(Arrays.asList(Commands.U.getCommand(), Commands.R.getCommand(), Commands.D.getCommand(), Commands.L.getCommand()), "D"),
	LR(Arrays.asList(Commands.U.getCommand(), Commands.B.getCommand(), Commands.D.getCommand(), Commands.F.getCommand()), "U"),
	LL(Arrays.asList(Commands.U.getCommand(), Commands.F.getCommand(), Commands.D.getCommand(), Commands.B.getCommand()), "U"),
	RR(Arrays.asList(Commands.U.getCommand(), Commands.F.getCommand(), Commands.D.getCommand(), Commands.B.getCommand()), "D"),
	RL(Arrays.asList(Commands.U.getCommand(), Commands.B.getCommand(), Commands.D.getCommand(), Commands.F.getCommand()), "D");

	private final List<String> order;
	private final String stringPosition;

	Controls(List<String> order, String stringPosition) {
		this.order = order;
		this.stringPosition = stringPosition;
	}

	public List<String> getOrder() {
		return order;
	}

	public String getStringPosition() {
		return stringPosition;
	}

}
