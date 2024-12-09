package com.infosupport.resources;

import com.infosupport.domain.Contact;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Dependent // gets same scope as the bean from where it is injected
public class ContactResource {

    private int id;

    @GET
    public Response one() {
        return Response.ok()
                .entity(new Contact(id, "Bram", "Janssens", "45@42.com"))
                .build();
    }

    @GET @Path("laptops")
    public String contactLaptops() {
        return "Alle laptops van " + this.id;
    }

    @GET @Path("laptops/{laptopId}")
    public String contactLaptop(@PathParam("laptopId") int lapId) {
        return "één laptop van één contact met id " + id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
