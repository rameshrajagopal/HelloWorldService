package helloworld.core;

/**
 * Created by indix on 30/8/16.
 */
public class Saying {
    private final long id;
    private final String content;

    public Saying(long id, String content) {
        System.out.println("op=Saying()");
        this.id = id;
        this.content = content;
    }

    public long getId() {
        System.out.println("op=getId()");
        return id;
    }

    public String getContent() {
        System.out.println("op=getContent()");
        return content;
    }

}
