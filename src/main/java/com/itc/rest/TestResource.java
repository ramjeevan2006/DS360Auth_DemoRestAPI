/**
 * 
 */
package com.itc.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.itc.annotations.Secured;
import com.itc.annotations.UserRole;

/**
 * @author 16945
 *
 */
@Path("/test")
public class TestResource {

	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
    @Path("/secured")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response securedMethod() throws WebApplicationException {
		System.out.println("in securedMethod");
		
		return Response.ok("Accessed secured Method with Token").build();
	}

	@Path("/unsecured")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response unSecuredMethod() throws WebApplicationException {
		System.out.println("in unSecuredMethod");
		return Response.ok("Accessed unsecured Method with out Token").build();
	}


}