package com.advancia;

import com.fasterxml.jackson.annotation.*;

public class ExteseUsers {
	@JsonIgnore
	private int id;
	private String name;
	private String lName;
	private String CodFis;
	private String indirizzo;
	
	
	public ExteseUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ExteseUsers(int id, String name, String lName, String codFis, String indirizzo) {
	
		super();
		this.id = id;
		this.name = name;
		this.lName = lName;
		CodFis = codFis;
		this.indirizzo = indirizzo;
	}
	
	
	public int getId() {
	
		return id;
	}
	
	
	public void setId(int id) {
	
		this.id = id;
	}
	
	
	public String getName() {
	
		return name;
	}
	
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	
	public String getlName() {
	
		return lName;
	}
	
	
	public void setlName(String lName) {
	
		this.lName = lName;
	}
	
	
	public String getCodFis() {
	
		return CodFis;
	}
	
	
	public void setCodFis(String codFis) {
	
		CodFis = codFis;
	}
	
	
	public String getIndirizzo() {
	
		return indirizzo;
	}
	
	
	public void setIndirizzo(String indirizzo) {
	
		this.indirizzo = indirizzo;
	}
}
