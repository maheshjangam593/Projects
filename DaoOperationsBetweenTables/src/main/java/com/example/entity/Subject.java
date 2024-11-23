package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sub_Id;
	private String subjectName;
//	@ManyToOne()
//	@JsonIgnore
//	//@JoinColumn(name = "student_id", referencedColumnName = "id")
	//private Student student;

}
