package com.fa.test.technique.app.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fa.test.technique.app.domain.Produit;
import com.fa.test.technique.app.service.TestTechniqueService;

@RestController
public class TestTechniqueAPIController {

	public static final Logger logger = LoggerFactory.getLogger(TestTechniqueAPIController.class);

	@Autowired
	private TestTechniqueService testTechniqueService;

	@GetMapping(path = "/calculerTaxes")
	public BigDecimal calculerTaxes(@RequestParam(value = "produitId") Long produitId) {
		BigDecimal taxes = BigDecimal.ZERO;
		Produit produit = testTechniqueService.findProduitById(produitId);
		if(produit != null) {
			taxes = testTechniqueService.calculerTaxes(produit.getPrix(), produit.getTaxes());
		}
		return taxes;
	}

}
