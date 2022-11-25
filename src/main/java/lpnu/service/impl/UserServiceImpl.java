package lpnu.service.impl;

import lpnu.dto.UserDTO;
import lpnu.entity.User;
import lpnu.entity.enums.Status;
import lpnu.exception.ServiceException;
import lpnu.mapper.UserMapper;
import lpnu.repository.UserRepository;
import lpnu.service.MailSender;
import lpnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MailSender mailSender;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO create(final UserDTO userDTO) {

        final User user = UserMapper.toEntity(userDTO);
        user.setCodeForAuth(UUID.randomUUID().toString());
        user.setStatus(Status.INACTIVE);
        userRepository.saveUser(user);

        final String message = String.format(
                "Hello %s!\n"+
                        "Welcome to LPNU. Please visit next link: http://localhost:8080/api/v1/auth/%s",
                userDTO.getName(),
                user.getCodeForAuth()
        );
        mailSender.send(userDTO.getEmail(), "Authorization code", message);

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
    public boolean authUser(final String code){
        final User user = userRepository.findByAuthCode(code);

        if (user == null){
            return false;
        }
        user.setCodeForAuth(null);
        user.setStatus(Status.ACTIVE);
        userRepository.update(user);
        return true;

    }
    @Override
    public UserDTO findById(final Long id) {

        return UserMapper.toDTO(userRepository.findById(id));
    }
}
