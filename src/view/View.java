package view;

import java.util.Scanner;

public class View {
	private static final String SPACE = " ";
	private static final String SPACE_REMOVER = "";

	public static String getUserInput(Scanner scanner) {
		System.out.print(Messages.CLI.getMessage());
		return scanner.nextLine().replaceAll(SPACE, SPACE_REMOVER);
	}
}
