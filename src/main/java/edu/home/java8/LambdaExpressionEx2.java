package edu.home.java8;

public class LambdaExpressionEx2 {
    public static void main(final String[] args) {
        // Anonymous Runnable
        final Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("*****");
            }
        };
        
        // Lambda Runnable
        final Runnable r2 = () -> System.out.println("#########");
        
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
