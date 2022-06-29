package com.cts.mutualfund.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.mutualfund.exception.MutualFundNotFoundException;
import com.cts.mutualfund.model.MutualFund;
import com.cts.mutualfund.repository.MutualFundRepository;

@Service
public class MutualFundService {
	
	@Autowired
	private MutualFundRepository mutualFundRepository;	
	
	public List<MutualFund> getAll() throws MutualFundNotFoundException{
		
		List<MutualFund> mf=mutualFundRepository.findAll();
		if(mf.isEmpty()) {
			throw new MutualFundNotFoundException("Mutual Found not Available");
		}
		return mf;
	}
	
	
	public MutualFund getByMutualFundName(String mfName) throws MutualFundNotFoundException {
		MutualFund mf=mutualFundRepository.findByMutualFundName(mfName);
		if(mf==null) {
			throw new MutualFundNotFoundException("Mutual Found not Available");
		}
		return mf;
	}

}
