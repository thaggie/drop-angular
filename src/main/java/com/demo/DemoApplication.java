package com.demo;

import health.DemoHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.jetty.MutableServletContextHandler;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.eclipse.jetty.servlet.ServletHolder;

import com.demo.resources.DemoResource;

public class DemoApplication extends Application<DemoConfig> {
    public static void main(String[] args) throws Exception {
        new DemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "demo-app";
    }

    @Override
    public void initialize(Bootstrap<DemoConfig> bootstrap) {
    }

    @Override
    public void run(DemoConfig configuration, Environment environment) {
    	MutableServletContextHandler ac = environment.getApplicationContext();
    	ServletHolder sh = ac.addServlet(AngularServlet.class, "/*");
        sh.setInitParameter(AngularServlet.URL, configuration.getUrl());

        final DemoResource helloResource = new DemoResource();
        environment.jersey().register(helloResource);

        DemoHealthCheck angularServletHealthCheck = new DemoHealthCheck();
        environment.healthChecks().register("demo", angularServletHealthCheck);
    }
}