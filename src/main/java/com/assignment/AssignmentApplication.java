package com.assignment;

import com.assignment.repository.AuthenticationRepository;
import com.assignment.resource.EmployeeResource;
import com.assignment.service.AuthenticationService;
import com.assignment.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.katharsis.core.properties.KatharsisProperties;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class AssignmentApplication extends ResourceConfig {

    public static final String APPLICATION_URL = "http://localhost:8080";

    public AssignmentApplication() {
        packages(true, "com.assignment");
        property(KatharsisProperties.RESOURCE_SEARCH_PACKAGE, "com.assignment.resource");
        property(KatharsisProperties.RESOURCE_DEFAULT_DOMAIN, APPLICATION_URL);
        //packages(true, "com.assignment");
        register(KatharsisDynamicFeature.class);
        register(new AbstractBinder() {
            @Override
            public void configure() {
                bindFactory(ObjectMapperFactory.class).to(ObjectMapper.class).in(Singleton.class);
                bindService(EmployeeResource.class);
                bindService(EmployeeService.class);
                bindService(com.assignment.repository.EmployeeRepository.class);
                bindService(AuthenticationService.class);
               bindService(AuthenticationRepository.class);
            }

            private void bindService(Class<?> serviceType) {
                bind(serviceType).to(serviceType).proxy(true).in(RequestScoped.class);
            }
        });
    }
}
