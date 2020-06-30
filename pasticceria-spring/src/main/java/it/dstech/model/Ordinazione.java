package it.dstech.model;
import java.util.List;

//Ordinazione ( Cliente, nome dolce[], data consegna, costo, sconto)
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ordinazione {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@ManyToOne
	private Cliente cliente;
	
	private List<Dolce> listaDolci;
	
	private String consegna;
	
	private double costoOrdinazione;
	
	private int sconto;
	
	public Ordinazione() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Dolce> getListaDolci() {
		return listaDolci;
	}

	public void setListaDolci(List<Dolce> listaDolci) {
		this.listaDolci = listaDolci;
	}

	public String getConsegna() {
		return consegna;
	}

	public void setConsegna(String consegna) {
		this.consegna = consegna;
	}

	public double getCostoOrdinazione() {
		return costoOrdinazione;
	}

	public void setCostoOrdinazione(double costoOrdinazione) {
		this.costoOrdinazione = costoOrdinazione;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	@Override
	public String toString() {
		return "Ordinazione [id=" + id + ", listaDolci=" + listaDolci + ", consegna=" + consegna + ", costoOrdinazione="
				+ costoOrdinazione + ", sconto=" + sconto + "]";
	}
}
