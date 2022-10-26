package org.sda.model;

/**
 * List of PaymentType
 *
 * @author Martti Triksberg
 */

public enum PaymentType {  // An enum is a type that has a predefined set of values
    CARD(1),
    CASH(2),
    BANK_TRANSFER(3),
    MOBILE_BANKING(4),
    BANK_LINK(5);
    // Can make getter and setter/ Constructors for enums aswell.
    private int value;

    PaymentType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
