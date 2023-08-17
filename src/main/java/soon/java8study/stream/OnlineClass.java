package soon.java8study.stream;

import lombok.Getter;

@Getter
public class OnlineClass {

    private Integer id;
    private String title;
    private boolean closed;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }
}
