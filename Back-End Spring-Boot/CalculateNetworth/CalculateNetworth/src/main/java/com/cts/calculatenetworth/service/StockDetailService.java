package com.cts.calculatenetworth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.calculatenetworth.model.StockDetail;
import com.cts.calculatenetworth.repository.StockDetailRepository;
import com.cts.calculatenetworth.vo.SaleDetailsVO;

@Service
public class StockDetailService {

	@Autowired
	private StockDetailRepository stockRepository;

	public StockDetail findStockName(String stockName) {
		StockDetail stockDetail = stockRepository.findByStockName(stockName);
		if (stockDetail == null) {
			return null;
		}
		return stockDetail;
	}

	public void deleteStockDetail(int stId) {
		stockRepository.deleteById(stId);
	}

	public void updateStockDetail(StockDetail currentStockDetail) {
		stockRepository.save(currentStockDetail);
	}

	public Map<String, Integer> updateAndDeleteStock(List<SaleDetailsVO> saleDetailsList) {
		int currentStockUnits;
		int soldStockUnits;
		StockDetail currentStockDetail = null;
		Map<String, Integer> map = new HashMap<>();
		for (SaleDetailsVO sale : saleDetailsList) {
			currentStockDetail = findStockName(sale.getAssetName());
			if (currentStockDetail != null) {
				soldStockUnits = sale.getSoldUnits();
				currentStockUnits = currentStockDetail.getStockCount();
				if (soldStockUnits == currentStockUnits) {
					deleteStockDetail(currentStockDetail.getStId());
				} else if ((currentStockUnits - soldStockUnits > 0) && soldStockUnits != 0) {
					currentStockUnits = currentStockUnits - soldStockUnits;
					currentStockDetail.setStockCount(currentStockUnits);
					updateStockDetail(currentStockDetail);
				} else {
					map.put(currentStockDetail.getStockName(), soldStockUnits);
				}
			}
		}
		return map;
	}	
}
