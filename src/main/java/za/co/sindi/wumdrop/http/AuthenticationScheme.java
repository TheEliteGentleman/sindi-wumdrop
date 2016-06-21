/**
 * 
 */
package za.co.sindi.wumdrop.http;

import za.co.sindi.wumdrop.http.exception.AuthenticationException;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public interface AuthenticationScheme {

	public String getSchemeName();
	public void authenticate(HttpRequest request) throws AuthenticationException;
}
