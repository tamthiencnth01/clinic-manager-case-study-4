package com.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wards")
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(targetEntity = Patient.class, fetch = FetchType.EAGER)
    private List<Patient> list;

    public Ward(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ward{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
