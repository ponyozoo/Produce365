package produce365.care;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCCareDAO implements CareDAO{

	@Override
	public boolean insert(Care care) {
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(
				"INSERT INTO MEMBER (CATEGORY,COST) VALUES (?,?)")){
			
			pStatement.setInt(1, care.getId());
			pStatement.setString(2, care.getCategory());
			pStatement.setInt(3, care.getCost());
			
			int affectedRows = pStatement.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("success");
			} else {
				System.out.println("fail");
			}
		}   catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Care> findAll() {
		List<Care> cares = new ArrayList<Care>();
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(
				 "SELECT * FROM CARE");
				ResultSet rs = pStatement.executeQuery()) {
			
			while(rs.next()) {
				Care care = new Care(
						rs.getInt("ID"),
						rs.getString("CATEGORY"),
						rs.getInt("COST"));
				cares.add(care);
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		  return cares;
}

	@Override
	public Care findById(int id) {
		 try (Connection connection = DataSource.getDataSource();
		          PreparedStatement pStatement = connection.prepareStatement(
		            		 "SELECT * FROM CARE WHERE ID = ? ");
					 ){
				 pStatement.setInt(1, id);
				 ResultSet rs = pStatement.executeQuery();
				 
			 if (rs.next()) {
				Care care = new Care(
						rs.getInt("ID"),
						rs.getString("CATEGORY"),
						rs.getInt("COST"));
				
				return care;
	}
				 
			 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	}				
			   return null;
	}

	@Override
	public boolean update(Care care) {
		try (Connection conn = DataSource.getDataSource();
			       PreparedStatement pStatement = conn.prepareStatement(
			    	  "UPDATE CARE SET CATEGORY= ? COST = ? WHERE ID = ?"))
			        {
			          pStatement.setString(1, care.getCategory());
			          pStatement.setInt(2, care.getCost());
			          pStatement.setInt(2, care.getId());
			          
		              pStatement.executeUpdate();
			        }
			        catch (Exception e)
			        {
			            e.printStackTrace();
			        }


			        return false;
}

	@Override
	public boolean deleteById(int id) {
		try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "DELETE FROM CARE WHERE ID= ?"))
	        {
	            pStatement.setInt(1, id);
	            
	            pStatement.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
}


	        return false;
}

}
