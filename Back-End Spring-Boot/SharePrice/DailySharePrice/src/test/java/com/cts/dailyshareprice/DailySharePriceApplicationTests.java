package com.cts.dailyshareprice;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.shareprice.controller.StockController;
import com.cts.shareprice.service.StockService;

@SpringBootTest
class DailySharePriceApplicationTests {

	@Autowired
    private StockController stockController;
    @Autowired
    private  StockService stockService;
     @Test
     void contextLoads() throws Exception {
            assertThat(stockController).isNotNull();
            assertThat(stockService).isNotNull();
      }
}
