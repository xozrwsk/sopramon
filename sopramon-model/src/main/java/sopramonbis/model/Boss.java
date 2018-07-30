package sopramonbis.model;

public class Boss {
	
	private int id;
	private String nom;
	private Type type;
	private int niveau;
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
