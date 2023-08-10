package soon.java8study.functionalinterface;

public class Foo {

    public static void main(String[] args) {
        // 함수형 인터페이스 -> 익명 내부 클래스 -> 람다
        RunSomething runSomething =
                () -> System.out.println("hello");
        runSomething.doIt();

        RunSomething2 runSomething2 = (number)
                -> number + 10;

        System.out.println(runSomething2.doIt(1));
        System.out.println(runSomething2.doIt(1));
        System.out.println(runSomething2.doIt(1));

        System.out.println(runSomething2.doIt(2));
        System.out.println(runSomething2.doIt(2));
        System.out.println(runSomething2.doIt(2));
    }
}
