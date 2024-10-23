package produce365.trainee;

import java.util.List;

public interface TraineeDAO {

	// id, name, birth, sex, height, weight, nationality, hiredate(null->sysdate)
	boolean insert(Trainee trainee);

	boolean update(Trainee trainee);

	boolean deleteById(int id);
	
	List<Trainee> selectAll();

	Trainee selectById(int id);

	List<Trainee> selectBySex(String sex); // join

	List<Trainee> selectByNationality(String Nationality);

	List<Trainee> selectNoDebut();

	List<String> selectDistinctNationality();
	

}
