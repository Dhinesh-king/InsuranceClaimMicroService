//package com.example.demo.controller;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.example.demo.entity.InitiateClaim;
//import com.example.demo.entity.InsurerDetail;
//
//import com.example.demo.repo.InitiateClaimRepository;
//import com.example.demo.repo.InsurerDetailRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.JsonProcessingException;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class InsurerDetailControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private InsurerDetailRepository irepo;
//
//	@MockBean
//	private InitiateClaimRepository icrepo;
//
//	@Test
//	public void testAllInsurerDetails() throws Exception {
//		List<InsurerDetail> AllInsurerDetails = Arrays.asList(
//				new InsurerDetail(1, "varun", "Health Policy", 90000.00, 1),
//				new InsurerDetail(2, "Aju", "Health insurance policy for heart", 200000.00, 1));
//		when(irepo.findAll()).thenReturn(AllInsurerDetails);
//		mockMvc.perform(get("/insurer/allInsurerDetails")).andExpect(status().isOk())
//				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].insurerDetailId", is(1)))
//				.andExpect(jsonPath("$[0].insurerName", is("varun")))
//				.andExpect(jsonPath("$[0].insurerPackageName", is("Health Policy")))
//				.andExpect(jsonPath("$[0].insuranceAmountLimit", is(90000.00)))
//				.andExpect(jsonPath("$[0].disbursementDuration", is(1)))
//				.andExpect(jsonPath("$[1].insurerDetailId", is(2))).andExpect(jsonPath("$[1].insurerName", is("Aju")))
//				.andExpect(jsonPath("$[1].insurerPackageName", is("Health insurance policy for heart")))
//				.andExpect(jsonPath("$[1].insuranceAmountLimit", is(200000.00)))
//				.andExpect(jsonPath("$[1].disbursementDuration", is(1)));
//
//		verify(irepo, times(1)).findAll();
//
//	}
//
//	@Test
//	public void testGetInsurerPackageName() throws Exception {
//		String insurerPackageName = "Health Policy";
//		Optional<InsurerDetail> detail1 = Optional.of(new InsurerDetail(1, "varun", "Health Policy", 90000.00, 1));
//		when(irepo.findByInsurerPackageName(insurerPackageName)).thenReturn(detail1);
//		mockMvc.perform(
//				MockMvcRequestBuilders.get("/insurer/getInsurerPackageName/{insurerPackageName}", insurerPackageName)
//						.accept(MediaType.APPLICATION_JSON))
//				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("insurerPackageName").exists());
//		;
//		verify(irepo, times(1)).findByInsurerPackageName(insurerPackageName);
//
//	}
//	
//}
