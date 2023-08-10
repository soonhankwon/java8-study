package soon.java8study.functionalinterface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorApp {

    public static void main(String[] args) {
        UnaryOperator<Integer> plus10v2 =
                (num) -> num + 10;
        UnaryOperator<Integer> multiply2 =
                (num) -> num * 2;

        BinaryOperator<Integer> plus =
                (num1, num2) -> num1 + num2;

        System.out.println(plus.apply(10, 10));
    }
}
