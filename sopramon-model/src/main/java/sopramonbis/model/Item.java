package sopramonbis.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Item {
	
	@Id
	@Column(name = "ITE_ID", columnDefinition = "INT NOT NULL AUTO_INCREMENT")
	@NotNull
	private int id;
	
	@Column(name = "ITE_NOM", columnDefinition = "VARCHAR(100) NOT NULL")
	@NotEmpty
	@Size(max = 100)
	private String nom;
	
	@Column(name = "ITE_PRIX", columnDefinition = "DOUBLE NOT NULL")
	@NotNull
	private Double prix;
	
	@ManyToOne
	@JoinColumn(name = "ITE_CAPACITE")
	private Capacite capacite;
	
	@Column(name = "ITE_ATT", columnDefinition = "INT SIGNED NOT NULL")
	@NotNull
	private int attaque;
	
	@Column(name = "ITE_DEF", columnDefinition = "INT SIGNED NOT NULL")
	@NotNull
	private int defense;
	
	@Column(name = "ITE_ESQ", columnDefinition = "INT SIGNED NOT NULL")
	@NotNull
	private int esquive;
	
	@Column(name = "ITE_VIT", columnDefinition = "INT SIGNED NOT NULL")
	@NotNull
	private int vitesse;
	
	
	public int getAttaque() {
		return attaque;
	}
	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getEsquive() {
		return esquive;
	}
	public void setEsquive(int esquive) {
		this.esquive = esquive;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Capacite getCapacite() {
		return capacite;
	}
	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}

 
}