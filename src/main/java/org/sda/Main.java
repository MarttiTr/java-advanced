package org.sda;

import org.sda.model.Person;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        // LAMBDA EXPRESSION
        // Predicate
        Person person = new Person("Martti", "Triksberg", 22);
        Predicate<Person> personTest = test -> test.getAge() > 20; // lambda expression
        System.out.println(personTest.test(person));

        // Method reference
        Predicate<Person> personTest2 = Person::isAdult; //Method reference -> ClassName::MethodName
        System.out.println(personTest2.test(person));

        // Supplier: Doesn´t take any arguments but returns/supplies only the value
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(); // No argument but returns random value
        System.out.println(randomNumberSupplier.get()); // get() should be called always

        // Consumer: It takes an argument and returns nothing
        Consumer<Person> printPerson = p -> System.out.println("Person first name:" + p.getFirstName() + " Last name:" + p.getLastName());
        printPerson.accept(person); // accept() method should be called always

        // Operator:
        UnaryOperator<Integer> toSquare = i -> i * i; //Unaryoperator - works with 1 operator.
        System.out.println(toSquare.apply(4)); // apply() should be called always

    }
}