/**
 * 
 */
package za.co.sindi.wumdrop.http;

import java.io.Closeable;

import za.co.sindi.wumdrop.http.exception.HttpException;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public interface HttpClient extends Closeable {

	public HttpResponse execute(HttpRequest request) throws HttpException;
}
