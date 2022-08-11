package com.example.webinarpatientapi.dto;

import com.example.webinarpatientapi.entity.PatientEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientDto {
    @JsonIgnore
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String diagnosis;
}
