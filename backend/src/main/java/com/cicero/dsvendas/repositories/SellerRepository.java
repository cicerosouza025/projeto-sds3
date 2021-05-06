package com.cicero.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cicero.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
