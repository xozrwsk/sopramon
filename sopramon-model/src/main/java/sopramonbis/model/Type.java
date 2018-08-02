package sopramonbis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class Type {
	
	@Id
	@Column(name = "TYP_ID", columnDefinition = "INT NOT NULL AUTO_INCREMENT")
	@NotNull
	private int id;
	
	@Column(name = "TYP_NOM", columnDefinition = "VARCHAR(100) NOT NULL")
	@NotEmpty
	@Size(max = 100)
	private String nom;
	
	
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
	
	
}