package com.iiht.training.patient.service;

import java.util.List;

import com.iiht.training.patient.dto.PatientDto;

public interface PatientService {

	public PatientDto addPatientDetails(PatientDto patientDto);

	public List<PatientDto> findPatientByName(String patientName);

}
