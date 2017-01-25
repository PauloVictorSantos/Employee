package com.journaldev.dao.employeedao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import com.journaldev.data.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public void saveEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		session.close();
	}

	@Override
	public List<Employee> showAllEmployees() {
		List<Employee> employeeList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Employee");
        employeeList = query.list();
        return employeeList;
	}

	@Override
	public void updateEmployee(int id, String name, String job, String salary) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        Employee emp = (Employee)session.load(Employee.class, id);
	        emp.setName(name);
	        emp.setJob(job);
	        emp.setSalary(salary);
	        session.update(emp);
	        transaction.commit();
	        session.close();  
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
	}

}
