/**
 * 
 */
package za.co.sindi.wumdrop.impl;

import za.co.sindi.wumdrop.http.impl.BasicAuthenticationScheme;

/**
 * @author Buhake Sindi
 * @since 04 December 2014
 *
 */
public class WumDropBasicAuthenticationScheme extends BasicAuthenticationScheme {

	/**
	 * @param userName
	 * @param password
	 */
	public WumDropBasicAuthenticationScheme(String apiKey) {
		super(apiKey, "");
		// TODO Auto-generated constructor stub
	}
}
