package edu.home.threads;

public class MultihreadDemo {
    public static void main(final String[] args) {
        final RunnableOne r = new RunnableOne(); // put break point here
        
        final Thread t1 = new Thread(r);
        final Thread t2 = new Thread(r);
        
        t1.start();
        t2.start();
    }
}
