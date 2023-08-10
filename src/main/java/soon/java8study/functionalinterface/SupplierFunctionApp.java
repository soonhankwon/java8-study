package soon.java8study.functionalinterface;

import java.util.function.Supplier;

public class SupplierFunctionApp {

    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> 10;

        System.out.println(get10.get());
    }
}
