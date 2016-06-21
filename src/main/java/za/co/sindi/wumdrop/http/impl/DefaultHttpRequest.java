/**
 * 
 */
package za.co.sindi.wumdrop.http.impl;

import java.net.URI;

import za.co.sindi.wumdrop.http.AbstractHttpRequest;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public class DefaultHttpRequest extends AbstractHttpRequest {

	/**
	 * @param method
	 * @param uri
	 */
	public DefaultHttpRequest(String method, String uri) {
		this(method, URI.create(uri));
	}
	
	/**
	 * @param method
	 * @param uri
	 */
	public DefaultHttpRequest(String method, URI uri) {
		super(method, uri);
	}
}
