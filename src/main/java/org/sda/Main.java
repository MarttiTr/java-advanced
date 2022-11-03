package org.sda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create a List and display its result (data should be provided by the user - console):
 * a) Purchases to be made. *If an element already exists on the list, then it should
 * not be added.
 * b) *Add to the example above the possibility of "deleting" purchased elements
 * c) Display only those purchases that start with „m” (e.g. milk)
 * d) * View only purchases whose next product on the list starts with „m” (e.g. eggs,
 * if milk was next on the list)
 */
public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the shop");

        List<String> shoppingBag = new ArrayList<>();
        menuOperation(shoppingBag);
    }

    private static void menuOperation(List<String> shoppingBag) {
        int menuOption = getMenu();

        switch (menuOption) {
            case 1: // Add item
                addItem(shoppingBag);
                menuOperation(shoppingBag);
                break;
            case 2: // Delete item
                deleteItem(shoppingBag);
                menuOperation(shoppingBag);
                break;
            case 3: // Display items
                displayItems(shoppingBag);
                menuOperation(shoppingBag);
                break;
            case 4: // exit
                System.out.println("Thanks for shopping. Visit us again!");
                break;
            default:
                System.out.println("Incorrect option, choose the correct one!");
                menuOperation(shoppingBag);
        }
    }

    private static int getMenu() {
        System.out.println("--------------");
        System.out.println("     MENU    ");
        System.out.println("--------------");

        List<String> menu = List.of("Add item", "Delete item", "Display items", "Exit");

        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + 1 + ". " + menu.get(i));
        }

        System.out.println("Choose a menu from above:");

        return SCANNER.nextInt();
    }

    private static void addItem(List<String> shoppingBag) {
        boolean isAdd = true;

        while (isAdd) {
            System.out.println("Enter an item name to be added to the bag: ");
            String addItem = SCANNER.next();

            if (!shoppingBag.contains(addItem)) {
                shoppingBag.add(addItem);
                System.out.println("'" + addItem + "' added to the bag. Do you want to add more item? (true/false)");
            } else {
                System.out.println("The item already exists, do you want to add an other item? (true/false)");
            }

            isAdd = SCANNER.nextBoolean();
        }
    }

    private static void deleteItem(List<String> shoppingBag) {
        boolean isDelete = true;

        while (isDelete) {
            System.out.println("Enter an item name to be deleted from the bag: ");
            String deleteItem = SCANNER.next();

            if (shoppingBag.contains(deleteItem)) {
                shoppingBag.remove(deleteItem);
                System.out.println("'" + deleteItem + "' deleted from the bag. Do you want to delete more item? (true/false)");
            } else {
                System.out.println("The item not exists, do you want to delete an other item? (true/false)");
            }

            isDelete = SCANNER.nextBoolean();
        }
    }

    private static void displayItems(List<String> shoppingBag) {
        int counter = 1;

        System.out.println("ITEMS: ");

        for (int i = 0; i < shoppingBag.size(); i++) {
            String thisItem = shoppingBag.get(i);
            String nextItem = (i + 1) <= (shoppingBag.size() - 1) ? shoppingBag.get(i + 1) : "";

            if (thisItem.startsWith("m") || thisItem.startsWith("M") || nextItem.startsWith("m") || nextItem.startsWith("M")) {
                System.out.println(counter + ". " + thisItem);
                counter++;
            }
        }


        if (counter == 1) {
            System.out.println("Your shopping bag is empty or doesn't contain the expected items. No items to display!");
        }
    }
}