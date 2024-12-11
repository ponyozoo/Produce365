package com.produce365.rating;

import com.produce365.trainee.Trainee;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RatingPK {
	@Column(name = "CATEGORY")
	private String category;
	@ManyToOne
	@JoinColumn(name = "TRAINEE_ID")
	private Trainee trainee;
}
