package sopramonbis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.Query;

import sopramonbis.dao.IDAOCombat;
import sopramonbis.dao.IDAOItem;
import sopramonbis.dao.IDAOSopramon;
import sopramonbis.hibernate.DAOCombatHibernate;
import sopramonbis.hibernate.DAOHibernate;
import sopramonbis.hibernate.DAOItemHibernate;
import sopramonbis.hibernate.DAOSopramonHibernate;
import sopramonbis.model.Arene;
import sopramonbis.model.Boss;
import sopramonbis.model.Capacite;
import sopramonbis.model.Combat;
import sopramonbis.model.Item;
import sopramonbis.model.Signe;
import sopramonbis.model.Sopramon;
import sopramonbis.model.Type;
import sopramonbis.model.Utilisateur;

public class Affichage {

	public static void main(String[] args) {

		choix();

	}

	static void choix() {

		System.out.println("°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°");
		System.out.println("          BIENVENUE A SOPRAGAMING         ");
		System.out.println("°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°");

		System.out.println("   --> Se connecter \nSaisir l'identifiant utilisateur : ");
		String u = lireChaine();
		System.out.println("Saisir le mot de passe : ");
		String y = lireChaine();

		IDAOSopramon daoSopramon = new DAOSopramonHibernate();

		boolean erreur = true;
		while (erreur) {
			try {
				Sopramon s = daoSopramon.findBySopramon(u, y);
				System.out.println("Vous etes bien connecte avec votre Sopramon :" + s.getNom());
				menu();
			} catch (Exception e) {
				erreur = false;
				System.err.println("==== > Identifiants et/ou mots de passe errone(s) <==== ");
				choix();
			}
		}
	}

	static void menu() {

		int q = 0;
		while (q < 1 || q > 7) {

			System.out.println("--------------->>  <<--------------");
			System.out.println("                MENU              ");
			System.out.println("--------------->>  <<--------------");

			System.out.println("1. S'inscrire et creer un Sopramon");
			System.out.println("2. Lister tous les Sopramon");
			System.out.println("3. Trouver un Sopramon avec son ID");
			System.out.println("4. Lancer un combat Sopra vs Boss");
			System.out.println("5. Ajouter un item");
			System.out.println("6. Lister les item \n");

			System.out.println("   --> Choisir un programme :");
			q = lireEntier();

			if (q == 1) {
				save();

			} else if (q == 2) {
				findAll();

			}

			else if (q == 3) {
				findById();

			}

			else if (q == 4) {
				combat();
			}

			else if (q == 5) {
				creerItem();
			}

			else if (q == 6) {
				listerItem();
			}
		}
	}

	static void findAll() {

		IDAOSopramon daoSopramon = new DAOSopramonHibernate();

		for (Sopramon s : daoSopramon.findAll()) {

			System.out.println("Identifiant : " + s.getId());
			System.out.println(s.getNom());
			System.out.println(s.getDateNaissance());
			System.out.println("Experience : " + s.getExperience());
			System.out.println("Niveau : " + s.getNiveau());
			System.out.println("Thunes : " + s.getArgent());
			System.out.println("Points de vie : " + s.getCapacite().getPointDeVie());
			System.out.println("Attaque : " + s.getCapacite().getAttaque());
			System.out.println("Defense : " + s.getCapacite().getDefense());
			System.out.println("Esquive : " + s.getCapacite().getEsquive());
			System.out.println("Vitesse : " + s.getCapacite().getVitesse());
			System.out.println("Type : " + s.getType().getNom());
			System.out.println("Signe : " + s.getSigne().getNom());
			System.out.println("--------------------------");
		}
	}

	static void findById() {

		IDAOSopramon daoSopramon = new DAOSopramonHibernate();

		int q = 0;
		System.out.println("Choisir un identifiant  :\n");
		q = lireEntier();

		Sopramon s = daoSopramon.findById(q);

		if (q < 1 || q > 11) {
			System.out.println("Votre Sopramon n'existe pas");
		} else {
			System.out.println("Identifiant : " + s.getId());
			System.out.println(s.getNom());
			System.out.println(s.getDateNaissance());
			System.out.println("Experience : " + s.getExperience());
			System.out.println("Niveau : " + s.getNiveau());
			System.out.println("Thunes : " + s.getArgent());

		}

	}

	static void combat() {

		IDAOCombat daoCombat = new DAOCombatHibernate();

		Combat nouveauCombat = new Combat();

		try {

			System.out.println("Saisir l'id d'un sopramon (entre 1 et 10) :");

			Sopramon nouveauSopramon = new Sopramon();
			int a = lireEntier();
			nouveauSopramon.setId(a);
			nouveauCombat.setSopramon(nouveauSopramon);
			nouveauCombat.setArene(Arene.Donjon);

			Boss nouveauBoss = new Boss();
			Type nouveauType = new Type();
			nouveauCombat.setBoss(nouveauBoss);
			nouveauCombat.getBoss().setId(1);
			nouveauCombat.setDateCombat(new Date());
			nouveauCombat.setType(nouveauType);
			nouveauCombat.getType().setId(4);

		} catch (Exception z) {
			z.printStackTrace();
		}

		daoCombat.save(nouveauCombat);

	}

