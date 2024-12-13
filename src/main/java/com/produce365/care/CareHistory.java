package com.produce365.care;

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

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARE_HISTORY")
public class CareHistory {
	@Id
	private int idx;
	@Column(name = "CARE_DATE")
	private Date date;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "CARE_ID")
	private Care care;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "TRAINEE_ID")
	private Trainee trainee;
}
