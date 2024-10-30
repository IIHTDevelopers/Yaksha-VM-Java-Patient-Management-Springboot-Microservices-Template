package com.iiht.training.patient.exceptions;

public class PatientNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PatientNotFoundException() {

	}

	public PatientNotFoundException(String message) {
		super(message);
	}
}
