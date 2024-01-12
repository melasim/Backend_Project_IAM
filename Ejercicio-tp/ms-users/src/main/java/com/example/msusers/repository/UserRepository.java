package com.example.msusers.repository;

import com.example.msusers.domain.User;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class UserRepository implements IUserRepository{

    private final Keycloak keycloakClient;
    @Value("${ms.keycloak.realm}")
    private String realm;
    @Override
    public User findById(String id) {
        UserRepresentation userRepresentation = keycloakClient.realm(realm)
                .users()
                .get(id)
                .toRepresentation();
        User user = toUser(userRepresentation);
        return user;
    }

    private User toUser(UserRepresentation userRepresentation){
        return User.builder()
                .id(userRepresentation.getId())
                .username(userRepresentation.getUsername())
                .email(userRepresentation.getEmail())
                .firstname(userRepresentation.getFirstName())
                .build();
    }
}
