package lpnu.resource;

import lpnu.dto.UserDTO;
import lpnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserDTO findById(@PathVariable final Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody @Validated final UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PutMapping("/user")
    public UserDTO updateUser(@RequestBody final UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity delete(@PathVariable final Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/auth/{code}")
    public ResponseEntity auth(final Model model, @PathVariable final String code) {
        final boolean isAuth = userService.authUser(code);

        if(isAuth){
            model.addAttribute("message", "User successfully authorized");
        }else{
            model.addAttribute("message","Auth code is not found");
        }

        return ResponseEntity.ok().build();
    }
}
