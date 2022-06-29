package com.cts.shareprice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.shareprice.exception.StockNotFoundException;
import com.cts.shareprice.model.Stock;
import com.cts.shareprice.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	public List<Stock> findAll() throws StockNotFoundException{
		List<Stock> stockList=stockRepository.findAll();
		if(stockList.isEmpty()) {
			throw new StockNotFoundException("Stock is not available");
		}
		return stockList;
	}
	
	public Stock getStockDetail(String stockName) throws StockNotFoundException {
		Stock stock=stockRepository.findByStockName(stockName);
		if(stock==null) {
			throw new StockNotFoundException("Stock is not available");
		}
		return stock;
	}

}
