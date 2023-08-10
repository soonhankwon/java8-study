package soon.java8study.methodreference;

public class Greeting {

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public String hello() {
        return "hello " + this.name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }
}
