package uz.loading.keycloak.admin.service;

import org.keycloak.representations.idm.UserRepresentation;
import uz.loading.keycloak.admin.service.dto.UserDTO;

public interface UserService {

    UserRepresentation createUser(UserRepresentation userRepresentation);

    UserRepresentation updateUser(UserRepresentation userRepresentation, String username);

    void removeUser(String userId) throws Throwable;

    void removeUserByUsername(String username);

    UserRepresentation findByUsername(String username);

    UserDTO createUser(UserDTO userDTO);
}
