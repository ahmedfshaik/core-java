package edu.home.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class ComparatorDemo5 {
	public static void main(String[] args) {
		List t = new Vector();
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
	public int compare(Object obj1, Object obj2) {
		String s1 = obj1.toString();
		String s2 = obj2.toString();
		int l1 = s1.length();
		int l2 = s2.length();
		if (l1 < l2)
			return -1;
		else if (l1 > l2)
			return +1;
		else
			return s1.compareTo(s2);
	}
}