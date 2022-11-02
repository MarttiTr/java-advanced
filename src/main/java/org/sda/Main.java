package org.sda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  Create a List and display its result (data should be provided by the user - console):
 *  a) Purchases to be made. *If an element already exists on the list, then it should
 *  not be added.
 *  b) *Add to the example above the possibility of "deleting" purchased elements
 *  c) Display only those purchases that start with „m” (e.g. milk)
 *  d) * View only purchases whose next product on the list starts with „m” (e.g. eggs,
 *  if milk was next on the list)
 */

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the shop");
        List<String> shoppingBag = new ArrayList<>();

        menuOperation( shoppingBag);

    }

    private static void menuOperation(List<String> shoppingBag) {
        int menuOption = getMenu();

        switch(menuOption) {
            case 1: // Add item
                addItem(shoppingBag);
                break;
            case 2: // Delete item
                deleteItem(shoppingBag);
                break;
            case 3: // Display item
                displayItems(shoppingBag);
                break;
            case 4: // Exit
                break;
            default:
                System.out.println("Incorrect option, choose the correct one!");
                menuOperation(shoppingBag);
        }
    }

    private static int getMenu() {
        List<String> menu = List.of("Add item", "Delete item", "Display items", "Exit");

        for(int i = 0; i < menu.size(); i++) {
            System.out.println(i + 1 + ". " + menu.get(i));
        }

        System.out.println("Choose a menu from above:");
        
        return SCANNER.nextInt();
    }
    
    private static void addItem(List<String> shoppingBag) {
        boolean isAdd = true;
        System.out.println("Enter an item name to be added to the bag: ");
        
        while(isAdd) {
            
            String addItem = SCANNER.next();
        
            if(!shoppingBag.contains(addItem)) {
                shoppingBag.add(addItem);
                System.out.println("Item added! Do you want to add more items?");
            } else {
                System.out.println("The item already exist, do you want to add an other item?");
                isAdd = true;
                }

            isAdd = SCANNER.nextBoolean();
            }
        
    }

    private static void deleteItem(List<String> shoppingBag) {
        boolean isDelete = true;
        System.out.println("Enter an item name to be deleted from the bag: ");

        while(isDelete) {

            String deleteItem = SCANNER.next();

            if(shoppingBag.contains(deleteItem)) {
                shoppingBag.remove(deleteItem);
                System.out.println("Item deleted! Do you want to delete more items?");
            } else {
                System.out.println("The item not exist, do you want to delete an other item?");
                isDelete = true;
            }

            isDelete = SCANNER.nextBoolean();
        }
    }

    private static void displayItems(List<String> shoppingBag) {
        int counter = 1;

        for(int i = 0; i < shoppingBag.size(); i++) {
            String thisItem = shoppingBag.get(i);
            String nextItem = (i + 1) == (shoppingBag.size() - 1) ? shoppingBag.get(i + 1) : "";

            if(thisItem.startsWith("m") || thisItem.startsWith("M") || nextItem.startsWith("m") || nextItem.startsWith("M")) {
                System.out.println(counter + ", " + shoppingBag.get(i));
                counter++;
            }
        }
    }
}