package uz.loading.keycloak.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "keycloak-admin")
public class KeycloakAdminProperties {

    private Boolean simulate;
    private String realm;
    private String clientId;
    private String username;
    private String password;
    private String url;

}
