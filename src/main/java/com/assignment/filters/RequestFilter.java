package com.assignment.filters;

import com.assignment.service.AuthenticationService;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@Provider
public class RequestFilter implements ContainerRequestFilter {

    @Inject
    private AuthenticationService authenticationService;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
       /* Date date = Calendar.getInstance().getTime();
        MultivaluedMap<String, String> headers = requestContext.getHeaders();
        if (headers.containsKey("token")) {
            boolean authenticated = authenticationService.verifyToken(headers.getFirst("token"));
            if (authenticated) {
                headers.putSingle("requestTime", String.valueOf(date.getTime()));
            } else {
                requestContext.abortWith(Response.status(Response.Status.BAD_REQUEST).entity("Token is not valid!!").build());
            }
        } else if (requestContext.getUriInfo().getPath().contains("login")) {
            headers.putSingle("requestTime", String.valueOf(date.getTime()));
        } else {
            requestContext.abortWith(Response.status(Response.Status.BAD_REQUEST).entity("Use /login endpoint for obtaining token").build());
        }*/

    }
}
