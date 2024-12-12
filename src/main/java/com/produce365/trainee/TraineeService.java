package com.produce365.trainee;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TraineeService {
private final TraineeRepository traineeRepository;
	
	public List<Trainee> getTrainees() {
		return traineeRepository.findAll();
	}
}
