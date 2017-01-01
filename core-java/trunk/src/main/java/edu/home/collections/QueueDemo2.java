package edu.home.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo2 {

	public static void main(String[] args) {
		// Queue q = new PriorityQueue(); // uses natural sorting order.
		Queue q = new PriorityQueue(new StrComparator()); // uses customized
		// sorting order.
		q.add("b");
		q.add("d");
		q.add("a");
		q.add("c");
		System.out.println(q.toString()); // [b, c, z, d]
		System.out.println(q.remove());// b
		System.out.println(q.remove()); // c
		System.out.println(q.remove());// d
		System.out.println(q.remove());// z
	}

}

class StrComparator implements Comparator<String> {
	public int compare(String str1, String str2) {
		return -str1.compareTo(str2);
	}
}