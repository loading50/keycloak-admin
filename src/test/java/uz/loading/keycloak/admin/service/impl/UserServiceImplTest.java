package uz.loading.keycloak.admin.service.impl;

import org.junit.jupiter.api.Test;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.loading.keycloak.admin.config.TestConfig;
import uz.loading.keycloak.admin.service.UserService;

import java.util.List;


@SpringBootTest(classes = TestConfig.class)
class UserServiceImplTest {

    private final static String USERNAME = "loading";

    @Autowired
    private UserService userService;

    @Test
    public void createUserTest() throws Throwable {
        var user = userService.findByUsername(USERNAME);
        if (user != null) {
            userService.removeUser(user.getId());
        }
        var result = userService.createUser(getUserRep());
        System.out.println(result);
        var result2 = userService.findByUsername(USERNAME);
        System.out.println(result2);
        assert result != null;
        assert result2 != null;
    }

    private UserRepresentation getUserRep() {
        var userRep = new UserRepresentation();
        userRep.setFirstName("Azizbek");
        userRep.setLastName("Kuchkarov");
        userRep.setEmail("aaa@gmail.com");
        userRep.setEmailVerified(true);
        userRep.setUsername(USERNAME);
        userRep.setEnabled(true);
        var credential = new CredentialRepresentation();
        credential.setTemporary(false);
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue("loading123");
        userRep.setCredentials(List.of(credential));
        return userRep;
    }

}