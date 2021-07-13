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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String cmnd;

    @Column(nullable = false)
    private String dob;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @OneToMany(targetEntity = MedicalBill.class, fetch = FetchType.EAGER)
    private Set<MedicalBill> listPatient;

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
