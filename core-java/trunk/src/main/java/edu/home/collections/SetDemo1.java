package edu.home.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {
	public static void main(String[] args) {
		//Set<String> names = new HashSet<String>();
		//Set<String> names = new LinkedHashSet<String>();
		Set<String> names = new TreeSet<String>();
		
		names.add("arti");
		names.add("ajay");
		names.add("siva");
		names.add("roopal");
		names.add("roopal");
		//names.add(null);
		//names.add(null);
		System.out.println(names.toString());
	}
}
