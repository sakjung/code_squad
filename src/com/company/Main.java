package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Cube cube = new Cube();
        cube.showCube();
        System.out.println();

        while (true) {
            CubeSystem.playCube(cube, scanner);
        }
    }
}
