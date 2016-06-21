/**
 * 
 */
package za.co.sindi.wumdrop.http;

import java.nio.charset.Charset;

/**
 * @author Bienfait Sindi
 * @since 14 December 2014
 *
 */
public final class HttpUtils {

	public static final String CHARSET_NAME_UTF8 = "UTF-8";
	public static final Charset CHARSET_UTF8 = Charset.forName(CHARSET_NAME_UTF8);
	public static final String DEFAULT_CHARSET_NAME = CHARSET_NAME_UTF8;
	public static final Charset DEFAULT_CHARSET = CHARSET_UTF8;
	
	/**
	 * 
	 */
	private HttpUtils() {
		// TODO Auto-generated constructor stub
		throw new AssertionError("Private Constructor.");
	}
}
