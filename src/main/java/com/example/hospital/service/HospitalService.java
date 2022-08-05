package com.example.hospital.service;

import com.example.hospital.model.Hospital;
import com.example.hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository; // field injection

    public void createHospital(String name) {
        Hospital hospital = new Hospital();
        hospital.setName(name);
        hospitalRepository.save(hospital);
    }

    public Hospital getHospital(Long id) {
        return hospitalRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT));
    }

    public Hospital updateName(String name) {
        return hospitalRepository.findByName(name);
    }
    @Transactional
    public void updateName(Long id, String newName) {
        Hospital hospital = getHospital(id);
        hospital.setName(newName);
    }

    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }
}
