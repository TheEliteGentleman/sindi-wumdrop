/**
 * 
 */
package za.co.sindi.wumdrop.impl;

import java.net.URI;

import net.sf.json.JSONObject;
import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.common.utils.Strings;
import za.co.sindi.wumdrop.AbstractRequest;
import za.co.sindi.wumdrop.JsonResponseHandler;
import za.co.sindi.wumdrop.data.Coordinate;
import za.co.sindi.wumdrop.data.NewDelivery;
import za.co.sindi.wumdrop.http.impl.DefaultHttpRequest;

/**
 * @author Bienfait Sindi
 * @since 08 December 2014
 *
 */
public class PostDeliveriesRequest extends AbstractRequest<NewDelivery> {
	
	/**
	 * 
	 * @param uri
	 * @param pickupAddress
	 * @param pickupContactName
	 * @param pickupContactPhone
	 * @param dropOffAddress
	 * @param dropOffContactName
	 * @param dropOffContactPhone
	 */
	public PostDeliveriesRequest(String uri, String pickupAddress, String pickupContactName, String pickupContactPhone, String dropOffAddress, String dropOffContactName, String dropOffContactPhone) {
		this(URI.create(uri), pickupAddress, pickupContactName, pickupContactPhone, dropOffAddress, dropOffContactName, dropOffContactPhone);
	}
	
	/**
	 * 
	 * @param uri
	 * @param pickupAddress
	 * @param pickupContactName
	 * @param pickupContactPhone
	 * @param dropOffAddress
	 * @param dropOffContactName
	 * @param dropOffContactPhone
	 */
	public PostDeliveriesRequest(URI uri, String pickupAddress, String pickupContactName, String pickupContactPhone, String dropOffAddress, String dropOffContactName, String dropOffContactPhone) {
		PreConditions.checkArgument(!Strings.isNullOrEmpty(pickupAddress), "Pick-up address is not specified.");
		PreConditions.checkArgument(!Strings.isNullOrEmpty(pickupContactName), "Pick-up contact name is not specified.");
		PreConditions.checkArgument(!Strings.isNullOrEmpty(pickupContactPhone), "Pick-up contact phone number is not specified.");
		PreConditions.checkArgument(!Strings.isNullOrEmpty(dropOffAddress), "Drop-off address is not specified.");
		PreConditions.checkArgument(!Strings.isNullOrEmpty(dropOffContactName), "Drop-off contact name is not specified.");
		PreConditions.checkArgument(!Strings.isNullOrEmpty(dropOffContactPhone), "Drop-off contact phone number is not specified.");
		
		setHttpRequest(new DefaultHttpRequest("POST", uri));
		getHttpRequest().setParameter("pickup_address", pickupAddress);
		getHttpRequest().setParameter("pickup_contact_name", pickupContactName);
		getHttpRequest().setParameter("pickup_contact_phone", pickupContactPhone);
		getHttpRequest().setParameter("dropoff_address", dropOffAddress);
		getHttpRequest().setParameter("dropoff_contact_name", dropOffContactName);
		getHttpRequest().setParameter("dropoff_contact_phone", dropOffContactPhone);
		
		setResponseHandler(new JsonResponseHandler<NewDelivery>() {

			/* (non-Javadoc)
			 * @see za.co.sindi.wumdrop.JsonResponseHandler#handleJsonObject(net.sf.json.JSONObject)
			 */
			@Override
			protected NewDelivery handleJsonObject(JSONObject jsonObject) {
				// TODO Auto-generated method stub
				NewDelivery delivery = new NewDelivery();
				delivery.setDeliveryId(jsonObject.getString("id"));
				delivery.setDistanceEstimate(jsonObject.getInt("delivery_estimate"));
				delivery.setMessage(jsonObject.getString("message"));
				delivery.setPrice(jsonObject.getInt("price"));
				delivery.setTimeEstimate(jsonObject.getInt("time_estimate"));
				
				return delivery;
			}
		});
	}
	
	/**
	 * 
	 * @param pickupRemarks
	 * @return
	 */
	public PostDeliveriesRequest setPickupRemarks(String pickupRemarks) {
		if (!Strings.isNullOrEmpty(pickupRemarks)) {
			getHttpRequest().setParameter("pickup_remarks", pickupRemarks);
		}
		
		return this;
	}
	
	/**
	 * 
	 * @param pickupCoordinate
	 * @return
	 */
	public PostDeliveriesRequest setPickupCoordinates(Coordinate pickupCoordinate) {
		if (pickupCoordinate != null) {
			getHttpRequest().setParameter("pickup_coordinates", pickupCoordinate.getLatitude() + ", " + pickupCoordinate.getLongitude());
		}
		
		return this;
	}
	
	/**
	 * 
	 * @param dropOffRemarks
	 * @return
	 */
	public PostDeliveriesRequest setDropOffRemarks(String dropOffRemarks) {
		if (!Strings.isNullOrEmpty(dropOffRemarks)) {
			getHttpRequest().setParameter("dropoff_remarks", dropOffRemarks);
		}
		
		return this;
	}
	
	/**
	 * 
	 * @param dropOffCoordinate
	 * @return
	 */
	public PostDeliveriesRequest setDropOffCoordinates(Coordinate dropOffCoordinate) {
		if (dropOffCoordinate != null) {
			getHttpRequest().setParameter("pickup_coordinates", dropOffCoordinate.getLatitude() + ", " + dropOffCoordinate.getLongitude());
		}
		
		return this;
	}

	/**
	 * @param city the city to set
	 */
	public PostDeliveriesRequest setCity(String city) {
		if (!Strings.isNullOrEmpty(city)) {
			getHttpRequest().setParameter("city", city);
		}

		return this;
	}

	/**
	 * @param customerIdentifier the customerIdentifier to set
	 */
	public PostDeliveriesRequest setCustomerIdentifier(String customerIdentifier) {
		if (!Strings.isNullOrEmpty(customerIdentifier)) {
			getHttpRequest().setParameter("customer_identifier", customerIdentifier);
		}
		
		return this;
	}
}
