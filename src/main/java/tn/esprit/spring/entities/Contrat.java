package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contrat implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@SequenceGenerator(name="seq")
	private int id;
	
	private String datex;
	
	//@Column(name="TYPE_CTR", nullable=true )
	private String typeContrat;
	
	@Transient 
	private float telephone;
	
	@JsonIgnore
	//@JsonBackReference
	@OneToOne(mappedBy="contrat")
	private Employe employe;
	
	@OneToMany(mappedBy="contrat")
	private List<Mission> missions;

	private float salaire;

	public Contrat() {
		super();
	}
	
	public Contrat(String datex, String typeContrat, float salaire) {
		this.datex = datex;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}
	
	public Contrat(int id,String datex, String typeContrat, float salaire) {
		super();
		this.id=id;
		this.datex = datex;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}


	public String getDatex() {
		return datex;
	}

	public void setDatex(String datex) {
		this.datex = datex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
}
