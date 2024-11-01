package produce365.rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import produce365.common.DataSource;
import produce365.trainee.Trainee;


public class JDBCRatingDAO implements RatingDAO {

	@Override
	public boolean insert(Rating rating) {

		boolean result = false;

		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection
						.prepareStatement("INSERT INTO RATING (CATEGORY , TRAINEE_ID , GRADE) VALUES (? , ? , ?)")) {

			pStatement.setString(1, rating.getCategory());
			pStatement.setInt(2, rating.getTrainee().getId()); // TRAINEE_ID
			pStatement.setString(3, rating.getGrade());

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
	public boolean update(Rating rating) {

		boolean result = false;

		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatment = connection
						.prepareStatement("UPDATE RATING SET GRADE = ? WHERE TRAINEE_ID = ? AND CATEGORY = ?")) {

			pStatment.setString(1, rating.getGrade());
			pStatment.setInt(2, rating.getTrainee().getId());// TRAINEE_ID
			pStatment.setString(3, rating.getCategory());

			int rows = pStatment.executeUpdate();

			if (rows > 0) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Rating> selectByTotalGrade(String grade) {

		List<Rating> ratings = new ArrayList<>();

		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection
						.prepareStatement("SELECT CATEGORY, TRAINEE_ID, GRADE, NAME, PHOTO "
								+ "FROM RATING JOIN TRAINEE ON RATING.TRAINEE_ID = TRAINEE.ID "
								+ "WHERE CATEGORY = 'TOTAL' AND GRADE = ?")) {
			{
				pStatement.setString(1, grade);
				ResultSet rs = pStatement.executeQuery();

				while (rs.next()) {
					Rating rating = new Rating();
					Trainee trainee = new Trainee();

					trainee.setId(rs.getInt("TRAINEE_ID"));
					trainee.setName(rs.getString("NAME"));
					trainee.setPhoto(rs.getString("PHOTO"));
					rating.setTrainee(trainee);
					rating.setCategory(rs.getString("CATEGORY"));
					rating.setGrade(rs.getString("GRADE"));

					ratings.add(rating);
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ratings;

	}

	@Override
	public List<Rating> selectByTraineeId(int id) {

		List<Rating> ratings = new ArrayList<>();

		String sql1 = ("SELECT * FROM RATING WHERE TRAINEE_ID = ?");

		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(sql1)) {
			{
				pStatement.setInt(1, id);
				ResultSet rs = pStatement.executeQuery();

				while (rs.next()) {
					Rating rating = new Rating();
					rating.setCategory(rs.getString("CATEGORY"));
					rating.setTrainee(new Trainee(rs.getInt("TRAINEE_ID")));
					rating.setGrade(rs.getString("GRADE"));

					ratings.add(rating);
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ratings;

	}

}