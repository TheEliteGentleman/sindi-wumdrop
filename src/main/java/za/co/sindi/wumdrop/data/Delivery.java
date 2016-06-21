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
public class Delivery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2264087602572581076L;
	
	private String id;
	private String driverId;
	private String dropOffAddress;
	private Coordinate dropOffCoordinates;
	private long dropOffTimestamp;
	private String confirmationImageUrl;
	private String pickUpAddress;
	private Coordinate pickUpCoordinates;
	private long pickUpTimestamp;
	private String status;
	private int timeEstimate;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the driverId
	 */
	public String getDriverId() {
		return driverId;
	}
	
	/**
	 * @param driverId the driverId to set
	 */
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	
	/**
	 * @return the dropOffAddress
	 */
	public String getDropOffAddress() {
		return dropOffAddress;
	}
	/**
	 * @param dropOffAddress the dropOffAddress to set
	 */
	public void setDropOffAddress(String dropOffAddress) {
		this.dropOffAddress = dropOffAddress;
	}
	
	/**
	 * @return the dropOffCoordinates
	 */
	public Coordinate getDropOffCoordinates() {
		return dropOffCoordinates;
	}
	/**
	 * @param dropOffCoordinates the dropOffCoordinates to set
	 */
	public void setDropOffCoordinates(Coordinate dropOffCoordinates) {
		this.dropOffCoordinates = dropOffCoordinates;
	}
	
	/**
	 * @return the dropOffTimestamp
	 */
	public long getDropOffTimestamp() {
		return dropOffTimestamp;
	}
	
	/**
	 * @param dropOffTimestamp the dropOffTimestamp to set
	 */
	public void setDropOffTimestamp(long dropOffTimestamp) {
		this.dropOffTimestamp = dropOffTimestamp;
	}
	
	/**
	 * @return the confirmationImageUrl
	 */
	public String getConfirmationImageUrl() {
		return confirmationImageUrl;
	}

	/**
	 * @param confirmationImageUrl the confirmationImageUrl to set
	 */
	public void setConfirmationImageUrl(String confirmationImageUrl) {
		this.confirmationImageUrl = confirmationImageUrl;
	}

	/**
	 * @return the pickUpAddress
	 */
	public String getPickUpAddress() {
		return pickUpAddress;
	}
	
	/**
	 * @param pickUpAddress the pickUpAddress to set
	 */
	public void setPickUpAddress(String pickUpAddress) {
		this.pickUpAddress = pickUpAddress;
	}
	/**
	 * @return the pickUpCoordinates
	 */
	public Coordinate getPickUpCoordinates() {
		return pickUpCoordinates;
	}
	
	/**
	 * @param pickUpCoordinates the pickUpCoordinates to set
	 */
	public void setPickUpCoordinates(Coordinate pickUpCoordinates) {
		this.pickUpCoordinates = pickUpCoordinates;
	}
	/**
	 * @return the pickUpTimestamp
	 */
	public long getPickUpTimestamp() {
		return pickUpTimestamp;
	}
	
	/**
	 * @param pickUpTimestamp the pickUpTimestamp to set
	 */
	public void setPickUpTimestamp(long pickUpTimestamp) {
		this.pickUpTimestamp = pickUpTimestamp;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
