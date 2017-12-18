package edu.home.collections;

import java.util.Stack;

public class StackDemo {
    public static void main(final String[] args) {
        final Stack<String> s = new Stack<>();
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
