package soon.java8study.stream;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("soon");
        names.add("han");
        names.add("kyu");
        names.add("ri");

        List<String> collect1 = names.parallelStream()
                .map(s -> {
                    System.out.println(s + " " + Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .toList();
        collect1.forEach(System.out::println);

        List<String> collect = names.stream()
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                }).toList();
        collect.forEach(System.out::println);

        System.out.println("==============");

        names.forEach(System.out::println);
    }
}
