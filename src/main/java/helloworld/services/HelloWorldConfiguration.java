package helloworld.services;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by indix on 30/8/16.
 */
public class HelloWorldConfiguration extends com.yammer.dropwizard.config.Configuration {
    @NotEmpty
    @JsonProperty
    private String template;

    @NotEmpty
    @JsonProperty
    private String defaultName = "Stranger";

    @NotEmpty
    @JsonProperty
    private String defaultTimeZone;

    public String getDefaultTimeZone() {
        return defaultTimeZone;
    }

    public String getTemplate() {
        System.out.println("op=getTemplate()");
        return template;
    }

    public String getDefaultName() {
        System.out.println("op=getDefaultName()");
        return defaultName;
    }
}
