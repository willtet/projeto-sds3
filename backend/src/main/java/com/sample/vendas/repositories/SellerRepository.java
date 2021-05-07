package com.sample.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.vendas.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{
	
}
