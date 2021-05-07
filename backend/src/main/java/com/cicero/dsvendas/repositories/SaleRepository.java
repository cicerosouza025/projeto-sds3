package com.cicero.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cicero.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
