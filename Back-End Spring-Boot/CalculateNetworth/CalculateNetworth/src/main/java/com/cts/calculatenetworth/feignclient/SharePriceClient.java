package com.cts.calculatenetworth.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.calculatenetworth.vo.StockDetailsVO;

@FeignClient(url = "http://localhost:8082", name = "SHAREPRICE-SERVICE")
public interface SharePriceClient {
	
	@GetMapping(value="/SharePrice/{stockName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StockDetailsVO getStockDetail(@RequestHeader("Authorization") String authorization,@PathVariable String stockName);

}
