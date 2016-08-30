package helloworld.services;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import helloworld.health.TemplateHealthCheck;
import helloworld.resources.HelloWorldResource;
import helloworld.resources.TimeResource;


/**
 * Created by indix on 30/8/16.
 */
public class HelloWorldService extends Service<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        System.out.println("Bootstrapped");
        bootstrap.setName("hello-world");
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {
        //nothing
        System.out.println("Hello World Service Started...");
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        final String defaultTz = configuration.getDefaultTimeZone();

        System.out.println("template=" + template + ", defaultName=" + defaultName);
        environment.addResource(new HelloWorldResource(template, defaultName, defaultTz));
        environment.addResource(new TimeResource(template, defaultName, defaultTz));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }
}
