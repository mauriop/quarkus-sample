package org.acme.spring.di;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
public class GreeterResource {

    @Autowired
    GreeterBean greeterBean;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "performedCalls", description = "How many calls have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public String hello() {
        return greeterBean.greet("my world");
    }
}