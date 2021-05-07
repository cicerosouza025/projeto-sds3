package com.cicero.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cicero.dsvendas.dto.SaleDTO;
import com.cicero.dsvendas.dto.SaleSuccessDTO;
import com.cicero.dsvendas.dto.SaleSumDTO;
import com.cicero.dsvendas.service.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
		
	//get com paginação
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupbySeller(){
		List<SaleSumDTO> list = service.amountGroupbySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupbySeller(){
		List<SaleSuccessDTO> list = service.successGroupbySeller();
		return ResponseEntity.ok(list);
	}
}
