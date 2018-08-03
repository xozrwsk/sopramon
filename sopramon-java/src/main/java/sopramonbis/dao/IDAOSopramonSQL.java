package sopramonbis.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sopramonbis.model.Capacite;
import sopramonbis.model.Signe;
import sopramonbis.model.Sopramon;
import sopramonbis.model.Type;
import sopramonbis.model.Utilisateur;

public class IDAOSopramonSQL extends IDAOSQL implements IDAOSopramon {

	@Override
	public List<Sopramon> findAll() {

		try {
			Statement myStatement = this.getConnection().createStatement();
			ResultSet myResult = myStatement
					.executeQuery("SELECT * FROM sopramon " + "LEFT JOIN capacite ON SOP_CAPACITE_ID = CAP_ID "
							+ "LEFT JOIN type ON SOP_TYPE_ID = TYP_ID " + "LEFT JOIN signe ON SOP_SIGNE_ID = SIG_ID");

			List<Sopramon> mesSopramon = new ArrayList<Sopramon>();

			while (myResult.next()) {

				Capacite myCapacite = new Capacite();

				myCapacite.setId(myResult.getInt("CAP_ID"));
				myCapacite.setPointDeVie(myResult.getInt("CAP_POINTVIE"));
				myCapacite.setAttaque(myResult.getInt("CAP_ATTAQUE"));
				myCapacite.setDefense(myResult.getInt("CAP_DEFENSE"));
				myCapacite.setEsquive(myResult.getInt("CAP_ESQUIVE"));
				myCapacite.setVitesse(myResult.getInt("CAP_VITESSE"));


				Type myType = new Type();

				myType.setId(myResult.getInt("TYP_ID"));
				myType.setNom(myResult.getString("TYP_NOM"));


				Signe mySigne = new Signe();

				mySigne.setId(myResult.getInt("SIG_ID"));
				mySigne.setNom(myResult.getString("SIG_NOM"));

//				mesSignes.add(mySigne);	

				Sopramon monSopramon = new Sopramon();

				monSopramon.setId(myResult.getInt("SOP_ID"));
				monSopramon.setNom(myResult.getString("SOP_NOM"));
				monSopramon.setDateNaissance(myResult.getDate("SOP_DATENAIS"));
				monSopramon.setExperience(myResult.getInt("SOP_EXPERIENCE"));
				monSopramon.setNiveau(myResult.getInt("SOP_NIVEAU"));
				monSopramon.setArgent(myResult.getDouble("SOP_ARGENT"));
				monSopramon.setCapacite(myCapacite);
				monSopramon.setSigne(mySigne);
				monSopramon.setType(myType);

				mesSopramon.add(monSopramon);

			}
			return mesSopramon;

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Sopramon findById(int id) {

		try {

			Statement myStatement = this.getConnection().createStatement();
			ResultSet myResult = myStatement.executeQuery("SELECT * FROM sopramon where SOP_ID = " + id); 
			
			
			if (myResult.next()) {
				Sopramon monSopramon = new Sopramon();

				monSopramon.setId(myResult.getInt("SOP_ID"));
				monSopramon.setNom(myResult.getString("SOP_NOM"));
				monSopramon.setDateNaissance(myResult.getDate("SOP_DATENAIS"));
				monSopramon.setExperience(myResult.getInt("SOP_EXPERIENCE"));
				monSopramon.setNiveau(myResult.getInt("SOP_NIVEAU"));
				monSopramon.setArgent(myResult.getDouble("SOP_ARGENT"));
			
				return monSopramon;
			}
		
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Sopramon save(Sopramon entity) {
		
			
		try {
			
			PreparedStatement myStatement = null;
			
	
			
			myStatement = this.getConnection().prepareStatement(
					"INSERT INTO capacite(CAP_POINTVIE, CAP_ATTAQUE, CAP_DEFENSE, CAP_ESQUIVE, CAP_VITESSE)"
							+ " VALUES (50,50,50,50,50)");
			myStatement.execute();
			
			Statement myStatement2 = this.getConnection().createStatement();
			ResultSet myResult = myStatement2.executeQuery("SELECT MAX(CAP_ID) AS max_cap FROM capacite");
			myResult.next();
			int max_cap = myResult.getInt(1);
			
			Statement myStatement3 = this.getConnection().createStatement();
			ResultSet myResult2 = myStatement3.executeQuery("SELECT MAX(UT_ID) AS max_utid FROM utilisateur");
			myResult2.next();
			int max_utid = myResult2.getInt(1);
			
			
						
			
			myStatement = this.getConnection().prepareStatement(
					"INSERT INTO sopramon(SOP_NOM, SOP_DATENAIS, SOP_EXPERIENCE, SOP_NIVEAU, SOP_CAPACITE_ID, SOP_UT_ID , SOP_ARGENT, SOP_SIGNE_ID, SOP_TYPE_ID)"
							+ " VALUES (?,?,0,1,"+ max_cap +","+ max_utid +",100,?,?)");

			SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
			String dateInString = formatter.format(entity.getDateNaissance());
			
			myStatement.setString(1, entity.getNom());
			myStatement.setString(2, dateInString);
			myStatement.setInt(3, entity.getSigne().getId());
			myStatement.setInt(4, entity.getType().getId());

				
			myStatement.execute();
		}
		

		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	
	}

	@Override
	public void delete(Sopramon entity) {
		// TODO Auto-generated method stub ==> option

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub ==> option

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

	@Override
	public Sopramon findBySopramon(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
