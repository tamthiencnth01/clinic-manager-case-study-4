package com.clinic.controller;

import com.clinic.model.Patient;
import com.clinic.service.patient.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private IPatientService patientService;

    @GetMapping
    public ModelAndView showAllPatients(Pageable pageable){
//        Page<Patient> patients = patientService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/patient/list");
//        modelAndView.addObject("patients",patients);
        return modelAndView;
    }

}
