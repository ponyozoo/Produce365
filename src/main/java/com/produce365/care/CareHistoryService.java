package com.produce365.care;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@RequestMapping("/CareHistory")
public class CareHistoryService {
	
	private final CareHistoryRepository careHistoryRepository;
	
	@PostMapping("/")
	String insert(CareHistory careHistory) {
		careHistoryRepository.save(careHistory);
		return "";
	}
}
