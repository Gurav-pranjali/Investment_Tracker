package com.cts.dailymutualfundnav;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.mutualfund.controller.MutualFundController;
import com.cts.mutualfund.service.MutualFundService;

@SpringBootTest
class DailyMutualFundNavApplicationTests {
	
	@Autowired
    private MutualFundController stockController;
    @Autowired
    private  MutualFundService stockService;
     @Test
     void contextLoads() throws Exception {
            assertThat(stockController).isNotNull();
            assertThat(stockService).isNotNull();
      }
	

}
