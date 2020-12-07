package com.company;

import java.util.Scanner;

public class StringPusher {
	private static final int LOWER_BOUND = -100;
	private static final int UPPER_BOUND = 100;

	private final String string;
	private final int numberOfPush;
	private final String direction;

	public StringPusher(String string, String numberOfPush, String direction) {
		validateInteger(numberOfPush);
		validateRange(numberOfPush);
		validateLeftRight(direction);
		this.string = string;
		this.numberOfPush = Integer.parseInt(numberOfPush);
		this.direction = direction;
	}

	private void validateInteger(String numberOfPush) {
		try {
			Integer.parseInt(numberOfPush);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}

	private void validateRange(String numberOfPush) {
		if (Integer.parseInt(numberOfPush) < LOWER_BOUND || UPPER_BOUND <= Integer.parseInt(numberOfPush)) {
			throw new IllegalArgumentException();
		}
	}

	private void validateLeftRight(String leftOrRight) {
		if (!(leftOrRight.equalsIgnoreCase("l")) && !(leftOrRight.equalsIgnoreCase("r"))) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isLeft() {
		return direction.equalsIgnoreCase("l");
	}

	public String getString() {
		return string;
	}

	public int getNumberOfPush() {
		return numberOfPush;
	}

	public String getDirection() {
		return direction;
	}
}