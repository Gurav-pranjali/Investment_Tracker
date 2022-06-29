package com.cts.shareprice.model;

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
@Getter
@Setter
@ToString
@Entity
@Table(name="stocklist")
public class Stock{
	
	@Id
	private int stockId;
	@Column(unique = true, nullable = false)
	private String stockName;
	private double stockValue;

}
