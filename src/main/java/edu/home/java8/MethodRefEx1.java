package edu.home.java8;

import java.util.Arrays;
import java.util.List;

public class MethodRefEx1 {
    
    public static void main(final String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        
        // Lambda approach
        friends.forEach(friend -> System.out.println(friend));
        
        // Method reference approach
        friends.forEach(System.out::println);
    }
}
