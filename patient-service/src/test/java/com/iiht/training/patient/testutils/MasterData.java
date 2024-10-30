package com.iiht.training.patient.testutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.iiht.training.patient.dto.PatientDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MasterData {
    public static PatientDto getPatientDto() {
        PatientDto dto = new PatientDto();
        dto.setId(1L);
        dto.setAddress("Test");
        dto.setGender(PatientDto.Gender.MALE);
        dto.setAge(50);
        dto.setName("Test");

        return dto;
    }

    public static List<PatientDto> getPatientDtoList() {
        List<PatientDto> dtos = new ArrayList<>();
        PatientDto dto = new PatientDto();
        dto.setId(4L);
        dto.setAddress("Test");
        dto.setGender(PatientDto.Gender.MALE);
        dto.setAge(50);
        dto.setName("Test");
        dtos.add(dto);
        dto = new PatientDto();
        dto.setId(50L);
        dto.setAddress("Test");
        dto.setGender(PatientDto.Gender.MALE);
        dto.setAge(50);
        dto.setName("Test");
        dtos.add(dto);
        return dtos;

    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            final String jsonContent = mapper.writeValueAsString(obj);

            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
