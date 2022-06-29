package com.cts.dailyshareprice.controller;

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

import com.cts.shareprice.controller.StockController;
import com.cts.shareprice.feigclient.AuthorizationClient;
import com.cts.shareprice.model.Stock;
import com.cts.shareprice.service.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(StockController.class)
class StockControllerTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	@MockBean
	private StockService stockService;
	@MockBean
	private AuthorizationClient authorizationClient;
	Stock s1 = new Stock(11, "CTS", 120000.00);
	Stock s2 = new Stock(12, "MNS", 120000.00);
	List<Stock> record = new ArrayList<>(Arrays.asList(s1, s2));

	@Test
	void testGetDailyAllMutualFundNav() throws Exception {

		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "token");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);

		Mockito.when(stockService.getStockDetail(s1.getStockName())).thenReturn(s1);

		mockMvc.perform(MockMvcRequestBuilders.get("/SharePrice/CTS").headers(httpHeaders)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void testFindAllStock() throws Exception {

		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "token");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);

		Mockito.when(stockService.findAll()).thenReturn(record);

		mockMvc.perform(MockMvcRequestBuilders.get("/SharePrice/allstock").headers(httpHeaders)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
