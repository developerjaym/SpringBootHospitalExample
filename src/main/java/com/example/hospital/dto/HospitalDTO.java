package com.example.hospital.dto;

import lombok.Data;

import java.util.Set;

@Data
public class HospitalDTO {
    private Long id;
    private String name;
    private Set<DepartmentDTO> departments;
}
