package soon.java8study.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> spring = () -> {
            Thread.sleep(1000L);
            return "Spring";
        };

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, spring));
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        System.out.println("=====================================");
        String any = executorService.invokeAny(Arrays.asList(hello, java, spring));
        System.out.println(any);

        System.out.println("=====================================");
        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

        helloFuture.cancel(true);
//        helloFuture.get(); // Blocking Call

        System.out.println(helloFuture.isDone());
        System.out.println("End!!!");
        executorService.shutdown();
    }
}
