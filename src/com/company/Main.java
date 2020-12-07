package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        if (input.length != 3) {
            throw new IllegalArgumentException();
        }

        StringPusher stringPusher = new StringPusher(input[0], input[1], input[2]);
        stringPusher.pushString();
        System.out.println(stringPusher.getString());
    }
}
