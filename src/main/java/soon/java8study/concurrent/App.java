package soon.java8study.concurrent;

public class App {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        System.out.println("====================");

        Thread thread = new Thread(() -> {
            while(true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("exit!");
                    return;
                }
            }
        });
        thread.start();
        Thread.sleep(3000L);
        thread.interrupt();

        thread.join();
        System.out.println("Main Worker");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("Hello: " + Thread.currentThread().getName());
        }
    }
}
