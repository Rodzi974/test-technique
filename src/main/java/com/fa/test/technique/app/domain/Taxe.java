package com.fa.test.technique.app.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "taxe")
public class Taxe implements Serializable {

	private static final long serialVersionUID = -3885945761667344833L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "libelle", nullable = false)
	private String libelle;

	@Column(name = "taux", nullable = false)
	private BigDecimal taux;

	@ManyToMany(mappedBy = "taxes")
	private Set<Produit> produits;
	
	public Taxe() {

	}

	public Long getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(final String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getTaux() {
		return taux;
	}

	public void setTaux(final BigDecimal taux) {
		this.taux = taux;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(final Set<Produit> produits) {
		this.produits = produits;
	}

}
