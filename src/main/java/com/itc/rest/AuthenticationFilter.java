/**
* 
 */
package com.itc.rest;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang3.StringUtils;

import com.itc.annotations.Secured;
import com.itc.bean.ClientContent;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

/**
 * @author 16945
 *
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws WebApplicationException {
		// Get the HTTP Authorization header from the request
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		System.out.println("in AuthenticationFilter");
		// Check if the HTTP Authorization header is present and formatted
		// correctly
		String token = null;
		if (StringUtils.isEmpty(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
			ResponseBuilder builder = null;
			String response = "EMPTY_AUTHORIZATION_HEADER";
			builder = Response.status(Response.Status.UNAUTHORIZED).entity(response);
			throw new WebApplicationException(builder.build());

		}else{
			token = authorizationHeader.substring("Bearer".length()).trim();
			if (StringUtils.isEmpty(token)) {
				throw new WebApplicationException("EMPTY_TOKEN");
			}
		}
		
		String userName =  ClientContent.clientDetailsMap.get(token);
		if (StringUtils.isEmpty(userName)) {
			ResponseBuilder builder = null;
			String response = "USER_NOT_FOUND";
			builder = Response.status(Response.Status.UNAUTHORIZED).entity(response);
			throw new WebApplicationException(builder.build());

		}

		try {
			// Validate the token
			validateToken(token, userName);

		} catch (Exception e) {
			// signing key cannot be null or empty.
			System.out.println(e.getMessage());
			ResponseBuilder builder = null;
			String response = null;
			if (e instanceof ExpiredJwtException) {
				response = "TOKEN_EXPIRED";
			} else if (e instanceof SignatureException) {
				response = "INVALID_TOKEN";
			} else {
				response = e.getMessage();
			}
			builder = Response.status(Response.Status.UNAUTHORIZED).entity(response);
			throw new WebApplicationException(builder.build());

		}
	}

	private void validateToken(String token, String username) throws WebApplicationException {
		System.out.println("in validateToken");

		String base64SecretBytes = ClientContent.clientDetailsMap.get(username.toUpperCase() + "_SECRET_KEY");
		System.out.println("base64SecretBytes = "+base64SecretBytes);
		//on Parsing it will throw an appropriate exception if the token is invalid or expired
		Claims claims = Jwts.parser().setSigningKey(base64SecretBytes).parseClaimsJws(token).getBody();
		
		/*System.out.println("----------------------------");
		System.out.println("USERNAME: " + username);
		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());*/
		
	}
}
