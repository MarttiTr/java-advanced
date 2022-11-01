package org.sda;

import org.sda.abstracts.Food;
import org.sda.abstracts.Fruit;
import org.sda.abstracts.Veggie;
import org.sda.exceptions.PersonNotFoundException;
import org.sda.models.Person;
import org.sda.service.PersonService;
import org.sda.service.implementations.PersonServiceImpl;

import javax.xml.namespace.QName;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws PersonNotFoundException {

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
        // Combining multiple exceptions
        try {
            int y = 10 / 0; // This line should throw expection
        } catch(ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException exception) {
            System.out.println("The value of y is not determined, Error:" + exception.getLocalizedMessage());
        }


        // Custom/User defined exceptions
        System.out.println(personService.findPersonByFirstName("Robin").toString());
        //System.out.println(personService.findPersonByFirstName("Raks").toString());

        // Catching user defined exception
        Person testPerson;
        try {
            testPerson = personService.findPersonByFirstName("Ingmar");

        } catch (PersonNotFoundException exception) {
            System.out.println("Person Ingmar is not found");

            //alternative code
            testPerson = new Person();
            testPerson.setFirstName("UNKNOWN");
            testPerson.setLastName("UNKNOWN last");
            testPerson.setAge(10);
        }
        System.out.println(testPerson.toString());


        // Homework exercise - exception handling

        try {
            displayNumber();
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            System.out.println("int -> " + i);
        } catch(InputMismatchException e) {
            System.out.println(e.getLocalizedMessage());
        }


        // Abstract class
        Fruit fruit = new Fruit("Red");
        fruit.eat();

        Food food = new Veggie("Green"); // We cannot instantiate (new Food()), but you can assign the child class to the abstract class
        food.eat();
    }

    public static void displayNumber() {

        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()) {
            int i = scanner.nextInt();
            System.out.println("int -> " + i);
        } else if(scanner.hasNextDouble()) {
            double d = scanner.nextDouble();
            System.out.println("double -> " + d);
        } else {
            throw new InputMismatchException("Hey, that´s not a value! Try once more!");
        }
    }
}