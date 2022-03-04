package vn.hanu.fit.service;

import org.springframework.context.annotation.Bean;
import vn.hanu.fit.dto.RegisterDTO;
import vn.hanu.fit.entity.User;

public class UserMappingDTOService {
    public static User mapping(RegisterDTO registerDTO){
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());
        user.setFullname(registerDTO.getFullname());
        user.setPhone(registerDTO.getPhone());
        user.setDateofbirth(registerDTO.getDateofbirth());
        user.setPhone(registerDTO.getPhone());
        user.setGender(registerDTO.isGender());
        user.setRole("USER");
        user.setEmail(registerDTO.getEmail());
        return user;
    }
}
