package com.example.hospital.dto;

import com.example.hospital.model.Ailment;
import lombok.Data;

@Data
public class PatientDTO {
    private String name;
    private Ailment ailment;
}
