package domain;

import controller.Controls;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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

	{
		for (Color color : Color.values()) {
			addSide(new Side(color.getLocation(), color.toString()));
		}
	}

	private void addSide(Side side) {
		sides.add(side);
	}

	private Side getSide(String location) {
		return sides.stream()
				.filter(side -> side.getLocationInCube().equalsIgnoreCase(location))
				.findFirst()
				.orElseThrow(() -> new NoSuchElementException());
	}

	public List<Side> getSidesToChange(String fullCommand) {
		return Controls.getControl(fullCommand)
				.getSidesToControl()
				.stream()
				.map(location -> getSide(location))
				.collect(Collectors.toList());
	}
}
