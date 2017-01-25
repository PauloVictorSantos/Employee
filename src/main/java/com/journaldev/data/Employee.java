package com.journaldev.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name = "EMP_ID")
	private int id;
	
	@Column(name="EMP_NAME")
	private String name;
	
	@Column(name="EMP_JOB")
	private String job;
	
	@Column(name="EMP_SALARY")
	private String salary;
	
	public int getId() {
		return id;
	}

	public void setId(int employeeID) {
		this.id = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String employeeSalary) {
		this.salary = employeeSalary;
	}

}
