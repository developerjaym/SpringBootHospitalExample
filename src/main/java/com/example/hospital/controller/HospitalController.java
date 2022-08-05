package com.example.hospital.controller;

import com.example.hospital.dto.CreateHospitalDTO;
import com.example.hospital.dto.HospitalDTO;
import com.example.hospital.model.Hospital;
import com.example.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @PostMapping // localhost:8080/hospitals POST
    public HospitalDTO createHospital(@RequestBody CreateHospitalDTO hospital) {
        return hospitalService.createHospital(hospital);
    }

    @GetMapping // localhost:8080/hospitals GET
    public List<HospitalDTO> getHospitals() {
        return hospitalService.getAllHospital();
    }

    @GetMapping("/{id}")  // localhost:8080/hospitals/1
    public HospitalDTO getHospital(@PathVariable Long id) {
        return hospitalService.getHospital(id);
    }
}
