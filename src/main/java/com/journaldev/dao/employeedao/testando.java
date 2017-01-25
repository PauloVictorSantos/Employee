package com.journaldev.dao.employeedao;

import java.util.ArrayList;
import java.util.List;

import com.journaldev.data.Employee;

public class testando {
	public static void main(String[] args) {
		Employee employee = new Employee();
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		employee.setId(5);
		employeeDaoImpl.deleteEmployee(employee);

	}
}
