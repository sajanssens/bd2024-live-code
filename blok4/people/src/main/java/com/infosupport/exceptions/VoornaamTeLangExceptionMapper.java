package com.infosupport.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
public class VoornaamTeLangExceptionMapper implements ExceptionMapper<VoornaamTeLangException> {
    @Override
    public Response toResponse(VoornaamTeLangException exception) {
        return Response.status(BAD_REQUEST)
                .entity("Voornaam " + exception.getMessage() + ".")
                .build();
    }
}
