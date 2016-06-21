/**
 * 
 */
package za.co.sindi.wumdrop.http;

import java.net.URI;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public interface HttpRequest extends HeaderParams {

	public String getMethod();
	public URI getURI();
	public String[] getParameterNames();
	public String[] getParameterValues(String name);
	public void setParameter(String name, String... values);
	public boolean containsParameter(String name);
	public void removeParameter(String name);
	public String toQueryParameterString();
}
