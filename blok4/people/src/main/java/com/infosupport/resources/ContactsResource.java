package com.infosupport.resources;

import com.infosupport.domain.Contact;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("contacts")
@Produces(APPLICATION_JSON)
public class ContactsResource {

    @GET
    public List<Contact> all() {
        return List.of(
                new Contact(1, "Bram1", "Janssens", "45@42.com"),
                new Contact(2, "Bram2", "Janssens", "45@42.com"),
                new Contact(22, "Bram2", "Janssens", "45@42.com"),
                new Contact(3, "Bram3", "Janssens", "45@42.com"));
    }

    @GET
    @Path("{id}")
    public Contact two(@PathParam("id") int id) {
        return new Contact(id, "Bram", "Janssens", "45@42.com");
    }
}
