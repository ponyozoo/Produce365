package com.produce365.care;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CareHistoryService {
	
	private final CareHistoryRepository careHistoryRepository;
	
	public List<CareHistory>getCareHistories(){
		return careHistoryRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
		
	}
	
	public boolean deleteCareHistories(int id) {
		try {
			careHistoryRepository.deleteById(id);
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
	}
	
	public boolean createCareHistory(CareHistory careHistory) {
		try {
			careHistoryRepository.save(careHistory);
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
	}
}
