package edu.home.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
    public static void main(final String[] args) {
        // Vector<String> names = new Vector<String>();
        final List<String> names = new ArrayList<>();
        names.add("Rohit");
        names.add("Abhay");
        names.add("Manisha");
        names.add("Kumar");
        names.add("Kumar");
        System.out.println(names.toString()); // prints all elements at a time
        
        // Retrieve elements using Enumeration
        /*
         * Enumeration<String> e = names.elements();
         * while(e.hasMoreElements()){
         * String name = e.nextElement();
         * System.out.print(name+" ");
         * }
         * System.out.println();
         */
        
        // Retrieve elements using Iterator
        final Iterator<String> ittr = names.iterator();
        while (ittr.hasNext()) {
            final String name = ittr.next();
            System.out.print(name + " ");
            /*
             * if(name.equals("Manisha")){
             * ittr.remove();
             * }
             */
        }
        System.out.println();
        
        // Retrieve elements using Iterator
        final ListIterator<String> littr = names.listIterator();
        while (littr.hasNext()) {
            final String name = littr.next();
            System.out.print(name + " ");
            /*
             * if(name.equals("Manisha")){
             * littr.set("mAnIsHa");;
             * }
             */
        }
        System.out.println();
        
        // Retrieve elements using Enhanced for loop
        for (final String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
        
        // Retrieve elements using Lambda expressions
        names.forEach(name -> System.out.print(name + " "));
        
        System.out.println();
        
        // Retrieve elements using Method reference
        names.forEach(System.out::println);
    }
}
