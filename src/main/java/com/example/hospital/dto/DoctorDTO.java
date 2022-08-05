package com.example.hospital.dto;

import lombok.Data;

import java.util.Set;

@Data
public class DoctorDTO {
    private Long id;
    private String name;
    private Set<PatientDTO> patients;
}
