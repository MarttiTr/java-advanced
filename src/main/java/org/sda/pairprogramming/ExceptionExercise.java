package org.sda.pairprogramming;

import java.util.Scanner;

/**
 *  Write an applicatio that will read the input and print back value that user, provided,
 *  use try/catch statements to parse the input, e.g. I/O:
 *
 *  Input: 10
 *  Output int -> 10
 */
public class ExceptionExercise {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            String errorMessage = "Hey! That´s not a value! Try once more!";

            if(!scanner.hasNextInt()) {
                System.out.println("int -> " + scanner);
            } else if (scanner.hasNextFloat()) {
                System.out.println("double -> " + scanner);
            } else {
                System.out.println(errorMessage);
        }
    }
}

