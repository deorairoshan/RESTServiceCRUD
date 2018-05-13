package org.test.RESTServiceCRUD.services;

import java.util.List;

import org.test.RESTServiceCRUD.beans.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public List<Employee> getAllEmployeesForCompany(String companyName);

	public List<Employee> getAllEmployeesPaginated(int start, int size);

	public Employee getEmployee(long id);

	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public Employee deleteEmployee(long id);

}
