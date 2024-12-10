package com.produce365.debut;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class DebutController {
	
	private final DebutService debutService;

	@GetMapping("/debutnew")
	public String debutForm() {
		return "pages/debutnew";
	}
	
	
	
	@GetMapping("/debut")
	public String debutList() {
		return "pages/debut";
	}
	 
	

	@GetMapping("/debutDetail/{id}")
	public String debutDetail(@PathVariable("id") int id, Model model) {
		Debut debut = debutService.getDebut(id);
		model.addAttribute("debut", debut);
		
		return "pages/debutupdate";
	}
	
	
	
	
}
