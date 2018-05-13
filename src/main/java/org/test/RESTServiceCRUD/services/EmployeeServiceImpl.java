package org.test.RESTServiceCRUD.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.test.RESTServiceCRUD.beans.Employee;
import org.test.RESTServiceCRUD.beans.ErrorMessage;
import org.test.RESTServiceCRUD.exceptions.DataNotFoundException;

public class EmployeeServiceImpl implements EmployeeService {

	private static Map<Long, Employee> employeeDetails = new HashMap<>();

	static {
		employeeDetails.put(1L, new Employee(1L, "Roshan Deorai", "9665975525", "deorairoshan@gmail.com",
				"Associate Consultant", "Capgemini"));
		employeeDetails.put(2L,
				new Employee(2L, "Peter Parker", "9876543210", "peterparker@gmail.com", "Consultant", "SpiderWeb"));
	}

	@Override
	public List<Employee> getAllEmployees() {
		return new ArrayList<>(employeeDetails.values());
	}

	@Override
	public List<Employee> getAllEmployeesForCompany(final String companyName) {
		return new ArrayList<>(employeeDetails.values().stream().filter(emp -> companyName.equals(emp.getCompany()))
				.collect(Collectors.toList()));
	}

	@Override
	public List<Employee> getAllEmployeesPaginated(int start, int size) {
		List<Employee> empList = new ArrayList<>(employeeDetails.values());
		return empList.subList(start, start + size);
	}

	@Override
	public Employee getEmployee(long id) {
		if (employeeDetails.containsKey(id)) {
			return employeeDetails.get(id);
		}
		
//		throw new DataNotFoundException("Employee with id " + employee.getId() + " not found.");
		
		ErrorMessage errorMessage = new ErrorMessage("Employee with id " + id + " not found.", 404,
				"http://localhost:8080/RESTServiceCRUD/webapi/");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		throw new WebApplicationException(response);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		employee.setId(employeeDetails.size() + 1);
		return employeeDetails.put(employee.getId(), employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		if (employeeDetails.containsKey(employee.getId())) {
			return employeeDetails.put(employee.getId(), employee);
		}
		throw new DataNotFoundException("Employee with id " + employee.getId() + " not found.");
	}

	@Override
	public Employee deleteEmployee(long id) {
		if (employeeDetails.containsKey(id)) {
			return employeeDetails.remove(id);
		}
		throw new DataNotFoundException("Employee with id " + id + " not found.");
	}

}
