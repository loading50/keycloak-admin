package uz.loading.keycloak.admin.service.mapper;

import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;
import uz.loading.keycloak.admin.service.dto.UserDTO;

@Mapper
public interface UserMapper {

    UserDTO toDTO(UserRepresentation representation);

    UserRepresentation toRepresentation(UserDTO userDTO);

}
