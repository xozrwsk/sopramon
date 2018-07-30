package sopramonbis.model;


public class Item {
	
	
	private int id;
	private String nom;
	private Double prix;
	private Capacite capacite;
	private int attaque;
	private int defense;
	private int esquive;
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
