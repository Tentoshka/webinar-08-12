package com.example.webinarpatientapi.repository;

import com.example.webinarpatientapi.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<PatientEntity, Long> {
}
