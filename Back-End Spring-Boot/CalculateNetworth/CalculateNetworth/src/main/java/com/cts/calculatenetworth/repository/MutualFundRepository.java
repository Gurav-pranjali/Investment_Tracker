package com.cts.calculatenetworth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.calculatenetworth.model.MutualFund;

public interface MutualFundRepository extends JpaRepository<MutualFund, Integer> {
	public MutualFund findByMutualFundName(String mfname);
}
