package produce365.lesson;

import java.util.List;

public interface LessonHistoryDAO {
	boolean insert(LessonHistory lessonHistory);
	List<LessonHistory> selectAll();
	List<LessonHistory> selectByTraineeId(int id);
	List<LessonHistory> selectByLessonId(int id);
}