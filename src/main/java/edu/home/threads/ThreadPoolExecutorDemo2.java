package edu.home.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(final Runnable r, final ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " is rejected");
    }
}

public class ThreadPoolExecutorDemo2 {
    public static void main(final String[] args) {
        final RunnableOne r = new RunnableOne();
        final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(3);
        final RejectedExecutionHandlerImpl rejectHandler = new RejectedExecutionHandlerImpl();
        final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 30, TimeUnit.SECONDS, queue, rejectHandler); // Put
        // break
        // point
        try {
            threadPool.execute(r); // pool-1-thread-1
            threadPool.execute(r); // pool-1-thread-2
            
            threadPool.execute(r); // added to queue
            threadPool.execute(r); // added to queue
            threadPool.execute(r); // added to queue
            
            threadPool.execute(r); // pool-1-thread-3
            threadPool.execute(r); // pool-1-thread-4
            
            threadPool.execute(r); // task is rejected but handled
            threadPool.execute(r); // task is rejected but handled
            threadPool.execute(r); // task is rejected but handled
        } finally {
            threadPool.shutdown();
        }
    }
}
