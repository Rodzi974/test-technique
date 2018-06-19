package com.fa.test.technique;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.fa.test.technique.app.domain.Panier;
import com.fa.test.technique.app.domain.Produit;
import com.fa.test.technique.app.repository.PanierRepository;
import com.fa.test.technique.app.repository.ProduitRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RespositoryTest extends AbstractTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PanierRepository panierRepository;

	@Autowired
	private ProduitRepository produitRepository;

	@Before
	public void setup() {
		Panier input1 = new Panier();
		input1.setLibelle("Input1");
		entityManager.persist(input1);
		entityManager.flush();

		Produit produit1 = new Produit();
		produit1.setLibelle("Livre");
		produit1.setPrix(new BigDecimal("12.49"));
		produit1.setQuantite(1);
		produit1.setPanier(input1);
		entityManager.persist(produit1);
		entityManager.flush();

		Produit produit2 = new Produit();
		produit2.setLibelle("CD musical");
		produit2.setPrix(new BigDecimal("16.49"));
		produit2.setQuantite(1);
		produit2.setPanier(input1);
		entityManager.persist(produit2);
		entityManager.flush();

		Produit produit3 = new Produit();
		produit3.setLibelle("barre de chocolat");
		produit3.setPrix(new BigDecimal("0.85"));
		produit3.setQuantite(1);
		produit3.setPanier(input1);
		entityManager.persist(produit3);
		entityManager.flush();

		Set<Produit> produits = new HashSet<>();
		produits.add(produit1);
		produits.add(produit2);
		produits.add(produit3);
		input1.setProduits(produits);

	}

	@Test
	public void populatePanierEtProduits() {
		List<Panier> paniers = panierRepository.findAll();
		assertEquals(1, paniers.size());
		assertFalse(paniers.get(0).getProduits().isEmpty());

		List<Produit> produits = produitRepository.findAll();
		assertEquals(3, produits.size());
		produits.forEach(produit -> {
			assertNotNull(produit.getPanier());
		});

	}

}
