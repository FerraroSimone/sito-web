package com.generation.projectwork.Entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;



@Entity
@Table(name = "utenti")
public class Utente {
@Id
@Column(name="id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String email;

//@NotEmpty(message = "La password è obbligatoria")
//@JsonIgnore(access = JsonProperty.Access.WRITE_ONLY)
private String password;

private String nome;

private String cognome;


private String ruolo;

private String username;

public Utente(){}


public Utente(int id, String email, String password, String nome, String cognome, String ruolo, String username) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.nome = nome;
	this.cognome = cognome;
	this.ruolo = ruolo;
	this.username=username;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCognome() {
	return cognome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public String getRuolo() {
	return ruolo;
}

public void setRuolo(String ruolo) {
	this.ruolo = ruolo;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}





}
