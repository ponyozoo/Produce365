package com.produce365.care;

import java.sql.Date;

import com.produce365.trainee.Trainee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARE_HISTORY")
public class CareHistory {
	@Id
	private int idx;
	@Column(name = "CARE_DATE")
	private Date careDate;
	@ManyToOne
	@JoinColumn(name = "CARE_ID")
	private Care care;
	@ManyToOne
	@JoinColumn(name = "TRAINEE_ID")
	private Trainee trainee;
}
