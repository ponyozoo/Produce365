package com.produce365.lesson;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonService {
	private final LessonRepository lessonRepository;
	
	public List<Lesson> getLessons() {
		return lessonRepository.findAll();
	}
	
	public boolean deleteLesson(int id) {
		try {
			lessonRepository.deleteById(id);
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
	}

	public boolean createLesson(Lesson lesson) {
		try {
			lessonRepository.save(lesson);
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
		
	}
}
