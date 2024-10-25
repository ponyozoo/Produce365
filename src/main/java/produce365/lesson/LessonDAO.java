package produce365.lesson;

import java.util.List;

public interface LessonDAO {
	
	boolean insert(Lesson lesson);
	List<Lesson> findAll();
	boolean deleteById(int id);
}
