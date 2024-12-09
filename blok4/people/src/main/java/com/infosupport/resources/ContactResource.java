package com.infosupport.resources;

import com.infosupport.domain.Contact;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Dependent // gets same scope as the bean from where it is injected
public class ContactResource {

    private int id;

    @GET
    public Response read() {
        return Response.ok()
                .entity(new Contact(id, "Bram", "Janssens", "45@42.com"))
                .build();
    }

    @DELETE
    public Response del() {
        return Response.noContent().entity("Deleted contact " + id).build();
    }

    @PUT
    public Response update() {
        return Response.ok().entity("Updated contact " + id).build();
    }

    @GET @Path("aangiftes")
    public String contactLaptops() {
        return "Alle aangiftes van " + this.id;
    }

    @GET @Path("aangiftes/{aangifteId}")
    public String contactLaptop(@PathParam("aangifteId") int aangifteId) {
        return "één aangifte van één contact met id " + id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
