package com.sendgrid.resources;

import com.sendgrid.api.Parse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ParseResource {

    @GET
    public String hello() {
        return "hello";
    }

    @POST
    @Path("/inbound")
    @Consumes(MediaType.APPLICATION_JSON)
    public String inbound(Parse parse) {
        System.out.println(parse.getEnvelope());
        return "OK";
    }
}


