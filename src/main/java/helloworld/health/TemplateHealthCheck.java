package helloworld.health;

import com.yammer.metrics.core.HealthCheck;

/**
 * Created by indix on 30/8/16.
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        super("template");
        this.template = template;
    }

    @Override
    protected Result check() throws  Exception {
        final String saying = String.format(template, "TEST");
        System.out.println("HealthCheck");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
