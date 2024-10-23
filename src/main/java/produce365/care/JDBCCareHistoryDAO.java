package produce365.care;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import produce365.trainee.Trainee;

public class JDBCCareHistoryDAO implements CareHistoryDAO{

	@Override
	public boolean insert(CareHistory careHistory) {
		boolean result = false;

	    try ( Connection connection = DataSource.getDataSource();
	        PreparedStatement pStatement = 
        		connection.prepareStatement("INSERT INTO CARE_HISTORY ( CARE_DATE, CARE_ID, TRAINEE_ID ) VALUES ( ?, ?, ? )") ) {
	
	    	pStatement.setDate(1, careHistory.getCareDate());
	        pStatement.setInt(2, careHistory.getCare().getId()); 
	      //  pStatement.setInt(3, careHistory.getTrainee().getId());  
	        
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
	public List<CareHistory> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CareHistory> selectByTraineeID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CareHistory> selectCareAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
