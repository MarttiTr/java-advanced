package org.sda;

import org.sda.model.*;

public class Main {
    public static void main(String[] args)  {
        // No argument constructor call:
        Person person = new Person();
        System.out.println(person.toString());
        System.out.println(person.getId());

        // All argument constructor call:
        Person person1 = new Person(12345L, "Martti", "Triksberg", "triksberg.martti@gmail.com", "+37256948284", "Rohu 107, Pärnu");
        System.out.println(person1.toString());
        System.out.println(person1.getEmail());

        Person person2 = new Person();
        person2.setFirstName("Margus");
        person2.setLastName("Mäearu");
        System.out.println(person2.getFirstName());
        System.out.println(person2.getLastName());


        Dog dog = new Dog(true, "GERMAN SHEPPERD");
        System.out.println(dog);
        System.out.println(dog.getAge());
        System.out.println(dog.getWeight());

        //Inheritance

        Passenger passenger = new Passenger("CARD", "Pärnu");
        passenger.setEmail("passanger@gmail.com"); //Access Person fields using Passenger object

        PrivatePassenger privatePassenger = new PrivatePassenger("CARD", "Viljandi");
        privatePassenger.setPersonalIDCode("238938498349");
        privatePassenger.setDestinationAddress("Tartu"); // Access Passengers field
        privatePassenger.setPhoneNumber("+3725895399"); // Access Person´s field

        // Overriding

        Person personOverride = new Person();
        personOverride.setEmail("triksberg.martti@gmail.com");
        System.out.println(personOverride.getEmail());

        Passenger passengerOverride = new Passenger();
        passengerOverride.setEmail("triksberg.martti@gmail.com");
        System.out.println(passengerOverride.getEmail());

        // Polymorphism

        Person person3 = new Person(12345L, "Pärnu");
        Person person4 = new Passenger("CARD", "Viljandi");
        System.out.println(person3.toString());
        System.out.println(person4.toString());

        // Calling parent methods

        Passenger passenger1 = new Passenger();
        passenger1.setAddress("Tallinn"); // Person.address
        passenger1.setDestinationAddress("Tartu"); // Passenger.destinationAddress
        System.out.println(passenger1.getAddresses());

    }
}




