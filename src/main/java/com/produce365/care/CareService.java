package com.produce365.care;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CareService {

	private final CareRepository careRepository;
	
	public boolean saveCare(Care care) {
		try { //왜 try catch 인지 물어보기
		careRepository.save(care);
		return true; 
		} catch(IllegalArgumentException e) { 
		return false;
		}
}
	
	public boolean deleteCare(int id) {
		try { //왜 try catch 인지 물어보기
		careRepository.deleteById(id);
		return true; 
		} catch(IllegalArgumentException e) { 
		return false;
		}
}
	
	public List<Care> getCares(){
		return careRepository.findAll();
	}
	
}

