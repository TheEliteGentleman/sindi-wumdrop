/**
 * 
 */
package za.co.sindi.wumdrop;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import za.co.sindi.common.utils.CloseUtils;
import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.wumdrop.exception.RequestException;
import za.co.sindi.wumdrop.exception.ResponseException;
import za.co.sindi.wumdrop.http.AuthenticationScheme;
import za.co.sindi.wumdrop.http.HttpClient;
import za.co.sindi.wumdrop.http.HttpRequest;
import za.co.sindi.wumdrop.http.HttpResponse;
import za.co.sindi.wumdrop.http.exception.AuthenticationException;
import za.co.sindi.wumdrop.http.exception.HttpException;
import za.co.sindi.wumdrop.http.impl.DefaultHttpClient;
import za.co.sindi.wumdrop.impl.WumDropBasicAuthenticationScheme;

/**
 * @author Bienfait Sindi
 * @since 08 December 2014
 *
 */
public abstract class AbstractRequest<T> implements Request<T> {
	
	protected final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	private HttpRequest httpRequest;
	private HttpClient httpClient;
	private AuthenticationScheme authenticationScheme;
	private ResponseHandler<T> responseHandler;
	
	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.Request#setApiKey(java.lang.String)
	 */
	public void setApiKey(String apiKey) {
		// TODO Auto-generated method stub
		setAuthenticationScheme(new WumDropBasicAuthenticationScheme(apiKey));
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.Request#setAuthenticationScheme(za.co.sindi.wumdrop.http.AuthenticationScheme)
	 */
	public void setAuthenticationScheme(AuthenticationScheme authenticationScheme) {
		// TODO Auto-generated method stub
		this.authenticationScheme = authenticationScheme;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.Request#setHttpClient(za.co.sindi.wumdrop.http.HttpClient)
	 */
	public void setHttpClient(HttpClient httpClient) {
		// TODO Auto-generated method stub
		this.httpClient = httpClient;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.Request#setResponseHandler(za.co.sindi.wumdrop.ResponseHandler)
	 */
	public void setResponseHandler(ResponseHandler<T> responseHandler) {
		// TODO Auto-generated method stub
		this.responseHandler = responseHandler;
	}

	/**
	 * @param httpRequest the httpRequest to set
	 */
	protected void setHttpRequest(HttpRequest httpRequest) {
		this.httpRequest = httpRequest;
	}

	/**
	 * @return the httpRequest
	 */
	protected HttpRequest getHttpRequest() {
		return httpRequest;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.Request#execute()
	 */
	public T execute() throws RequestException, ResponseException {
		// TODO Auto-generated method stub
//		Conditions.checkState(httpClient != null, "No HTTP Client was specified.");
		PreConditions.checkState(httpRequest != null, "No HTTP request was specified.");
		PreConditions.checkState(authenticationScheme != null, "No authentication was specified.");
		PreConditions.checkState(responseHandler != null, "No response handler was specified.");
		
		if (httpClient == null) {
			if (LOGGER.isLoggable(Level.INFO)) {
				LOGGER.info("No HttpClient was provided, defaulting to " + DefaultHttpClient.class.getName());
			}
			
			httpClient = new DefaultHttpClient();
		}
		
		HttpResponse response = null;
		
		try {
			authenticationScheme.authenticate(httpRequest);
			response = httpClient.execute(httpRequest);
			return responseHandler.handleResponse(response);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			throw new RequestException(e);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			throw new RequestException(e);
		} finally {
			try {
				CloseUtils.close(response.getInputStream());
				CloseUtils.close(httpClient);
				
//				if (response != null) {
//					CloseUtils.close(response.getInputStream());
//				}
//
//				if (httpClient != null) {
//					httpClient.close();
//				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LOGGER.log(Level.WARNING, "Error closing response inputstream.", e);
			}
		}
	}
}
