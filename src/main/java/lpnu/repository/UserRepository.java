package lpnu.repository;
import lpnu.entity.User;

import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private long id = 1;

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public void delete(final Long id) {
        for (final User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                break;
            }
        }
    }

    public User update(final User user) {
        final User savedUser = findById(user.getId());

        savedUser.setName(user.getName());
        savedUser.setEmail(user.getEmail());
        savedUser.setStatus(user.getStatus());

        return savedUser;
    }

    public void saveUser(final User user) {
        user.setId(id);
        ++id;
        users.add(user);
    }

    public User findById(final Long id) {
        return users.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "user with id " + id + " not found"));
    }
}