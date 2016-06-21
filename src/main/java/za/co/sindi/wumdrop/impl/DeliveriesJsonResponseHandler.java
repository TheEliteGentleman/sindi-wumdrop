/**
 * 
 */
package za.co.sindi.wumdrop.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import za.co.sindi.wumdrop.JsonResponseHandler;
import za.co.sindi.wumdrop.data.Deliveries;
import za.co.sindi.wumdrop.data.DeliveryState;

/**
 * @author Bienfait Sindi
 * @since 14 January 2015
 *
 */
public class DeliveriesJsonResponseHandler extends JsonResponseHandler<Deliveries> {

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.JsonResponseHandler#handleJsonObject(net.sf.json.JSONObject)
	 */
	@Override
	protected Deliveries handleJsonObject(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		List<DeliveryState> deliveries = new ArrayList<DeliveryState>();
		JSONArray jsonArray = jsonObject.getJSONArray("deliveries");
		if (jsonArray != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject deliveryJSON = jsonArray.getJSONObject(i);
				deliveries.add(new DeliveryState(deliveryJSON.getString("id"), deliveryJSON.getString("state")));
			}
		}
		
		String nextPage = null;
		if (jsonObject.containsKey("next_page")) {
			nextPage = jsonObject.getString("next_page");
		}
		
		try {
			return new Deliveries(deliveries.toArray(new DeliveryState[deliveries.size()]), nextPage);
		} finally {
			deliveries.clear();
		}
	}
}
