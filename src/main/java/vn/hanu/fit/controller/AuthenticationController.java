package vn.hanu.fit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {

    @RequestMapping("/login")
    public String showLogin(){
        return "login";
    }

    @RequestMapping("/logout")
    public String handleError(){
        return "handleError";
    }
}