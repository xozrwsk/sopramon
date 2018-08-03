package sopramonbis.dao;

import sopramonbis.model.Sopramon;

public interface IDAOSopramon extends IDAO <Sopramon>{
	
	public Sopramon findBySopramon(String username, String password);

}
