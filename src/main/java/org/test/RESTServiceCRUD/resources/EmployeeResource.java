package org.test.RESTServiceCRUD.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.test.RESTServiceCRUD.beans.Employee;
import org.test.RESTServiceCRUD.beans.ParameterBean;
import org.test.RESTServiceCRUD.services.EmployeeService;
import org.test.RESTServiceCRUD.services.EmployeeServiceImpl;

@Path("employee")
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class EmployeeResource {

	private EmployeeService employeeService = new EmployeeServiceImpl();

	/*@GET
	public List<Employee> getAllEmployees(@QueryParam("company") String company, @QueryParam("start") int start,
			@QueryParam("size") int size) {

		if (company != null) {
			return employeeService.getAllEmployeesForCompany(company);
		}

		else if (start >= 0 && size > 0) {
			return employeeService.getAllEmployeesPaginated(start, size);
		}

		return employeeService.getAllEmployees();
	}*/
	
	@GET
	public List<Employee> getAllEmployees(@BeanParam ParameterBean parameterBean) {

		if (parameterBean.getCompany() != null) {
			return employeeService.getAllEmployeesForCompany(parameterBean.getCompany());
		}

		else if (parameterBean.getStart() >= 0 && parameterBean.getSize() > 0) {
			return employeeService.getAllEmployeesPaginated(parameterBean.getStart(), parameterBean.getSize());
		}

		return employeeService.getAllEmployees();
	}

	@Path("/{employeeId}")
	@GET
	public Employee getEmployee(@PathParam("employeeId") long id) {
		return employeeService.getEmployee(id);
	}

	@POST
	public Employee addEmployee(Employee employee) {
		employeeService.addEmployee(employee);
		return employee;
	}

	@PUT
	public Employee updateEmployee(Employee employee) {
		employeeService.updateEmployee(employee);
		return employee;
	}

	@Path("/{employeeId}")
	@DELETE
	public Employee deleteEmployee(@PathParam("employeeId") long id) {
		return employeeService.deleteEmployee(id);
	}

}
