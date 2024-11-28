package com.infosupport.resources;

import com.infosupport.domain.ContactDto;
import com.infosupport.domain.Contact;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.ArrayList;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static java.util.Comparator.comparingInt;

@Path("contacts")
@Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
public class ContactsResource {

    @Context UriInfo uri;

    private static final ArrayList<Contact> contacts = new ArrayList<>(List.of(
            new Contact(1, "Bram1", "Janssens", "45@42.com"),
            new Contact(2, "Bram2", "Janssens", "45@42.com"),
            new Contact(3, "Bram3", "Janssens", "45@42.com"),
            new Contact(4, "Bram4", "Janssens", "45@42.com"))
    );

    @GET
    public List<Contact> allByQ(@QueryParam("q") String q,
                                @QueryParam("firstName") String f) {
        if (q == null || q.isBlank()) {
            return contacts;
        } else {
            return contacts.stream()
                    .filter(c -> c.getFirstName().contains(q) ||
                            c.getSurname().contains(q) ||
                            c.getEmail().contains(q))
                    .toList();
        }
    }

    @POST
    public Response add(ContactDto contactDto) {
        int maxId = contacts.stream()
                .max(comparingInt(Contact::getId))
                .map(Contact::getId)
                .orElse(0);

        Contact newContact = new Contact(++maxId, contactDto.firstName(), contactDto.surname(), contactDto.email());

        contacts.add(newContact);

        return Response
                .created(uri.getAbsolutePath())
                .entity(newContact).build();
    }

    @GET @Path("{id}")
    public Response one(@PathParam("id") int id) {
        return Response.ok()
                .entity(new Contact(id, "Bram", "Janssens", "45@42.com"))
                .build();
    }
}
