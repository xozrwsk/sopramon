package sopramonbis.model;


import java.util.Date;

public class Coup {
	private int id;
 private Date date;
 private int degats;
 private int persistance;
 
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getDegats() {
	return degats;
}
public void setDegats(int degats) {
	this.degats = degats;
}
public int getPersistance() {
	return persistance;
}
public void setPersistance(int persistance) {
	this.persistance = persistance;
}
 
 
 
 
}
