package com.clinic.controller.api;

import com.clinic.model.Doctor;
import com.clinic.model.MedicalBill;
import com.clinic.model.Patient;
import com.clinic.model.Ward;
import com.clinic.service.doctor.IDoctorService;
import com.clinic.service.medicalbill.IMedicalBillService;
import com.clinic.service.patient.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/bills")
public class MedicalBillAPI {

    @Autowired
    private IMedicalBillService medicalBillService;

    @Autowired
    private IPatientService patientService;

    @Autowired
    private IDoctorService doctorService;

    @GetMapping
    public ResponseEntity<Iterable<MedicalBill>> showListMedicalBill(){
        Iterable<MedicalBill> medicalBills = medicalBillService.findAll();
        if (((List) medicalBills).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalBills, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicalBill> createMedicalBill(@RequestBody MedicalBill medicalBill){
        if (medicalBill.getId() != null){
            return new ResponseEntity<>(medicalBillService.save(medicalBill),HttpStatus.OK);
        }
        Optional<Doctor> doctor = doctorService.findById(medicalBill.getDoctor().getId());
        Optional<Patient> patient = patientService.findById(medicalBill.getPatient().getId());
        if (doctor.isPresent()||patient.isPresent()){
            medicalBill.setDoctor(doctor.get());

            medicalBill.setPatient(patient.get());
            medicalBill.setDateOnExamination(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
            return new ResponseEntity<>(medicalBillService.save(medicalBill), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Iterable<MedicalBill>> findAllByPatientId(@PathVariable Long id){
        Iterable<MedicalBill> medicalBills = medicalBillService.findAllByPatientId(id);
        if (((List) medicalBills).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalBills,HttpStatus.OK);
    }
}
