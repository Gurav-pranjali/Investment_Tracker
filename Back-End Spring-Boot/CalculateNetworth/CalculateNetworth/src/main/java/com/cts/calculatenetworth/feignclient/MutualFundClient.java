package com.cts.calculatenetworth.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.calculatenetworth.vo.MutualFundVO;



@FeignClient(url = "http://localhost:8083", name = "MUTUALFUND-SERVICE")
public interface MutualFundClient {

	@GetMapping(value = "/MutualFund/{mutualFundName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MutualFundVO getMutualFundDetails(@RequestHeader("Authorization") String authorization,
			@PathVariable String mutualFundName);
}
