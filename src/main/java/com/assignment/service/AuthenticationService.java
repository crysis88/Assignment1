package com.assignment.service;

import com.assignment.model.Token;
import com.assignment.model.User;
import com.assignment.repository.AuthenticationRepository;

import javax.inject.Inject;
import java.util.UUID;

public class AuthenticationService {

    @Inject
    private AuthenticationRepository authenticationRepository;

    public Token generateToken(String username, String password) {
        User user = authenticationRepository.verifyUserDetails(username, password);
        if (user != null) {
            Token token = new Token();
            token.setToken(UUID.randomUUID().toString());
            authenticationRepository.storeToken(user.getId(), token.getToken());
            return token;
        } else {
            return null;
        }

    }

    public boolean verifyToken(String token) {
        return authenticationRepository.verifyToken(token);
    }
}
