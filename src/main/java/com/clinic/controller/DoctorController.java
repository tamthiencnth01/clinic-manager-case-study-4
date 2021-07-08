package com.clinic.controller;

import com.clinic.service.doctor.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private IDoctorService doctorService;

    @GetMapping
    public ModelAndView showAllDoctor(){
        return new ModelAndView("/doctor/list");
    }
}
