/**
 * 
 */
package za.co.sindi.wumdrop.exception;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.wumdrop.data.Error;

/**
 * @author Bienfait Sindi
 * @since 09 December 2014
 *
 */
public class ErrorResponseException extends ResponseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2849372978116225164L;
	
	private Error error;

	/**
	 * @param error
	 */
	public ErrorResponseException(Error error) {
		super();
		PreConditions.checkArgument(error != null, "No error provided.");
		this.error = error;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return error.getMessage();
	}
}
