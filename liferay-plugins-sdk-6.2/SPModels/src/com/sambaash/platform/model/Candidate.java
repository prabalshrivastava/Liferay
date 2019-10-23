package com.sambaash.platform.model;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class Candidate {

	private static Log _log = LogFactoryUtil.getLog(Candidate.class);

	public Candidate(String response) {
		super();
		JSONObject responseJson = JSONFactoryUtil.createJSONObject();
		try {
			responseJson = JSONFactoryUtil.createJSONObject(response);
		} catch (JSONException e) {
			_log.error(e.getMessage());
		}
		JSONObject contentJson = responseJson.getJSONObject("contentJson");
		if (contentJson != null) {
			this.firstName = contentJson.getString("FirstName");
			this.lastName = contentJson.getString("LastName");
			this.gender = contentJson.getString("Gender");
			// this.NRIC = contentJson.getString("NRIC");
			// this.Passport = contentJson.getString("FirstName");
			this.DOB = contentJson.getString("DateOfBirth");
			this.primaryEmail = contentJson.getString("PrimaryEmailAddress");
			this.secondaryEmai = contentJson.getString("SecondaryEmailAddress");
			this.contactNumber = contentJson.getString("ContactNumberSingapore");
			this.otherContact = contentJson.getString("ContactNumberOthers");
			this.postalCode = contentJson.getString("PostalCode");
			this.houseBlockNo = contentJson.getString("HouseBlockNo");
			this.streetName = contentJson.getString("StreetName");
			this.buildingName = contentJson.getString("BuildingName");
		} else {

		}
	}

	long id;
	String firstName = "";
	String lastName = "";
	String gender = "";
	String NRIC = "";
	String Passport = "";
	String DOB = "";
	String qualification = "";
	String primaryEmail = "";
	String secondaryEmai = "";
	String contactNumber = "";
	String otherContact = "";
	String postalCode = "";
	String houseBlockNo = "";
	String streetName = "";
	String buildingName = "";

	public long getId() {
		return id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNRIC() {
		return NRIC;
	}

	public void setNRIC(String nRIC) {
		NRIC = nRIC;
	}

	public String getPassport() {
		return Passport;
	}

	public void setPassport(String passport) {
		Passport = passport;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getSecondaryEmai() {
		return secondaryEmai;
	}

	public void setSecondaryEmai(String secondaryEmai) {
		this.secondaryEmai = secondaryEmai;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOtherContact() {
		return otherContact;
	}

	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getHouseBlockNo() {
		return houseBlockNo;
	}

	public void setHouseBlockNo(String houseBlockNo) {
		this.houseBlockNo = houseBlockNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
