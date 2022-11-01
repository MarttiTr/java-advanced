package org.sda.abstracts;

/**
 * Fruit class maatching the abstract Food class
 *
 * @author Martti Triksberg
 */

public class Fruit extends Food {

    public Fruit(String color) {
        super(color);
    }

    @Override
    public void eat() {
        System.out.println("I´m eating a " + super.getColor() + " fruit..");
    }
}
