package sopramonbis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import sopramon.dao.IDAOBoss;
import sopramon.dao.IDAOCombat;
import sopramon.dao.IDAOCoup;
import sopramon.dao.IDAOItem;
import sopramon.dao.IDAOSopramon;
import sopramonbis.model.Arene;
import sopramonbis.model.Boss;
import sopramonbis.model.Capacite;
import sopramonbis.model.Combat;
import sopramonbis.model.Coup;
import sopramonbis.model.Item;
import sopramonbis.model.Signe;
import sopramonbis.model.Sopramon;
import sopramonbis.model.Type;
import sopramonbis.model.Utilisateur;

public class Affichage {

	@Autowired
	private IDAOSopramon daoSopramon;
	@Autowired
	private IDAOBoss daoBoss;
	@Autowired
	private IDAOCombat daoCombat;
	@Autowired
	private IDAOItem daoItem;
	@Autowired
	private IDAOCoup daoCoup;

	public void run(String[] args) {

		choix();

	}

	public void choix() {

		System.out.println("°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°");
		System.out.println("           BIENVENUE A SOPRAGAMING         ");
		System.out.println("°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°~~°");

		System.out.println("   --> Se connecter \nSaisir l'identifiant utilisateur : ");
		String u = lireChaine();
		System.out.println("Saisir le mot de passe : ");
		String y = lireChaine();

		boolean erreur = true;
		while (erreur) {
			try {
				Sopramon s = daoSopramon.finBySopramon(u, y);
				System.out.println("Vous etes bien connecte avec votre Sopramon :" + s.getNom());
				menu();
			} catch (Exception e) {
				erreur = false;
				System.err.println("==== > Identifiants et/ou mots de passe errone(s) <==== ");
				choix();
			}
		}
	}

