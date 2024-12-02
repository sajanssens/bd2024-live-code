package com.infosupport.resources;

import com.infosupport.domain.Contact;
import com.infosupport.domain.ContactDto;
import com.infosupport.repositories.ContactInMemoryRepo;
import com.infosupport.repositories.Repo;
import jakarta.inject.Inject;
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

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static java.util.Comparator.comparingInt;

@Path("contacts")
@Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
public class ContactsResource {

    @Context UriInfo uri;

    @Inject ContactInMemoryRepo repo;

    @GET
    public List<Contact> allByQ(@QueryParam("q") String q) {
        if (q == null || q.isBlank()) {
            return repo.findAll();
        } else {
            return repo.search(q);
        }
    }

    @POST
    public Response add(ContactDto contactDto) {
        Contact add = repo.add(contactDto);

        return Response
                .created(uri.getAbsolutePath())
                .entity(add).build();
    }

    @GET @Path("{id}")
    public Response one(@PathParam("id") int id) {
        return Response.ok()
                .entity(new Contact(id, "Bram", "Janssens", "45@42.com"))
                .build();
    }
}
