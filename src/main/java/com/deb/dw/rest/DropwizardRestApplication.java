package com.deb.dw.rest;

import com.deb.dw.rest.health.TemplateHealthCheck;
import com.deb.dw.rest.resources.DropwizardRestResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardRestApplication extends Application<DropwizardRestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardRestApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropwizardRest";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardRestConfiguration> bootstrap) {

    }

    @Override
    public void run(final DropwizardRestConfiguration configuration,
            final Environment environment) {

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);

        final DropwizardRestResource resource = new DropwizardRestResource(
                configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);
    }
}
