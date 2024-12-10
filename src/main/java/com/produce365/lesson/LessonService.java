package com.produce365.lesson;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonService {
	private final LessonRepository lessonRepository;
	
}
