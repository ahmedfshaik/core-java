package edu.home.collections;

import java.util.Vector;

public class VectorDemo {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.addElement(1); // auto boxing
		v.addElement(new Integer(5));
		v.add(new Integer(3));
		v.add(new Integer(3)); // allows duplicate element
		v.add(null); // allows null value
		v.add(null); // duplicate null value
		v.add(0, new Integer(4)); // adding element using index position
		v.add("hello");
		System.out.println(v.toString()); // [4, 1, 5, 3, 3, null, null, hello]
	}
}
