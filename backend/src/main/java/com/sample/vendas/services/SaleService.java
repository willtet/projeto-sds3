package com.sample.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.vendas.dto.SaleDTO;
import com.sample.vendas.dto.SaleSuccessDTO;
import com.sample.vendas.dto.SaleSumDTO;
import com.sample.vendas.dto.SellerDTO;
import com.sample.vendas.entity.Sale;
import com.sample.vendas.repositories.SaleRepository;
import com.sample.vendas.repositories.SellerRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> list = repository.findAll(pageable);
		return list.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGrupedBySeller(){
		return repository.amountGrupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> sucessGrupedBySeller(){
		return repository.successGrupedBySeller();
	}

}
