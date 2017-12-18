package edu.home.java8;

import java.util.Arrays;
import java.util.List;

public class MethodRefEx2 {
    
    public static void main(final String[] args) {
        final List<Integer> asList = Arrays.asList(4, 6, 10, 3, 6);
        
        // Static method reference
        System.out.println("Descending order");
        asList.sort(MethodRefEx2::comapreToStatic);
        asList.forEach(System.out::println);
        // Instance method reference
        final MethodRefEx2 methodTest = new MethodRefEx2();
        System.out.println("Ascending order");
        asList.sort(methodTest::comapreToNonStatic);
        asList.forEach(System.out::println);
    }
    
    private static Integer comapreToStatic(final Integer e1, final Integer e2) {
        return e2.compareTo(e1);
    }
    
    private Integer comapreToNonStatic(final Integer e1, final Integer e2) {
        return e1.compareTo(e2);
    }
}
