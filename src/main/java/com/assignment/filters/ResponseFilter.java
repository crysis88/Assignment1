package com.assignment.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Calendar;

@Provider
public class ResponseFilter implements ContainerResponseFilter {

    private static final Logger log = LogManager.getLogger(ResponseFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        String requestTime = requestContext.getHeaders().getFirst("requestTime");
        if (requestTime != null) {
            long requestT = Long.parseLong(requestTime);
            long currentTime = Calendar.getInstance().getTime().getTime();
            log.info("Request Uri: " + requestContext.getUriInfo().getAbsolutePath());
            log.info("Time take for request is " + (currentTime - requestT) + "ms");
        }
    }
}
