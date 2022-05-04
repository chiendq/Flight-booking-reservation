package vn.hanu.fit.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.entity.Role;
import vn.hanu.fit.repository.RoleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<Role> getRoleList(){
        return roleRepository.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Role getRoleById(@PathVariable(value = "id") int id){
        return roleRepository.findById(id).get();
    }

    @PostMapping
    public Role addRole(@RequestBody Role role){
        return roleRepository.save(role);
    }

    @PutMapping(value = "/{id}")
    public void updateRole(
            @PathVariable(value = "id") Integer id,
            @RequestBody Role role) {
        if (roleRepository.existsById(id)) {
            role.setId(id);
            roleRepository.save(role);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRole(
            @PathVariable(value = "id") int id) {
        if (roleRepository.existsById(id)) {
            Role role = roleRepository.getById(id);
            roleRepository.delete(role);
        }
    }

}
