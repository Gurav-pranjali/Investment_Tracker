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

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="stockdetail")
public class StockDetail {
	

	@Id
	@Column(name="st_id")
	private int stId;
	@Column(name="stock_name")
	private String stockName;
	@Column(name="stock_count")
	private int stockCount;
	
	@ManyToOne
	@JoinColumn(name="investment_id")
	@JsonBackReference
	private InvestmentDetails investmentDetails;
	
	public StockDetail(int stId, String stockName, int stockCount) {
		super();
		this.stId = stId;
		this.stockName = stockName;
		this.stockCount = stockCount;
	}
	
}
