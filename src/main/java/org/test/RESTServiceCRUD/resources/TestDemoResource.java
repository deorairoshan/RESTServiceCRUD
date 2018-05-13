package org.test.RESTServiceCRUD.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("params")
@Produces(MediaType.TEXT_PLAIN)
public class TestDemoResource {

	@GET
	public String test(@MatrixParam("matrix") String matrixParam, @HeaderParam("header") String headerParam,
			@CookieParam("name") String cookieParam) {
		return "Test Matrix Param=" + matrixParam + "\nHeader Param=" + headerParam + "\nCookie Param=" + cookieParam;
	}

	@GET
	@Path("/context")
	public String context(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {

		return "Path : " + uriInfo.getAbsolutePath().toString() + "\n Header: " + httpHeaders.getRequestHeaders();
	}
}
