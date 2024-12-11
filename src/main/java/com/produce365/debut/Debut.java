package com.produce365.debut;

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
@Table(name = "DEBUT")
public class Debut {
	@Id
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "MEMBER_COUNT")
	private int memberCount;
	@Column(name = "CONCEPT")
	private String concept;
	@Column(name = "GRADE")
	private String grade;
	@Column(name = "DEBUT_DATE")
	private Date debutDate;
	@Column(name = "PHOTO")
	private String photo;
}
