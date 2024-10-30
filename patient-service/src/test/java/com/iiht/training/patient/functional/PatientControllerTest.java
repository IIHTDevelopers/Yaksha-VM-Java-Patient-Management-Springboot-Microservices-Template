package com.iiht.training.patient.functional;

import static com.iiht.training.patient.testutils.TestUtils.businessTestFile;
import static com.iiht.training.patient.testutils.TestUtils.currentTest;
import static com.iiht.training.patient.testutils.TestUtils.testReport;
import static com.iiht.training.patient.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.List;

import com.iiht.training.patient.controller.PatientController;
import com.iiht.training.patient.dto.PatientDto;
import com.iiht.training.patient.service.PatientService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.iiht.training.patient.testutils.MasterData;

@WebMvcTest(PatientController.class)
@AutoConfigureMockMvc
public class PatientControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PatientService patientService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void patient_testAddPatient() throws Exception {
		PatientDto dto = MasterData.getPatientDto();
		PatientDto savedDto = MasterData.getPatientDto();
		when(this.patientService.addPatientDetails(dto)).thenReturn(savedDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/patient")
				.content(MasterData.asJsonString(dto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedDto)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void patient_testAddPatientIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		PatientDto dto = MasterData.getPatientDto();
		when(this.patientService.addPatientDetails(dto)).then(new Answer<PatientDto>() {

			@Override
			public PatientDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return dto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/patient")
				.content(MasterData.asJsonString(dto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}


	@Test
	public void patient_testFindPatientByName() throws Exception {
		List<PatientDto> patientDtos = MasterData.getPatientDtoList();
		when(this.patientService.findPatientByName("Java")).thenReturn(patientDtos);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/patient/test")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(patientDtos))
						? "true"
						: "false"),
				businessTestFile);

	}

}
