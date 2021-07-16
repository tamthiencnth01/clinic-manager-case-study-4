package com.clinic.service.patient;

import com.clinic.model.Patient;
import com.clinic.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Optional;

public interface IPatientService extends IGeneralService<Patient>{
    Page<Patient> findAll(Pageable pageable);
    Page<Patient> findAllByCmndContaining(String cmnd, Pageable pageable);
}
