package edu.home.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

//Provide sorting order for non-comparable built-in classes such as StringBuffer

class MyComparator implements Comparator {
    @Override
    public int compare(final Object o1, final Object o2) {
        final String str1 = o1.toString();
        final String str2 = o2.toString();
        return str1.compareTo(str2);
    }
}

public class ComparatorDemo2 {
    public static void main(final String[] args) {
        final StringBuffer sb1 = new StringBuffer("A");
        final StringBuffer sb2 = new StringBuffer("C");
        final StringBuffer sb3 = new StringBuffer("B");
        final List v = new Vector();
        v.add(sb1);
        v.add(sb2);
        v.add(sb3);
        // Collections.sort(v); //throws C.C.E since collection elements are non
        // comparable.
        Collections.sort(v, new MyComparator());
        System.out.println("After sorting....");
        System.out.println(v.toString()); // [A, B, C]
    }
}
