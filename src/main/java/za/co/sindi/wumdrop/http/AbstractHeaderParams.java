/**
 * 
 */
package za.co.sindi.wumdrop.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import za.co.sindi.common.utils.PreConditions;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public abstract class AbstractHeaderParams implements HeaderParams {

	private Map<String, List<String>> headerParams = new HashMap<String, List<String>>();
	
	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HeaderParams#getHeaderNames()
	 */
	public String[] getHeaderNames() {
		// TODO Auto-generated method stub
		return headerParams.keySet().toArray(new String[headerParams.size()]);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HeaderParams#getHeaderValue(java.lang.String)
	 */
	public String getHeaderValue(String name) {
		// TODO Auto-generated method stub
		return toHeaderParameterString(headerParams.get(name));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HeaderParams#setHeader(java.lang.String, java.lang.String)
	 */
	public void addHeader(String name, String value) {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(name != null && !name.isEmpty(), "No header parameter provided.");
		if (!containsHeader(name)) {
			headerParams.put(name, new ArrayList<String>());
		}
		
		headerParams.get(name).add(value == null ? "" : value);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HeaderParams#containsHeader(java.lang.String)
	 */
	public boolean containsHeader(String name) {
		// TODO Auto-generated method stub
		return headerParams.containsKey(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.http.HeaderParams#removeHeader(java.lang.String)
	 */
	public void removeHeader(String name) {
		// TODO Auto-generated method stub
		headerParams.remove(name);
	}
	
	private String toHeaderParameterString(List<String> values) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		if (values != null) {
			for (String value : values) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				
				sb.append(value);
			}
		}
			
		return sb.toString();
	}
}
