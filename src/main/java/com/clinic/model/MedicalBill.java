package com.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicalbills")
public class MedicalBill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String dateOnExamination;
    private String symptom;

    public MedicalBill(Doctor doctor, Patient patient, String dateOnExamination, String symptom) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateOnExamination = dateOnExamination;
        this.symptom = symptom;
    }

    public MedicalBill(Doctor doctor, String symptom) {
        this.doctor = doctor;
        this.symptom = symptom;
    }
}
