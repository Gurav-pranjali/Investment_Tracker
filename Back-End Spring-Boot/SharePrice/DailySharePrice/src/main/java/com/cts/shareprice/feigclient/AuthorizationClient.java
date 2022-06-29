package com.cts.shareprice.feigclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8081", name = "AUTHORIZATION-SERVICE")
public interface AuthorizationClient {
	
	@GetMapping("/getuname")
	public String getUname(@RequestHeader("Authorization") String authorization);

}
