/**
 * 
 */
package za.co.sindi.wumdrop;

import za.co.sindi.wumdrop.exception.RequestException;
import za.co.sindi.wumdrop.exception.ResponseException;
import za.co.sindi.wumdrop.http.AuthenticationScheme;
import za.co.sindi.wumdrop.http.HttpClient;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public interface Request<T> {

	public void setApiKey(String apiKey);
	public void setAuthenticationScheme(AuthenticationScheme authenticationScheme);
	public void setHttpClient(HttpClient httpClient);
	public void setResponseHandler(ResponseHandler<T> responseHandler);
	public T execute() throws RequestException, ResponseException;
}
