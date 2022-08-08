package com.example.hospital.service;

import com.example.hospital.dto.HospitalDTO;
import com.example.hospital.model.Hospital;
import com.example.hospital.repository.HospitalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HospitalServiceTest {

    @InjectMocks
    private HospitalService hospitalService;

    @Mock
    private HospitalRepository hospitalRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void getHospital_happy() {
        //arrange
        Hospital hospital = new Hospital();
        hospital.setId(1L);
        when(hospitalRepository.findById(1L))
                .thenReturn(Optional.of(hospital));

        HospitalDTO returnedFromMapper = new HospitalDTO();
        returnedFromMapper.setId(1L);
        when(modelMapper.map(hospital, HospitalDTO.class))
                .thenReturn(returnedFromMapper);

        //act
        HospitalDTO actual = hospitalService.getHospital(1L);


        //assert
        Assertions.assertEquals(
                returnedFromMapper, actual, "We got the hospital back!");

    }

    @Test
    public void getHospital_sad() {
        //arrange
        when(hospitalRepository.findById(1L))
                .thenReturn(Optional.empty());

        //act
        Assertions.assertThrows(ResponseStatusException.class, () -> {
            //Code under test
            hospitalService.getHospital(1L);
        });

        verifyNoInteractions(modelMapper);
        verify(hospitalRepository).findById(1L);
    }

//    @Test
//    public void testGetHospital() {
//        HospitalDTO hospitalDTO = new HospitalDTO();
//
//        when(hospitalService.getHospital(1L)).thenReturn(hospitalDTO);
//
//        HospitalDTO actual = hospitalService.getHospital(1L);
//
//        assertEquals("It worked", hospitalDTO, actual);
//    }
}
