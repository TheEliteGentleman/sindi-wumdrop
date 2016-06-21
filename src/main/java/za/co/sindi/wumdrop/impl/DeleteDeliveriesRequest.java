/**
 * 
 */
package za.co.sindi.wumdrop.impl;

import java.net.URI;

import za.co.sindi.wumdrop.AbstractRequest;
import za.co.sindi.wumdrop.http.impl.DefaultHttpRequest;

/**
 * @author Bienfait Sindi
 * @since 08 December 2014
 *
 */
public class DeleteDeliveriesRequest extends AbstractRequest<String> {

	/**
	 * 
	 * @param uri
	 */
	public DeleteDeliveriesRequest(String uri) {
		this(URI.create(uri));
	}
	
	/**
	 * 
	 * @param uri
	 */
	public DeleteDeliveriesRequest(URI uri) {
		setHttpRequest(new DefaultHttpRequest("DELETE", uri));
		setResponseHandler(new MessageJsonResponseHandler());
	}
}
