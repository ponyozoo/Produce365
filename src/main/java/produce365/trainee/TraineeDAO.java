package produce365.trainee;

import java.util.List;

public interface TraineeDAO {
	boolean insert(Trainee trainee);

	boolean update(Trainee trainee);

	boolean deleteById(int id);
	
	List<Trainee> selectAll();

	Trainee selectById(int id);

	List<Trainee> selectBySex(String sex);

	List<Trainee> selectByNationality(String Nationality);

	List<Trainee> selectByName(String name);

	List<Trainee> selectNoDebut();

	List<String> selectDistinctNationality();
	

}
