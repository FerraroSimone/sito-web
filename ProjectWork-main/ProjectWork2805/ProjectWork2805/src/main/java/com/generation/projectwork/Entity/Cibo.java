package com.generation.projectwork.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cibo")
public class Cibo {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private String immagine;
	
	@Column(precision=6,scale=2)
	private BigDecimal prezzo;
	
	private String allergeni;
	
	private String descrizione;
	
	private String portata;
	
	private String alimentazione;

	private int furgoni_id;
	
	
	public Cibo(){}
	
	
	public Cibo(int id, String nome, String immagine, BigDecimal prezzo, String allergeni, String descrizione,
			String portata, String alimentazione, int furgoni_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.immagine = immagine;
		this.prezzo = prezzo;
		this.allergeni = allergeni;
		this.descrizione = descrizione;
		this.portata = portata;
		this.alimentazione = alimentazione;
		this.furgoni_id = furgoni_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public String getAllergeni() {
		return allergeni;
	}

	public void setAllergeni(String allergeni) {
		this.allergeni = allergeni;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getPortata() {
		return portata;
	}

	public void setPortata(String portata) {
		this.portata = portata;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}


	public int getFurgoni_id() {
		return furgoni_id;
	}


	public void setFurgoni_id(int furgoni_id) {
		this.furgoni_id = furgoni_id;
	}
	
	
	
}
