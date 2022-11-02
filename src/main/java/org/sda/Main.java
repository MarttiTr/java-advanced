package org.sda;

import org.sda.generics.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // GENERIC TYPE
        Fruit fruit = new Fruit();
        fruit.setName("Apple");
        fruit.setColor("Green");
        fruit.setPrice(BigDecimal.valueOf(1.99)); // converting a double value to BigDecimal

        GenericFood<Fruit> genericFoodWithFruit = new GenericFood<>(fruit);
        System.out.println(genericFoodWithFruit.getItem());

        String str = "I´m a great developer";
        GenericFood<String> genericFoodWithString = new GenericFood<>(str);
        System.out.println(genericFoodWithString.getItem());

        genericFoodWithString.setItem("I´m a good person!");
        System.out.println(genericFoodWithString.getItem());

        // Generic type - extends
        Vegetable vegetable = new Vegetable();
        GenericExtendFood<Vegetable> vegetableGenericExtendFood = new GenericExtendFood<>(vegetable);
        System.out.println(vegetableGenericExtendFood.getRating());

        // Generic type - interface
        Snack snack1 = new Snack(5);
        Snack snack2 = new Snack(3);
        System.out.println("Snack 1 is better than Snack 2: " + snack1.isBetter(snack2));

        // List
        List<String> animalList = new ArrayList<>();
        animalList.add("Lion");
        animalList.add("Tiger");
        animalList.add("Dog");
        animalList.add("Cat");
        animalList.add("Bear");
        animalList.add("Panda");

        System.out.println(animalList.get(1)); // Prints tiger

        animalList.remove(1); // Tiger will be deleted
        animalList.remove("Dog");

        for(String animal: animalList) {
            System.out.println(animal);
        }

        // Iterator
        Iterator<String> stringIterator = animalList.listIterator();
        while(stringIterator.hasNext()) {
            System.out.println(stringIterator.next() + " ,");
        }

        // Continues block 38-54, List of items to be removed
        List<String> removeAnimalList = new ArrayList<>();
        removeAnimalList.add("Cat");
        removeAnimalList.add("Panda");

        animalList.removeAll(removeAnimalList);

        for(String animal: animalList) {
            System.out.println(animal);
        }


    }
}