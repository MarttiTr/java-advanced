package org.sda.model.homework;

/**
 * Create a Shape class.
 * a) Add fields, create constructor, getters and setters.
 * b) Create classes Rectangle and Circle. Both of them should inherit class Shape.
 * Which fields and methods are common?
 */

public class Shape {

    private float circumference;
    private float area;
    private boolean isRound;

    public Shape() {

    }

    public Shape(float circumference, float area, boolean isRound) {
        this.circumference = circumference;
        this.area = area;
        this.isRound = isRound;
    }

    public float getCircumference() {
        return circumference;
    }

    public void setCircumference(float circumference) {
        this.circumference = circumference;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public boolean isRound() {
        return isRound;
    }

    public void setRound(boolean round) {
        isRound = round;
    }
}
