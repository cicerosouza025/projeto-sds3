package com.cicero.dsvendas.dto;

import java.io.Serializable;

import com.cicero.dsvendas.entities.Seller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaleSumDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Double sum;
	
	public SaleSumDTO() {}

	public SaleSumDTO(Seller seller, Double sum) {
		this.sellerName = seller.getName();
		this.sum = sum;
	}
}
