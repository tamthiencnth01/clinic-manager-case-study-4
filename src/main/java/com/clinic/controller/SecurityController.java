package com.clinic.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class SecurityController {
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails){
            userName = ((UserDetails) principal).getUsername();
        }else {
            userName = principal.toString();
        }
        return userName;
    }

    @GetMapping(value = {"/", "/home"})
    public String Homepage(Model model){
        model.addAttribute("user",getPrincipal());
        return "/patient/list";
    }

    @GetMapping("/admin")
    public String adminPage(ModelMap modelMap) {
        modelMap.addAttribute("user",getPrincipal());
        return "/patient/list";
    }
    @GetMapping("/accessDenied")
    public String accessDeniedPage(ModelMap modelMap){
        modelMap.addAttribute("user",getPrincipal());
        return "/account/accessDenied";
    }

    @GetMapping("/dba")
    public String dbaPage(ModelMap modelMap){
        modelMap.addAttribute("user",getPrincipal());
        return "/account/dba";
    }
}