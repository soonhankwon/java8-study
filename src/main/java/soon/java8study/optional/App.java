package soon.java8study.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = optional.isPresent();
        boolean empty = optional.isEmpty();
        System.out.println(present);
        System.out.println(empty);

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));
        System.out.println("==================");

//        OnlineClass onlineClass = optional.orElse(createNewClass());
        OnlineClass onlineClass = optional.orElseGet(App::createNewClass);
        optional.orElseThrow(IllegalStateException::new);

        Optional<OnlineClass> onlineClass1 = optional.filter(oc -> !oc.isClosed());
        System.out.println(onlineClass1.isEmpty());

        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

//        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
//        Optional<Progress> progress1 = progress.orElseThrow();

        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
        progress.orElseThrow();

        System.out.println(onlineClass.getTitle());
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
