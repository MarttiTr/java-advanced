package org.sda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Person model
 *
 * @author Martti Triksberg
 */
@AllArgsConstructor
@Getter
@ToString
public class Person { // Outer class(Nested classes teema)
    private String firstName;
    private String lastName;
    private String userName;
    private int age;

    public boolean isAdult() {
        return age >= 18;
    }

    @Getter
    @Setter
    @ToString
    //Non-static nested class: We dont use static keyword. Can access outer class parameters
    public class Employee{ // Inner class (Nested classes teema)
        private String address;
        public void userName() {
            userName = firstName.concat(lastName).toLowerCase().replace(" ", ""); // Changing the value of outerclass (Person class)
        }
    }

    @Getter
    @Setter
    @ToString
    //Static nested class: We cant access outer class parameters
    public static class Customer{
        public void userName(Person person) { // As this class cant acces outer class we give this method a outer class parameters
            person.userName = person.firstName.concat(person.lastName).toUpperCase().replace(" ", "");
        }
    }
}
