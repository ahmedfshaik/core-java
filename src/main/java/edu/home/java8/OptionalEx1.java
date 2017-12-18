package edu.home.java8;

import java.util.Optional;

public class OptionalEx1 {
    
    public static void main(final String[] args) {
        final Integer value1 = null;
        final Integer value2 = new Integer(10);
        
        // System.out.println(value1 + value2); //null pointer exception
        
        final int sum = Optional.ofNullable(value1).orElse(new Integer(0)) + Optional.ofNullable(value2).orElse(new Integer(0));
        System.out.println("The result:" + sum);
    }
}
