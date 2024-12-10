package com.produce365.lesson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LessonController {
	@GetMapping("lesson")
	public String Lesson() {
		return "pages/lesson";
	}
}
