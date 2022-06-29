package com.cts.calculatenetworth.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.calculatenetworth.model.StockDetail;
import com.cts.calculatenetworth.repository.StockDetailRepository;
@SpringBootTest
class StockDetailServiceTest {

	@MockBean
	private StockDetailRepository stockDetailsRepository;
	@Autowired
	private StockDetailService stockDetailService;

	StockDetail stockDetail = new StockDetail(10, "CTS", 101);

	@Test
	void testFindStockName() {
		Mockito.when(stockDetailsRepository.findByStockName("CTS")).thenReturn(stockDetail);
		assertEquals(stockDetail,stockDetailService.findStockName("CTS"));
		status().isOk();
	}

	@Test
	void testDeleteStockDetail() {
		int sid=10;
		stockDetailService.deleteStockDetail(sid);
		verify(stockDetailsRepository, times(1)).deleteById(sid);
		
	}

	@Test
	void testUpdateStockDetail() {

		stockDetail.setStockCount(4);		
		stockDetailService.updateStockDetail(stockDetail);;
		verify(stockDetailsRepository, times(1)).save(stockDetail);
		
	}

}
