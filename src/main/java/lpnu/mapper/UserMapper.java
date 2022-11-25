package lpnu.mapper;

import lpnu.entity.User;
import lpnu.dto.UserDTO;

public class UserMapper {
    public static UserDTO toDTO(final User user){
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setCodeForAuth(user.getCodeForAuth());
        userDTO.setCoffeeBean(user.getCoffeeBean());
        userDTO.setStatus(user.getStatus());

        return userDTO;
    }

    public static User toEntity(final UserDTO userDTO){
        final User user = new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setCodeForAuth(userDTO.getCodeForAuth());
        user.setCoffeeBean(userDTO.getCoffeeBean());
        user.setStatus(userDTO.getStatus());

        return user;
    }
}
