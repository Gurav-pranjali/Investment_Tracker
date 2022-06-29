package com.cts.mutualfund.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="mutualfund")
public class MutualFund {
	
	@Id
	private int mutualFundId;
	@Column(unique = true, nullable = false)
	private String mutualFundName;
	private double mutualFundValue;

}
