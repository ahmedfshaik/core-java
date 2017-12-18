package edu.home.java8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachEx1 {
    
    public static void main(final String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        
        // Old approach using Iterator
        final Iterator<String> ittr = friends.iterator();
        while (ittr.hasNext()) {
            final String friend = ittr.next();
            System.out.print(friend + " ");
        }
        System.out.println("");
        
        // Enhanced for loop
        for (final String friend : friends) {
            System.out.print(friend + " ");
        }
        System.out.println("");
        
        // Using forEach() method added to Iterable in Java 8
        friends.forEach(new Consumer<String>() {
            
            @Override
            public void accept(final String friend) {
                System.out.print(friend + " ");
            }
        });
        System.out.println("");
        
        // Using forEach() method added to Iterable and Lambda expression Java 8
        friends.forEach(friend -> System.out.print(friend + " "));
        System.out.println("");
        
        // Using forEach() method added to Iterable, Lambda expression and
        // Method references in Java
        // 8
        friends.forEach(System.out::println);
    }
}
