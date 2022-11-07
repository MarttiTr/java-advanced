package org.sda;

import org.sda.generics.*;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // GENERIC TYPE
        Fruit fruit = new Fruit();
        fruit.setName("Apple");
        fruit.setColor("Green");
        fruit.setPrice(BigDecimal.valueOf(1.99)); // converting a double value to BigDecimal

        GenericFood<Fruit> genericFoodWithFruit = new GenericFood<>(fruit);
        System.out.println(genericFoodWithFruit.getItem());

        String str = "I´m a great developer";
        GenericFood<String> genericFoodWithString = new GenericFood<>(str);
        System.out.println(genericFoodWithString.getItem());

        genericFoodWithString.setItem("I´m a good person!");
        System.out.println(genericFoodWithString.getItem());

        // Generic type - extends
        Vegetable vegetable = new Vegetable();
        GenericExtendFood<Vegetable> vegetableGenericExtendFood = new GenericExtendFood<>(vegetable);
        System.out.println(vegetableGenericExtendFood.getRating());

        // Generic type - interface
        Snack snack1 = new Snack(5);
        Snack snack2 = new Snack(3);
        System.out.println("Snack 1 is better than Snack 2: " + snack1.isBetter(snack2));

        // List
        List<String> animalList = new ArrayList<>();
        animalList.add("Lion");
        animalList.add("Tiger");
        animalList.add("Dog");
        animalList.add("Cat");
        animalList.add("Bear");
        animalList.add("Panda");

        System.out.println(animalList.get(1)); // Prints tiger

        animalList.remove(1); // Tiger will be deleted
        animalList.remove("Dog");

        for(String animal: animalList) {
            System.out.println(animal);
        }

        // Iterator
        Iterator<String> stringIterator = animalList.listIterator();
        while(stringIterator.hasNext()) {
            System.out.println(stringIterator.next() + " ,");
        }

        // Continues block 38-54, List of items to be removed
        List<String> removeAnimalList = new ArrayList<>();
        removeAnimalList.add("Cat");
        removeAnimalList.add("Panda");

        animalList.removeAll(removeAnimalList);

        // Final Removed list
        for(String animal: animalList) {
            System.out.println(animal);
        }


        // SET - on case sensitive
        Set<String> countrySet = new HashSet<>();
        countrySet.add("Eesti");
        countrySet.add("Saksamaa");
        countrySet.add("Poola");
        countrySet.add("Rootsi");
        // countrySet.add("Eesti"); -> Duplicates not allowed.

        for (String country: countrySet) { // Non-sorted, randomly stored
            System.out.println(country);
        }

        System.out.println("Before sorting: " + countrySet);
        TreeSet<String> countryTreeset = new TreeSet<>(countrySet); // Stored as sorted alphabetically
        System.out.println("After sorting: " + countryTreeset);


        // MAP - A Map is an object that maps keys to values. A map cannot contain duplicate keys: Each key can map to at most one value.
        // 1) Map of fullname
        Map<String, String> fullName = new HashMap<>(); // Non sorted as stored
        fullName.put("Vinod", "John"); // Esimene on key, teine on value.
        fullName.put("Martti", "Triksberg");
        fullName.put("Marko", "Piir");

        System.out.println(fullName);
        System.out.println(fullName.get("Vinod")); // Vinod: on key, mis annab value milleks on: John
        System.out.println(fullName.remove("Marko"));

        System.out.println(fullName);

        // 2) Map of name and age
        Map<String, Integer> nameAndAge = new HashMap<>();
        nameAndAge.put("Martti", 22);
        nameAndAge.put("Vinod", 32);
        nameAndAge.put("Marko", 22);

        System.out.println(nameAndAge);

        // 3) Map of friends(Map of List)
        Map <String, List<String>> friendsMap = new HashMap<>();
        List<String> marttiFriendList = List.of("Tony", "Marko", "Tiina");
        List<String> tiinaFriendList = List.of("Joosep", "Kätlin", "Karl");

        friendsMap.put("Martti", marttiFriendList);
        friendsMap.put("Tiina", tiinaFriendList);

        System.out.println(friendsMap);

        // 4) Map of maps
        Map<String, Map<String, String>> detailsMap = new HashMap<>();
        Map<String, String> vinodInfoMap = new HashMap<>();
        vinodInfoMap.put("age", "15");
        vinodInfoMap.put("birthPlace", "Tartu");
        vinodInfoMap.put("residence", "Estonia");
        vinodInfoMap.put("phone", "123456");
        detailsMap.put("vinod", vinodInfoMap);

        System.out.println(detailsMap);


        // Input & Output (I/O)
        // creating a file object
        File absoluteFile = new File("C:\\Users\\37256\\main\\java-advanced\\src\\main\\resources\\myText.txt");
        File relativeFile = new File("myText.txt");

        // File reading (reading mytext.txt line)
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(absoluteFile));
            String fileLine; // To store the line of text from the file.

            while((fileLine = bufferedReader.readLine()) != null) {
                System.out.println(fileLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // File writing
        try {
            FileWriter fileWriter = new FileWriter(absoluteFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String fileLine = "\n I can write error-less Java code :D";
            bufferedWriter.write(fileLine);
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // I/O Serializzation: Writing an object to a file
        String fileName = "file.ser";

        try{
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(file);

            outputStream.writeObject(fruit);
            outputStream.close();
            file.close();  // Closing the file

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Deserialization: To get/read an object from a file.
        Fruit deserializedFruit = null;

        try{
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream inputStream = new ObjectInputStream(file);

            deserializedFruit =(Fruit) inputStream.readObject();

            inputStream.close();
            file.close();

            System.out.println(deserializedFruit.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        // New I/O (From java 8+...)
        Path absolutePath = Paths.get("C:\\Users\\37256\\main\\java-advanced\\src\\main\\resources\\myText.txt");
        Path relativePath = Paths.get("myText.txt");

        try {
            //File reading - For reading-writing we use List<String>
            List<String> fileLines = Files.readAllLines(absolutePath, StandardCharsets.UTF_8);

            //Just to print the file which was read above
            for(String fileLine: fileLines) {
                System.out.println(fileLine);
            }

            //File writing
            List<String> fileLinesToWrite = List.of("I love Java!", "Estonian is my country!");
            Files.write(absolutePath, fileLinesToWrite, StandardOpenOption.APPEND); // Append lisab vanale failile selle uue osa mis lisada tahame otsa.


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}