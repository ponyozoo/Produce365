package com.produce365.debutMember;

import com.produce365.debut.Debut;
import com.produce365.trainee.Trainee;

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
@Table(name = "DEBUT_MEMBER")
public class DebutMember {
	@Id
	private int idx;
	@ManyToOne
	@JoinColumn(name = "GROUP_ID")
	private Debut group;
	@ManyToOne
	@JoinColumn(name = "TRAINEE_ID")
	private Trainee trainee;
}
