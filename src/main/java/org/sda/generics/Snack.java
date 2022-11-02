package org.sda.generics;

/**
 *  Implementation of Comparable interface
 */

public class Snack implements Comparable<Snack> {
    private int tasteRating;

    public Snack(int tasteRating) {
        this.tasteRating = tasteRating;
    }

    @Override
    public boolean isBetter(Snack item) {
        return this.tasteRating > item.tasteRating;
    }
}
