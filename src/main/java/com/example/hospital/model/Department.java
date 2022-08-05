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
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Set<Doctor> doctors = new HashSet<>();
    @ManyToOne
    private Hospital hospital;
}
