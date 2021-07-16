package com.clinic.repository;

import com.clinic.model.MedicalBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicalBillRepository extends JpaRepository<MedicalBill,Long> {
    Iterable<MedicalBill> findAllByPatientId(Long id);
}
