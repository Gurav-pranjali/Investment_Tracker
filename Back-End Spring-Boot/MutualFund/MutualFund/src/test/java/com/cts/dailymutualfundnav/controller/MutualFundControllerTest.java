package com.cts.dailymutualfundnav.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.mutualfund.controller.MutualFundController;
import com.cts.mutualfund.feignclient.AuthorizationClient;
import com.cts.mutualfund.model.MutualFund;
import com.cts.mutualfund.service.MutualFundService;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebMvcTest(MutualFundController.class)
class MutualFundControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	private MutualFundService mutualFundService;
	
	@MockBean
	private AuthorizationClient  authorizationClient;

	MutualFund m1=new MutualFund(11,"GLE",120000.00);
	MutualFund m2=new MutualFund(11,"FRB",150000.00);
	List<MutualFund> record=new ArrayList<>(Arrays.asList(m1,m2));
	@Test
    void testGetDailyAllMutualFundNav() throws Exception {
		
		Map<String,String> map=new HashMap<>();
		map.put("Authorization", "token");
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setAll(map);
		
		Mockito.when(mutualFundService.getByMutualFundName(m1.getMutualFundName())).thenReturn(m1);

		mockMvc.perform(MockMvcRequestBuilders.get("/MutualFund/GLE")
				.headers(httpHeaders).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
    void testGetAllMutualFund() throws Exception {
		
		Map<String,String> map=new HashMap<>();
		map.put("Authorization", "token");
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setAll(map);
		
		Mockito.when(mutualFundService.getAll()).thenReturn(record);

		mockMvc.perform(MockMvcRequestBuilders.get("/MutualFund/allmf")
				.headers(httpHeaders).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
}
