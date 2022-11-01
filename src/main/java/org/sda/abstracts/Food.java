package org.sda.abstracts;

/**
 * An abstract Food class
 *
 * @author Martti Triksberg
 */
// Cant you private methods since child classes need to have access to abstract class. If making constructor in abstraction class, you need to make same constructor in extending class.
public abstract class Food {

    private String color;

    public Food(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void eat(); // You can only define it here, but cannot write the implementation here. The implementation will be in the extending classes
}
