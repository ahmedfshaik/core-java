package edu.home.threads;

import java.util.concurrent.Callable;

//Define thread
public class CallableOne implements Callable<Integer> { // task
    @Override
    public Integer call() throws Exception {
        try {
            Thread.sleep(20 * 1000);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("callable");
        return new Integer("1234");
    }
}
