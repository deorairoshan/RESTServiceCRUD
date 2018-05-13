package org.test.RESTServiceCRUD.beans;

import javax.ws.rs.QueryParam;

public class ParameterBean {

	private @QueryParam("company") String company;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
