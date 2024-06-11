package com.generation.projectwork.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "furgoni")
public class Furgoni {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private String immagine;
	
	private int n_telefono;
	
	private String descrizione;

	
	public Furgoni() {}
	
	
	public Furgoni(int id, String nome, String immagine, int n_telefono, String descrizione) {
		super();
		this.id = id;
		this.nome = nome;
		this.immagine = immagine;
		this.n_telefono = n_telefono;
		this.descrizione = descrizione;
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

	public void setImmagini(String immagine) {
		this.immagine = immagine;
	}

	public int getN_telefono() {
		return n_telefono;
	}

	public void setN_telefono(int n_telefono) {
		this.n_telefono = n_telefono;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	
}
