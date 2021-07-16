package com.clinic.controller.api;

import com.clinic.model.Patient;
import com.clinic.model.Ward;
import com.clinic.service.patient.IPatientService;
import com.clinic.service.ward.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientAPI {
    @Autowired
    private IPatientService patientService;

    @Autowired
    private IWardService wardService;

//    @GetMapping
//    public ResponseEntity<Iterable<Patient>> getAllPatients(){
//        Iterable<Patient> patients = patientService.findAll();
//        if (((List) patients).isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(patients,HttpStatus.OK);
//    }
//    @GetMapping
//    public ModelAndView listCustomers(@RequestParam("search") Optional<String> cmnd, Pageable pageable){
//        Page<Patient> patients;
//        if(cmnd.isPresent()){
//            patients = patientService.findAllByCmndContaining(cmnd.get(), pageable);
//        } else {
//            patients = patientService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("/patient/list");
//        modelAndView.addObject("patients", patients);
//        return modelAndView;
//    }

    @GetMapping
    public ResponseEntity<Page<Patient>> listCustomers(@RequestParam("search") Optional<String> cmnd,@PageableDefault(value = 10) Pageable pageable){
        Page<Patient> patients;
        if (cmnd.isPresent()){
            patients = patientService.findAllByCmndContaining(cmnd.get(), pageable);
            if (patients.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(patients,HttpStatus.OK);
        } else {
            patients = patientService.findAll(pageable);
            if(patients.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            ModelAndView modelAndView = new ModelAndView("/patient/list");
            modelAndView.addObject("patients",patients);
            return new ResponseEntity<>(patients,HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Optional<Patient> patient = patientService.findById(id);
        if (patient.isPresent()){
            return new ResponseEntity<>(patient.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        if (patient.getId() != null){
            return new ResponseEntity<>(patientService.save(patient),HttpStatus.OK);
        }
        Optional<Ward> ward = wardService.findById(patient.getWard().getId());
        if (ward.isPresent()){
            patient.setWard(ward.get());
            return new ResponseEntity<>(patientService.save(patient), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping()
    public ResponseEntity<Patient> deletePatient(@RequestBody Map<String, String> json){
        Long id =Long.valueOf(json.get("id"));
        Optional<Patient> patientOptional = patientService.findById(id);
        if (!patientOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        patientService.remove(id);
        return new ResponseEntity<>(patientOptional.get(),HttpStatus.NO_CONTENT);
    }
}
