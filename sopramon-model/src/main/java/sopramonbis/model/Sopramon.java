package sopramonbis.model;


import java.util.Date;

public class Sopramon {
	private int id;
	private String nom;
	private Date dateNaissance;
	private int experience;
	private int niveau;
	private Double argent;
	private Capacite capacite;
	private Signe Signe;
	private Utilisateur Utilisateur;
	private Type Type;
	
	
	
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public int getId() {
		return id;
	}
	public Type getType() {
		return Type;
	}
	public void setType(Type type) {
		Type = type;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Utilisateur getUtilisateur() {
		return Utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		Utilisateur = utilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public Double getArgent() {
		return argent;
	}
	public void setArgent(Double argent) {
		this.argent = argent;
	}
	public Capacite getCapacite() {
		return capacite;
	}
	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}
	public Signe getSigne() {
		return Signe;
	}
	public void setSigne(Signe signe) {
		Signe = signe;
	}
	
	
	
}
	
	