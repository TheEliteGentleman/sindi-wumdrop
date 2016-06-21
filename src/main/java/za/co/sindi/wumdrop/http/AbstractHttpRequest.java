/**
 * 
 */
package za.co.sindi.wumdrop.http;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.common.utils.URLEncoderUtils;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public abstract class AbstractHttpRequest extends AbstractHeaderParams implements HttpRequest {

	private Map<String, List<String>> requestParams = new HashMap<String, List<String>>(); 
	private String method;
	private URI uri;
	
	/**
	 * @param method
	 * @param uri
	 */
	protected AbstractHttpRequest(String method, URI uri) {
		super();
		PreConditions.checkArgument(method != null && !method.isEmpty(), "No HTTP Method provided.");
		PreConditions.checkArgument(uri != null, "No HTTP URI provided.");
		
		this.method = method;
		this.uri = uri;
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpRequest#getMethod()
	 */
	public String getMethod() {
		// TODO Auto-generated method stub
		return method;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpRequest#getURI()
	 */
	public URI getURI() {
		// TODO Auto-generated method stub
		return uri;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpRequest#getParameterNames()
	 */
	public String[] getParameterNames() {
		// TODO Auto-generated method stub
		return requestParams.keySet().toArray(new String[requestParams.size()]);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpRequest#getParameterValues(java.lang.String)
	 */
	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		List<String> valueList = requestParams.get(name);
		return (valueList == null ? null : valueList.toArray(new String[valueList.size()]));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpRequest#setParameter(java.lang.String, java.lang.String[])
	 */
	public void setParameter(String name, String... values) {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(name != null && !name.isEmpty(), "HTTP request parameter name may not be null or empty.");
		if (values != null) {
			for (String value : values) {
				if (!containsParameter(name)) {
					requestParams.put(name, new ArrayList<String>());
				}
				
				requestParams.get(name).add(value == null ? "" : value);
			}
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpRequest#containsParameter(java.lang.String)
	 */
	public boolean containsParameter(String name) {
		// TODO Auto-generated method stub
		return requestParams.containsKey(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpRequest#removeParameter(java.lang.String)
	 */
	public void removeParameter(String name) {
		// TODO Auto-generated method stub
		requestParams.remove(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HttpRequest#toQueryParameters()
	 */
	public String toQueryParameterString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (String header : getParameterNames()) {
			if (sb.length() > 0) {
				sb.append("&");
			}
			
			sb.append(URLEncoderUtils.encodeQuery(header, HttpUtils.CHARSET_UTF8)).append("=");
			
			String queryString = "";
			for (String value : getParameterValues(header)) {
				if (queryString.length() > 0) {
					queryString += ",";
				}
				
				queryString += URLEncoderUtils.encodeQuery(value == null ? "" : value, HttpUtils.CHARSET_UTF8);
			}
			sb.append(queryString);
		}
		
		return sb.toString();
	}
}
