package edu.home.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Capitalize each name
public class StreamEx1 {
    public static void main(final String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> uppercaseNames = new ArrayList<>();
        
        // Imperative style -- older approach
        for (final String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }
        System.out.println(uppercaseNames);
        uppercaseNames.clear();
        
        // Using Lambda, forEach() in Java 8
        friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
        System.out.println(uppercaseNames);
        uppercaseNames.clear();
        
        // Using Lambda, forEach(), map() method in Stream interface in Java 8
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> uppercaseNames.add(name));
        System.out.println(uppercaseNames);
        uppercaseNames.clear();
        
        System.out.println("*************");
        friends.stream()
                // .map(name->name.toUpperCase())
                .forEach(name -> uppercaseNames.add(name.toUpperCase()));
        System.out.println(uppercaseNames);
        uppercaseNames.clear();
        
        // Using Lambda, forEach(), map() method in Stream interface, Method
        // reference in Java 8
        friends.stream()
                .map(String::toUpperCase)
                .forEach(name -> uppercaseNames.add(name));
        System.out.println(uppercaseNames);
    }
}
