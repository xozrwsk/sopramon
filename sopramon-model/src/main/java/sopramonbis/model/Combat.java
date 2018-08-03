package sopramonbis.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class Combat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COM_ID")
	private int id;

	@Column(name = "COM_DATE", columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
	@NotNull
	private Date dateCombat;

	@Enumerated
	@Column(name = "COM_ARENE")
	private Arene arene;

	@ManyToOne
	@JoinColumn(name = "COM_TYPE")
	private Type type;

	@Column(name = "COM_TOURS", columnDefinition = "INT NOT NULL DEFAULT 0")
	@NotNull
	private int tours;

	@ManyToOne
	@JoinColumn(name = "COM_SOPRAMON_ID")
	private Sopramon sopramon;

	@ManyToOne
	@JoinColumn(name = "COM_BOSS_ID")
	private Boss boss;

	@OneToMany(mappedBy = "combat")
	private List<Coup> coups;

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

	public List<Coup> getCoups() {
		return coups;
	}

	public void setCoups(List<Coup> coups) {
		this.coups = coups;
	}

	public void setTours(int tours) {
		this.tours = tours;
	}

	public Sopramon getSopramon() {
		return sopramon;
	}

	public void setSopramon(Sopramon sopramon) {
		this.sopramon = sopramon;
	}

	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	

}