package com.clinic.controller.api;

import com.clinic.model.MedicalBill;
import com.clinic.service.medicalbill.IMedicalBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class MedicalBillAPI {

    @Autowired
    private IMedicalBillService medicalBillService;

    @GetMapping
    public ResponseEntity<Iterable<MedicalBill>> showListMedicalBill(){
        Iterable<MedicalBill> medicalBills = medicalBillService.findAll();
        if (((List) medicalBills).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
