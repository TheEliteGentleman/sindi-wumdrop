/**
 * 
 */
package za.co.sindi.wumdrop.exception;

/**
 * @author Buhake Sindi
 * @since 04 December 2014
 *
 */
public class RequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8093958242835384439L;

	/**
	 * 
	 */
	public RequestException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public RequestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public RequestException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RequestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public RequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
}
