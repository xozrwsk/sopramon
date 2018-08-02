package sopramonbis.model;


public enum Arene {

	Versus(1),
	Donjon(2);
	
	
	private int valeur = 0;
	Arene(int valeur) {
	this.valeur = valeur;
	}
	public int getValeur() {
	return this.valeur;
	}
	
	

}
