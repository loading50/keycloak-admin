package uz.loading.keycloak.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.loading.keycloak.admin.config.KeycloakAdminProperties;

@SpringBootApplication
@EnableConfigurationProperties(KeycloakAdminProperties.class)
public class KeycloakAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeycloakAdminApplication.class, args);
    }
}
