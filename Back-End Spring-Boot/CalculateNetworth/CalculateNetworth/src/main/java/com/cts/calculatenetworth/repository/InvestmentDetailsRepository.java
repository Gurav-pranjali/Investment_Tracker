package com.cts.calculatenetworth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.calculatenetworth.model.InvestmentDetails;

public interface InvestmentDetailsRepository extends JpaRepository<InvestmentDetails, Integer> {
	public InvestmentDetails findByInvestmentid(int id);

}
