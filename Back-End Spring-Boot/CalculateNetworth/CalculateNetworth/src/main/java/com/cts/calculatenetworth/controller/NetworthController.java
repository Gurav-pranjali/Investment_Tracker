package com.cts.calculatenetworth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.calculatenetworth.feignclient.AuthorizationClient;
import com.cts.calculatenetworth.model.AssetSaleResponse;
import com.cts.calculatenetworth.model.MutualFund;
import com.cts.calculatenetworth.model.InvestmentDetails;
import com.cts.calculatenetworth.model.StockDetail;
import com.cts.calculatenetworth.service.MutualFundService;
import com.cts.calculatenetworth.service.InvestmentDetailService;
import com.cts.calculatenetworth.service.StockDetailService;
import com.cts.calculatenetworth.vo.SaleDetailsVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/calculateNetworth")
@Slf4j
@CrossOrigin(origins = "*")
public class NetworthController {

	@Autowired
	private InvestmentDetailService investmentDetailService;

	@Autowired
	private AuthorizationClient authorizationClient;

	@Autowired
	private StockDetailService stockDetailService;

	@Autowired
	private MutualFundService mutualFundfolioDetailService;

	@GetMapping(value = "/viewAsset", produces = MediaType.APPLICATION_JSON_VALUE)
	public InvestmentDetails getAssetById(@RequestHeader("Authorization") String authorization) {
		int pid = authorizationClient.getUserId(authorization);
		log.info("finding user by id...");
		return investmentDetailService.findByPfid(pid);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public double calculateNetworth(@RequestHeader("Authorization") String authorization) {
		int pid = authorizationClient.getUserId(authorization);
		log.info("calculating networth....");
		return investmentDetailService.getcalculateNetworth(pid, authorization);
	}

	@PostMapping(value = "/sellAssets", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AssetSaleResponse> sellingAssets(@RequestHeader("Authorization") String authorization,
			@RequestBody List<SaleDetailsVO> saleDetailsList) {
		int pid = authorizationClient.getUserId(authorization);
		log.info("selling started...");
		AssetSaleResponse assetSaleResponse = new AssetSaleResponse();	
		Map<String, Integer> stockMap=stockDetailService.updateAndDeleteStock(saleDetailsList);
		Map<String, Integer> mfMap=mutualFundfolioDetailService.updateAndDeleteStock(saleDetailsList);
		stockMap.putAll(mfMap);
		if (!stockMap.isEmpty()) {
			assetSaleResponse.setSaleStatus(false);
			assetSaleResponse.setMap(stockMap);
			assetSaleResponse.setNetworth(investmentDetailService.getcalculateNetworth(pid, authorization));
			log.info("Having Problem in selling....");
			log.info("............."+stockMap.size());
			return ResponseEntity.status(HttpStatus.OK).body(assetSaleResponse);
		} else {
			assetSaleResponse.setNetworth(investmentDetailService.getcalculateNetworth(pid, authorization));
			assetSaleResponse.setSaleStatus(true);
			log.info("successfully sell....");
			return ResponseEntity.status(HttpStatus.OK).body(assetSaleResponse);
		}
	}
}
