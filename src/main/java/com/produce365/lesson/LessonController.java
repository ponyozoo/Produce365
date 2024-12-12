package com.produce365.lesson;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {
	private final LessonService lessonService;
	
	@GetMapping(value = {"/", ""})
	public String showLessonList(Model model) {
		List<Lesson> lessons = lessonService.getLessons();
		model.addAttribute("lessons", lessons);
		model.addAttribute("newLesson", new Lesson());
		return "pages/lesson";
	}
	
	@GetMapping("/delete")
	public String deleteLesson(@RequestParam("id") int id, Model model) {
		boolean res = lessonService.deleteLesson(id);
		if (res)
			return "redirect:/lesson";
		else {
			model.addAttribute("msg", "삭제 실패");
			return "pages/lesson";
		}
	}
	
	@PostMapping("/save")
	public String saveLesson(Lesson lesson, BindingResult bindingResult, Model model) {
		boolean res = lessonService.createLesson(lesson);
		if (res)
			return "redirect:/lesson";
		else {
			model.addAttribute("msg", "등록 실패");
			return "pages/lesson";
		}
	}
}
