/**
 * 
 */
package za.co.sindi.wumdrop;

import za.co.sindi.wumdrop.exception.ResponseException;
import za.co.sindi.wumdrop.http.HttpResponse;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public interface ResponseHandler<T> {

	public T handleResponse(HttpResponse response) throws ResponseException;
}
