package produce365.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCAccountDAO {
	public Account selectById(String id) {
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatment = connection.prepareStatement("SELECT * FROM ACCOUNT WHERE ID = ?")) {

			pStatment.setString(1, id);
			ResultSet rs = pStatment.executeQuery();

			if (rs.next())
				return new Account(rs.getString("ID"), rs.getString("PW"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
