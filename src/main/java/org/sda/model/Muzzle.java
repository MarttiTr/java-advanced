package org.sda.model;

/**
 *  Composition exercise
 *
 *  1. Create a muzzle class
 *  2. Create a muzzle object
 *  3. Assign the created object to a Dog object
 *  4. How to use a Dog object to show all attributes of a Muzzile object_
 */

public class Muzzle {
    private Long id;
    private int noiseRange;
    private boolean isTooNoisy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNoiseRange() {
        return noiseRange;
    }

    public void setNoiseRange(int noiseRange) {
        this.noiseRange = noiseRange;
    }

    public boolean isTooNoisy() {
        return isTooNoisy;
    }

    public void setTooNoisy(boolean tooNoisy) {
        isTooNoisy = tooNoisy;
    }
}
