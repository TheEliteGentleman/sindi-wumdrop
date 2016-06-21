/**
 * 
 */
package za.co.sindi.wumdrop.http;

import java.io.InputStream;

import za.co.sindi.common.utils.PreConditions;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public abstract class AbstractHttpResponse extends AbstractHeaderParams implements HttpResponse {

	private int statusCode;
	private String statusReason;
	private InputStream inputStream;
	
	/**
	 * @param statusCode
	 * @param statusReason
	 * @param inputStream
	 */
	protected AbstractHttpResponse(int statusCode, String statusReason, InputStream inputStream) {
		super();
		PreConditions.checkArgument(statusCode > 0, "HTTP status code may not be less than 0.");
		PreConditions.checkArgument(statusReason != null && !statusReason.isEmpty(), "HTTP status reason may not be null or empty.");
		PreConditions.checkArgument(inputStream != null, "No InputStream provided.");
		
		this.statusCode = statusCode;
		this.statusReason = statusReason;
		this.inputStream = inputStream;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpResponse#getStatusCode()
	 */
	public int getStatusCode() {
		// TODO Auto-generated method stub
		return statusCode;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpResponse#getStatusReason()
	 */
	public String getStatusReason() {
		// TODO Auto-generated method stub
		return statusReason;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpResponse#getInputStream()
	 */
	public InputStream getInputStream() {
		// TODO Auto-generated method stub
		return inputStream;
	}
}
