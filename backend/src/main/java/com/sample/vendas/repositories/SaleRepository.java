package com.sample.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.vendas.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
