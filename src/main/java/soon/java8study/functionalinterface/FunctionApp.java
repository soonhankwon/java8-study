package soon.java8study.functionalinterface;

import java.util.function.Function;

public class FunctionApp {

    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        Function<Integer, Integer> plus10v2 =
                (num) -> num + 10;
        System.out.println(plus10v2.apply(1));

        Function<Integer, Integer> multiply2 =
                (num) -> num * 2;
        System.out.println(multiply2.apply(1));

        System.out.println(plus10v2.compose(multiply2).apply(2));
        System.out.println(plus10v2.andThen(multiply2).apply(2));
    }
}
