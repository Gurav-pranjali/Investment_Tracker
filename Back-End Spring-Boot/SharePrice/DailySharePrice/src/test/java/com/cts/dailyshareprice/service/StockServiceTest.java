package com.cts.dailyshareprice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.shareprice.exception.StockNotFoundException;
import com.cts.shareprice.model.Stock;
import com.cts.shareprice.repository.StockRepository;
import com.cts.shareprice.service.StockService;

@SpringBootTest
class StockServiceTest {

	@MockBean
	private StockRepository stockRepository;

	@Autowired
	private StockService stockService;

	Stock s1 = new Stock(11, "CTS", 120000.00);
	Stock s2 = new Stock(12, "MNS", 120000.00);
	List<Stock> record=new ArrayList<>(Arrays.asList(s1,s2));
	@Test
	void testGetStockDetail() throws StockNotFoundException  {
		Mockito.when(stockRepository.findByStockName("CTS")).thenReturn(s1);
		assertEquals(s1, stockService.getStockDetail("CTS"));
		status().isOk();

	}
	
	@Test
	void testfindAll() throws StockNotFoundException  {
		Mockito.when(stockRepository.findAll()).thenReturn(record);
		assertEquals(record, stockService.findAll());
		status().isOk();

	}
}
