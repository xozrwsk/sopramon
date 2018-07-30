package sopramonbis.model;

import java.util.Date;

public class Achat {
		
		private int id;
		private Date date;
		private Double prix;
		private Sopramon Sopramon;
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
