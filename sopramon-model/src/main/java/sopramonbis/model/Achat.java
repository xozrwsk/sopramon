package sopramonbis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="achat")
public class Achat {
		
	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ACH_ID", columnDefinition="INT NOT NULL")
		@NotNull
		private int id;
	
		@Column(name = "ACH_DATE", columnDefinition="INT NOT NULL")
		@NotNull
		@Temporal(TemporalType.DATE)
		private Date date;
		
		
		@Column(name = "ACH_PRIX",  columnDefinition="DOUBLE NOT NULL")
		@NotNull
		private Double prix;
		
		
		@ManyToOne
		@JoinColumn(name="ACH_SOP_ID")
		private Sopramon Sopramon;
		
		@ManyToOne
		@JoinColumn(name="ACH_ITEM_ID")
		private Item Item;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getDate() {
			return date;
		}
		public Sopramon getSopramon() {
			return Sopramon;
		}
		public void setSopramon(Sopramon sopramon) {
			Sopramon = sopramon;
		}
		public Item getItem() {
			return Item;
		}
		public void setItem(Item item) {
			Item = item;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Double getPrix() {
			return prix;
		}
		public void setPrix(Double prix) {
			this.prix = prix;
		}
	
	

}
