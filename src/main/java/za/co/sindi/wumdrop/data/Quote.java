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
public class Quote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6694887349224124517L;
	
	private int distance;
	private int price;
	private int time;
	
	/**
	 * 
	 */
	public Quote() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param distance
	 * @param price
	 * @param time
	 */
	public Quote(int distance, int price, int time) {
		super();
		this.distance = distance;
		this.price = price;
		this.time = time;
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
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
	 * @return the time
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + distance;
		result = prime * result + price;
		result = prime * result + time;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quote other = (Quote) obj;
		if (distance != other.distance)
			return false;
		if (price != other.price)
			return false;
		if (time != other.time)
			return false;
		return true;
	}
}
