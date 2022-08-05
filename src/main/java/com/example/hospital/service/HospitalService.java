package com.example.hospital.service;

import com.example.hospital.dto.CreateHospitalDTO;
import com.example.hospital.dto.HospitalDTO;
import com.example.hospital.model.Hospital;
import com.example.hospital.repository.HospitalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository; // field injection

    @Autowired
    private ModelMapper mapper;

    public HospitalDTO createHospital(CreateHospitalDTO createDTO) {
        // Convert the HospitalCreateDTO to a Hospital entity
        Hospital hospital = mapper.map(createDTO, Hospital.class);
        // createDTO has a name property
        // hospital has a name property
        // the mapper will create a hospital with the name from the createDTO
        hospital = hospitalRepository.save(hospital);
        // hospital will now have a name and an id
        // then we map that hospital entity to a HospitalDTO
        // and then return that
        return mapper.map(hospital, HospitalDTO.class);
    }

    public HospitalDTO getHospital(Long id) {
        Hospital hospital =
                hospitalRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.map(hospital, HospitalDTO.class);
    }

    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }

    public List<HospitalDTO> getAllHospital() {
        return hospitalRepository.findAll().stream().map(hospital -> mapper.map(hospital, HospitalDTO.class)).toList();
    }
}
