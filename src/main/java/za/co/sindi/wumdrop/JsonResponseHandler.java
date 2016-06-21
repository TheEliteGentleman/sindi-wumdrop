/**
 * 
 */
package za.co.sindi.wumdrop;

import java.io.IOException;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.common.utils.IOUtils;
import za.co.sindi.wumdrop.exception.ErrorResponseException;
import za.co.sindi.wumdrop.exception.ResponseException;
import za.co.sindi.wumdrop.http.HttpResponse;
import za.co.sindi.wumdrop.http.ResponseUtils;
import za.co.sindi.wumdrop.data.Error;

/**
 * @author Bienfait Sindi
 * @since 09 December 2014
 *
 */
public abstract class JsonResponseHandler<T> implements ResponseHandler<T> {

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.ResponseHandler#handleResponse(za.co.sindi.wumdrop.http.HttpResponse)
	 */
	public T handleResponse(HttpResponse response) throws ResponseException {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(response != null, "No HTTP response was provided.");
		
		try {
			String charset = ResponseUtils.getCharset(response);
			JSONObject json = (JSONObject) JSONSerializer.toJSON(IOUtils.toString(response.getInputStream(), charset));
			if (response.getStatusCode() >= 400) {
				throw new ErrorResponseException(new Error(json.getString("status"), json.getString("message")));
			}
			
			return handleJsonObject(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ResponseException(e);
		}
	}
	
	protected abstract T handleJsonObject(JSONObject jsonObject);
}
