/**
 * 
 */
package com.sambaash.platform.model;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Gaurav Vijayvergia
 * 
 */
public class AddressMap implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, SPAddress> addressMap;

	/**
	 * @return the addressMap
	 */
	public Map<String, SPAddress> getAddressMap() {
		return addressMap;
	}

	/**
	 * @param addressMap
	 *            the addressMap to set
	 */
	public void setAddressMap(Map<String, SPAddress> addressMap) {
		this.addressMap = addressMap;
	}

	public void addAddress(SPAddress address) {
		if (addressMap == null) {
			addressMap = new Hashtable<String, SPAddress>();
		}
		addressMap.put(Long.toString(address.getAddressId()), address);
	}

	public int size() throws NullPointerException{
		return addressMap.size();
	}
	
}
