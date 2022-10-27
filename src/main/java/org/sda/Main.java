package org.sda;

import org.sda.models.Person;
import org.sda.service.PersonService;
import org.sda.service.implementations.PersonServiceImpl;

public class Main {
    public static void main(String[] args) {

        //INTERFACE
        Person person = new Person();
        person.setFirstName("Martti");
        person.setLastName("Triksberg");
        person.setAge(22);

        // Left side should be interface name, right side should be interface´s implementation class name
        PersonService personService = new PersonServiceImpl();

        System.out.println("Person´s birth year: " + personService.getPersonBirthYear(person.getAge()));
        System.out.println("Person´s full name: " + personService.getPersonFullName(person));

        System.out.println("Person´s last name: " + person.getLastName());

        // Exceptions
        // - exception handling
        try{
            int[] intArray = {1, 4, 56, 7};
            System.out.println(intArray[4]);
        }
          catch(ArrayIndexOutOfBoundsException e) { // e on variable nimi, võib kasutada ja nt arrayIndexOutOfBoundException
            System.out.println("The number cannot be printed because its unavailable in the array!");
        } catch(Exception exception) {
            System.out.println("Exception being caught");
        } finally { // finally plokk ei sõltu try-catchist, alati töötab.
            int a = 15;
            System.out.println("THIS BLOCK WILL BE EXECUTED NO MATTER WHAT" + a);
        }

    }
}