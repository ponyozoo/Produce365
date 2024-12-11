package com.produce365.trainee;

import java.sql.Date;

import jakarta.persistence.Column;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRAINEE")
public class Trainee {
	@Id
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SEX")
	private String sex;
	@Column(name = "BIRTH")
	private Date birth;
	@Column(name = "NATIONALITY")
	private String nationality;
	@Column(name = "HEIGHT")
	private int height;
	@Column(name = "WEIGHT")
	private int weight;
	@Column(name = "HIRE_DATE")
	private Date hireDate;
	@Column(name = "PHOTO")
	private String photo;
}
