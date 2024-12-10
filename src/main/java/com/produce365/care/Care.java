package com.produce365.care;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "CARE")
public class Care {
	@Id
	private int id;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "COST")
	private int cost;
}