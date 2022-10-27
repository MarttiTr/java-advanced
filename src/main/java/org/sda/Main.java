package org.sda;

import org.sda.model.*;

import java.util.Arrays;

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

        Passenger passenger = new Passenger(PaymentType.CARD, "Pärnu");
        passenger.setEmail("passanger@gmail.com"); //Access Person fields using Passenger object

        PrivatePassenger privatePassenger = new PrivatePassenger(PaymentType.CARD, "Viljandi");
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
        Person person4 = new Passenger(PaymentType.CARD, "Viljandi");
        System.out.println(person3.toString());
        System.out.println(person4.toString());

        // Calling parent methods - using keyword super.

        Passenger passenger1 = new Passenger();
        passenger1.setAddress("Tallinn"); // Person.address
        passenger1.setDestinationAddress("Tartu"); // Passenger.destinationAddress
        System.out.println(passenger1.getAddresses());

        // Calling parent´s hidden field
        passenger1.getHiddenAlive();

        // Passing parameters
        Passenger passenger2 = new Passenger(123456L, "Tallinn", PaymentType.CARD, "Tartu");
        printPersonAddress(passenger2);
        printPassengerWithPrefix("Person", passenger2);

        //Composition exercise
        Muzzle muzzle = new Muzzle();
        muzzle.setId(890L);
        muzzle.setNoiseRange(10);
        muzzle.setTooNoisy(true);

        Dog dog1 = new Dog(true, "DOBER");
        dog1.setMuzzle(muzzle);

        System.out.println(dog1.getMuzzle().toString());


        // Enums
        System.out.println(PaymentType.CARD);
        System.out.println(PaymentType.values()); // Ei prindi kuna pole arrays to string
        System.out.println(PaymentType.BANK_TRANSFER.getValue()); // Annab mulle value, mis ma bank transferile panin paymenttype enumi alt.

        for(PaymentType paymentType: PaymentType.values()) {
            System.out.println(paymentType.name());
        }

        System.out.println(PaymentType.MOBILE_BANKING.toString());


        // Enum(planet) exercise
        System.out.println(">>>>>>>>>>>>>>PLANETS<<<<<<<<<<<<<<<<<<<");
        System.out.println(Planets.Jupiter.toString());
        System.out.println("Distance of " + Planets.Jupiter.name() + " from Earth: " + Planets.Jupiter.distanceFromEarth());
        System.out.println("------------------");
        System.out.println(Planets.Mars.toString());
        System.out.println("Distance of " + Planets.Mars.name() + " from Earth: "+ Planets.Mars.distanceFromEarth()) ;
    }

    private static void printPersonAddress(Person person) {
        System.out.println(person.getAddress());
    }

    private static void printPassengerWithPrefix(String prefix, Object object) {
        System.out.println(prefix + object);


    }
}




