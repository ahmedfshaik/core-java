package edu.home.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo3 {
    public static void main(final String[] args) throws Exception {
        final CallableOne c = new CallableOne();
        final ExecutorService threadPool = Executors.newCachedThreadPool();
        
        final Future<Integer> future = threadPool.submit(c);
        System.out.println("future done? " + future.isDone()); // may be false
        final Integer result = future.get(); // blocks the current thread and
                                             // waits
        // until the callable task completes
        // before returning the actual result
        System.out.println("future done? " + future.isDone()); // always true
        System.out.print("result: " + result);
    }
}
