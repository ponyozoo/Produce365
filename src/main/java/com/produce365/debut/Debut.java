package com.produce365.debut;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Debut {
	
	@Id
	private int id;
	
	private String name;
	private int memberCount;
	private String concept;
	private String grade;
	private Date debutDate;
	private String photo;
}
