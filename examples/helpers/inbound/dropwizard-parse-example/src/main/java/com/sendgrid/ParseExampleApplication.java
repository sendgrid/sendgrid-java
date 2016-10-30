package com.sendgrid;

import com.sendgrid.resources.ParseResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ParseExampleApplication extends Application<ParseExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ParseExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "ParseExample";
    }

    @Override
    public void initialize(final Bootstrap<ParseExampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ParseExampleConfiguration configuration,
                    final Environment environment) {
        final ParseResource resource = new ParseResource();
        environment.jersey().register(resource);
    }

}
