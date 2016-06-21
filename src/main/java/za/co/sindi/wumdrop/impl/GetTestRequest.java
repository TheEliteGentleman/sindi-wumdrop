/**
 * 
 */
package za.co.sindi.wumdrop.impl;

import java.net.URI;

import za.co.sindi.wumdrop.AbstractRequest;
import za.co.sindi.wumdrop.http.impl.DefaultHttpRequest;

/**
 * @author Bienfait Sindi
 * @since 10 December 2014
 *
 */
public class GetTestRequest extends AbstractRequest<String> {

	/**
	 * 
	 * @param uri
	 */
	public GetTestRequest(String uri) {
		// TODO Auto-generated constructor stub
		this(URI.create(uri));
	}

	/**
	 * 
	 * @param uri
	 */
	public GetTestRequest(URI uri) {
		// TODO Auto-generated constructor stub
		setHttpRequest(new DefaultHttpRequest("GET", uri));
		setResponseHandler(new MessageJsonResponseHandler());
	}
}
