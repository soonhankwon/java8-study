package soon.java8study.java8api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("soon");
        names.add("han");
        names.add("kyu");
        names.add("ri");

//        names.forEach(System.out::println);
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();

        while (spliterator.tryAdvance(System.out::println));
        System.out.println("==============");
        while (spliterator1.tryAdvance(System.out::println));

        names.removeIf(s -> s.startsWith("h"));
        names.forEach(System.out::println);
        System.out.println("==============");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());
        System.out.println(names);
    }
}
