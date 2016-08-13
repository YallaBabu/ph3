package org.cap.dao;

import java.util.List;

import org.cap.pojo.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
	
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Employee emp=(Employee)sessionFactory.getCurrentSession().get(Employee.class, employeeId);
		if(emp!=null)
			sessionFactory.getCurrentSession().delete(emp);
		
	}

}
