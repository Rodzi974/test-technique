package com.fa.test.technique.app.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit implements Serializable {

	private static final long serialVersionUID = 2571775121564374791L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "libelle", nullable = false)
	private String libelle;

	@Column(name = "prix", nullable = false)
	private BigDecimal prix;

	@Column(name = "quantite", nullable = false)
	private int quantite;

	@ManyToOne
	private Panier panier;

	@ManyToMany
	@JoinTable(name = "taxe_produit", joinColumns = @JoinColumn(name = "produitId"), inverseJoinColumns = @JoinColumn(name = "taxeId"))
	private Set<Taxe> taxes;

	public Produit() {

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

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(final BigDecimal prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(final int quantite) {
		this.quantite = quantite;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(final Panier panier) {
		this.panier = panier;
	}

	public Set<Taxe> getTaxes() {
		return taxes;
	}

	public void setTaxes(final Set<Taxe> taxes) {
		this.taxes = taxes;
	}

}
