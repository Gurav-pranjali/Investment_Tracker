package com.cts.calculatenetworth.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString 
public class AssetSaleResponse {
	
	private Boolean saleStatus;
	private Double networth;
	private Map<String, Integer> map = new HashMap<>();

}
