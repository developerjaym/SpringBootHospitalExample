package com.example.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum Ailment {
    CHEST_PAIN("Chest Pain", Specialty.CARDIOLOGY), OTHER("Other", Specialty.ONCOLOGY);
    private String description;
    private Specialty associatedSpecialty;
}
