/**
 * 
 */
package com.itc.exceptionmappers;

/**
 * @author 16945
 *
 */
public class CustomReasonPhraseException extends Exception {

	private static final long serialVersionUID = -271582074543512905L;

	//private final int businessCode;

	public CustomReasonPhraseException(String message) {
		super(message);
		//this.businessCode = businessCode;
	}

	/*public int getBusinessCode() {
		return businessCode;
	}
*/
}
