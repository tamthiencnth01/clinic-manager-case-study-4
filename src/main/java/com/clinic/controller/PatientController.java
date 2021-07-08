package com.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/patient")
public class PatientController {
    @GetMapping
    public ModelAndView showAllPatients(){
        ModelAndView modelAndView = new ModelAndView("/patient/list");
        return modelAndView;
    }
}
