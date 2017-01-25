package com.journaldev.dao.employeedao;

import java.util.List;

import com.journaldev.data.Employee;

public interface EmployeeDao {
	public void saveEmployee(Employee employee);

	public List<Employee> showAllEmployees();

	public void updateEmployee(int id, String name, String job, String salary);

	public void deleteEmployee(Employee employee);
}
