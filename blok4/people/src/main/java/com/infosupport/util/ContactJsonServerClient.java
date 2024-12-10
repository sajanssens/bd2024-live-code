package com.infosupport.util;

import com.infosupport.domain.Contact;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@RegisterRestClient(
        configKey = "contactsJsonServerClient",
        baseUri = "http://localhost:3000")
@Path("contacts")
public interface ContactJsonServerClient {

    @GET
    @Produces(APPLICATION_JSON)
    List<Contact> getContacts();
}
