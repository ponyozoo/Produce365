package com.produce365.care;

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
@RequestMapping("/care")
public class CareController {
	
	private final CareService careService;
	
	@PostMapping("/save")
    public String saveCare(Care care, BindingResult bindingResult, Model model) {
		boolean result =  careService.saveCare(care);
        if(result) 
        	return "redirect:/care";
    else {
    }	model.addAttribute("msg","저장실패");
    	return "pages/care";
    }
	
	@GetMapping(value = {"/", ""}) //뭔지 물어보기
    public String getAllCares(Model model) {
        List<Care> cares = careService.getCares();
        model.addAttribute("cares", cares);
        model.addAttribute("care", new Care()); //왜 한번더 했는지 물어보기
        return "pages/care";
    }
	@GetMapping("/delete")
	public String deleteCare(@RequestParam("id") int id, Model model) {
		boolean result = careService.deleteCare(id);
		if(result)
			return "redirect:/care";
		else {
			model.addAttribute("msg", "삭제실패");
			return "pages/care";
		}
		
	}
	
}
