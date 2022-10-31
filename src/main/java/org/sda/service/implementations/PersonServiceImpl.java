package org.sda.service.implementations;

import org.sda.exceptions.PersonNotFoundException;
import org.sda.models.Person;
import org.sda.service.PersonService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Override
    public Person findPersonByFirstName(String firstName) throws PersonNotFoundException {
        Person resultPerson = null;

        // Search a person with a given firstname from the random list
        for(Person person: getRandomPersonList()) {// : - tähendab of!
              if(person.getFirstName().equals(firstName)) {
                resultPerson = person;
                break;
            }
        }

        // If the person is not found then throw an exception
        if(resultPerson == null) {
            throw new PersonNotFoundException(firstName); // Whenever you use throw PersonNotFoundExeption, you need to declear it in method aswell as throws PersonNotFoundExcecption
        }

        return resultPerson;
    }



    // PRIVATE METHODS //
    private List<Person> getRandomPersonList() {

        Person person1 = new Person();
        person1.setFirstName("Tuuli");
        person1.setLastName("Mägi");
        person1.setAge(12);

        Person person2 = new Person();
        person2.setFirstName("Margus");
        person2.setLastName("Kask");
        person2.setAge(9);

        Person person3 = new Person();
        person3.setFirstName("Ragnar");
        person3.setLastName("Jõgi");
        person3.setAge(6);

        Person person4 = new Person();
        person4.setFirstName("Robin");
        person4.setLastName("Kool");
        person4.setAge(22);



        return List.of(person1,person2,person3,person4);
    }
}