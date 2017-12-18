package edu.home.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class ComparatorDemo5 {
    public static void main(final String[] args) {
        final List t = new Vector();
        t.add(new StringBuffer("ABC"));
        t.add(new StringBuffer("AA"));
        t.add("XX");
        t.add("ABCD");
        t.add("A");
        Collections.sort(t, new LengthComparator());
        System.out.println(t);// [A, AA, XX, ABC, ABCD]
    }
}

class LengthComparator implements Comparator {
    @Override
    public int compare(final Object obj1, final Object obj2) {
        final String s1 = obj1.toString();
        final String s2 = obj2.toString();
        final int l1 = s1.length();
        final int l2 = s2.length();
        if (l1 < l2) {
            return -1;
        } else if (l1 > l2) {
            return +1;
        } else {
            return s1.compareTo(s2);
        }
    }
}