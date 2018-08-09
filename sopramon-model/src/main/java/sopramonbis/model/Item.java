package sopramonbis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITE_ID")
	private int id;
	
	@Column(name = "ITE_NOM", columnDefinition = "VARCHAR(100) NOT NULL")
	@NotEmpty
	@Size(max = 100)
	private String nom;
	
	@Column(name = "ITE_PRIX", columnDefinition = "DOUBLE NOT NULL")
	@NotNull
	private int prix;
	
	
	@Column(name = "ITE_DESCRIPTION",  columnDefinition = "VARCHAR(300) NOT NULL")
	@NotEmpty
	@Size(max = 300)
	private String description;
	
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
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

	

 
}