/**
 * 
 */
package za.co.sindi.wumdrop.data;

import java.io.Serializable;

/**
 * @author Bienfait Sindi
 * @since 14 January 2015
 *
 */
public class Deliveries implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5992975463732456510L;
	
	private DeliveryState[] deliveries;
	private String nextPage;
	
	/**
	 * 
	 */
	public Deliveries() {
		super();
	}

	/**
	 * @param deliveries
	 * @param nextPage
	 */
	public Deliveries(DeliveryState[] deliveries, String nextPage) {
		super();
		this.deliveries = deliveries;
		this.nextPage = nextPage;
	}

	/**
	 * @return the deliveries
	 */
	public DeliveryState[] getDeliveries() {
		return deliveries;
	}
	
	/**
	 * @param deliveries the deliveries to set
	 */
	public void setDeliveries(DeliveryState[] deliveries) {
		this.deliveries = deliveries;
	}
	
	/**
	 * @return the nextPage
	 */
	public String getNextPage() {
		return nextPage;
	}
	
	/**
	 * @param nextPage the nextPage to set
	 */
	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}	
}
