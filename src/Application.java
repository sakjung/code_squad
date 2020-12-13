import controller.CubeController;
import domain.Cube;
import view.View;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		Cube cube = new Cube();
		View.showCube(cube);
		CubeController.playCube(cube, scanner);
	}
}
