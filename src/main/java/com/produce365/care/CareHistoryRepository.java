package com.produce365.care;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareHistoryRepository extends JpaRepository<CareHistory, Integer>{
	
}
