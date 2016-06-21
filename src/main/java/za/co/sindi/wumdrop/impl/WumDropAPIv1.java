/**
 * 
 */
package za.co.sindi.wumdrop.impl;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.common.utils.Strings;
import za.co.sindi.wumdrop.API;
import za.co.sindi.wumdrop.Request;
import za.co.sindi.wumdrop.data.Coordinate;
import za.co.sindi.wumdrop.data.Deliveries;
import za.co.sindi.wumdrop.data.Delivery;
import za.co.sindi.wumdrop.data.NewDelivery;
import za.co.sindi.wumdrop.data.Quote;
import za.co.sindi.wumdrop.exception.RequestException;
import za.co.sindi.wumdrop.exception.ResponseException;

/**
 * @author Bienfait Sindi
 * @since -09 December 2014
 *
 */
public class WumDropAPIv1 implements API {

	private String apiUri;
	private String apiKey;
	
	/**
	 * @param apiKey
	 */
	public WumDropAPIv1(String apiKey) {
		this("https://api.wumdrop.com/v1/", apiKey);
	}

	/**
	 * @param apiUri
	 * @param apiKey
	 */
	public WumDropAPIv1(String apiUri, String apiKey) {
		super();
		this.apiUri = apiUri;
		this.apiKey = apiKey;
	}

	private String appendPath(String directory) {
		PreConditions.checkArgument(directory != null && !directory.isEmpty(), "no directory provided.");
		StringBuilder sb = new StringBuilder().append(apiUri);
		if (!apiUri.endsWith("/") && !directory.startsWith("/")) {
			sb.append("/");
		}
		if (directory.endsWith("/")) {
			directory = directory.substring(0, directory.length() - 1);
		}
		sb.append(directory);
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.API#getCustomerDeliveries(java.lang.String)
	 */
	public Deliveries getCustomerDeliveries(String customerId) throws RequestException, ResponseException {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(!Strings.isNullOrEmpty(customerId), "Customer ID must not be null or empty.");
		
		Request<Deliveries> getCustomerDeliveriesRequest = new GetCustomerDeliveriesRequest(appendPath("deliveries/customer/" + customerId));
		getCustomerDeliveriesRequest.setApiKey(apiKey);
		return getCustomerDeliveriesRequest.execute();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.Api#deleteDeliveries(java.lang.String)
	 */
	public String deleteDeliveries(String id) throws RequestException, ResponseException {
		Request<String> deleteRequest = new DeleteDeliveriesRequest(appendPath("deliveries/" + id));
		deleteRequest.setApiKey(apiKey);
		return deleteRequest.execute();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.Api#getDeliveries()
	 */
	public Deliveries getDeliveries() throws RequestException, ResponseException {
		Request<Deliveries> getDeliveriesRequest = new GetDeliveriesRequest(appendPath("deliveries"));
		getDeliveriesRequest.setApiKey(apiKey);
		return getDeliveriesRequest.execute();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.API#getDelivery(java.lang.String)
	 */
	public Delivery getDelivery(String deliveryId) throws RequestException,	ResponseException {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(!Strings.isNullOrEmpty(deliveryId), "Delivery ID must not be null or empty.");
		
		Request<Delivery> getDeliveryRequest = new GetDeliveryRequest(appendPath("delivery/" + deliveryId));
		getDeliveryRequest.setApiKey(apiKey);
		return getDeliveryRequest.execute();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.Api#getEstimateQuote(za.co.sindi.wumdrop.Coordinate, za.co.sindi.wumdrop.Coordinate)
	 */
	public Quote getEstimateQuote(Coordinate coord1, Coordinate coord2) throws RequestException, ResponseException {
		return getEstimateQuote(coord1, coord2, null);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.API#getEstimateQuote(za.co.sindi.wumdrop.data.Coordinate, za.co.sindi.wumdrop.data.Coordinate, java.lang.String)
	 */
	public Quote getEstimateQuote(Coordinate coord1, Coordinate coord2,	String city) throws RequestException, ResponseException {
		// TODO Auto-generated method stub
		Request<Quote> quoteRequest = new GetEstimateQuoteRequest(appendPath("estimates/quote"), coord1, coord2).setCity(city);
		quoteRequest.setApiKey(apiKey);
		return quoteRequest.execute();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.API#postDelivery(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public NewDelivery postDelivery(String pickupAddress,
			String pickupContactName, String pickupContactPhone,
			String dropOffAddress, String dropOffContactName,
			String dropOffContactPhone) throws RequestException,
			ResponseException {
		// TODO Auto-generated method stub
		return postDelivery(pickupAddress, pickupContactName, pickupContactPhone, null, null, dropOffAddress, dropOffContactName, dropOffContactPhone, null, null, null, null);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.API#postDelivery(java.lang.String, java.lang.String, java.lang.String, java.lang.String, za.co.sindi.wumdrop.data.Coordinate, java.lang.String, java.lang.String, java.lang.String, java.lang.String, za.co.sindi.wumdrop.data.Coordinate, java.lang.String, java.lang.String)
	 */
	public NewDelivery postDelivery(String pickupAddress,
			String pickupContactName, String pickupContactPhone,
			String pickupRemarks, Coordinate pickupCoordinate,
			String dropOffAddress, String dropOffContactName,
			String dropOffContactPhone, String dropOffRemarks,
			Coordinate dropOffCoordinate, String city, String customerIdentifier)
			throws RequestException, ResponseException {
		// TODO Auto-generated method stub
		Request<NewDelivery> postDeliveriesRequest = new PostDeliveriesRequest(appendPath("deliveries"), pickupAddress, pickupContactName, pickupContactPhone, dropOffAddress, dropOffContactName, dropOffContactPhone)
															.setPickupRemarks(pickupRemarks)
															.setPickupCoordinates(pickupCoordinate)
															.setDropOffRemarks(dropOffRemarks)
															.setDropOffCoordinates(dropOffCoordinate)
															.setCity(city)
															.setCustomerIdentifier(customerIdentifier);
		postDeliveriesRequest.setApiKey(apiKey);		
		return postDeliveriesRequest.execute();
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.API#postWebHook(java.lang.String)
	 */
	public String postWebHook(String endpointURL) throws RequestException, ResponseException {
		Request<String> testRequest = new PostWebHookRequest(appendPath("webhooks"), endpointURL);
		testRequest.setApiKey(apiKey);
		return testRequest.execute();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.wumdrop.Api#test()
	 */
	public String test() throws RequestException, ResponseException {
		Request<String> testRequest = new GetTestRequest(appendPath("test"));
		testRequest.setApiKey(apiKey);
		return testRequest.execute();
	}
}
