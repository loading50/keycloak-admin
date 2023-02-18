package uz.loading.keycloak.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

    public static final String KEYCLOAK_ADMIN_OBJECT_MAPPER = "KEYCLOAK_ADMIN_OBJECT_MAPPER";
    private final KeycloakAdminProperties keycloakAdminProperties;

    @Bean(KEYCLOAK_ADMIN_OBJECT_MAPPER)
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    protected Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl(keycloakAdminProperties.getUrl())
                .realm(keycloakAdminProperties.getRealm())
                .clientId(keycloakAdminProperties.getClientId())
                .username(keycloakAdminProperties.getUsername())
                .password(keycloakAdminProperties.getPassword())
                .grantType(OAuth2Constants.PASSWORD)
                .build();
    }

    @Bean
    protected RealmResource realmRepresentation(Keycloak keycloak) {
        return keycloak.realm(keycloakAdminProperties.getRealm());
    }
}