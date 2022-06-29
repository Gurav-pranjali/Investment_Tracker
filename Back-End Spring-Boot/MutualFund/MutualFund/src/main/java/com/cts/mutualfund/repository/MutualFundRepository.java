package com.cts.mutualfund.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.mutualfund.model.MutualFund;

@Repository
public interface MutualFundRepository extends JpaRepository<MutualFund, Integer> {

	public List<MutualFund> findAll();
	public MutualFund findByMutualFundName(String mutualFundName);
}
