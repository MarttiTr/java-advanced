package org.sda.model;

/**
 * 1. Create enum Planets.
 *         a) Override toString method. It should print relative size of a planet and it’s name.
 *         E.g. „Huge Jupiter”, „Small Pluto”.
 *         b) Create distanceFromEarth method.
 *         c) Verify both methods for multiple planets
 */


public enum Planets {
    Mars(250000, "Adjacent Mars"),
    Earth(3000000, "My Earth"),
    Jupiter(46000000, "Huge Jupiter"),
    Saturn(350000000, "Ring Saturn"),
    Pluto(100000, "Small Pluto"),
    Venus(150000, "Evening star Venus");

    private float relativeSize;
    private String name;

    Planets(float relativeSize, String name) {
        this.relativeSize = relativeSize;
        this.name = name;
    }

    public void setRelativeSize(float relativeSize) {
        this.relativeSize = relativeSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planets{" +
                "relativeSize=" + relativeSize +
                ", name='" + name + '\'' +
                '}';
    }

    public double distanceFromEarth() {

        return Earth.relativeSize - this.relativeSize; // This relativesize on nagu ükskõik milline planeet millega võrreldes tahame teada kaugust maast.
    }
}
