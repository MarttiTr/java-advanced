package org.sda.homeworks;

public class Animal {


    public static void main(String[] args) {

        Cat cat = new Cat("Mia",31,"Meow");
        Dog dog = new Dog("Pepe", 12,"Auh,Auh");

        String[] animals = {"cat", "dog"};

        for (String animal : animals) {
            System.out.println(animal);
        }
    }

    public static void setAnimalYieldVoice(Cat cat) {

        Cat cat1 = new Cat("Meow");
        Dog dog1 = new Dog("Auh-Auh");

    }
}

