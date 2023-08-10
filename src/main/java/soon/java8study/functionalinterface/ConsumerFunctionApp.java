package soon.java8study.functionalinterface;

import java.util.function.Consumer;

public class ConsumerFunctionApp {

    public static void main(String[] args) {
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);
    }
}
