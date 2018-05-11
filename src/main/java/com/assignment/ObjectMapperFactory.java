package com.assignment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.hk2.api.Factory;

public class ObjectMapperFactory implements Factory<ObjectMapper> {

    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ObjectMapper provide() {
        return objectMapper;
    }

    @Override
    public void dispose(ObjectMapper instance) {

    }
}
