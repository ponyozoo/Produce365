package produce365.debut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; // driver 종류
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // DB의 위치
	private static final String USERNAME = "minjeong";
	private static final String PASSWORD = "a1234";
	
	//커넥션을 리턴하는 메소드 -> 커넥션만 생성해서 리턴하는 메소드.
	public static Connection getDataSource() {
		Connection connection = null;
		try {
		Class.forName(DRIVER); //
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);  
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
