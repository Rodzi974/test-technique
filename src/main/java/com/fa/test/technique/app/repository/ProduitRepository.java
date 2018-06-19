package com.fa.test.technique.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.test.technique.app.domain.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	List<Produit> findByPanierId(Long panierId);
	
}
