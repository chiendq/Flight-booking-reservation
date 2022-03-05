package vn.hanu.fit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.dto.LoginDTO;
import vn.hanu.fit.dto.RegisterDTO;
import vn.hanu.fit.entity.User;
import vn.hanu.fit.repository.UserRepository;
import vn.hanu.fit.service.UserMappingDTOService;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;


@Controller
@RequestMapping()
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/join")
    public String showRegisForm(Model model){
        LOGGER.info("/join called");
        model.addAttribute("registerdto", new RegisterDTO());
        return "register";
    }

    @PostMapping(value="/join")
    public String saveAccount( @Valid @ModelAttribute("registerdto") RegisterDTO registerDTO, BindingResult result){
        if(result.hasErrors()){
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors ) {
                LOGGER.error("/join: "+error.getDefaultMessage());
            }
            return "register";
        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(userRepository.existsByUsername(registerDTO.getUsername())){
            registerDTO.setStatus(true);
            return "register";
        }
        User userUpdated = userRepository.save(UserMappingDTOService.mapping(registerDTO));
        LOGGER.info("/join: NEW ACCOUNT CREATED " + userUpdated.toString());
        return "redirect:/";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        LOGGER.info("/login called");
        model.addAttribute("logindto", new LoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String loginValidate( @Valid @ModelAttribute("logindto") LoginDTO loginDTO, BindingResult result){
        if(result.hasErrors()){
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors ) {
                LOGGER.warn("/join/save: "+error.getDefaultMessage());
            }
            LOGGER.info("BINDINGRESULT: Username :" + loginDTO.getUsername() + " , Password:" + loginDTO.getPassword());
            return "login";
        }

        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        if(!userRepository.existsByUsernameAndPassword(username, password)){
            LOGGER.info("INCORRECT Username :" + username + " , Password:" + password);
            loginDTO.setStatus(true);
            return "login";
        }
        LOGGER.info("LOG IN SUCCESSFUL : Username :" + username + " , Password:" + password);
        return "index";
    }

//    @RequestMapping(value = "/login/validate")
//    public String loginCheck(@ModelAttribute("logininfor") LoginInfor logininfor
//            , HttpSession httpSession){
//        String username = logininfor.getUsername();
//        String password = logininfor.getPassword();
//
//        if(!userRepository.existsUserByUsernameAndPassword(username, password)){
//            System.err.println("Username : " + username + ". Password: " + password + ". INCORRECT");
//            return "home";
//        }
//        System.out.println("Username : " + username + ". Password: " + password + ". CORRECT");
//        httpSession.setAttribute("username", username);
//        return "redirect:/employeeList";
//
//    }

}
