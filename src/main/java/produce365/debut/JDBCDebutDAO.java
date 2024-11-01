package produce365.debut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import produce365.common.DataSource;

public class JDBCDebutDAO implements DebutDAO {

	@Override
	public boolean insert(Debut debut) {
		boolean result = false;

		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
				= connection.prepareStatement("INSERT INTO DEBUT (NAME, MEMBER_COUNT, CONCEPT, GRADE, DEBUT_DATE, PHOTO) VALUES (?, ?, ?, ?, ?, ?)")) {
			
			pStatement.setString(1, debut.getName());
			pStatement.setInt(2, debut.getMemberCount());
			pStatement.setString(3, debut.getConcept());
			pStatement.setString(4, debut.getGrade());
			pStatement.setDate(5,debut.getDebutDate());
			pStatement.setString(6, debut.getPhoto());
			
			int rows = pStatement.executeUpdate(); 
			if (rows > 0) {
				result = true;
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean update(Debut debut) {
		boolean result = false;
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
				= connection.prepareStatement("UPDATE DEBUT SET NAME = ?, MEMBER_COUNT = ?, CONCEPT = ?, GRADE = ?, DEBUT_DATE = ? WHERE ID = ?")
				) {
			
			pStatement.setString(1, debut.getName());
			pStatement.setInt(2, debut.getMemberCount());
			pStatement.setString(3, debut.getConcept());
			pStatement.setString(4, debut.getGrade());
			pStatement.setDate(5, debut.getDebutDate());
			pStatement.setInt(6, debut.getId());
			
			int rows = pStatement.executeUpdate();
			if(rows > 0) {
				result = true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean deleteById(int id) {
		boolean result = false;
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
				= connection.prepareStatement("DELETE FROM DEBUT WHERE ID = ?")) {
			
			pStatement.setInt(1, id);
			
			int rows = pStatement.executeUpdate();
			if(rows > 0) {
				result = true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Debut> findAll() {
		List<Debut> debuts = new ArrayList<Debut>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
				= connection.prepareStatement("SELECT * FROM DEBUT ORDER BY ID");
				ResultSet rs = pStatement.executeQuery()) {
		
			while(rs.next()) {
				Debut debut = new Debut(
						rs.getInt("ID"),
						rs.getString("NAME"),
						rs.getInt("MEMBER_COUNT"),
						rs.getString("CONCEPT"),
						rs.getString("GRADE"),
						rs.getDate("DEBUT_DATE"),
						rs.getString("PHOTO")
						);
									
				debuts.add(debut);
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return debuts;
	}

	@Override
	public Debut findById(int id) {
		Debut debut = null;
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
				= connection.prepareStatement("SELECT * FROM DEBUT WHERE ID = ?")) {
			
			pStatement.setInt(1, id);
			ResultSet rs = pStatement.executeQuery();
			
			if(rs.next()) {
				debut = new Debut();
				debut.setId(rs.getInt("ID"));
				debut.setName(rs.getString("NAME"));
				debut.setMemberCount(rs.getInt("MEMBER_COUNT"));
				debut.setConcept(rs.getString("CONCEPT"));
				debut.setGrade(rs.getString("GRADE"));
				debut.setDebutDate(rs.getDate("DEBUT_DATE"));
				debut.setPhoto(rs.getString("PHOTO"));
		
			}
			
		} catch (SQLException e) {
						
			e.printStackTrace();
		}
		return debut;
	}
	
	@Override
	public int getLastIdx() {
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
				= connection.prepareStatement("SELECT ID FROM DEBUT WHERE ROWNUM = 1 ORDER BY ID DESC");
				ResultSet rs = pStatement.executeQuery()) {

			if(rs.next())
				return rs.getInt("ID");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}

}
