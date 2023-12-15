package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Employee {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int eno;
	private String ename;
	private double salary;
	private Date dob;
	private Date doj;
	private String manager;
	private String dept;
}