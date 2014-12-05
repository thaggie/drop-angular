package com.demo;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class DemoConfig extends Configuration {
    @NotEmpty
    private String url;

    public DemoConfig() {
    	
    }
    
    @JsonProperty
    public String getUrl() {
        return url;
    }

    @JsonProperty
    public void setUrl(String name) {
        this.url = name;
    }
}