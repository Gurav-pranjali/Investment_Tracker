package com.cts.mutualfund.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mutualfund.exception.MutualFundNotFoundException;
import com.cts.mutualfund.feignclient.AuthorizationClient;
import com.cts.mutualfund.model.MutualFund;
import com.cts.mutualfund.service.MutualFundService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/MutualFund")
public class MutualFundController {

	@Autowired
	private MutualFundService mutualFundService;

	@Autowired
	private AuthorizationClient authorizationClient;

	@GetMapping(value = "/{mutualFundName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MutualFund getMutualFundDetails(@RequestHeader("Authorization") String authorization,
			@PathVariable String mutualFundName) throws MutualFundNotFoundException {
		authorizationClient.getUname(authorization);
		log.info("Fetching MutualFund using MutualName");
		return mutualFundService.getByMutualFundName(mutualFundName);
	}
	
	@GetMapping(value="/allmf", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MutualFund> getAllMutualFund(@RequestHeader("Authorization") String authorization) throws MutualFundNotFoundException
	{
		authorizationClient.getUname(authorization);
		return mutualFundService.getAll();
	}

}
