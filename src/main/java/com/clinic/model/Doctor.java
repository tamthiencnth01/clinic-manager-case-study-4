package com.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;

    private String address;

    @OneToMany(targetEntity = MedicalBill.class, fetch = FetchType.EAGER)
    private Set<MedicalBill> medicalBills;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;



    public Doctor(String name,String address, Department department) {
        this.name = name;
        this.address = address;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", department=" + department +
                '}';
    }
}
