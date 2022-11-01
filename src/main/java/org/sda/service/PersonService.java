package org.sda.service;

import org.sda.exceptions.PersonNotFoundException;
import org.sda.models.Person;

import java.time.LocalDate;

/**
 * PersonService interface to handle Person related operations
 *
 * @author Martti Triksberg
 */

public interface PersonService {    // In Interface dont start with public/private jne, alustab kohe meetodist. Alati kui interfacele kirjutad selgitust, siis alati kirjutada juurde mida
                                    // mingi asi tähendab. Ainult methodi deklareerimine ja selgitus on interfaces.
                                    // All methods are public and abstract by default, cant define protected/private methods.
    static final int AVERAGE_AGE = 20; // See näide, saab deklareerida static fielde, aga ei saa kirjutada nt int averageAge = 20;

    /**
     * To get the birth year of the Person
     *
     * @param age Age of the person
     * @return Birth year
     */
    int getPersonBirthYear(int age);

    /**
     * To get the full name of the person
     * @param person Person model
     * @return Full name as String
     */

    String getPersonFullName(Person person);

    /**
     * To find the Person by first name
     * @param firstName Firstname of a Person
     * @return Person
     */
    Person findPersonByFirstName(String firstName) throws PersonNotFoundException;


    //static method definition is allowed   for example:
    static int getAverageAge() {
        return AVERAGE_AGE;
    }

}
