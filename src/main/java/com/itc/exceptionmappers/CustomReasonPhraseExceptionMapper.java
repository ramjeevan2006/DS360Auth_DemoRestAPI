/**
 * 
 */
package com.itc.exceptionmappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author 16945
 *
 */
@Provider
public class CustomReasonPhraseExceptionMapper implements ExceptionMapper<CustomReasonPhraseException> {

	public Response toResponse(CustomReasonPhraseException bex) {
		System.out.println("toResponse");
		return Response.status(new CustomReasonPhraseExceptionStatusType(Status.BAD_REQUEST,bex.getMessage()))
				.entity("Custom Reason Phrase exception occured : " + bex.getMessage())
				.build();
	}

}
