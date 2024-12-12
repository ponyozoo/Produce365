package com.produce365.lesson;

import java.sql.Date;

import com.produce365.trainee.Trainee;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "LESSON_HISTORY")
public class LessonHistory {
	@Id
	private int idx;
	@Column(name = "LESSON_DATE")
	private Date date;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "LESSON_ID")
	private Lesson lesson;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "TRAINEE_ID")
	private Trainee trainee;
}
