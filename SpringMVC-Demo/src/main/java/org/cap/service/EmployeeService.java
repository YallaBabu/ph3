package org.cap.service;

import java.util.List;

import org.cap.pojo.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(int employeeId);
}
