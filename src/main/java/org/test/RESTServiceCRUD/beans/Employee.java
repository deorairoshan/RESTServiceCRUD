package org.test.RESTServiceCRUD.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private long id;
	private String name;
	private String phone;
	private String email;
	private String designation;
	private String company;

	public Employee() {
		
	}

	public Employee(long id, String name, String phone, String email, String designation, String company) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.designation = designation;
		this.company = company;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
