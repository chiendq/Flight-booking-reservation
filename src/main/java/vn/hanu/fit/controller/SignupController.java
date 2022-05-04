package vn.hanu.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.hanu.fit.entity.User;
import vn.hanu.fit.repository.RoleRepository;
import vn.hanu.fit.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SignupController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/signup")
    public String showSignup(Model model) {
        model.addAttribute("newUser", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String validateSignup(@Valid @ModelAttribute("newUser") User user,
                                 BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            return "signup";
        }
        if (userRepository.existsByUsername(user.getUsername())) {
            user.setExist(true);
            return "signup";
        }
        user.setRole(roleRepository.findById(1).get());
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode( user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        user.setExist(true);
        userRepository.save(user);
        return "redirect:/login?registed";
    }
}
