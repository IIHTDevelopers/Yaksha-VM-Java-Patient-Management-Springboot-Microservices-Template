package com.iiht.training.patient.controller;


import com.iiht.training.patient.dto.PatientDto;
import com.iiht.training.patient.service.PatientService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("/patient")
	public ResponseEntity<PatientDto> addPatientDetails(@Valid @RequestBody PatientDto patientDto,
													 BindingResult result) {
		return null;
	}
	// get patient by patientName
	@GetMapping("/patient/{patientName}")
	public ResponseEntity<List<PatientDto>> getPatientByPatientName(@PathVariable String patientName) {
		return null;
	}
}
