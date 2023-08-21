package soon.java8study.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureAppVer2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        boolean throwError = false;

        CompletableFuture<String> futureEx = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });

        CompletableFuture<String> futureHandle = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex)-> {
            if(ex != null) {
                System.out.println(ex);
                return "Error!";
            }
            return result;
        });
        System.out.println(futureEx.get());
        System.out.println("=======================");
        System.out.println(futureHandle.get());
        System.out.println("=======================");

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = hello.thenCompose(CompletableFutureAppVer2::getWorld);
        System.out.println(world.get());

        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(future.get());

        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);

        CompletableFuture<List<String>> results = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));

        System.out.println("=======================");
        results.get().forEach(System.out::println);

        System.out.println("=======================");
        CompletableFuture<Void> future3 = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
        future3.get();
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }
}
