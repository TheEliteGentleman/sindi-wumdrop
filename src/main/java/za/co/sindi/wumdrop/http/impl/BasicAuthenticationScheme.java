/**
 * 
 */
package za.co.sindi.wumdrop.http.impl;

import za.co.sindi.codec.Base64Codec;
import za.co.sindi.codec.exception.EncodingException;
import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.common.utils.Strings;
import za.co.sindi.wumdrop.http.AbstractAuthenticationScheme;
import za.co.sindi.wumdrop.http.exception.AuthenticationException;

/**
 * @author Buhake Sindi
 * @since 04 December 2014
 *
 */
public class BasicAuthenticationScheme extends AbstractAuthenticationScheme {

	private String userName;
	private String password;
	
	/**
	 * @param userName
	 * @param password
	 */
	public BasicAuthenticationScheme(String userName, String password) {
		super("Basic");
		PreConditions.checkArgument(!Strings.isNullOrEmpty(userName)/*userName != null && !userName.isEmpty()*/, "User name may not be null or empty.");
		this.userName = userName;
		this.password = password == null ? "" : password;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.AbstractAuthenticationSchement#processAuthentication()
	 */
	@Override
	protected String processAuthentication() throws AuthenticationException {
		// TODO Auto-generated method stub
		try {
//			return Base64Codec.encode(userName + ":" + password, "UTF-8");
			return Base64Codec.getBase64Codec().encode(userName + ":" + password, "UTF-8");
		} catch (EncodingException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new AuthenticationException("Encoding exception encountered with UTF-8", e);
		}
	}
}
