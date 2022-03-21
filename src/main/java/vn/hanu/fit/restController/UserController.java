package vn.hanu.fit.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.entity.User;
import vn.hanu.fit.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUserList(){
        return userRepository.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public User getUserById(@PathVariable(value = "id") Long id){
        return userRepository.findById(id).get();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping(value = "/{id}")
    public void updateUser(
            @PathVariable(value = "id") Integer id,
            @RequestBody User user) {
        if (userRepository.existsById(Long.valueOf(id))) {
            user.setId(Long.valueOf(id));
            userRepository.save(user);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(
            @PathVariable(value = "id") Long id) {
        if (userRepository.existsById(id)) {
            User user = userRepository.getById(id);
            userRepository.delete(user);
        }
    }

}
