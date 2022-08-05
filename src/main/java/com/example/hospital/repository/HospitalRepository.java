package com.example.hospital.repository;

import com.example.hospital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Hospital findByName(String name);

    void deleteByName(String name);
}
