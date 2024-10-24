package produce365.debut;

import java.util.List;

public interface DebutDAO {
	boolean insert(Debut debut);

	boolean update(Debut debut);

	boolean deleteById(int id);

	List<Debut> findAll();

	Debut findById(int id);
}
