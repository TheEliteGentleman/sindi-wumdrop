/**
 * 
 */
package za.co.sindi.wumdrop.http;

import java.io.InputStream;

/**
 * @author Buhake Sindi
 * @since 04 December 2014
 *
 */
public interface HttpResponse extends HeaderParams {

	public int getStatusCode();
	public String getStatusReason();
	public InputStream getInputStream();
}
