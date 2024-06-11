package com.generation.projectwork.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordine_dettaglio")
public class OrdiniDettaglio {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int ordineId;
	private int ciboId;
	private int quantita;
	private int prezzo;
	
	public OrdiniDettaglio(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdine_id() {
		return ordineId;
	}

	public void setOrdine_id(int ordine_id) {
		this.ordineId = ordine_id;
	}

	public int getCibo_id() {
		return ciboId;
	}

	public void setCibo_id(int cibo_id) {
		this.ciboId = cibo_id;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	
}
