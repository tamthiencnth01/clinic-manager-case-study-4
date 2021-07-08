package com.clinic.controller.api;

import com.clinic.model.Patient;
import com.clinic.model.Ward;
import com.clinic.service.patient.IPatientService;
import com.clinic.service.ward.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<Iterable<Patient>> getAllPatients(){
        Iterable<Patient> patients = patientService.findAll();
        if (((List) patients).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patients,HttpStatus.OK);
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
