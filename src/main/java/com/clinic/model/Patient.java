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
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @NotNull
    private String phone;
    @NotNull
    private String cmnd;
    @NotNull
    private String dob;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @OneToMany(targetEntity = MedicalBill.class, fetch = FetchType.EAGER)
    private Set<MedicalBill> listPatient;

    public Patient(@NotNull String name, @NotNull String phone, @NotNull String cmnd, @NotNull String dob, Ward ward) {
        this.name = name;
        this.phone = phone;
        this.cmnd = cmnd;
        this.dob = dob;
        this.ward = ward;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", dob='" + dob + '\'' +
                ", ward=" + ward +
                '}';
    }
}
