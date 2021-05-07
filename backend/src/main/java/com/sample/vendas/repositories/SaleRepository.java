package com.sample.vendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.vendas.dto.SaleSuccessDTO;
import com.sample.vendas.dto.SaleSumDTO;
import com.sample.vendas.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.sample.vendas.dto.SaleSumDTO(tb_sale.seller, SUM(tb_sale.amount)) from Sale AS tb_sale GROUP BY tb_sale.seller")
	List<SaleSumDTO> amountGrupedBySeller();
	
	@Query("SELECT new com.sample.vendas.dto.SaleSuccessDTO(tb_sale.seller, SUM(tb_sale.visited), SUM(tb_sale.deals)) from Sale AS tb_sale GROUP BY tb_sale.seller")
	List<SaleSuccessDTO> successGrupedBySeller();
}
