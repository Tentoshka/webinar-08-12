package com.example.webinarpatientapi.controllers;

import com.example.webinarpatientapi.dto.PatientDto;
import com.example.webinarpatientapi.entity.PatientEntity;
import com.example.webinarpatientapi.mapper.PatientMapper;
import com.example.webinarpatientapi.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientRepo patientRepo;

    @Autowired
    public PatientController(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PatientDto> allPatients() {
        return patientRepo.findAll()
                .stream()
                .map(PatientMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PatientDto getPatient(@PathVariable Long id) {
        return PatientMapper.toDto(patientRepo.findById(id).orElse(new PatientEntity()));
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public PatientDto createPatient(@RequestBody PatientDto patient) {
        PatientEntity patientEntity = PatientMapper.toEntity(patient);
        PatientEntity savedPatient =  patientRepo.save(patientEntity);
        return PatientMapper.toDto(savedPatient);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public PatientDto updatePatient(@PathVariable Long id, @RequestBody PatientDto patient) {
        patient.setId(id);
        PatientEntity patientEntity = PatientMapper.toEntity(patient);
        PatientEntity updatedPatient = patientRepo.save(patientEntity);
        return PatientMapper.toDto(updatedPatient);
    }
    //
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public void deletePatient(@PathVariable Long id) {
        patientRepo.deleteById(id);
    }
}
