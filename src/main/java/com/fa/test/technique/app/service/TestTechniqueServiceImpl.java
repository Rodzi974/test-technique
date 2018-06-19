package com.fa.test.technique.app.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.fa.test.technique.app.domain.Panier;
import com.fa.test.technique.app.domain.Produit;
import com.fa.test.technique.app.domain.Taxe;
import com.fa.test.technique.app.repository.PanierRepository;
import com.fa.test.technique.app.repository.ProduitRepository;

@Service("testTechniqueService")
@Transactional
public class TestTechniqueServiceImpl implements TestTechniqueService {

	@Autowired
	private PanierRepository panierRepository;

	@Autowired
	private ProduitRepository produitRepository;

	@Override
	public List<Panier> findAllPaniers() {
		return panierRepository.findAll();
	}

	@Override
	public Produit findProduitById(Long produitId) {
		return produitRepository.getOne(produitId);
	}
	
	@Override
	public BigDecimal calculerFacture(Long panierId) {
		BigDecimal facture = BigDecimal.ZERO;
		List<Produit> listeProduits = produitRepository.findByPanierId(panierId);
		for (Produit produit : listeProduits) {
			if(!CollectionUtils.isEmpty(produit.getTaxes())) {
				facture = facture.add(calculerTaxes(produit.getPrix(), produit.getTaxes()));
			}
			facture = facture.add(produit.getPrix());
		}
		return facture;
	}

	@Override
	public BigDecimal calculerTaxes(BigDecimal prix, Set<Taxe> taxes) {
		BigDecimal taxesCalculees = BigDecimal.ZERO;
		if(!CollectionUtils.isEmpty(taxes)) {
			for(Taxe taxe : taxes) {
				taxesCalculees = taxesCalculees.add(prix.multiply(taxe.getTaux()).multiply(new BigDecimal("0.05")).round(new MathContext(2)).divide(new BigDecimal("0.05")));
			}
		}
		return taxesCalculees;
	}
	
}
