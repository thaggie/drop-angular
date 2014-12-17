package com.demo.resources;

import com.demo.dto.Saying;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.concurrent.atomic.AtomicLong;

@Path("/demo.json")
@Produces(MediaType.APPLICATION_JSON)
public class DemoResource {
    private final AtomicLong counter;

    public DemoResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("area") String area, @QueryParam("query") Optional<String> query) {
        return new Saying(counter.incrementAndGet(), "You sent: " + area +  " and " + query.or("(nothing)"));
    }
}