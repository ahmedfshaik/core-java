package edu.home.collections;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack<String> s=new Stack<String>();
		s.push("C");
		s.push("B");
		s.push("A");
		s.push(null);
		s.push(null);
		s.forEach(System.out::println);
		System.out.println("------------");
		
		s.pop();
		s.forEach(System.out::println);
	}
}
