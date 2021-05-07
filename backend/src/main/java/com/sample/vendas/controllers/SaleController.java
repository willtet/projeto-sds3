package com.sample.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.vendas.dto.SaleDTO;
import com.sample.vendas.dto.SaleSuccessDTO;
import com.sample.vendas.dto.SaleSumDTO;
import com.sample.vendas.services.SaleService;

@RestController
@RequestMapping(value="/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> page= service.findAll(pageable);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping(value="/sum-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGrupedBySeller(){
		List<SaleSumDTO> list= service.amountGrupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> sucessGrupedBySeller(){
		List<SaleSuccessDTO> list= service.sucessGrupedBySeller();
		return ResponseEntity.ok(list);
	}
}
