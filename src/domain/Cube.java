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

	public List<Side> getSidesToChange(String command) {
		return sides.stream()
				.filter(side -> Commands.getLocationsToChange(command).contains(side.getLocation()))
				.collect(Collectors.toList());
	}
}
