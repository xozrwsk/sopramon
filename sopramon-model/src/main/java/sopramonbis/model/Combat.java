package sopramonbis.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

public class Combat {

	@Id
	@Column(name = "COM_ID", columnDefinition = "INT NOT NULL AUTO_INCREMENT")
	@NotNull
	private int id;

	@Column(name = "COM_DATE", columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
	@NotNull
	private Date dateCombat;

	@ManyToOne
	@JoinColumn(name = "COM_ARENE")
	private Arene arene;

	@JoinColumn(name = "COM_SOPRAMON_ID", columnDefinition = "INT NOT NULL DEFAULT 0")
	private Type type;

	@Column(name = "COM_TOURS", columnDefinition = "INT NOT NULL DEFAULT 0")
	@NotNull
	private int tours;

	@ManyToOne
	@JoinColumn(name = "COM_SOPRAMON_ID")
	private Sopramon Sopramon;

	@ManyToOne
	@JoinColumn(name = "COM_BOSS_ID")
	private Boss Boss;

	@OneToMany(mappedBy = "combat")
	private List<Coup> coup;

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

}