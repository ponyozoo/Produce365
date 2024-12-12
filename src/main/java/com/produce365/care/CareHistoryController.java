package com.produce365.care;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CareHistoryController {
	
	private final CareHistoryService careHistoryService;
}
