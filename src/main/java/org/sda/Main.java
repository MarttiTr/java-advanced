package org.sda;

import org.sda.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1. LAMBDA EXPRESSION
        // 1.1 Predicate
        Person person = new Person("Martti", "Triksberg","martti" ,22);
        Predicate<Person> personTest = test -> test.getAge() > 20; // lambda expression
        System.out.println(personTest.test(person));

        // 1.2 Method reference
        Predicate<Person> personTest2 = Person::isAdult; //Method reference -> ClassName::MethodName
        System.out.println(personTest2.test(person));

        // 1.3 Supplier: Doesn´t take any arguments but returns/supplies only the value
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(); // No argument but returns random value
        System.out.println(randomNumberSupplier.get()); // get() should be called always

        // 1.4 Consumer: It takes an argument and returns nothing
        Consumer<Person> printPerson = p -> System.out.println("Person first name:" + p.getFirstName() + " ,Last name:" + p.getLastName());
        printPerson.accept(person); // accept() method should be called always

        // 1.5 Operator:
        UnaryOperator<Integer> toSquare = i -> i * i; //Unaryoperator - works with 1 operator.
        System.out.println(toSquare.apply(4)); // apply() should be called always

        // 2. OPTIONAL
        Person person3 = new Person("Tony", "Stark","tony" ,22);

        Optional<Person> optionalPerson = Optional.of(person3);

        if(optionalPerson.isEmpty()) {
            System.out.println("Person cannot be printed!");
        } else {
            System.out.println(optionalPerson.get().toString());
        }

        optionalPerson.ifPresent(person1 -> System.out.println(person1)); // - Sama asi aga lihtsamalt. Rida 41-44


        System.out.println(getRandomPerson().toString()); // Optinali näite printline.


        // 3. STREAMS - mainly used with lists and arrays (Java > 8 alates)
        List<String> carList = List.of("BMW", "Audi", "Skoda", "Toyota", "Ford");

        carList.stream()
                .findFirst()
                .ifPresent(System.out::println); // Prints BMW - First item from list. findFirst() -> Optional<T> // <T> - on any type

        carList.stream()
                .findAny()
                .ifPresent(System.out::println); // findAny() -> Optional<T>    : Finds random element in the List and prints it.

        // 3.1 Stream filter - used to apply a condition to the list and filter the list by the condition
        List<String> filteredCars = carList.stream()
                .filter(s -> s.length() >= 5)  // Filter returns Stream<T>
                .collect(Collectors.toList());  // Concert Stream<T> to List<T>

        filteredCars.forEach(s ->  {
            String prefixed  = "Car: " + s;
            System.out.println(prefixed);
        });

        // 3.2 Stream - map: used to apply an operation to all the elements in the list
        List<Integer> carLengths = carList.stream()
                .map(String::length)
                .collect(Collectors.toList());Collectors.toList();

                carLengths.forEach(System.out::println);


       // 3.3  Stream - allMatch(): used to check if all the elements in the list are matching a given condition
        boolean isAllCarsGreaterThanFive = carList.stream()
                .allMatch(s -> s.length() >= 5); // s represent element in the list
        System.out.println(isAllCarsGreaterThanFive); // Annab false, sest kõigi autode suurus ei suurem/võrdne kui viis.


        // 3.4 Stream - anyMatch(): used to check if atleast one element in the list matches the given condition
        boolean isAnyCarStartingWithB = carList.stream()
                .anyMatch(s -> s.startsWith("B")); // Starts-with is case-sensitive
        System.out.println(isAnyCarStartingWithB);


        // 3.5 Stream - reduce method: Used to reduce the list to String/other type
        String cars = carList.stream()
                .reduce("",((s, s2) -> (s.equals("") ? "" : s + ", ") + s2)); // Automaatselt läheb edasi Listis.
        System.out.println(cars);


        // 3.6 Stream - sorted
        carList.stream() // This example puts all the items in the list to alphabetical order
                .sorted()
                .forEach(System.out::println);

        carList.stream() // Reversed alphabetical order
                .sorted((car1, car2) -> car2.compareTo(car1)) // 2 tüüpi .sorted() on olemas, üks comparable ja see siin näites
                .forEach(System.out::println);

        carList.stream() // Alternative way reversed alphabetical order
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);


        // 4 Nested class
        //   non-static
        Person person4 = new Person("Helar", "Rangooski", "helar", 85);
        System.out.println(person4.getUserName()); // Outer class method call

        Person.Employee employee = person4.new Employee(); // To acces inner class method. (Outerclass.Innerclass)
        employee.userName();
        System.out.println(person4.getUserName());


        // 4.1 static
        Person person5 = new Person("Ivo", "Kukk", "ivo", 37);
        System.out.println(person5.getUserName()); // Outer class method call

        Person.Customer customer = new Person.Customer(); // Diffrence in the object instantiation
        customer.userName(person5);
        System.out.println(person5.getUserName());
    }
        // 2.1 optional-orElse näide
    private static Person getRandomPerson() {
        //Optional<Person> optionalPerson = Optional.empty();
        Optional<Person> optionalPerson = Optional.of(new Person("Captain", "Estonia","captain" ,22));
        Person person2 = new Person("Marek", "Austin","marek" ,33); // Backup subst

        return optionalPerson.orElse(person2);
    }
}