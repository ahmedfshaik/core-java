package edu.home.collections;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add("ten");
		l.add(10);
		l.add(null);
		l.add(null);
		l.addFirst("one");
		System.out.println(l); //[one, ten, 10, null]
		l.removeLast();
		l.removeFirst();
		System.out.println(l);//[ten, 10]

	}

}
