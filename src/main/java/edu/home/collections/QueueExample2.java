package edu.home.collections;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample2 {
    public static void main(final String[] args) {
        // Queue<String> qe=new PriorityQueue<String>(); ////elements order is
        // natural sorting order
        final Queue<String> qe = new PriorityQueue<>(Collections.reverseOrder()); //// elements
        //// order
        //// is
        //// customized
        //// sorting
        //// order
        
        qe.add("b");
        qe.add("a");
        qe.add("c");
        qe.add("e");
        qe.add("d");
        // qe.add(null); //not allowed
        System.out.println(qe);
        
        qe.remove();
        qe.remove();
        System.out.println(qe);
    }
}
