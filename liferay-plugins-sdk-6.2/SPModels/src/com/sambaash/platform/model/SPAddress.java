package com.sambaash.platform.model;

import java.io.Serializable;

/**
 * @author rioortiz Create from portlet preferences a template named
 *         "shipping_address" or "billing_address" Add the following fields in
 *         order: 1. First Name 2. Last Name 3. Street Address 4. Postal Code 5.
 *         City 6. Country 7. Phone 8. Default Shipping Address 9. Default
 *         Billing Address
 */

public class SPAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	private long addressId;
	private String firstName; // first_name_1
	private String lastName; // last_name_2
	private String streetAddress; // street_address_3
	private String postalCode; // postal_code_4
	private String city; // city_5
	private String country; // country_6
	private String phone; // phone_7
	private boolean defaultShippingAddress; // default_shipping_address_8
	private boolean defaultBillingAddress; // default_billing_address_9

	/**
	 * @return the addressId
	 */
	public long getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId
	 *            the addressId to set
	 */
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @param streetAddress
	 *            the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the defaultShippingAddress
	 */
	public boolean isDefaultShippingAddress() {
		return defaultShippingAddress;
	}

	/**
	 * @param defaultShippingAddress
	 *            the defaultShippingAddress to set
	 */
	public void setDefaultShippingAddress(boolean defaultShippingAddress) {
		this.defaultShippingAddress = defaultShippingAddress;
	}

	/**
	 * @return the defaultBillingAddress
	 */
	public boolean isDefaultBillingAddress() {
		return defaultBillingAddress;
	}

	/**
	 * @param defaultBillingAddress
	 *            the defaultBillingAddress to set
	 */
	public void setDefaultBillingAddress(boolean defaultBillingAddress) {
		this.defaultBillingAddress = defaultBillingAddress;
	}

	@Override
	public String toString() {
		return "SPAddress [addressId=" + addressId + ", firstName=" + firstName + ", lastName=" + lastName + ", streetAddress=" + streetAddress
				+ ", postalCode=" + postalCode + ", city=" + city + ", country=" + country + ", phone=" + phone + ", defaultShippingAddress="
				+ defaultShippingAddress + ", defaultBillingAddress=" + defaultBillingAddress + "]";
	}

}
