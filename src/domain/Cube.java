package domain;

import controller.Commands;

import java.util.ArrayList;
import java.util.List;

public class Cube {
	private enum Color {
		B("U"),W("F"),O("L"),G("R"),Y("B"),R("D");

		private final String location;

		Color(String location) {
			this.location = location;
		}

		private String getLocation() {
			return location;
		}
	}

	private static final List<Side> sides = new ArrayList<>();

	static {
		for (Color color : Color.values()) {
			addSide(new Side(color.getLocation(), color.toString()));
		}
	}

	private static void addSide(Side side) {
		sides.add(side);
	}

	private static List<Side> getSidesToChange(String command) {
		// U, D
		if (Commands.getFirstCommandComponent(command).equals(Commands.U.getCommand())
		|| Commands.getFirstCommandComponent(command).equals(Commands.D.getCommand())) {
			return
		}
		// F, B
		// L, R
	}
}
