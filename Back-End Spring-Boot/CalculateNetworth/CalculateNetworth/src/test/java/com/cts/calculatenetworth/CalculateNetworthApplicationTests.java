package com.cts.calculatenetworth;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.calculatenetworth.controller.NetworthController;
import com.cts.calculatenetworth.service.MutualFundService;
import com.cts.calculatenetworth.service.InvestmentDetailService;
import com.cts.calculatenetworth.service.StockDetailService;


@SpringBootTest
class CalculateNetworthApplicationTests {

	@Autowired
    private NetworthController networthController;
    @Autowired
    private  MutualFundService mutualFundService;
    @Autowired
    private  InvestmentDetailService investmentService;
    @Autowired
    private  StockDetailService stockDetailService;
     @Test
     void contextLoads() throws Exception {
            assertThat(networthController).isNotNull();
            assertThat(mutualFundService).isNotNull();
            assertThat(investmentService).isNotNull();
            assertThat(stockDetailService).isNotNull();
      }
	

}
