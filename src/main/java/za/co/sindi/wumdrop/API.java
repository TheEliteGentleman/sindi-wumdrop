/**
 * 
 */
package za.co.sindi.wumdrop;

import za.co.sindi.wumdrop.data.Coordinate;
import za.co.sindi.wumdrop.data.Deliveries;
import za.co.sindi.wumdrop.data.Delivery;
import za.co.sindi.wumdrop.data.NewDelivery;
import za.co.sindi.wumdrop.data.Quote;
import za.co.sindi.wumdrop.exception.RequestException;
import za.co.sindi.wumdrop.exception.ResponseException;

/**
 * @author Bienfait Sindi
 * @since 09 December 2014
 *
 */
public interface API {

	public String test() throws RequestException, ResponseException;
	public Deliveries getCustomerDeliveries(String customerId) throws RequestException, ResponseException;
	public Deliveries getDeliveries() throws RequestException, ResponseException;
	public Delivery getDelivery(String deliveryId) throws RequestException, ResponseException;
	public NewDelivery postDelivery(String pickupAddress, String pickupContactName, String pickupContactPhone, String dropOffAddress, String dropOffContactName, String dropOffContactPhone) throws RequestException, ResponseException;
	public NewDelivery postDelivery(String pickupAddress, String pickupContactName, String pickupContactPhone, String pickupRemarks, Coordinate pickupCoordinate, String dropOffAddress, String dropOffContactName, String dropOffContactPhone, String dropOffRemarks, Coordinate dropOffCoordinate, String city, String customerIdentifier) throws RequestException, ResponseException;
	public String deleteDeliveries(String id) throws RequestException, ResponseException;
	public Quote getEstimateQuote(Coordinate coord1, Coordinate coord2) throws RequestException, ResponseException;
	public Quote getEstimateQuote(Coordinate coord1, Coordinate coord2, String city) throws RequestException, ResponseException;
	public String postWebHook(String endpointURL) throws RequestException, ResponseException;
}
