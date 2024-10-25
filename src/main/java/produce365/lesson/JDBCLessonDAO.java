package produce365.lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import produce365.care.DataSource;

public class JDBCLessonDAO implements LessonDAO {

	@Override
	public boolean insert(Lesson lesson) {
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection
						.prepareStatement("INSERT INTO LESSON (TRAINER, SUBJECT, TIME) VALUES (?, ?, ?)")) {

			pStatement.setString(1, lesson.getTrainer());
			pStatement.setString(2, lesson.getSubject());
			pStatement.setFloat(3, lesson.getTime());

			int affectedRows = pStatement.executeUpdate();
			if (affectedRows > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Lesson> findAll() {
		List<Lesson> lessons = new ArrayList<Lesson>();
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM LESSON");
				ResultSet rs = pStatement.executeQuery()) {

			while (rs.next()) {
				Lesson lesson = new Lesson(
						rs.getInt("ID"), 
						rs.getString("TRAINER"), 
						rs.getString("SUBJECT"),
						rs.getFloat("TIME"));

				lessons.add(lesson);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lessons;
	}

	@Override
	public boolean deleteById(int id) {
		try (Connection conn = DataSource.getDataSource();
	             PreparedStatement pStatement = conn.prepareStatement(
	            		 "DELETE FROM LESSON WHERE ID = ?"))
	        {
	            pStatement.setInt(1, id);    
	            
	      	            
	            if(pStatement.executeUpdate() > 0) {
	            	return true;
	            }            

	        } catch (Exception e)
	        {
	            e.printStackTrace();
}
	        return false;
}

}
