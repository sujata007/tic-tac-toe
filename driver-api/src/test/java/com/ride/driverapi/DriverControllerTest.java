package com.ride.driverapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ride.driverapi.controller.DriverController;
import com.ride.driverapi.model.Driver;
import com.ride.driverapi.repository.DocumentRepository;
import com.ride.driverapi.repository.DriverRepository;
import com.ride.driverapi.repository.VehicleRepository;
import com.ride.driverapi.schedulers.BackGroundWorkerScheduler;
import com.ride.driverapi.service.DriverService;
import com.ride.driverapi.service.VehicleService;
import com.ride.driverapi.service.VendorService;

@WebMvcTest(controllers = DriverController.class)
public class DriverControllerTest {
	@Mock
	private DriverRepository driverRepository;
	@Mock
	private DocumentRepository documentRepository;
	@Mock
	private VehicleRepository vehicleRepository;
	@MockBean
	private DriverService driverService;
	@MockBean
	private VehicleService vehicleService;
	@MockBean
	private VendorService vendorService;
	@MockBean
	private BackGroundWorkerScheduler backGroundWorkerScheduler;
	@MockBean
	private JavaMailSender javaMailSender;
	@Autowired
	private WebApplicationContext webApplicationContext;
	Driver driverRequest;
	@Autowired
	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		driverRequest = new Driver("abc@gmail.com", "8882164563", "abc", "def", "aaaa", null, null);
	}

	@Test
	public void driverSignUpSuccess() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/driver/signup").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(driverRequest))).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
