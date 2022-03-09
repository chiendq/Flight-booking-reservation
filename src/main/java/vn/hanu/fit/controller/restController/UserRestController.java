package vn.hanu.fit.controller.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.entity.User;
import vn.hanu.fit.exception.ResourceNotFoundException;
import vn.hanu.fit.repository.UserRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {

        User user = userRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("This user does not exist: " + employeeId));

        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public User createEmployee(@Valid @RequestBody User user, BindingResult result) {
//        if(result.hasErrors()){
//            return "Hello";
//        }
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId
            ,@Valid @RequestBody User userDetails) throws ResourceNotFoundException{
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("This user does not exist: " + userId));
        user.setPassword(userDetails.getPassword());
        user.setFullname(userDetails.getFullname());
        user.setPhone(userDetails.getPhone());
        user.setDateofbirth(userDetails.getDateofbirth());
        user.setGender(userDetails.isGender());
        user.setEmail(userDetails.getEmail());
        final User updatedUser = userRepository.save(user);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("This user does not exist: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
