package org.sda.homeworks;

import javax.naming.Name;

public class Animal {

    public static void main(String[] args) {

        Cat cat = new Cat("Mia",31, "Meow");
        Dog dog = new Dog("Pepe", 12, "Auh-Auh");

        cat.setYieldVoice("Meow");
        dog.setYieldVoice("Auh-Auh");

        String[] animals = {"Cat","Dog"};

        for (String animal : animals) {
            System.out.println(animal.toString());
        }
    }

}
