package produce365.debutMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import produce365.debut.Debut;
import produce365.trainee.Trainee;

public class JDBCDebutMemberDAO implements DebutMemberDAO {

	@Override
	public boolean insert (DebutMember debutMember) {
		boolean result = false;
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
				= connection.prepareStatement("INSERT INTO DEBUT_MEMBER (GROUP_ID, TRAINEE_ID) VALUES (? , ?)")) {

			pStatement.setInt(1, debutMember.getGroup().getId());
			pStatement.setInt(2, debutMember.getTrainee().getId());

			int Rows = pStatement.executeUpdate();
			if (Rows > 0) {
			result = true; 
			}
			
			return result;
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}

	
	@Override
	public boolean delete(DebutMember debutMember) {
		boolean result = false;
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
				= connection.prepareStatement("DELETE FROM DEBUT_MEMBER WHERE GROUP_ID = ? AND TRAINEE_ID = ?")) {

			pStatement.setInt(1, debutMember.getGroup().getId());
			pStatement.setInt(2, debutMember.getTrainee().getId());

			int Rows = pStatement.executeUpdate();

			if (Rows > 0) {
				result = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<DebutMember> selectAll() {
		List<DebutMember> debutMembers = new ArrayList<DebutMember>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
				= connection.prepareStatement("SELECT IDX, ID, NAME, PHOTO "
						+ "FROM DEBUT_MEMBER M, TRAINEE T "
						+ "WHERE M.TRAINEE_ID = T.ID");	
				ResultSet rs = pStatement.executeQuery()) {
			
			while(rs.next()) {
				DebutMember debutMember = new DebutMember(rs.getInt("IDX"));
				Trainee trainee = new Trainee(rs.getInt("ID"));
				
				trainee.setName(rs.getString("NAME"));
				trainee.setPhoto(rs.getString("PHOTO"));
				debutMember.setTrainee(trainee);

				debutMembers.add(debutMember);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return debutMembers;
	}

	@Override
	public List<DebutMember> selectByGroup(int groupId) {
		List<DebutMember> debutMembers = new ArrayList<DebutMember>();

		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
				= connection.prepareStatement("SELECT IDX, GROUP_ID, ID, NAME FROM DEBUT_MEMBER D, TRAINEE T WHERE D.TRAINEE_ID = T.ID AND GROUP_ID = ? ORDER BY NAME")) {
			
			pStatement.setInt(1, groupId);
			ResultSet rs = pStatement.executeQuery();
			
			while(rs.next()) {
				DebutMember debutMember = new DebutMember();
				Debut debut = new Debut();
				Trainee trainee = new Trainee();
				
				debutMember.setIdx(rs.getInt("IDX"));
				
				debut.setId(rs.getInt("GROUP_ID"));
				debutMember.setGroup(debut);
				
				trainee.setId(rs.getInt("ID"));
				trainee.setName(rs.getString("NAME"));
				debutMember.setTrainee(trainee);
				
				debutMembers.add(debutMember);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return debutMembers;
	}

	

}
