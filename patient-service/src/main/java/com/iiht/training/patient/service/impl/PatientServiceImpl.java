package com.iiht.training.patient.service.impl;

import java.util.List;

import com.iiht.training.patient.dto.PatientDto;
import com.iiht.training.patient.repository.PatientRepository;
import com.iiht.training.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository repository;

	@Override
	public PatientDto addPatientDetails(PatientDto patientDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientDto> findPatientByName(String patientName) {
		// TODO Auto-generated method stub
		return null;
	}

}
