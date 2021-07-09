package com.clinic.service.patient;

import com.clinic.model.Patient;
import com.clinic.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPatientService extends IGeneralService<Patient> {
    Page<Patient> findAllPatients(Pageable pageable);
}
