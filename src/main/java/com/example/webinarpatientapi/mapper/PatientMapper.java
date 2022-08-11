package com.example.webinarpatientapi.mapper;

import com.example.webinarpatientapi.dto.PatientDto;
import com.example.webinarpatientapi.entity.PatientEntity;

public class PatientMapper {
    public static PatientDto toDto(PatientEntity patientEntity) {
        return PatientDto.builder()
                .id(patientEntity.getId())
                .name(patientEntity.getName())
                .email(patientEntity.getEmail())
                .phone(patientEntity.getPhone())
                .address(patientEntity.getAddress())
                .diagnosis(patientEntity.getDiagnosis())
                .build();
    }

    public static PatientEntity toEntity(PatientDto patientDto) {
        return PatientEntity.builder()
                .id(patientDto.getId())
                .name(patientDto.getName())
                .email(patientDto.getEmail())
                .phone(patientDto.getPhone())
                .address(patientDto.getAddress())
                .diagnosis(patientDto.getDiagnosis())
                .build();
    }
}
