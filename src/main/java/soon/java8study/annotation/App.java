package soon.java8study.annotation;

import java.util.Arrays;
import java.util.List;

@Chicken("source")
@Chicken("garlic")
public class App {

    public static void main(String[] args) throws RuntimeException {
        List<String> names = Arrays.asList("soon");

        FeelsLikeChicken.print("today's menu is chicken");
        FeelsLikeChicken.print(0.12345);

        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(i -> System.out.println(i.value()));

        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(i ->
                System.out.println(i.value()));
    }

    static class FeelsLikeChicken<@Chicken("ice") T> {

        public static <@Chicken("fried") C> void print(@Chicken("turkey") C c) {
            System.out.println(c);
        }
    }
}
