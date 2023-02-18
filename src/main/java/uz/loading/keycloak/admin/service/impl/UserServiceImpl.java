package uz.loading.keycloak.admin.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import uz.loading.keycloak.admin.service.UserService;
import uz.loading.keycloak.admin.service.dto.UserDTO;
import uz.loading.keycloak.admin.service.mapper.UserMapper;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "keycloak-admin", name = "simulate", havingValue = "false")
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final RealmResource realmResource;
    private final Integer FIRST_ITEM = 0;


    @Override
    public UserRepresentation createUser(UserRepresentation userRepresentation) {

        var result = realmResource
                .users()
                .create(userRepresentation);
        log.debug("Result create user representation: {}", result.getEntity());
        return userRepresentation;
    }

    @Override
    public UserRepresentation updateUser(UserRepresentation newUser, String username) {

        var userFromDB = realmResource
                .users()
                .searchByUsername(username, false)
                .get(FIRST_ITEM);

        if (userFromDB != null) {
            newUser.setId(userFromDB.getId());
            realmResource
                    .users()
                    .create(newUser);
        }

        return newUser;
    }

    @Override
    public void removeUser(String userId) {
        var result = realmResource.users().delete(userId);
        log.debug("User removed result: {}", result);
    }

    @Override
    public void removeUserByUsername(String username) {

        var user = realmResource
                .users()
                .searchByUsername(username, false)
                .get(FIRST_ITEM);

        if (user != null) {
            var result = realmResource
                    .users()
                    .delete(user.getId());
            log.debug("User removed result: {}", result);
        }

        log.debug("User not found by username: {}", username);

    }

    @Override
    public UserRepresentation findByUsername(String username) {
        return realmResource
                .users()
                .searchByUsername(username, false)
                .get(0);

    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        var representation = userMapper.toRepresentation(userDTO);
        if (userDTO.getPassword() != null) {
            var credentials = new CredentialRepresentation();
            credentials.setType(CredentialRepresentation.PASSWORD);
            credentials.setValue(userDTO.getPassword());
            representation.setCredentials(List.of(credentials));
        }
        representation.setEmailVerified(true);
        representation = createUser(representation);
        return userMapper.toDTO(representation);
    }

}
