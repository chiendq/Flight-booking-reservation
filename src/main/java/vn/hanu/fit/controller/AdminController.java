package vn.hanu.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.entity.User;
import vn.hanu.fit.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserRepository userRepository;


    private boolean isAdmin(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return true;
        }
        return false;
    }

    @RequestMapping
    public String showAdmin(){
        if (!isAdmin())  return "redirect:/";

        return "admin";
    }

    @RequestMapping("/manage")
    public String showManageList(){
        if(!isAdmin()) return "redirect:/";
        return "admin_manage";
    }

    @RequestMapping("/manage/user")
    public String showManageUser(Model model){
        if(!isAdmin()) return "redirect:/";
        model.addAttribute("users", userRepository.findAll());
        return "admin_manage_user";
    }

    @RequestMapping("/manage/user/update/{id}")
    public String manageUpdateUser(@PathVariable("id") Long id, Model model){
        if(!isAdmin()) return "redirect:/";
        model.addAttribute("user", userRepository.findById(id).get());
        return "admin_manage_user_update";
    }

    @RequestMapping("/manage/user/update/save/{id}")
    public String saveUserUpdate(@PathVariable("id") Long id, @ModelAttribute("user") User user ){
        if(!isAdmin()) return "redirect:/";
        User userUpdate = userRepository.findById(id).get();
        if(userRepository.existsById(id)){
            user.setId(id);
            user.setUsername(userUpdate.getUsername());
            user.setPassword(userUpdate.getPassword());
            userRepository.save(user);
        }
        return "redirect:/admin/manage/user";
    }

    @RequestMapping("/manage/user/delete/{id}")
    public String manageDeleteUser(@PathVariable("id") Long id){
        if(!isAdmin()) return "redirect:/";
        userRepository.deleteById(id);
        return "redirect:/admin/manage/user";
    }

}
