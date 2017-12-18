package edu.home.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java program to solve Producer Consumer problem using put() and take()
 * methods in java.util.concurrent.BlockingQueue.
 * Producer Consumer is also a popular concurrency design pattern.
 *
 */
public class ProducerConsumerPattern {
    public static void main(final String args[]) {
        // Creating shared object
        final BlockingQueue<Runnable> sharedQueue = new ArrayBlockingQueue<>(3);
        final ExecutorService threadPool = Executors.newFixedThreadPool(2);
        
        // Executing Producer and Consumer tasks
        threadPool.execute(new Producer(sharedQueue));
        threadPool.execute(new Consumer(sharedQueue));
        
        threadPool.shutdown();
    }
}

// Producer Class in java
class Producer implements Runnable {
    private final BlockingQueue sharedQueue;
    
    public Producer(final BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (final InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

// Consumer Class in Java
class Consumer implements Runnable {
    private final BlockingQueue sharedQueue;
    
    public Consumer(final BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + sharedQueue.take());
            } catch (final InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
