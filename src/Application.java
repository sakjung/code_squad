import controller.CubeController;
import domain.Cube;
import view.View;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		Cube answerCube = new Cube();
		Cube playerCube = CubeController.generatePlayerCube(answerCube);
		View.showCube(playerCube);
		CubeController.playCube(playerCube, answerCube, scanner);
	}
}
