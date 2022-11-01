package org.sda.abstracts;

/**
 * Veggie class extending the abstract Food class
 *
 * @author Martti Triksberg
 */

public class Veggie extends Food {

    public Veggie(String color) {
        super(color);
    }

    @Override
    public void eat() {
        System.out.println("I´m eating a " + super.getColor() + " veggie");
    }
}
