package it.dstech.model;
import java.util.List;

//Cliente( nome, cognome, ordinazioni[])
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Cliente {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private String nome;
	
	private String cognome;
	
	@OneToMany
	private List<Ordinazione> listaOrdinazioni;
	
	public Cliente() {}

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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Ordinazione> getListaOrdinazioni() {
		return listaOrdinazioni;
	}

	public void setListaOrdinazioni(List<Ordinazione> listaOrdinazioni) {
		this.listaOrdinazioni = listaOrdinazioni;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", listaOrdinazioni="
				+ listaOrdinazioni + "]";
	}
	
	
}
