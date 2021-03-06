package edu.home.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExpressionEx4 {
    
    public static void main(final String[] args) {
        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        
        /*
         * Predicate<Integer> predicate = new Predicate<Integer>() {
         * 
         * @Override
         * public boolean test(Integer n) {
         * return true;
         * }
         * };
         */
        // Predicate<Integer> predicate = n -> true
        // n is passed as parameter to test method of Predicate interface
        // test method will always return true no matter what value n has.
        
        System.out.println("Print all numbers:");
        
        // pass n as parameter
        eval(list, n -> true);
        
        /*
         * Predicate<Integer> predicate = new Predicate<Integer>() {
         * 
         * @Override
         * public boolean test(Integer n) {
         * return n % 2 == 0;
         * }
         * };
         */
        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n%2 comes to be zero
        
        System.out.println("Print even numbers:");
        eval(list, n -> n % 2 == 0);
        /*
         * Predicate<Integer> predicate = new Predicate<Integer>() {
         * 
         * @Override
         * public boolean test(Integer n) {
         * return n > 3;
         * }
         * };
         */
        // Predicate<Integer> predicate2 = n -> n > 3
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n is greater than 3.
        
        System.out.println("Print numbers greater than 3:");
        eval(list, n -> n > 3);
    }
    
    public static void eval(final List<Integer> list, final Predicate<Integer> predicate) {
        for (final Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}
