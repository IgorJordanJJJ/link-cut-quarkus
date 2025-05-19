package org.jordan.pro.app;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class GreetingResource {

    private static final Logger log = LoggerFactory.getLogger(GreetingResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        MyEntity test = new MyEntity();
        test.field = "test";
        log.info(test.field);
        return "Hello from Quarkus REST";
    }
}
