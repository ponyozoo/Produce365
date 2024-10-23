package produce365.care;

import java.util.List;

public interface CareDAO {
	boolean insert(Care care);
	List<Care> findAll();
	Care findById(int id);
	boolean update(Care care);
	boolean deleteById(int id);
}
