/**
 * 
 */
package za.co.sindi.wumdrop.http.exception;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public class HttpException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2247759067937362917L;

	/**
	 * 
	 */
	public HttpException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public HttpException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public HttpException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public HttpException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public HttpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
}
