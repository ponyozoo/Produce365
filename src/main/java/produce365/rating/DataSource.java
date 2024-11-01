package produce365.rating;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource  {

		private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
		private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		private static final String USERNAME = "produce365";
		private static final String PASSWORD = "a1234";

		public static Connection getDataSource() {
			
			Connection connection = null;
			
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (ClassNotFoundException e) {

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return connection;

		}
		
//		public static void main(String[] args) throws SQLException{
//			
//			Connection connection = DataSource.getDataSource();
//			System.out.println(connection);
//			connection.close();
//			
//		}

	}
