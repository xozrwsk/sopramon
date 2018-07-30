package sopramonbis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import sopramonbis.model.Combat;
import sopramonbis.model.Sopramon;

public class IDAOCombatSQL extends IDAOSQL implements IDAOCombat {


	
	
	@Override
	public List<Combat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Combat findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Combat save(Combat entity) {
		// TODO Auto-generated method stub
		
PreparedStatement myStatement = null;
		
		try {
			
			myStatement = this.getConnection().prepareStatement(
					"INSERT INTO combat(COM_ARENE, COM_TYPE, COM_TOURS, COM_SOPRAMON_ID, COM_BOSS_ID) "
					+ "VALUES (2,4,0,?,1)");
						
						
			myStatement.setInt(1, entity.getSopramon().getId());
			
			myStatement.execute();			
			
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

				
		
		return null;
	}

	@Override
	public void delete(Combat entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}
