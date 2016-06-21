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
public class Error implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4849203197551519061L;
	
	private String status;
	private String message;
	
	/**
	 * 
	 */
	public Error() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param status
	 * @param message
	 */
	public Error(String status, String message) {
		super();
		this.status = status;
		this.message = message;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Error other = (Error) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
