package com.produce365.care;

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
@AllArgsConstructor
@NoArgsConstructor
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