package com.journaldev.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.journaldev.dao.employeedao.EmployeeDao;
import com.journaldev.dao.employeedao.EmployeeDaoImpl;
import com.journaldev.data.Employee;

public class EmployeeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Employee employee = new Employee();
	EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
	EmployeeDao employeeDao;

	Logger logger = Logger.getLogger(EmployeeController.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("Register") != null) {
			String employeeName = request.getParameter("employeeName");
			String employeeJob = request.getParameter("employeeJob");
			String employeeSalary = request.getParameter("employeeSalary");
			employee.setName(employeeName);
			employee.setJob(employeeJob);
			employee.setSalary(employeeSalary);
			System.out.println(request.getParameter("employeeName"));
			try {
				employeeDaoImpl.saveEmployee(employee);

			} catch (Exception e) {
				logger.error("Employee Creation Failed", e);
				throw new ServletException(e);
			}
			// RequestDispatcher rd =
			// // request.getRequestDispatcher("/register/success.jsp");
			// // rd.forward(request, response);
		}

		if (request.getParameter("showEmployee") != null) {
			List<Employee> employeeList = new ArrayList();
			employeeList = employeeDaoImpl.showAllEmployees();
			List<Employee> list = new ArrayList();
			list = employeeDaoImpl.showAllEmployees();
			for (Employee e : list) {
				System.out.print("\n" + e.getJob());
			}
			request.setAttribute("employeeList", employeeList);
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/register/showAll.jsp");
			// rd.forward(request, response);
		}
		if (request.getParameter("updateEmployee") != null) {
			System.out.println("Atualizando");
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("employeeName");
			String job = request.getParameter("employeeJob");
			String salary = request.getParameter("employeeSalary");
			employeeDaoImpl.updateEmployee(id, name, job, salary);

			// RequestDispatcher rd =
			// request.getRequestDispatcher("EmployeeAdd.jsp");
			// rd.forward(request, response);
		}
		if (request.getParameter("deleteEmployee") != null) {
			System.out.println("Excluindo");
			int id2 = Integer.parseInt(request.getParameter("id"));
			employee.setId(id2);
			employeeDaoImpl.deleteEmployee(employee);
			// RequestDispatcher rd =
			// request.getRequestDispatcher("EmployeeAdd.jsp");
			// rd.forward(request, response);
		}

	}
}
