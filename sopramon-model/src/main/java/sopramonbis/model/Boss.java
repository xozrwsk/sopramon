package sopramonbis.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="boss")
public class Boss {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOSS_ID", columnDefinition="INT NOT NULL")
	@NotNull
	private int id;
	
	@Column(name = "BOSS_NOM",  columnDefinition="VARCHAR(100) NOT NULL")
	@NotEmpty
	@Size(max=100)
	private String nom;
	
	@OneToOne
	@JoinColumn(name = "BOSS_TYPE_ID")
	private Type type;
	
	
	@Column(name = "BOSS_NIVEAU",  columnDefinition="INT NOT NULL")
	@NotNull
	private int niveau;
	
	
	@OneToOne
	@JoinColumn(name = "BOSS_CAPACITE_ID")
	private Capacite capacite;
		
	
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
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public Capacite getCapacite() {
		return capacite;
	}
	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}
	
}
