package com.produce365.lesson;

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
@Table(name = "LESSON")
public class Lesson {
	@Id
	private int id;
	@Column(name = "TRAINER")
	private String trainer;
	@Column(name = "SUBJECT")
	private String subject;
	@Column(name = "TIME")
	private float time;
}
