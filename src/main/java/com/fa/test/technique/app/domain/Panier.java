package com.fa.test.technique.app.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier implements Serializable {

	private static final long serialVersionUID = -6592194237503633392L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "libelle", nullable = false)
	private String libelle;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "panier")
	private Set<Produit> produits;

	public Panier() {

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

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(final Set<Produit> produits) {
		this.produits = produits;
	}

}
