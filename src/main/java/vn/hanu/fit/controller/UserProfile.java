package vn.hanu.fit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.dto.EditUserInfoDto;
import vn.hanu.fit.entity.User;
import vn.hanu.fit.repository.UserRepository;
import vn.hanu.fit.userdetails.MyUserDetails;

import java.util.Date;

@Controller
@Slf4j
public class UserProfile {
    UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserProfile(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping("/manage")
    public String showSignup(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
            EditUserInfoDto user = EditUserInfoDto.builder()
                    .fullName(userDetails.getFullName())
                    .password("*********")
                    .email(userDetails.getEmail())
                    .identityNumber(userDetails.getIdentityNumber())
                    .phoneNumber(userDetails.getPhoneNumber())
                    .gender(userDetails.getGender())
                    .dateOfBirth(userDetails.getDateOfBirth())
                    .build();
            model.addAttribute("user", user);
            return "profile";
        }
        return "redirect:/";
    }
}
