package soon.java8study.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Foo {

    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> 10;
        BinaryOperator<Integer> sum = (a,b) -> a + b;

        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        final int baseNumber = 10;

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                // shadowing
                System.out.println(baseNumber);
            }
        };

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11; //shadowing
                System.out.println(baseNumber); //11
            }
        }

        // 변수 캡쳐
        IntConsumer printInt = (i) -> {
//            int baseNumber = 11; // 람다를 감싸고 있는 스콥이랑 같다. (not shadowing)
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }
}
