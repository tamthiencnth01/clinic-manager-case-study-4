package com.clinic.service.medicalbill;

import com.clinic.model.MedicalBill;
import com.clinic.service.IGeneralService;

public interface IMedicalBillService extends IGeneralService<MedicalBill> {
    Iterable<MedicalBill> findAllByPatientId(Long id);
}
