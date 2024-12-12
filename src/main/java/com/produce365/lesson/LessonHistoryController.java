package com.produce365.lesson;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.produce365.trainee.Trainee;
import com.produce365.trainee.TraineeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lessonHistory")
public class LessonHistoryController {
	private final LessonHistoryService lessonHistoryService;
	private final LessonService lessonService;
	private final TraineeService traineeService;
	
	@GetMapping(value = {"/", ""})
	public String showLessonHistoryList(Model model) {
		List<LessonHistory> lessonHistories = lessonHistoryService.getLessonHistories();
		List<Lesson> lessons = lessonService.getLessons();
		List<Trainee> trainees = traineeService.getTrainees();
		model.addAttribute("lessonHistories", lessonHistories);
		model.addAttribute("lessons", lessons);
		model.addAttribute("trainees", trainees);		
		model.addAttribute("newLessonHistory", new LessonHistory());
		return "pages/lessonHistory";
	}
	
	@GetMapping("/delete")
	public String deleteLessonHistory(@RequestParam("id") int id, Model model) {
		boolean res = lessonHistoryService.deleteLessonHistory(id);
		if (res)
			return "redirect:/lessonHistory";
		else {
			model.addAttribute("msg", "삭제 실패");
			return "pages/lessonHistory";
		}
	}
	
	@PostMapping("/save")
	public String saveLessonHistory(LessonHistory lessonHistory, BindingResult bindingResult, Model model) {
		boolean res = lessonHistoryService.createLessonHistory(lessonHistory);
		if (res)
			return "redirect:/lessonHistory";
		else {
			model.addAttribute("msg", "등록 실패");
			return "pages/lessonHistory";
		}
	}
}
