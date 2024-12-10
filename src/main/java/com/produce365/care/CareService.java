package com.produce365.care;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/cares")
public class CareService {

	private final CareRepository careRepository;

	public CareService(CareRepository careRepository) {
		this.careRepository = careRepository;
	}
	
	public void saveCare(Care care) {
		careRepository.save(care);
	}
	
	public void deleteCare(int id) {
		careRepository.deleteById(id);
	}
	
	public List<Care> getCares(){
		return careRepository.findAll();
	}
	
}

