/**
 * 
 */
package za.co.sindi.wumdrop.impl;

import net.sf.json.JSONObject;
import za.co.sindi.wumdrop.JsonResponseHandler;

/**
 * @author Bienfait Sindi
 * @since 18 December 2014
 *
 */
public class MessageJsonResponseHandler extends JsonResponseHandler<String> {

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.JsonResponseHandler#handleJsonObject(net.sf.json.JSONObject)
	 */
	@Override
	protected String handleJsonObject(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		return jsonObject.getString("message");
	}
}
