package com.produce365.lesson;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonHistoryService {
	private final LessonHistoryRepository lessonHistoryRepository;
	
	public List<LessonHistory> getLessonHistories() {
		return lessonHistoryRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
	}

	public boolean deleteLessonHistory(int id) {
		try {
			lessonHistoryRepository.deleteById(id);
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
	}

	public boolean createLessonHistory(LessonHistory lessonHistory) {
		try {
			lessonHistoryRepository.save(lessonHistory);
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
	}
}
