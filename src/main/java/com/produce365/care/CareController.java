package com.produce365.care;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CareController {
	
	private final CareService careService;
	
	@GetMapping("/care")
	public String careForm(Model model) {
	    Care care = new Care();
	    model.addAttribute("care", care);
	    return "pages/care";
	}
	
	@PostMapping("/care")
    public String saveCare(@ModelAttribute Care care) {
        careService.saveCare(care);
        return "pages/care";
    }

	@GetMapping("/careList")
    public String getAllCares(Model model) {
        List<Care> cares = careService.getCares();
        model.addAttribute("cares", cares);
        return "pages/careList";
    }
	@GetMapping("/cares/delete")
	public String deleteCare(@RequestParam("id") int id) {
		careService.deleteCare(id);
		
		return "pages/careList";
		
	}
	
}
