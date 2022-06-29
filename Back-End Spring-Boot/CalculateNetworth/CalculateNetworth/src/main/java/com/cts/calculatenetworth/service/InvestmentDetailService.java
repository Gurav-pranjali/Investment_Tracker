package com.cts.calculatenetworth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.calculatenetworth.feignclient.MutualFundClient;
import com.cts.calculatenetworth.feignclient.SharePriceClient;
import com.cts.calculatenetworth.model.MutualFund;
import com.cts.calculatenetworth.model.InvestmentDetails;
import com.cts.calculatenetworth.model.StockDetail;
import com.cts.calculatenetworth.repository.InvestmentDetailsRepository;
import com.cts.calculatenetworth.vo.MutualFundVO;
import com.cts.calculatenetworth.vo.StockDetailsVO;

@Service
public class InvestmentDetailService {

	@Autowired
	private InvestmentDetailsRepository investmentDetailsRepository;
	
	@Autowired
	private SharePriceClient sharePriceClient;
	
	@Autowired
	private MutualFundClient mutualFundClient;

	public List<InvestmentDetails> getAll() {
		return investmentDetailsRepository.findAll();
	}

	public InvestmentDetails findByPfid(int id) {
		InvestmentDetails pfDetail = investmentDetailsRepository.findByInvestmentid(id);
		if (pfDetail == null) {
			return null;
		}
		return pfDetail;
	}

	public double getcalculateNetworth(int id,String authorization) {
		double totalNetworth=0.0;
		InvestmentDetails pfDetail = findByPfid(id);
		List<StockDetail> stockDetail = pfDetail.getStockDetailList();
		List<MutualFund> mutualFund = pfDetail.getMutualFundList();
		for (StockDetail stock : stockDetail) {
			StockDetailsVO stockDetailsVO=sharePriceClient.getStockDetail(authorization,stock.getStockName());
			totalNetworth += stockDetailsVO.getStockValue() * stock.getStockCount();
		}
		for (MutualFund mfund : mutualFund) {
			MutualFundVO mutualFundVO=mutualFundClient.getMutualFundDetails(authorization,mfund.getMutualFundName());
			totalNetworth += mutualFundVO.getMutualFundValue() * mfund.getMutualFundUnits();
		}

		return totalNetworth;
	}

}
