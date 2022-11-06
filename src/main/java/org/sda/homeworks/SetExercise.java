package org.sda.homeworks;

import jdk.internal.icu.text.UnicodeSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *  Exercise - Set
 *  1.Create a set consisting of colors - given from the user
 *  2.Present the removal of individual elements from the set
 *  3.Display the collection before and after sorting
 *  @author Martti Triksberg
 */

public class SetExercise {

    boolean hasMoreColours;
    static Scanner scanner = new Scanner(System.in);
    String errorMessage = "Thats not a valid answer, Please enter again:";
    public Set<String> colours;

    public static void main(String[] args) {

        System.out.println("Write x amount of colours, one after another:");
        Set<String> colours = new HashSet<>();

        colours.add(scanner.next());
    }

    public boolean hasMoreColoursToGive() {

        System.out.println("Do you want to add more colours? (true/false)");

            while(!hasMoreColours) {

                hasMoreColours = scanner.nextBoolean();

                if(hasMoreColours == true) {
                    colours.add(scanner.next());
                    System.out.println("Do you want to add more colours? (true/false)");
                    scanner.nextBoolean();
                    if(scanner.nextBoolean() == true) {
                        return true;
                    } else {
                        return false;
                    }

                } else {
                    return false;
                }
            }
        return false;
    }

    public String printColourList() {
        Set<String> ColourList = colours;

        return String.valueOf(ColourList.toArray());
    }



    }
