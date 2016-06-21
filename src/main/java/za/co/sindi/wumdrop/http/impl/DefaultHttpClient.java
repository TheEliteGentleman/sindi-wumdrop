/**
 * 
 */
package za.co.sindi.wumdrop.http.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.common.utils.Strings;
import za.co.sindi.wumdrop.http.HttpClient;
import za.co.sindi.wumdrop.http.HttpRequest;
import za.co.sindi.wumdrop.http.HttpResponse;
import za.co.sindi.wumdrop.http.HttpUtils;
import za.co.sindi.wumdrop.http.exception.HttpException;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public class DefaultHttpClient implements HttpClient {

	private HttpURLConnection httpConnection = null;
	
	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpClient#execute(za.co.sindi.wumdrop.http.HttpRequest)
	 */
	public HttpResponse execute(HttpRequest request) throws HttpException {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(request != null, "No HTTP Request provided.");
		boolean appendQueryParameters = ("GET".equals(request.getMethod()) || "DELETE".equals(request.getMethod()));
		String queryString = request.toQueryParameterString();
		
		try {
			if (appendQueryParameters) {
				String uri = request.getURI().toString();
				if (!Strings.isNullOrEmpty(queryString)) {
					uri += (uri.contains("?") ? "&" : "?") + queryString;
				}
				httpConnection = (HttpURLConnection) URI.create(uri).toURL().openConnection();
			} else {
				httpConnection = (HttpURLConnection) request.getURI().toURL().openConnection();
			}
			
			httpConnection.setDefaultUseCaches(false);
			httpConnection.setRequestMethod(request.getMethod());
			httpConnection.setDoInput(true);
			
			//Add headers
			for (String header : request.getHeaderNames()) {
				httpConnection.setRequestProperty(header, request.getHeaderValue(header));
			}
			
			if (!appendQueryParameters) {
				httpConnection.setDoOutput(true);
				byte[] contents = queryString.getBytes(HttpUtils.DEFAULT_CHARSET);
				httpConnection.setRequestProperty("Accept-Charset", HttpUtils.DEFAULT_CHARSET_NAME);
				httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				httpConnection.setRequestProperty("Content-Length", String.valueOf(contents.length));
				httpConnection.getOutputStream().write(contents);
			}
			
			//Execute
			httpConnection.connect();
			
			//Create response
			int statusCode = httpConnection.getResponseCode();
			String statusReason = httpConnection.getResponseMessage();
			InputStream stream = null;
			try {
				stream = httpConnection.getInputStream();
			} catch (IOException e) {
				if (statusCode >= 400) {
					stream = httpConnection.getErrorStream();
				}
			}
			
			HttpResponse response = new DefaultHttpResponse(statusCode, statusReason, stream);
			Map<String, List<String>> responseHeaders = httpConnection.getHeaderFields();
			if (responseHeaders != null) {
				for (Entry<String, List<String>> entry : responseHeaders.entrySet()) {
					String name = entry.getKey();
					if (!Strings.isNull(name)) {
						response.addHeader(name, entry.getValue().get(0));
					}
				}
			}
			
			return response;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			throw new HttpException("MalformedURLException", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new HttpException("IOException", e);
		}
	}

	/* (non-Javadoc)
	 * @see java.io.Closeable#close()
	 */
	public void close() throws IOException {
		// TODO Auto-generated method stub
		if (httpConnection != null) {
			httpConnection.disconnect();
			httpConnection = null;
		}
	}
}
