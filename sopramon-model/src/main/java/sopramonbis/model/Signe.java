package sopramonbis.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Signe {
	
	@Id
	@Column(name = "SIG_ID", columnDefinition = "INT NOT NULL AUTO_INCREMENT")
	@NotNull
	private int id;
	
	@Column(name = "SIG_NOM", columnDefinition = "VARCHAR(100) NOT NULL")
	@NotEmpty
	@Size(max = 100)
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "CAP_ITEM_ID")
	private Type type;
	
	
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	
	
}
