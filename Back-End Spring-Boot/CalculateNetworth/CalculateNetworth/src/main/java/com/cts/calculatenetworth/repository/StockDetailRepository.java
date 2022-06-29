package com.cts.calculatenetworth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.calculatenetworth.model.StockDetail;

public interface StockDetailRepository extends JpaRepository<StockDetail, Integer> {
	public StockDetail findByStockName(String stockName);
}
