package org.sda.model;

/**
 * List of PaymentType
 *
 * @author Martti Triksberg
 */

public enum PaymentType {  // An enum is a type that has a predefined set of values
    CARD(1, "CARD"),
    CASH(2, "CASH"),
    BANK_TRANSFER(3, "Bank transfer"),
    MOBILE_BANKING(4, "Mobile banking"),
    BANK_LINK(5, "Bank link");
    // Can make getter and setter/ Constructors for enums aswell.
    private int value;
    private String name;

    PaymentType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
