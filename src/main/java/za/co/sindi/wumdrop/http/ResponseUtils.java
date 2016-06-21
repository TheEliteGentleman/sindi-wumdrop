/**
 * 
 */
package za.co.sindi.wumdrop.http;


/**
 * @author Bienfait Sindi
 * @since 09 December 2014
 *
 */
public final class ResponseUtils {

	private static final String CHARSET_TOKEN = "charset="; // "; charset=";
	private static final String DEFAULT_CHARSET = "UTF-8";
	
	private ResponseUtils() {
		throw new AssertionError("Private Constructor.");
	}
	
	public static String getCharset(HttpResponse response) {
		if (response == null) {
			return null;
		}
		
		String contentType = response.getHeaderValue("Content-Type");
		int charsetPos = contentType.indexOf(CHARSET_TOKEN); 
		if (charsetPos == -1) {
			return DEFAULT_CHARSET;
		}
		
		return contentType.substring(charsetPos + CHARSET_TOKEN.length());
	}
	
	public static final String getContentType(HttpResponse response) {
		if (response == null) {
			return null;
		}
		
		String contentType = response.getHeaderValue("Content-Type");
		int semicolonPos = contentType.indexOf(";", 1);
		if (semicolonPos == -1) {
			return contentType;
		}
		
		return contentType.substring(0, semicolonPos);
	}
}
