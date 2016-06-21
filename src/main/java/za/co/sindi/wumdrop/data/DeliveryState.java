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
public class DeliveryState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5046367055738033362L;
	
	private String id;
	private String state;
	
	/**
	 * 
	 */
	public DeliveryState() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param state
	 */
	public DeliveryState(String id, String state) {
		super();
		this.id = id;
		this.state = state;
	}

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
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		DeliveryState other = (DeliveryState) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
}
