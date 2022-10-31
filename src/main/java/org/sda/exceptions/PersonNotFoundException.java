package org.sda.exceptions;

/**
 *  Doing our own exception called PersonNotFoundException
 *  Handles if person is not found
 *
 *  @author Martti Triksberg
 */
// Tehes oma exceptioni, pead alati panema extends Exception.

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(String name) {
        super(String.format("The person (%s) is not found!", name));
    }
}
