package com.cicero.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cicero.dsvendas.dto.SaleDTO;
import com.cicero.dsvendas.dto.SaleSuccessDTO;
import com.cicero.dsvendas.dto.SaleSumDTO;
import com.cicero.dsvendas.entities.Sale;
import com.cicero.dsvendas.repositories.SaleRepository;
import com.cicero.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository SellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		SellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupbySeller(){
		return repository.amountGroupbySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupbySeller(){
		return repository.successGroupbySeller();
	}
}
