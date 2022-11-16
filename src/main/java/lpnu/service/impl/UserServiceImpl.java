package lpnu.service.impl;

import lpnu.dto.UserDTO;
import lpnu.entity.User;
import lpnu.entity.enums.Status;
import lpnu.exception.ServiceException;
import lpnu.mapper.UserMapper;
import lpnu.repository.UserRepository;
import lpnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO create(final UserDTO userDTO) {

        final User user = UserMapper.toEntity(userDTO);
        user.setStatus(Status.ACTIVE);
        userRepository.saveUser(user);

        return UserMapper.toDTO(user);
    }

    @Override
    public void delete(final Long id) {
        userRepository.delete(id);
    }

    @Override
    public UserDTO update(final UserDTO userDTO) {
        if (userDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }
        final User user = UserMapper.toEntity(userDTO);

        userRepository.update(user);

        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO findById(final Long id) {

        return UserMapper.toDTO(userRepository.findById(id));
    }
}
