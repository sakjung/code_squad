package domain;

import java.util.ArrayList;
import java.util.List;

public class Cube {
	private enum Color {
		B,W,O,G,Y,R;
	}

	private static final List<Side> sides = new ArrayList<>();

	static {
		for (Color color : Color.values()) {
			addSide(new Side(color.toString()));
		}
	}

	private static void addSide(Side side) {
		sides.add(side);
	}
}