	public void menu() {

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
			System.out.println("6. Lister les item ");
			System.out.println("7. Modifier un item ");
			System.out.println("8. Supprimer un item ");

			System.out.println("   --> Choisir un programme :");
			q = lireEntier();

			if (q == 1) {
				save();
			} else if (q == 2) {
				findAll();
			} else if (q == 3) {
				findById();
			} else if (q == 4) {
				combat();
			} else if (q == 5) {
				creerItem();
			} else if (q == 6) {
				listerItem();
			} else if (q == 7) {
				modifierItem();
			} else if (q == 8) {
				supprimerItem();
			}

		}

	}

	public void findAll() {

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

	public void findById() {

		int q = 0;
		System.out.println("Choisir un identifiant  :\n");
		q = lireEntier();

		Optional<Sopramon> s = daoSopramon.findById(q);

		if (q < 1 || q > 11) {
			System.out.println("Votre Sopramon n'existe pas");
		} else {
			System.out.println("Identifiant : " + s.get().getId());
			System.out.println(s.get().getNom());
			System.out.println(s.get().getDateNaissance());
			System.out.println("Experience : " + s.get().getExperience());
			System.out.println("Niveau : " + s.get().getNiveau());
			System.out.println("Thunes : " + s.get().getArgent());

		}
	}

	public void combat() {

		Combat nouveauCombat = new Combat();
		Sopramon nouveauSopramon = new Sopramon();

		try {
			System.out.println("Saisir l'id d'un sopramon (entre 1 et 10) :");
			int a = lireEntier();
			nouveauSopramon.setId(a);
			nouveauCombat.setSopramon(nouveauSopramon);
			nouveauCombat.setArene(Arene.Donjon);
			Boss nouveauBoss = new Boss();
			Type nouveauType = new Type();
			nouveauCombat.setBoss(nouveauBoss);
			nouveauCombat.getBoss().setId(1);
			nouveauBoss.setId(1);
			nouveauCombat.setDateCombat(new Date());
			nouveauCombat.setType(nouveauType);
			nouveauCombat.getType().setId(4);

			daoCombat.save(nouveauCombat);

			Optional<Sopramon> s = daoSopramon.findById(a);
			System.out.println("Points de vie du Sopramon : " + s.get().getCapacite().getPointDeVie());
			int sopvie = s.get().getCapacite().getPointDeVie();

			Optional<Boss> b = daoBoss.findById(1);
			System.out.println("Points de vie du Boss : " + b.get().getCapacite().getPointDeVie());
			int bossvie = b.get().getCapacite().getPointDeVie();

			Random r = new Random();
			int n = r.nextInt(2);
			System.out.println(n);

			if (n == 1) {
				try {
					while (bossvie > 0 && sopvie > 0) {
						Coup nouveauCoup = new Coup();
						nouveauCoup.setSopramon(nouveauSopramon);
						nouveauCoup.setBoss(nouveauBoss);

						System.out.println("C'est : " + s.get().getNom() + " qui attaque");
						// tant que la vie du boss est > 0 : la vie du boss diminue de l'attaque du
						// Sopramon.
						// les points de vie du boss changent (-50pts)
						bossvie = b.get().getCapacite().getPointDeVie() - s.get().getCapacite().getAttaque();
						b.get().getCapacite().setPointDeVie(bossvie);
						System.out.println("Points de vie restants de : " + b.get().getNom() + " " + bossvie);

						int degats = s.get().getCapacite().getAttaque();
						nouveauCoup.setDegats(degats);
						nouveauCoup.getSopramon().setId(a);
						nouveauCoup.getSopramon().setId(1);
						nouveauCoup.setCombat(nouveauCombat);
						nouveauCoup.setDate(new Date());
						daoCoup.save(nouveauCoup);

						System.out.println("C'est : " + b.get().getNom() + " qui attaque");
						sopvie = s.get().getCapacite().getPointDeVie() - b.get().getCapacite().getAttaque();
						s.get().getCapacite().setPointDeVie(sopvie);
						System.out.println("Points de vie restants : " + s.get().getNom() + " " + sopvie);

						int degatb = s.get().getCapacite().getAttaque();
						nouveauCoup.setDegats(degatb);
						nouveauCoup.getSopramon().setId(a);
						nouveauCoup.getSopramon().setId(1);
						nouveauCoup.setCombat(nouveauCombat);
						nouveauCoup.setDate(new Date());
						daoCoup.save(nouveauCoup);
					}
				} catch (Exception z) {
					z.printStackTrace();
				}
			}

			else if (n == 0) {
				try {
					while (bossvie > 0 && sopvie > 0) {
						Coup nouveauCoup = new Coup();
						nouveauCoup.setSopramon(nouveauSopramon);
						nouveauCoup.setBoss(nouveauBoss);

						System.out.println("C'est : " + b.get().getNom() + " qui attaque");
						// tant que la vie du sopramon est > 0 : la vie du sopramon diminue de l'attaque
						// du Sopramon.
						// les points de vie du sopramon changent (-50pts)
						// on enregistre le coup.
						bossvie = s.get().getCapacite().getPointDeVie() - b.get().getCapacite().getAttaque();
						System.out.println("Points de vie restants : " + s.get().getNom() + " " + bossvie);
						s.get().getCapacite().setPointDeVie(bossvie);

						int degatb = b.get().getCapacite().getAttaque();
						nouveauCoup.setDegats(degatb);
						nouveauCoup.getSopramon().setId(a);
						nouveauCoup.getSopramon().setId(1);
						nouveauCoup.setCombat(nouveauCombat);
						nouveauCoup.setDate(new Date());
						daoCoup.save(nouveauCoup);

						System.out.println("C'est : " + s.get().getNom() + " qui attaque");
						sopvie = b.get().getCapacite().getPointDeVie() - s.get().getCapacite().getAttaque();
						b.get().getCapacite().setPointDeVie(sopvie);
						System.out.println("Points de vie restants de : " + b.get().getNom() + " " + sopvie);

						int degats = s.get().getCapacite().getAttaque();
						nouveauCoup.setDegats(degats);
						nouveauCoup.getSopramon().setId(a);
						nouveauCoup.getSopramon().setId(1);
						nouveauCoup.setCombat(nouveauCombat);
						nouveauCoup.setDate(new Date());
						daoCoup.save(nouveauCoup);
					}
				}

				catch (Exception z) {
					z.printStackTrace();
				}
			}
		}

		catch (

		Exception z) {
			z.printStackTrace();
		}

	}

	public void save() {

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

	public void creerItem() {

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

	public void modifierItem() {

		System.out.println("Choisir l'item a modifier :");

		List<Item> items = daoItem.findAll();
		Item item = null;

		for (int i = 0; i < items.size(); i++) {
			System.out.println("Item " + i + ": " + items.get(i).getNom());
		}

		int z = lireEntier();
		item = items.get(z);

		System.out.println("Modifier nom de l'item :");
		String a = lireChaine();
		item.setNom(a);

		System.out.println("Modifier prix de l'item :");
		int b = lireEntier();
		item.setPrix(b);

		System.out.println("Modifier description de l'item :");
		String c = lireChaine();
		item.setDescription(c);

		System.out.println("Modifier caracteristique d'attaque :");
		int d = lireEntier();
		item.setAttaque(d);

		System.out.println("Modifier caracteristique de defense :");
		int e = lireEntier();
		item.setDefense(e);

		System.out.println("Modifier caracteristique de vitesse :");
		int f = lireEntier();
		item.setVitesse(f);

		System.out.println("Modifier caracteristique d'esquive :");
		int g = lireEntier();
		item.setEsquive(g);

		daoItem.save(item);

		System.out.println("Nom : " + a);
		System.out.println("Prix : " + b);
		System.out.println("Description : " + c);
		System.out.println("Attaque : " + d);
		System.out.println("Defense : " + e);
		System.out.println("Vitesse : " + f);
		System.out.println("Esquive : " + g);

	}

	public void listerItem() {

		int q = 0;

		do {

			System.out.println("Liste des item :");
			System.out.println("0 - Retour");
			for (Item i : daoItem.findAll()) {
				System.out.println(i.getId() + " - " + i.getNom());
			}

			System.out.println("Choisir un item :");
			q = lireEntier();
			Optional<Item> j = daoItem.findById(q);

			if (j != null) {
				System.out.println("Nom : " + j.get().getNom());
				System.out.println("Prix : " + j.get().getPrix());
				System.out.println("Description : " + j.get().getDescription());
				System.out.println("Attaque : " + j.get().getAttaque());
				System.out.println("Defense : " + j.get().getDefense());
				System.out.println("Vitesse : " + j.get().getVitesse());
				System.out.println("Esquive : " + j.get().getEsquive());
			}
		} while (q != 0);

		choix();
	}

	public void supprimerItem() {

		System.out.println("Choisir l'item a supprimer :");

		List<Item> items = daoItem.findAll();
		Item item = null;

		for (int i = 0; i < items.size(); i++) {
			System.out.println("Item " + i + ": " + items.get(i).getNom());
		}

		int z = lireEntier();
		item = items.get(z);

		daoItem.delete(item);

	}

	public int lireEntier() {
		Scanner myScanner = new Scanner(System.in);

		try {
			return myScanner.nextInt();
		}

		catch (Exception ex) {
			return 0;
		}
	}

	public String lireChaine() {
		Scanner myScanner = new Scanner(System.in);

		try {
			return myScanner.nextLine();
		}

		catch (Exception ex) {
			return null;
		}
	}

}