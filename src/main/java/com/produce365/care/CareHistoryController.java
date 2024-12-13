package com.produce365.care;

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
@RequestMapping("/careHistory")
public class CareHistoryController {
	
	private final CareHistoryService careHistoryService;
	private final CareService careService;
	private final TraineeService traineeService;
	
	@GetMapping(value = {"/", ""})
	public String showCareHistoryList(Model model) {
		List<CareHistory> careHistories = careHistoryService.getCareHistories();
		List<Care> cares = careService.getCares();
 		List<Trainee> trainees = traineeService.getTrainees();
 		model.addAttribute("careHistories", careHistories);
 		model.addAttribute("cares", cares);
 		model.addAttribute("trainees",trainees);
 		model.addAttribute("newCareHistory", new CareHistory());
 		return "pages/careHistory";
	}
	
	@GetMapping("/delete")
	public String deleteCareHistory(@RequestParam("id") int id, Model model) {
		boolean result = careHistoryService.deleteCareHistories(id);
		if(result)
			return "redirect:/careHistory";
		else {
			model.addAttribute("msg","삭제실패");
			return "pages/careHistory";
		}
	}
	
	@PostMapping("/save")
	public String saveCareHistory(CareHistory careHistory, BindingResult bindingResult, Model model) {
		boolean result = careHistoryService.createCareHistory(careHistory);
		if(result)
			return "redirect:/careHistory";
		else {
			model.addAttribute("msg","추가실패");
			return "pages/careHistory";
		}
	}
}
