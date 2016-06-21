/**
 * 
 */
package za.co.sindi.wumdrop.http;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.wumdrop.http.exception.AuthenticationException;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public abstract class AbstractAuthenticationScheme implements AuthenticationScheme {

	private String schemeName;
	
	/**
	 * @param schemeName
	 */
	protected AbstractAuthenticationScheme(String schemeName) {
		super();
		PreConditions.checkArgument(schemeName != null && !schemeName.isEmpty(), "HTTP Authentication scheme name may not be null or empty.");
		this.schemeName = schemeName;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.AuthenticationScheme#getSchemeName()
	 */
	public String getSchemeName() {
		// TODO Auto-generated method stub
		return schemeName;
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.AuthenticationScheme#authenticate(za.co.sindi.wumdrop.http.HttpRequest)
	 */
	public void authenticate(HttpRequest request) throws AuthenticationException {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(request != null, "No HttpRequest has been provided.");
		request.addHeader("Authorization", getSchemeName() + " " + processAuthentication());
	}

	protected abstract String processAuthentication() throws AuthenticationException;
}
