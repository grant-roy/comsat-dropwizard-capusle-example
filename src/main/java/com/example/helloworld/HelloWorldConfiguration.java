package com.example.helloworld;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.HttpClientConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class HelloWorldConfiguration extends Configuration {


    @Valid
    @NotNull
    @JsonProperty
    private final HttpClientConfiguration httpClient = new HttpClientConfiguration();

    @JsonProperty
    public HttpClientConfiguration getHttpClientConfiguration() {
        return httpClient;
    }



}
