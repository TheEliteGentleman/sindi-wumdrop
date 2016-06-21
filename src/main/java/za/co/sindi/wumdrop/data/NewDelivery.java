/**
 * 
 */
package za.co.sindi.wumdrop.data;

import java.io.Serializable;

/**
 * @author Bienfait Sindi
 * @since 09 December 2014
 *
 */
public class NewDelivery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4612579812609627528L;
	
	private int distanceEstimate;
	private String deliveryId;
	private String message;
	private int price;
	private int timeEstimate;
	
	/**
	 * @return the distanceEstimate
	 */
	public int getDistanceEstimate() {
		return distanceEstimate;
	}
	
	/**
	 * @param distanceEstimate the distanceEstimate to set
	 */
	public void setDistanceEstimate(int distanceEstimate) {
		this.distanceEstimate = distanceEstimate;
	}
	
	/**
	 * @return the deliveryId
	 */
	public String getDeliveryId() {
		return deliveryId;
	}
	
	/**
	 * @param deliveryId the deliveryId to set
	 */
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * @return the timeEstimate
	 */
	public int getTimeEstimate() {
		return timeEstimate;
	}
	
	/**
	 * @param timeEstimate the timeEstimate to set
	 */
	public void setTimeEstimate(int timeEstimate) {
		this.timeEstimate = timeEstimate;
	}
}
