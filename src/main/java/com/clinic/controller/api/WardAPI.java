package com.clinic.controller.api;

import com.clinic.model.Ward;
import com.clinic.service.ward.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wards")
public class WardAPI {
    @Autowired
    public IWardService wardService;

    @GetMapping
    public ResponseEntity<Iterable<Ward>> findAllWards(){
        Iterable<Ward> wards = wardService.findAll();
        if (((List) wards).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(wards,HttpStatus.OK);
    }
}
