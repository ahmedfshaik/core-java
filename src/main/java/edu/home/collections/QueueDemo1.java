package edu.home.collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo1 {
	public static void main(String[] args) {
		Queue qe=new LinkedList(); //Elements order is insertion order i.e., FIFO
		qe.add("b");
		qe.add("a");
		qe.add("c");
		qe.add("e");
		qe.add("d");
		qe.add(null);
		System.out.println(qe.toString()); //[b, a, c, e, d]
		qe.remove();
		qe.poll();
		System.out.println(qe.toString());//[c, e, d]
		qe.element();
		qe.peek();
		System.out.println(qe.toString()); //[c, e, d]
		qe.offer("z");
		qe.add("y");
		System.out.println(qe.toString());//[c, e, d, z, y]
		}
}
