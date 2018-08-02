package sopramonbis.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="coup")
public class Coup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COU_ID", columnDefinition="INT NOT NULL")
	@NotNull	
	private int id;
	
	@Column(name = "COU_DATE", columnDefinition="INT NOT NULL")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "COU_DEGATS", columnDefinition="INT")
	private int degats;
	
	@Column(name = "COU_PERSISTANCE", columnDefinition="INT")
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
