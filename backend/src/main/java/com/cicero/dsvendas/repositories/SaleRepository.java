package com.cicero.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cicero.dsvendas.dto.SaleSuccessDTO;
import com.cicero.dsvendas.dto.SaleSumDTO;
import com.cicero.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.cicero.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale as obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupbySeller();
	
	@Query("SELECT new com.cicero.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale as obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupbySeller();
}
