package org.sda.service.implementations;

import org.sda.models.Person;
import org.sda.service.PersonService;

import java.time.LocalDate;

/**
 * Implementation of person service
 *
 * @author Martti Triksberg
 */

public class PersonServiceImpl implements PersonService {
    @Override
    public int getPersonBirthYear(int age) {
        return LocalDate.now().getYear() - age;
    }

    @Override
    public String getPersonFullName(Person person) {
        return person.getFirstName() + " " + person.getLastName();
    }
}
