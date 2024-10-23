package produce365.care;

import java.util.List;

public interface CareHistoryDAO {
	
	boolean insert(CareHistory careHistory);
	List<CareHistory> selectAll();
	List<CareHistory> selectByTraineeID(int id);
	List<CareHistory> selectCareAll(int id);
	
}
