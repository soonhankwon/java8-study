package soon.java8study.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsApp {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName());
            }
        });

        executorService.submit(() -> System.out.println("Thread " + Thread.currentThread().getName()));
        executorService.shutdown(); //graceful shutdown
    }
}
