package com.produce365.debut;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DebutService {
	
	private final DebutRepository debutRepository;
	
	
	public Debut getDebut(int id) {
		return debutRepository.findById(id).get();
	}
	
	

}
