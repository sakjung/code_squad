package com.company;

import java.util.Scanner;

public class System {
	public String pushString(Scanner scanner) {
		StringPusher stringPusher = createStringPusher(scanner);
		// push with input num
		if (stringPusher.isLeft()) {
			// push to left

		} else {
			// push to right
		}
	}

	private StringPusher createStringPusher(Scanner scanner) {
		String[] input = scanner.nextLine().split(" ");
		if (input.length == 3) {
			return new StringPusher(input[0], input[1], input[2]);
		}
		throw new IllegalArgumentException();
	}
}
