package com.assignment.resource;


import com.assignment.model.Token;
import com.assignment.service.AuthenticationService;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/login")
public class AuthenticationResource {

    @Inject
    private AuthenticationService authenticationService;


    @POST
    @Produces("application/json")
    public Response getToken(@FormParam("username") String username, @FormParam("password") String password) {
        Token token = authenticationService.generateToken(username, password);
        return Response.ok().entity(token).build();
    }
}
