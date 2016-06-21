/**
 * 
 */
package za.co.sindi.wumdrop.impl;

import java.net.URI;

import za.co.sindi.wumdrop.AbstractRequest;
import za.co.sindi.wumdrop.data.Deliveries;
import za.co.sindi.wumdrop.http.impl.DefaultHttpRequest;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public class GetDeliveriesRequest extends AbstractRequest<Deliveries> {

	/**
	 * @param uri
	 */
	public GetDeliveriesRequest(String uri) {
		this(URI.create(uri));
	}
	
	/**
	 * @param uri
	 */
	public GetDeliveriesRequest(URI uri) {
		super();
		setHttpRequest(new DefaultHttpRequest("GET", uri));
		setResponseHandler(new DeliveriesJsonResponseHandler());
	}
}
