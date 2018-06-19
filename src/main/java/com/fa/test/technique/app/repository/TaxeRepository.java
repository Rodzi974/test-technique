package com.fa.test.technique.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.test.technique.app.domain.Taxe;

@Repository
public interface TaxeRepository extends JpaRepository<Taxe, Long> {

}
