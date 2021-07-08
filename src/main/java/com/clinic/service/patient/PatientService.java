package com.clinic.service.patient;

import com.clinic.model.Patient;
import com.clinic.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PatientService implements IPatientService{
    @Autowired
    private IPatientRepository patientRepository;
    @Override
    public Iterable<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void remove(Long id) {
        patientRepository.deleteById(id);
    }
}
