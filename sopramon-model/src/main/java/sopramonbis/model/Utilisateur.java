package sopramonbis.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Utilisateur {
	
	@Id
	@Column(name = "UT_ID", columnDefinition = "INT NOT NULL AUTO_INCREMENT")
	@NotNull
	private int id;
	
	@Column(name = "UT_NOM", columnDefinition = "VARCHAR(100) NOT NULL")
	@NotEmpty
	@Size(max = 100)
	private String nom;
	
	@Column(name = "UT_PRENOM", columnDefinition = "VARCHAR(100) NOT NULL")
	@NotEmpty
	@Size(max = 100)
	private String prenom;
	
	@Column(name = "UT_USERNAME", columnDefinition = "VARCHAR(100) NOT NULL")
	@NotEmpty
	@Size(max = 100)
	private String username;
	
	@Column(name = "UT_PASSWORD", columnDefinition = "VARCHAR(100) NOT NULL")
	@NotEmpty
	@Size(max = 100)
	private String password;
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}