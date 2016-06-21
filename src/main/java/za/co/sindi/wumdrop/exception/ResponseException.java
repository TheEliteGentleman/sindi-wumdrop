/**
 * 
 */
package za.co.sindi.wumdrop.exception;

/**
 * @author Bienfait Sindi
 * @since 09 December 2014
 *
 */
public class ResponseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8412301286145409241L;

	/**
	 * 
	 */
	public ResponseException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ResponseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ResponseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ResponseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ResponseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
}
