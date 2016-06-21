/**
 * 
 */
package za.co.sindi.wumdrop.impl;

import java.net.URI;

import net.sf.json.JSONObject;
import za.co.sindi.common.utils.Strings;
import za.co.sindi.wumdrop.AbstractRequest;
import za.co.sindi.wumdrop.JsonResponseHandler;
import za.co.sindi.wumdrop.data.Coordinate;
import za.co.sindi.wumdrop.data.Delivery;
import za.co.sindi.wumdrop.http.impl.DefaultHttpRequest;

/**
 * @author Buhake Sindi
 * @since 08 December 2014
 *
 */
public class GetDeliveryRequest extends AbstractRequest<Delivery> {

	/**
	 * @param uri
	 */
	public GetDeliveryRequest(String uri) {
		this(URI.create(uri));
	}
	
	/**
	 * @param uri
	 */
	public GetDeliveryRequest(URI uri) {
		super();
		setHttpRequest(new DefaultHttpRequest("GET", uri));
		
		setResponseHandler(new JsonResponseHandler<Delivery>() {

			/* (non-Javadoc)
			 * @see za.co.sindi.wumdrop.JsonResponseHandler#handleJsonObject(net.sf.json.JSONObject)
			 */
			@Override
			protected Delivery handleJsonObject(JSONObject jsonObject) {
				// TODO Auto-generated method stub
				Delivery delivery = new Delivery();
				if (jsonObject.containsKey("driver_id")) {
					delivery.setDriverId(jsonObject.getString("driver_id"));
				}
				
				delivery.setDropOffAddress(jsonObject.getString("dropoff_address"));
				if (jsonObject.containsKey("dropoff_coordinates")) {
					String[] coordinates = getCoordinates(jsonObject.getString("dropoff_coordinates"));
					delivery.setDropOffCoordinates(new Coordinate(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1])));
				}
				if (jsonObject.containsKey("dropoff_timestamp")) {
					Object value = jsonObject.get("dropoff_timestamp");
					if (value instanceof Long) {
						delivery.setDropOffTimestamp((Long)value);
					}
				}
				if (jsonObject.containsKey("confirmation_image_url")) {
					delivery.setConfirmationImageUrl(jsonObject.getString("confirmation_image_url"));
				}
				delivery.setId(jsonObject.getString("id"));
				delivery.setPickUpAddress(jsonObject.getString("pickup_address"));
				if (jsonObject.containsKey("pickup_coordinates")) {
					String[] coordinates = getCoordinates(jsonObject.getString("pickup_coordinates"));
					delivery.setPickUpCoordinates(new Coordinate(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1])));
				}
				if (jsonObject.containsKey("pickup_timestamp")) {
					Object value = jsonObject.get("pickup_timestamp");
					if (value instanceof Long) {
						delivery.setPickUpTimestamp((Long)value);
					}
				}
				delivery.setStatus(jsonObject.getString("status"));
				delivery.setTimeEstimate(jsonObject.getInt("time_estimate"));
				return delivery;
			}			
		});
	}
	
	private String[] getCoordinates(String coordinate) {
		if (Strings.isNull(coordinate)) {
			return null;
		}
		
		return coordinate.trim().split("\\s*,\\s*");
	}
}
