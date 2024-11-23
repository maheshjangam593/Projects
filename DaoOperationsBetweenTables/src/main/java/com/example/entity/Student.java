package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stu_Id;
	private String studentName;
	// it will create a foreign key by default with name of other Entity_primary key of that , subjects_id
	//if we want to rename the default foreign  key then use @joinCoulumn(name="subId")
//	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Subject> subjects;
	@OneToOne( cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="subject_Id")
	private Subject subjects;
}
