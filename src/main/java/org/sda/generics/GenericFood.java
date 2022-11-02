package org.sda.generics;

/**
 * Generic food class //Generic class should have single uppercase letter inside <>
 *
 * @author Martti Triksberg
 */
// <T> makes this class generic. <T> - can mean anything(String, Double, Float, Car, Vehicle... jne
public class GenericFood<T> {
    private T item;  // private Fruit item

    public GenericFood(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
