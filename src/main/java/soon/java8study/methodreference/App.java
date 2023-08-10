package soon.java8study.methodreference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        Function<Integer, String> intToString =
                (i) -> "number";

        Greeting greeting = new Greeting();
        UnaryOperator<String> hi = greeting::hello;
        System.out.println(hi.apply("soon"));

        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting1 = newGreeting.get();
        System.out.println(greeting1.hello("soon"));

        Function<String, Greeting> nameGreeting
                = Greeting::new;
        Greeting soon = nameGreeting.apply("han");
        System.out.println(soon.hello());

        String[] names = {"soon", "kyu", "han"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
