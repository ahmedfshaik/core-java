package edu.home.collections;

import java.util.Arrays;
import java.util.List;

public class SortDemo1 {
    public static void main(final String[] args) {
        final List<String> names = Arrays.asList("Divya", "Amol", "Sheyas", "Rohit");
        
        /*
         * Collections.sort(names);
         * names.forEach(name->System.out.print(name+" "));
         */
        
        names.sort(null); // null means Natural Sorting Order Using
                          // java.lang.Comparable
        names.forEach(name -> System.out.print(name + " "));
    }
}
