package uz.loading.keycloak.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import uz.loading.keycloak.admin.service.UserService;
import uz.loading.keycloak.admin.service.dto.UserDTO;

@Slf4j
@Service
@ConditionalOnProperty(prefix = "keycloak-admin", name = "simulate", havingValue = "true", matchIfMissing = true)
public class UserServiceSimulate implements UserService {

    @Override
    public UserRepresentation createUser(UserRepresentation userRepresentation) {
        log.debug("Simulate is enable");
        return userRepresentation;
    }

    @Override
    public UserRepresentation updateUser(UserRepresentation userRepresentation, String username) {
        log.debug("Simulate is enable");
        return userRepresentation;
    }

    @Override
    public void removeUser(String userId) throws Throwable {
        log.debug("Simulate is enable");
    }

    @Override
    public void removeUserByUsername(String username) {
        log.debug("Simulate is enable");
    }

    @Override
    public UserRepresentation findByUsername(String username) {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.debug("Simulate is enable");
        return userDTO;
    }
}
