package sopramonbis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity

public class Capacite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAP_ID")
	private int id;
	
	@Column(name = "CAP_POINTVIE", columnDefinition = "INT NOT NULL")
	@NotNull
	private int pointDeVie;
	
	@Column(name = "CAP_ATTAQUE", columnDefinition = "INT NOT NULL")
	@NotNull
	private int attaque;
	
	@Column(name = "CAP_DEFENSE", columnDefinition = "INT NOT NULL")
	@NotNull
	private int defense;
	
	@Column(name = "CAP_ESQUIVE", columnDefinition = "INT NOT NULL")
	@NotNull
	private int esquive;
	
	@Column(name = "CAP_VITESSE", columnDefinition = "INT NOT NULL")
	@NotNull
	private int vitesse;
	
	@OneToMany(mappedBy = "capacite")
	private List<Item> items;
	
	


	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPointDeVie() {
		return pointDeVie;
	}
	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}
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
	
}