package org.sda.generics;

public class GenericExtendFood<T extends Food> {
    private final T item;  //final optional(?)

    public GenericExtendFood(T item) {
        this.item = item;
    }

    public float getRating() {
        return item.rating();
    }

}
