package com.example.helloworld;

import co.paralleluniverse.fibers.dropwizard.FiberApplication;
import co.paralleluniverse.fibers.dropwizard.FiberHttpClientBuilder;
import com.example.helloworld.resources.HelloWorldResource;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.http.client.HttpClient;

public class HelloWorldApplication extends FiberApplication<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {


        System.out.println(System.getProperty("java.class.path"));
        new HelloWorldApplication().run(args);
    }

    //
    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
    }

    @Override
    public void fiberRun(HelloWorldConfiguration configuration,
            final Environment environment) throws ClassNotFoundException {

        final HttpClient fhc = new FiberHttpClientBuilder(environment).
                using(configuration.getHttpClientConfiguration()).
                build("FiberHttpClient");

        final HelloWorldResource helloWorldResource = new HelloWorldResource(
                //pass the fiber wrapped http client to our Rest Resource
                fhc

        );
        environment.jersey().register(helloWorldResource);

    }
}