	static void save() {

		IDAOSopramon daoSopramon = new DAOSopramonHibernate();
		Sopramon nouveauSopramon = new Sopramon();
		Utilisateur nouveauUtilisateur = new Utilisateur();

		System.out.println("Choisir un nom d'utilisateur :");
		String a = lireChaine();
		nouveauUtilisateur.setNom(a);

		System.out.println("Choisir un prenom d'utilisateur :");
		String b = lireChaine();
		nouveauUtilisateur.setPrenom(b);

		System.out.println("Choisir un username :");
		String c = lireChaine();
		nouveauUtilisateur.setUsername(c);

		System.out.println("Choisir un password:");
		String d = lireChaine();
		nouveauUtilisateur.setPassword(d);

		System.out.println("Choisir un nom de Sopramon :");
		String e = lireChaine();
		nouveauSopramon.setNom(e);

		System.out.println("Rentrez votre date de naissance");

		try {
			String j = lireChaine();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatter.parse(j);
			nouveauSopramon.setDateNaissance(date);

		} catch (Exception z) {
			z.printStackTrace();
		}

		Signe nouveauSigne = new Signe();

		System.out.println(
				"Choisir un signe astro: LION 1 ; BELIER 2 ; SAGITTAIRE 3 ; TAUREAU 4 ; VIERGE 5 ; CAPRICORNE 6 ; GEMEAUX 7 ; BALANCE 8 ; VERSEAU 9 ; POISSONS 10 ; SCORPION 11 ; CANCER 12");
		int f = 0;
		f = lireEntier();
		nouveauSigne.setId(f);
		nouveauSopramon.setSigne(nouveauSigne);

		Type nouveauType = new Type();
		nouveauSopramon.setType(nouveauType);

		if (f < 4) {
			nouveauSopramon.getType().setId(1);
		} else if (f == 4) {
			nouveauSopramon.getType().setId(2);
		} else if (f == 5) {
			nouveauSopramon.getType().setId(2);
		} else if (f == 6) {
			nouveauSopramon.getType().setId(2);
		} else if (f == 7) {
			nouveauSopramon.getType().setId(3);
		} else if (f == 8) {
			nouveauSopramon.getType().setId(3);
		} else if (f == 9) {
			nouveauSopramon.getType().setId(3);
		} else if (f > 9) {
			nouveauSopramon.getType().setId(4);
		}

		Capacite macapacite = new Capacite();
		macapacite.setAttaque(50);
		macapacite.setDefense(50);
		macapacite.setEsquive(50);
		macapacite.setPointDeVie(50);
		macapacite.setVitesse(50);

		nouveauSopramon.setArgent(100.0);
		nouveauSopramon.setCapacite(macapacite);
		nouveauSopramon.setUtilisateur(nouveauUtilisateur);
		daoSopramon.save(nouveauSopramon);

	}

	static void creerItem() {

		IDAOItem daoItem = new DAOItemHibernate();
		Item nouveauItem = new Item();

		System.out.println("Nom de l'item :");
		String a = lireChaine();
		nouveauItem.setNom(a);

		System.out.println("Prix de l'item :");
		int b = lireEntier();
		nouveauItem.setPrix(b);

		System.out.println("Description de l'item :");
		String c = lireChaine();
		nouveauItem.setDescription(c);

		System.out.println("Caracteristique d'attaque :");
		int d = lireEntier();
		nouveauItem.setAttaque(d);

		System.out.println("Caracteristique de defense :");
		int e = lireEntier();
		nouveauItem.setDefense(e);

		System.out.println("Caracteristique de vitesse :");
		int f = lireEntier();
		nouveauItem.setVitesse(f);

		System.out.println("Caracteristique d'esquive :");
		int g = lireEntier();
		nouveauItem.setEsquive(g);

		daoItem.save(nouveauItem);

		System.out.println("Nom : " + a);
		System.out.println("Prix : " + b);
		System.out.println("Description : " + c);
		System.out.println("Attaque : " + d);
		System.out.println("Defense : " + e);
		System.out.println("Vitesse : " + f);
		System.out.println("Esquive : " + g);

	}

	static void listerItem() {

		int q = 0;

		do {
			IDAOItem daoItem = new DAOItemHibernate();
			System.out.println("Liste des item :");
			System.out.println("0 - Retour");
			for (Item i : daoItem.findAll()) {
				System.out.println(i.getId() + " - " + i.getNom());
			}

			System.out.println("Choisir un item :");
			q = lireEntier();
			Item j = daoItem.findById(q);

			if (j != null) {
				System.out.println("Nom : " + j.getNom());
				System.out.println("Prix : " + j.getPrix());
				System.out.println("Description : " + j.getDescription());
				System.out.println("Attaque : " + j.getAttaque());
				System.out.println("Defense : " + j.getDefense());
				System.out.println("Vitesse : " + j.getVitesse());
				System.out.println("Esquive : " + j.getEsquive());
			}
		} while (q != 0);

		choix();
	}

	static int lireEntier() {
		Scanner myScanner = new Scanner(System.in);

		try {
			return myScanner.nextInt();
		}

		catch (Exception ex) {
			return 0;
		}
	}

	static String lireChaine() {
		Scanner myScanner = new Scanner(System.in);

		try {
			return myScanner.nextLine();
		}

		catch (Exception ex) {
			return null;
		}
	}

}