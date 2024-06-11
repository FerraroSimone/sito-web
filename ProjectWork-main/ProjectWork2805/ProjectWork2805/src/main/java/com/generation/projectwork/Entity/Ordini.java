package com.generation.projectwork.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordini")
public class Ordini {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int utenti_id;
	
	private String data;
	
	public Ordini() {
		
	}
	
	public Ordini(int id, int utenti_id, String data) {
		super();
		this.id = id;
		this.utenti_id = utenti_id;
		this.data = data;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUtenti_id() {
		return utenti_id;
	}

	public void setUtenti_id(int utenti_id) {
		this.utenti_id = utenti_id;
	}

	
	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	
	
	
	
	
}
