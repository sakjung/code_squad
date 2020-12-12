package domain;

import controller.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	private List<String> getLocationsToChange(String command) {
		if (Commands.getFirstCommandComponent(command).equals(Commands.U.getCommand())
				|| Commands.getFirstCommandComponent(command).equals(Commands.D.getCommand())) {
			return Arrays.asList(Commands.F.getCommand(),
					Commands.B.getCommand(),
					Commands.L.getCommand(),
					Commands.R.getCommand());
		}
		if (Commands.getFirstCommandComponent(command).equals(Commands.F.getCommand())
				|| Commands.getFirstCommandComponent(command).equals(Commands.B.getCommand())) {
			return Arrays.asList(Commands.U.getCommand(),
					Commands.D.getCommand(),
					Commands.L.getCommand(),
					Commands.R.getCommand());
		}
		return Arrays.asList(Commands.F.getCommand(),
				Commands.B.getCommand(),
				Commands.U.getCommand(),
				Commands.D.getCommand());
	}

	public List<Side> getSidesToChange(String command) {
		return sides.stream()
				.filter(side -> getLocationsToChange(command).contains(side.getLocation()))
				.collect(Collectors.toList());
	}
}
