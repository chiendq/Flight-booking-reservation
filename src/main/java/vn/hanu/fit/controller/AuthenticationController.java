package vn.hanu.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.hanu.fit.entity.User;
import vn.hanu.fit.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthenticationController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/login")
    public String loginError(@RequestParam(value = "error", defaultValue = "false") boolean loginError){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout( request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping("/signup")
    public String showSignup(Model model){
        model.addAttribute("newUser", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String validateSignup(@Valid  @ModelAttribute("newUser") User user,
                                 BindingResult result,
                                 @RequestParam(value = "validate", defaultValue = "false") boolean validate,
                                 Model model){
        if(result.hasErrors()){
            List<FieldError> errors = result.getFieldErrors();
            return "signup";
        }
        if(userRepository.existsByUsername(user.getUsername())){
            user.setExist(true);
            return "signup";
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login?registed";
    }
}