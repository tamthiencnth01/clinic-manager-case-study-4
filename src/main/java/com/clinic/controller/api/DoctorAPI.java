package com.clinic.controller.api;

import com.clinic.model.Doctor;
import com.clinic.service.doctor.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/doctors")
public class DoctorAPI {
    @Autowired
    private IDoctorService doctorService;

    @GetMapping
    public ResponseEntity<Iterable<Doctor>> showListDoctor(){
        Iterable<Doctor> doctors = doctorService.findAll();
        if (((List) doctors).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(doctors,HttpStatus.OK);
    }
}
