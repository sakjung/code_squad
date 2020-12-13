package domain;

import controller.Controls;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cube {
	public static final int NUMBER_OF_SIDES = 6;

	private final List<Side> sides = new ArrayList<>();
	private long startTime;

	{
		for (Color color : Color.values()) {
			addSide(new Side(color.getLocation(), color.toString()));
		}
		this.startTime = System.nanoTime();
	}

	public List<Side> getSides() {
		return sides;
	}

	private void addSide(Side side) {
		sides.add(side);
	}

	public long getStartTime() {
		return startTime;
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

	private enum Color {
		B("U"), W("F"), O("L"), G("R"), Y("B"), R("D");

		private final String location;

		Color(String location) {
			this.location = location;
		}

		private String getLocation() {
			return location;
		}
	}
}
