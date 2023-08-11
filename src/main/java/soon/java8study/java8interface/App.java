package soon.java8study.java8interface;

public class App {

    public static void main(String[] args) {
        DefaultFoo foo = new DefaultFoo("soon");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
