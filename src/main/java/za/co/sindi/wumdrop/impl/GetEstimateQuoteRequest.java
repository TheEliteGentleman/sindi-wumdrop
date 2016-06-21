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
import za.co.sindi.wumdrop.data.Quote;
import za.co.sindi.wumdrop.http.impl.DefaultHttpRequest;

/**
 * @author Bienfait Sindi
 * @since 09 December 2014
 *
 */
public class GetEstimateQuoteRequest extends AbstractRequest<Quote> {

	public GetEstimateQuoteRequest(String uri, Coordinate coord1, Coordinate coord2) {
		this(URI.create(uri), coord1, coord2);
	}
	
	public GetEstimateQuoteRequest(URI uri, Coordinate coord1, Coordinate coord2) {
		PreConditions.checkArgument(coord1 != null, "No coordinate provided for point A.");
		PreConditions.checkArgument(coord2 != null, "No coordinate provided for point B.");
		
		setHttpRequest(new DefaultHttpRequest("GET", uri));
		getHttpRequest().setParameter("lat1", String.valueOf(coord1.getLatitude()));
		getHttpRequest().setParameter("lon1", String.valueOf(coord1.getLongitude()));
		getHttpRequest().setParameter("lat2", String.valueOf(coord2.getLatitude()));
		getHttpRequest().setParameter("lon2", String.valueOf(coord2.getLongitude()));
		
		setResponseHandler(new JsonResponseHandler<Quote>() {

			/* (non-Javadoc)
			 * @see za.co.sindi.wumdrop.JsonResponseHandler#handleJsonObject(net.sf.json.JSONObject)
			 */
			@Override
			protected Quote handleJsonObject(JSONObject jsonObject) {
				// TODO Auto-generated method stub
				return new Quote(jsonObject.getInt("distance"), jsonObject.getInt("price"), jsonObject.getInt("time"));
			}
		});
	}

	/**
	 * @param city the city to set
	 */
	public GetEstimateQuoteRequest setCity(String city) {
		if (!Strings.isNullOrEmpty(city)) {
			getHttpRequest().setParameter("lon2", city);
		}
		
		return this;
	}
}
