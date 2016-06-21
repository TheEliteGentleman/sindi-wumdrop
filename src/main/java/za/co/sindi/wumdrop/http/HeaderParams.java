/**
 * 
 */
package za.co.sindi.wumdrop.http;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public interface HeaderParams {

	public String[] getHeaderNames();
	public String getHeaderValue(String name);
	public void addHeader(String name, String value);
	public boolean containsHeader(String name);
	public void removeHeader(String name);
}
