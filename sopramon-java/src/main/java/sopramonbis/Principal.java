package sopramonbis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import sopramon.dao.IDAOCombat;
import sopramon.dao.IDAOCombatSQL;
import sopramon.dao.IDAOSopramon;
import sopramon.dao.IDAOSopramonSQL;
import sopramonbis.model.Combat;
import sopramonbis.model.Signe;
import sopramonbis.model.Sopramon;
import sopramonbis.model.Type;
import sopramonbis.model.Utilisateur;

public class Principal {

	public static void main(String[] args) {
		choix();

	}

	static void choix() {

		int q = 0;
		while (q < 1 || q > 4) {

			System.out.println("--------------------------");
			System.out.println("           MENU           ");
			System.out.println("--------------------------");

			System.out.println("1. Créer un Sopramon");
			System.out.println("2. Lister tous les Sopramon");
			System.out.println("3. Trouver un Sopramon");
			System.out.println("4. Lancer un combat Sopra vs Boss");
			System.out.println("--------------------------");

			System.out.println("   Choisir un programme :");
			q = lireEntier();
			System.out.println("                     ");

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
		}
	}

	static void findAll() {

		IDAOSopramon daoSopramon = new IDAOSopramonSQL();

		for (Sopramon s : daoSopramon.findAll()) {

			System.out.println("Identifiant : " + s.getId());
			System.out.println(s.getNom());
			System.out.println(s.getDateNaissance());
			System.out.println("Expérience : " + s.getExperience());
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

		IDAOSopramon daoSopramon = new IDAOSopramonSQL();

		int q = 0;
		System.out.println("Choisir un identifiant  :");
		q = lireEntier();

		System.out.println("                     ");
		Sopramon s = daoSopramon.findById(q);

		if (q < 1 || q > 11) {
			System.out.println("Votre Sopramon n'existe pas");
		} else {
			System.out.println("Identifiant : " + s.getId());
			System.out.println(s.getNom());
			System.out.println(s.getDateNaissance());
			System.out.println("Expérience : " + s.getExperience());
			System.out.println("Niveau : " + s.getNiveau());
			System.out.println("Thunes : " + s.getArgent());

		}

	}
	static void combat() {
		
		IDAOCombat daoCombat = new IDAOCombatSQL();

		Combat nouveauCombat = new Combat();
		
		try {
			
			System.out.println("Saisir l'id d'un sopramon (entre 1 et 10) :");
			
			Sopramon nouveauSopramon = new Sopramon();
			int a = lireEntier();
			nouveauSopramon.setId(a);
			nouveauCombat.setSopramon(nouveauSopramon);
			
			}
			catch (Exception z) {
				z.printStackTrace();
			}
		
		
		
		
		daoCombat.save(nouveauCombat);
		
	}	
	static void save() {
	
		
		Utilisateur nouveauUtilisateur = new Utilisateur();
		
		System.out.println("Choisir un nom d'utilisateur :");
		String a = lireChaine();
		nouveauUtilisateur.setNom(a);
		
		System.out.println("Choisir un prénom d'utilisateur :");
		String b = lireChaine();
		nouveauUtilisateur.setPrenom(b);
		
		System.out.println("Choisir un username :");
		String c = lireChaine();
		nouveauUtilisateur.setUsername(c);
		
		
		System.out.println("Choisir un password:");
		String d = lireChaine();
		nouveauUtilisateur.setPassword(d);
		
		
		try {
		
			
		Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramon", "root", "");
		PreparedStatement myStatement = myConnection.prepareStatement("INSERT INTO utilisateur(UT_NOM, UT_PRENOM, UT_USERNAME, UT_PASSWORD)"
						+ " VALUES ('"+ a +"','"+ b +"','"+ c +"','"+ d +"')");
	
		myStatement.execute();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		IDAOSopramon daoSopramon = new IDAOSopramonSQL();

		Sopramon nouveauSopramon = new Sopramon();

		System.out.println("Choisir un nom de Sopramon :");
		String e = lireChaine();
		nouveauSopramon.setNom(e);
		
		System.out.println("Rentrez votre date de naissance");
		
		try {
		String j = lireChaine();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formatter.parse(j);
		nouveauSopramon.setDateNaissance(date);
		
		}
		catch (Exception z) {
			z.printStackTrace();
		}
		
		Signe nouveauSigne = new Signe();
		
		System.out.println("Choisir un signe astro: LION 1 ; BELIER 2 ; SAGITTAIRE 3 ; TAUREAU 4 ; VIERGE 5 ; CAPRICORNE 6 ; GEMEAUX 7 ; BALANCE 8 ; VERSEAU 9 ; POISSONS 10 ; SCORPION 11 ; CANCER 12");
		int f = 0;
		f = lireEntier();
		nouveauSigne.setId(f);
		nouveauSopramon.setSigne(nouveauSigne);
		
		Type nouveauType = new Type();
		nouveauSopramon.setType(nouveauType);
		
			if (f < 4) {
				nouveauSopramon.getType().setId(1);
			}
			else if (f == 4 ){
				nouveauSopramon.getType().setId(2);
			}
			else if (f == 5 ){
				nouveauSopramon.getType().setId(2);
			}
			else if (f == 6 ){
				nouveauSopramon.getType().setId(2);
			}
			
			else if (f == 7) {
				nouveauSopramon.getType().setId(3);
			}
			else if (f == 8) {
				nouveauSopramon.getType().setId(3);
			}
			else if (f == 9) {
				nouveauSopramon.getType().setId(3);
			}
			else if (f > 9) {
				nouveauSopramon.getType().setId(4);
			}
			
		daoSopramon.save(nouveauSopramon);
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
			return myScanner.next();
		}

		catch (Exception ex) {
			return null;
		}
	}
	

}