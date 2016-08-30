package helloworld.resources;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import helloworld.core.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by indix on 30/8/16.
 */
@Path("hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private final String defaultTz;

    public HelloWorldResource(String template, String defaultName, String defaultTz) {
        System.out.print("op=HelloWorldResouce, creatingObject");
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.defaultTz = defaultTz;
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        System.out.println("op=sayHelloEp, Passed=" + name + ", default=" + defaultName);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone tz = TimeZone.getTimeZone(defaultTz);
        formatter.setTimeZone(tz);
        return new Saying(counter.incrementAndGet(), String.format(template, name.or(defaultName), formatter.format(new Date()), defaultTz));
    }
}

