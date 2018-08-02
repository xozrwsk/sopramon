package sopramonbis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity

public class Capacite {
	
	@Id
	@Column(name = "CAP_ID", columnDefinition = "INT NOT NULL AUTO_INCREMENT")
	@NotNull
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
	
	@ManyToOne
	@JoinColumn(name = "CAP_ITEM_ID")
	private Item Item;
	
	
	
	public Item getItem() {
		return Item;
	}
	public void setItem(Item item) {
		Item = item;
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