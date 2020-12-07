package com.company;

public class StringPusher {
	private static final int LOWER_BOUND = -100;
	private static final int UPPER_BOUND = 100;

	private String string;
	private int numberOfPush;
	private String direction;

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

	private boolean isLeft() {
		// positive + l || negative + r
		return (0 <= numberOfPush && direction.equalsIgnoreCase("l")
				|| numberOfPush < 0 && direction.equalsIgnoreCase("r"));
	}

	public void pushString() {
		int cut = Math.abs(numberOfPush) % string.length();
		if (cut == 0) {
			return;
		}
		if (isLeft()) {
			// push to left
			string = string.substring(cut) + string.substring(0, cut);
			return;
		}
		// push to right
		string = string.substring(string.length() - cut) + string.substring(0, string.length() - cut);
	}

	public String getString() {
		return string;
	}
}