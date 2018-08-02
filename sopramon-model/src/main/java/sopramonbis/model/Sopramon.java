package sopramonbis.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class Sopramon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SOP_ID")
	private int id;

	@Column(name = "SOP_NOM", columnDefinition = "VARCHAR(100) NOT NULL")
	@NotEmpty
	@Size(max = 100)
	private String nom;

	@Column(name = "SOP_DATENAIS", columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
	@NotNull
	private Date dateNaissance;

	@Column(name = "SOP_EXPERIENCE", columnDefinition = "INT DEFAULT 0")
	@NotNull
	private int experience;

	@Column(name = "SOP_NIVEAU", columnDefinition = "INT DEFAULT 1")
	@NotNull
	private int niveau;

	@Column(name = "SOP_ARGENT", columnDefinition = "INT DEFAULT 100")
	@NotNull
	private Double argent;

	@OneToOne
	@JoinColumn(name = "SOP_CAPACITE_ID")
	private Capacite capacite;

	@ManyToOne
	@JoinColumn(name = "SOP_SIGNE_ID")
	private Signe Signe;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SOP_UT_ID")
	private Utilisateur Utilisateur;

	@ManyToOne
	@JoinColumn(name = "SOP_TYPE_ID")
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