package com.cts.calculatenetworth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@ToString
@Entity
@Table(name = "mutualfund")
public class MutualFund {

	public MutualFund(Integer mfId, String mutualFundName, Integer mutualFundUnits) {
		super();
		this.mfId = mfId;
		this.mutualFundName = mutualFundName;
		this.mutualFundUnits = mutualFundUnits;
	}

	@Id
	@Column(name = "mf_id")
	private Integer mfId;

	@Column(name = "mutual_fund_name")
	private String mutualFundName;
	
	@Column(name = "mutual_fund_units")
	private Integer mutualFundUnits;

	@ManyToOne
	@JoinColumn(name = "investment_id")
	@JsonBackReference
	private InvestmentDetails investmentDetails;

}
