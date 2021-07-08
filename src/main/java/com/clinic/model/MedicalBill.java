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

    private String symptom;

    public MedicalBill(Doctor doctor, String symptom) {
        this.doctor = doctor;
        this.symptom = symptom;
    }
}
