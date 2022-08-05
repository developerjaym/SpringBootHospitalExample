package com.example.hospital.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Department department;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private Set<Patient> patients = new HashSet<>();
}
