/**
 * 
 */
package za.co.sindi.wumdrop.http.impl;

import java.io.InputStream;

import za.co.sindi.wumdrop.http.AbstractHttpResponse;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public class DefaultHttpResponse extends AbstractHttpResponse {

	/**
	 * @param statusCode
	 * @param statusReason
	 * @param inputStream
	 */
	public DefaultHttpResponse(int statusCode, String statusReason, InputStream inputStream) {
		super(statusCode, statusReason, inputStream);
		// TODO Auto-generated constructor stub
	}
}
