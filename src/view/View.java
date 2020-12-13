package view;

import controller.CubeController;
import domain.Cube;
import domain.Side;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class View {
	private static final String SPACE = " ";
	private static final String SPACE_REMOVER = "";
	private static final int CUBE_STATUS_OUTPUT_HEIGHT= 3;

	public static String getUserInput(Scanner scanner) {
		System.out.print(Messages.CLI.getMessage());
		return scanner.nextLine().replaceAll(SPACE, SPACE_REMOVER);
	}

	private static String padRight(String s, int n) {
		return String.format("%-" + n + "s", s);
	}

	private static String padLeft(String s, int n) {
		return String.format("%" + n + "s", s);
	}

	private static void showSingleSide(Side side) {
		for (String[] row : side.getSide()) {
			System.out.println(padRight(padLeft(String.join(" ", row), 20), 35));
		}
	}

	private static String createRowToPrint(List<Side> sides, int row) {
		return padRight(String.join(" ", sides.get(0).getSide()[row]),10)
				+ padRight(String.join(" ", sides.get(1).getSide()[row]),10)
				+ padRight(String.join(" ", sides.get(2).getSide()[row]),10)
				+ String.join(" ", sides.get(3).getSide()[row]);
	}

	private static void showFourSides(List<Side> sides) {
		for (int row = 0; row < Side.SIZE; row++) {
			System.out.println(createRowToPrint(sides, row));
		}
	}

	public static void showCube(Cube cube) {
		List<Side> sides = cube.getSides();
		showSingleSide(sides.get(0));
		System.out.println();
		showFourSides(sides.subList(1, 5));
		System.out.println();
		showSingleSide(sides.get(5));
		System.out.println();
	}

	private static String getTimeElapsed(Cube cube) {
		long elapsedTime = System.nanoTime() - cube.getStartTime();
		long seconds = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
		return String.format("%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60));
	}

	public static void printQuitMessages(Cube cube) {
		System.out.println(getTimeElapsed(cube));
		System.out.println(Messages.NUMBER_OF_CONTROLS.getMessage() + CubeController.NUMBER_OF_CONTROLS);
		System.out.println(Messages.QUIT_MESSAGE.getMessage());
	}
}
