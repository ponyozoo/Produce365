package produce365.rating;

import java.util.List;

public interface RatingDAO {

	boolean insert(Rating rating);

	boolean update(Rating rating);

	List<Rating> selectByTotalGrade(String grade); // join

	List<Rating> selectByTraineeId(int id);

}
