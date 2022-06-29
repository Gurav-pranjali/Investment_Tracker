package com.cts.dailyshareprice.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.shareprice.model.Stock;

@SpringBootTest
class StockTest {

	Stock st = new Stock();
	Stock st1 = new Stock(11, "MRX", 12);

	@Test
	void testGetStockId() {
		st.setStockId(12);
		assertEquals(12, st.getStockId());
	}

	@Test
	void testGetStockName() {
		st.setStockName("CRS");
		assertEquals("CRS", st.getStockName());
	}

	@Test
	void testGetStockValue() {
		st.setStockValue(15);
		assertEquals(15, st.getStockValue());
		;
	}

	@Test
	void testSetStockId() {
		st.setStockId(13);
		assertEquals(13, st.getStockId());
	}

	@Test
	void testSetStockName() {
		st.setStockName("CRX");
		assertEquals("CRX", st.getStockName());
	}

	@Test
	void testSetStockValue() {
		st.setStockValue(16);
		assertEquals(16, st.getStockValue());
		;
	}

	@Test
	void testToString() {
		Stock st= new Stock(101, "abc", 10.0);
		assertEquals("Stock(stockId=101, stockName=abc, stockValue=10.0)",st.toString());

	}

}
