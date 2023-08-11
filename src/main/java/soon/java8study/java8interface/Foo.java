package soon.java8study.java8interface;

public interface Foo {

    void printName();

    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    };

    String getName();

    static void printAnything() {
        System.out.println("FOO");
    }
}
