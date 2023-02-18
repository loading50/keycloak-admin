package uz.loading.keycloak.admin.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String enabled;
    private List<String> roles;
}
