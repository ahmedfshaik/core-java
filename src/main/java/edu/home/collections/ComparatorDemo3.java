package edu.home.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
//Provide sorting technique other than natural sorting order for built-in comparable classes.
public class ComparatorDemo3 {
	public static void main(String[] args) {
		String s1 = "A";

		String s2 = "C";
		String s3 = "B";
		List list = new Vector();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		Collections.sort(list); // Natural sorting order
		System.out.println("Ascending Order:");
		System.out.println(list.toString()); // O/P: [A, B, C]
		Collections.sort(list, new StringDescendingOrder()); // Descending order
		System.out.println("Descending Order:");
		System.out.println(list.toString()); // O/P: [C, B, A]
	}
}
class StringDescendingOrder implements Comparator {
	public int compare(Object o1, Object o2) {
		String str1 = o1.toString();
		String str2 = o2.toString();
		return -str1.compareTo(str2);
	}
}