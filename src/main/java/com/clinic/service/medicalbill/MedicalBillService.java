package com.clinic.service.medicalbill;

import com.clinic.model.MedicalBill;
import com.clinic.repository.IMedicalBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalBillService  implements IMedicalBillService{
    @Autowired
    private IMedicalBillRepository medicalBillRepository;
    @Override
    public Iterable<MedicalBill> findAll() {
        return medicalBillRepository.findAll();
    }

    @Override
    public Optional<MedicalBill> findById(Long id) {
        return medicalBillRepository.findById(id);
    }

    @Override
    public MedicalBill save(MedicalBill medicalBill) {
        return medicalBillRepository.save(medicalBill);
    }

    @Override
    public void remove(Long id) {
        medicalBillRepository.deleteById(id);
    }

    @Override
    public Iterable<MedicalBill> findAllByPatientId(Long id) {
        return medicalBillRepository.findAllByPatientId(id);
    }
}
