package lpnu.mapper;

import lpnu.entity.User;
import lpnu.dto.UserDTO;

public class UserMapper {
    public static UserDTO toDTO(final User user){
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPhone(user.getPhone());
        userDTO.setRole(user.getRole());
        userDTO.setStatus(user.getStatus());

        return userDTO;
    }

    public static User toEntity(final UserDTO userDTO){
        final User user = new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());

        return user;
    }
}
