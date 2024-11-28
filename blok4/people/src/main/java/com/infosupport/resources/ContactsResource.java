package com.infosupport.resources;

import com.infosupport.domain.Contact;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static java.util.Comparator.comparingInt;

@Path("contacts")
@Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
public class ContactsResource {

    private static ArrayList<Contact> contacts = new ArrayList<>(List.of(
            new Contact(1, "Bram1", "Janssens", "45@42.com"),
            new Contact(2, "Bram2", "Janssens", "45@42.com"),
            new Contact(3, "Bram3", "Janssens", "45@42.com"),
            new Contact(4, "Bram4", "Janssens", "45@42.com"))
    );

    @GET
    public List<Contact> allByQ(@QueryParam("q") String q, @QueryParam("firstName") String f) {
        if (q == null || q.isBlank()) {
            return contacts;
        } else {
            return contacts.stream()
                    .filter(c -> c.firstName().contains(q) ||
                            c.surname().contains(q) ||
                            c.email().contains(q))
                    .toList();
        }
    }

    @POST
    public Contact add(Contact contact) {
        int maxId = contacts.stream()
                .max(comparingInt(Contact::id))
                .map(Contact::id)
                .orElse(0);

        Contact newContact = new Contact(++maxId, contact.firstName(), contact.surname(), contact.email());

        contacts.add(newContact);
        return newContact;
    }

    @GET @Path("{id}")
    public Response one(@PathParam("id") int id) {
        return Response.ok()
                .entity(new Contact(id, "Bram", "Janssens", "45@42.com"))
                .build();
    }
}
