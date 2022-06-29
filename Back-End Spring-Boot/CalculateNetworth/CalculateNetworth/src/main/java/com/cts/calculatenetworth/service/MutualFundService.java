package com.cts.calculatenetworth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.calculatenetworth.model.MutualFund;
import com.cts.calculatenetworth.repository.MutualFundRepository;
import com.cts.calculatenetworth.vo.SaleDetailsVO;

@Service
public class MutualFundService {
	@Autowired
	private MutualFundRepository mutualFundRepository;

	public MutualFund findByMutualFundName(String mutualFundName) {
		MutualFund mutualFund = mutualFundRepository.findByMutualFundName(mutualFundName);
		if (mutualFund == null) {
			return null;
		}
		return mutualFund;
	}

	public void deleteMutalFund(Integer mfId) {
		mutualFundRepository.deleteById(mfId);

	}

	public void updateMutualFund(MutualFund currentMutualFund) {

		mutualFundRepository.save(currentMutualFund);
	}

	public Map<String, Integer> updateAndDeleteStock(List<SaleDetailsVO> saleDetailsList) {
		int currentMfUnits;
		int soldMfUnits;
		MutualFund currentMutualFund = null;
		Map<String, Integer> map = new HashMap<>();
		for (SaleDetailsVO sale : saleDetailsList) {
			currentMutualFund = findByMutualFundName(sale.getAssetName());
			if (currentMutualFund != null) {
				soldMfUnits = sale.getSoldUnits();
				currentMfUnits = currentMutualFund.getMutualFundUnits();
				if (soldMfUnits == currentMfUnits) {
					deleteMutalFund(currentMutualFund.getMfId());
				} else if (currentMfUnits - soldMfUnits > 0 && soldMfUnits != 0) {
					currentMfUnits = (currentMfUnits - soldMfUnits);
					currentMutualFund.setMutualFundUnits(currentMfUnits);
					updateMutualFund(currentMutualFund);
				} else {			
					map.put(currentMutualFund.getMutualFundName(), soldMfUnits);
				}
			}
		}
		return map;
	}

}
