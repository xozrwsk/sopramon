package sopramon.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import sopramonbis.model.Combat;

public class IDAOCombatSQL extends IDAOSQL implements IDAOCombat {

	public List<Combat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Combat findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

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

	public void delete(Combat entity) {
		// TODO Auto-generated method stub

	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

}
