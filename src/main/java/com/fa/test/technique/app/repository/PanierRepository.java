package com.fa.test.technique.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.test.technique.app.domain.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {

}
