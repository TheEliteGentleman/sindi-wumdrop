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
public class GetCustomerDeliveriesRequest extends AbstractRequest<Deliveries> {

	/**
	 * @param uri
	 */
	public GetCustomerDeliveriesRequest(String uri) {
		this(URI.create(uri));
	}
	
	/**
	 * @param uri
	 */
	public GetCustomerDeliveriesRequest(URI uri) {
		super();
		setHttpRequest(new DefaultHttpRequest("GET", uri));
		setResponseHandler(new DeliveriesJsonResponseHandler());
	}
}
