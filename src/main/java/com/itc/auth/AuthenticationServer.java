/**
 * 
 */
package com.itc.auth;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.itc.annotations.Secured;
import com.itc.bean.ClientContent;
import com.itc.bean.UserCredentials;
import com.itc.model.Employee;
import com.itc.service.EmployeeService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * @author 16945
 *
 */
@Secured
@Path("/authentication")
public class AuthenticationServer {

	private static final long EXPIRES_IN = 900000; // 15 mins

	@Autowired
	private EmployeeService employeeService;

	String userRole;

	@Path("/authenticate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticateUser(UserCredentials credentials) {

		System.out.println("in authenticateUser");
		//String token = null;
		try {

			// Authenticate the user using the credentials provided
			if (authenticate(credentials.getUserName(), credentials.getPassword())) {
				// Issue a token for the user and return the token
				String[] response = generateToken(credentials.getUserName());
				
				return Response.ok(response).build();
			} else {
				return Response.status(Response.Status.UNAUTHORIZED).build();
			}

		} catch (Exception e) {
			//e.printStackTrace(); 
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

	}

	private boolean authenticate(String username, String password) throws Exception {
		// Authenticate against a database, LDAP, file or whatever
		// boolean validEmployee = employeeService.authenticateEmployee(username,password);
		Employee employee = employeeService.authenticateEmployee(username,password);
		if (employee != null) {
			userRole = employee.getEmployeeRole();
			return true;
		}

		return false;
	}


	private String[] generateToken(String username) {
		String tokenIdentifier = UUID.randomUUID().toString().replace("-", "");
		Date now = new Date();
		Date exp = new Date(System.currentTimeMillis() + EXPIRES_IN);
		String base64EncodedSecretKey = Base64.getEncoder()
				.encodeToString(MacProvider.generateKey(SignatureAlgorithm.HS256).getEncoded());

		String token = Jwts.builder().setId(tokenIdentifier).setIssuer(username).setIssuedAt(now).setNotBefore(now)
				.setExpiration(exp).signWith(SignatureAlgorithm.HS256, base64EncodedSecretKey).compact();
		
		
		ClientContent.clientDetailsMap.remove(token);
		ClientContent.clientDetailsMap.remove(username.toUpperCase() + "_ROLE");
		ClientContent.clientDetailsMap.remove(username.toUpperCase() + "_SECRET_KEY");
		
		ClientContent.clientDetailsMap.put(token, username);
		ClientContent.clientDetailsMap.put(username.toUpperCase() + "_ROLE", userRole);
		ClientContent.clientDetailsMap.put(username.toUpperCase() + "_SECRET_KEY", base64EncodedSecretKey);
		
		String[] response = new String[3];
		response[0]=username;
		response[1]=userRole;
		response[2]=token;
				
		return response;
	}
	
	@Path("/refreshToken")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response refreshToken(String token) {

		System.out.println("in refreshToken");
		try {

			String userName = ClientContent.clientDetailsMap.get(token);
			if (StringUtils.isEmpty(userName)) {
				String[] response = generateToken(userName);
				
				return Response.ok(response[2]).build();
			} else {
				return Response.status(Response.Status.UNAUTHORIZED).build();
			}

		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

	}

	@Path("/logOut")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logOut(String token) {
		System.out.println("in logOut");
		
		String userName = ClientContent.clientDetailsMap.get(token);
		try {
			if (StringUtils.isEmpty(userName)) {
				ClientContent.clientDetailsMap.remove(token);
				ClientContent.clientDetailsMap.remove(userName.toUpperCase() + "_ROLE");
				ClientContent.clientDetailsMap.remove(userName.toUpperCase() + "_SECRET_KEY");
			}
			return Response.ok("LOGGED_OUT").build();

		} catch (Exception e) {
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	
}