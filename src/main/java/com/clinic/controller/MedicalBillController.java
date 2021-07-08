package com.clinic.controller;

import com.clinic.service.medicalbill.IMedicalBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicalBillController {
    @Autowired
    IMedicalBillService medicalBillServicel;

    @GetMapping
    public ModelAndView showAllBill(){
        return new ModelAndView("/medicalbill/list");
    }
}
