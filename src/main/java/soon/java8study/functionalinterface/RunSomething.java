package soon.java8study.functionalinterface;

@FunctionalInterface
public interface RunSomething {

    // 추상 메서드가 1개라면 -> functionalInterface
    void doIt();

    static void printName() {
        System.out.println("soon");
    }

    default void printAge() {
        System.out.println("35");
    }
}
