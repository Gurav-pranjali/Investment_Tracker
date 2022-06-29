package com.cts.shareprice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.shareprice.exception.StockNotFoundException;
import com.cts.shareprice.feigclient.AuthorizationClient;
import com.cts.shareprice.model.Stock;
import com.cts.shareprice.service.StockService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/SharePrice")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private AuthorizationClient authorizationClient;
	
	
	
	@GetMapping(value="/{stockName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Stock getStockDetail(@RequestHeader("Authorization") String authorization,@PathVariable String stockName) throws StockNotFoundException {
		authorizationClient.getUname(authorization);
		log.info("fetching Stock Details using stockName");
		return stockService.getStockDetail(stockName);
	}
	
	@GetMapping(value="/allstock", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getAllStockDetails(@RequestHeader("Authorization") String authorization) throws StockNotFoundException
	{
		authorizationClient.getUname(authorization);
		return stockService.findAll();
	}
	
}
