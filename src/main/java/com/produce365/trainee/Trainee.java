package com.produce365.trainee;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRAINEE")
public class Trainee {
	@Id
	private int id;
	private String name;
	private String sex;
	private Date birth;
	private String nationality;
	private int height;
	private int weight;
	private Date hireDate;
	private String photo;
}
