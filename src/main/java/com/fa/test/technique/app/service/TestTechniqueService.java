package com.fa.test.technique.app.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.fa.test.technique.app.domain.Panier;
import com.fa.test.technique.app.domain.Produit;
import com.fa.test.technique.app.domain.Taxe;

public interface TestTechniqueService {

	List<Panier> findAllPaniers();

	Produit findProduitById(Long produitId);
	
	BigDecimal calculerTaxes(BigDecimal prix, Set<Taxe> taxes);

	BigDecimal calculerFacture(Long panierId);

}
