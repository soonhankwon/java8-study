package soon.java8study.functionalinterface;

import java.util.function.Predicate;

public class PredicateFunctionApp {

    public static void main(String[] args) {
        Predicate<String> startsWithSoon = (s) -> s.startsWith("soon");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

        System.out.println(startsWithSoon.test("soon"));
        System.out.println(isEven.test(3));
    }
}
