package it.dstech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingrediente {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private String nome;
	
	private double costoIng;
	
	
	public Ingrediente() {}


	public Ingrediente(long id, String nome, double costo) {
		this.id = id;
		this.nome = nome;
		this.costoIng = costo;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getCosto() {
		return costoIng;
	}


	public void setCosto(double costo) {
		this.costoIng = costo;
	}


	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nome=" + nome + ", costo=" + costoIng + "]";
	}
	
	
	
}
