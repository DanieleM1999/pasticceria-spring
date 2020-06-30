package it.dstech.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Ricetta (nome, tempo di realizzazione (HH:mm), difficoltà(1-5), ingredienti[], descrizione, costo*)


@Entity
public class Ricetta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private String nome;
	
	private String tempo;
	
	private int difficolta;
	
	private List<Ingrediente> listaIngredienti;
	
	private String descrizione;
	
	private double costoRicetta;
	
	public Ricetta() {}

	public Ricetta(long id, String nome, String tempo, int difficolta, List<Ingrediente> listaIngredienti,
			String descrizione, double costoRicetta) {
		this.id = id;
		this.nome = nome;
		this.tempo = tempo;
		this.difficolta = difficolta;
		this.listaIngredienti = listaIngredienti;
		this.descrizione = descrizione;
		this.costoRicetta = costoRicetta;
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

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public int getDifficolta() {
		return difficolta;
	}

	public void setDifficolta(int difficolta) {
		this.difficolta = difficolta;
	}

	public List<Ingrediente> getListaIngredienti() {
		return listaIngredienti;
	}

	public void setListaIngredienti(List<Ingrediente> listaIngredienti) {
		this.listaIngredienti = listaIngredienti;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getCostoRicetta() {
		return costoRicetta;
	}

	public void setCostoRicetta(double costoRicetta) {
		this.costoRicetta = costoRicetta;
	}

	@Override
	public String toString() {
		return "Ricetta [id=" + id + ", nome=" + nome + ", tempo=" + tempo + ", difficolta=" + difficolta
				+ ", listaIngredienti=" + listaIngredienti + ", descrizione=" + descrizione + ", costoRicetta="
				+ costoRicetta + "]";
	}

}
