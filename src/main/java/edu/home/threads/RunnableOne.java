package edu.home.threads;

//Define thread
public class RunnableOne implements Runnable { // task
    @Override
    public void run() {
        try {
            Thread.sleep(20 * 1000);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("runnable");
    }
}
