package com.example.hospital.dto;

import com.example.hospital.model.Specialty;
import lombok.Data;

import java.util.Set;

@Data
public class DepartmentDTO {
    private Long id;
    private Specialty specialty;
    private Set<DoctorDTO> doctors;
}
