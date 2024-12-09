package com.infosupport.resources;

import com.infosupport.domain.Contact;
import com.infosupport.repositories.ContactDataRepo;
import com.infosupport.repositories.ContactJPARepo;
import jakarta.enterprise.context.RequestScoped;
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

@Path("contacts") // implicitly @RequestScoped
@Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
public class ContactsResource {

    @Context UriInfo uri;

    @Inject ContactJPARepo repo;

    @Inject ContactResource contactResource;

    @GET
    public List<Contact> allByQ(@QueryParam("firstName") String firstName) {
        if (firstName == null || firstName.isBlank()) {
            return repo.findAll();
        } else {
            return repo.search(firstName);
        }
    }

    @POST
    public Response add(Contact contact) {
        Contact add = repo.add(contact);

        return Response
                .created(uri.getAbsolutePath())
                .entity(add).build();
    }

    @Path("{id}")
    public ContactResource toContactResource(@PathParam("id") int id){
        this.contactResource.setId(id);
        return this.contactResource;
    }


}
