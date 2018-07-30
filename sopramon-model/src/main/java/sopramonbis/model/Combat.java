package sopramonbis.model;


import java.util.Date;

public class Combat {
 
private int id;	
private Date dateCombat;
 private Arene arene;
 private Type type;
 private int tours;
 private Sopramon Sopramon;
 private Boss Boss;
 private Coup Coup;
 
 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getDateCombat() {
	return dateCombat;
}
public void setDateCombat(Date dateCombat) {
	this.dateCombat = dateCombat;
}
public Arene getArene() {
	return arene;
}
public void setArene(Arene arene) {
	this.arene = arene;
}
public Type getType() {
	return type;
}
public void setType(Type type) {
	this.type = type;
}
public int getTours() {
	return tours;
}
public void setTours(int tours) {
	this.tours = tours;
}
public Sopramon getSopramon() {
	return Sopramon;
}
public void setSopramon(Sopramon sopramon) {
	Sopramon = sopramon;
}
public Boss getBoss() {
	return Boss;
}
public void setBoss(Boss boss) {
	Boss = boss;
}
public Coup getCoup() {
	return Coup;
}
public void setCoup(Coup coup) {
	Coup = coup;
}

}
 
