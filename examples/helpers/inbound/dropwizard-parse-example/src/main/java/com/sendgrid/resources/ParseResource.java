package com.sendgrid.resources;

import com.sendgrid.api.Parse;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String inbound(@FormDataParam("data") Parse parse) {
        System.out.println(parse.getEnvelope());
        return "OK";
    }
}


