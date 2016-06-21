/**
 * 
 */
package za.co.sindi.wumdrop.impl;

import java.net.URI;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.common.utils.Strings;
import za.co.sindi.wumdrop.AbstractRequest;
import za.co.sindi.wumdrop.http.impl.DefaultHttpRequest;

/**
 * @author Bienfait Sindi
 * @since 10 December 2014
 *
 */
public class PostWebHookRequest extends AbstractRequest<String> {

	/**
	 * 
	 * @param uri
	 * @param endpointURL
	 */
	public PostWebHookRequest(String uri, String endpointURL) {
		// TODO Auto-generated constructor stub
		this(URI.create(uri), endpointURL);
	}

	/**
	 * 
	 * @param uri
	 * @param endpointURL
	 */
	public PostWebHookRequest(URI uri, String endpointURL) {
		// TODO Auto-generated constructor stub
		PreConditions.checkArgument(!Strings.isNullOrEmpty(endpointURL), "The designated endpoint URL is not provided.");
		
		setHttpRequest(new DefaultHttpRequest("POST", uri));
		getHttpRequest().setParameter("endpoint_url", endpointURL);
		setResponseHandler(new MessageJsonResponseHandler());
	}
}
