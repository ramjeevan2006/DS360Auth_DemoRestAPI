/**
 * 
 */
package com.itc.rest;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import com.itc.annotations.UserRole;
import com.itc.bean.ClientContent;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;

import com.itc.annotations.Secured;

/**
 * @author 16945
 *
 */
@Secured
@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter implements ContainerRequestFilter {
	private static final UserRole[] NO_ROLES = {};
	
    @Context
    private ResourceInfo resourceInfo;
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
    	System.out.println("in AuthorizationFilter");
		
        // Get the resource class which matches with the requested URL
        // Extract the roles declared by it
        Class<?> resourceClass = resourceInfo.getResourceClass();
        UserRole[] classRoles = extractRoles(resourceClass);

        // Get the resource method which matches with the requested URL
        // Extract the roles declared by it
        Method resourceMethod = resourceInfo.getResourceMethod();
        UserRole[] methodRoles = extractRoles(resourceMethod);

        try {
        	String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION).substring("Bearer".length()).trim();
        	String userName = ClientContent.clientDetailsMap.get(token);
            // Check if the user is allowed to execute the method
            // The method annotations override the class annotations
        	
	            if (methodRoles.length == 0) {
	                checkPermissions(classRoles,userName);
	            } else {
	                checkPermissions(methodRoles,userName);
	            }
        	

        } catch (Exception e) {
            /*requestContext.abortWith(
                Response.status(Response.Status.FORBIDDEN).build());*/
        	ResponseBuilder builder = Response.status(Response.Status.FORBIDDEN);
			String response = "NO_PERMISSION";
			builder.entity(response);
			throw new WebApplicationException(builder.build());
        }
    }

    // Extract the roles from the annotated element
    private UserRole[] extractRoles(AnnotatedElement annotatedElement) {
        if (annotatedElement == null) {
            return  NO_ROLES;
        } else {
            Secured secured = annotatedElement.getAnnotation(Secured.class);
            if (secured == null) {
                return NO_ROLES;
            } else {
                UserRole[] allowedRoles = secured.value();
               // return Arrays.asList(allowedRoles);
                return allowedRoles;
            }
        }
    }

    private void checkPermissions(UserRole[] allowedRoles, String username) throws Exception {
        // Check if the user contains one of the allowed roles
    	
		String userRole = ClientContent.clientDetailsMap.get(username.toUpperCase() + "_ROLE");
		boolean containsRole = false;
		for(UserRole role : allowedRoles){
			if(role.name().equals(userRole)){
				containsRole = true;
			}
		}
		
		// Throw an Exception if the user has not permission to execute the method
		if(!containsRole){
			throw new Exception();
		}
		
        
    }
}