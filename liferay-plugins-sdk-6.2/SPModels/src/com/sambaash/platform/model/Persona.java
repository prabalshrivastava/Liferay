package com.sambaash.platform.model;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * @author Abhi
 *
 */
public class Persona {

	private static Log _log = LogFactoryUtil.getLog(Persona.class);

	long id;
	private String userType = StringPool.BLANK;
	private String firstName = StringPool.BLANK;
	private String lastName = StringPool.BLANK;
	private String gender = StringPool.BLANK;
	private String nric = StringPool.BLANK;
	private String passport = StringPool.BLANK;
	private String dateOfBirth = StringPool.BLANK;
	private String qualification = StringPool.BLANK;
	private String primaryEmail = StringPool.BLANK;
	private String secondaryEmai = StringPool.BLANK;
	private String contactNumber = StringPool.BLANK;
	private String otherContact = StringPool.BLANK;
	private String postalCode = StringPool.BLANK;
	private String houseBlockNo = StringPool.BLANK;
	private String streetName = StringPool.BLANK;
	private String buildingName = StringPool.BLANK;
	private String countryOfStay = StringPool.BLANK;
	private String maritalStatus = StringPool.BLANK;
	private String countryOfNationality;
	private String race = StringPool.BLANK;
	private String religion = StringPool.BLANK;
	private String writing = StringPool.BLANK;
	private String reading = StringPool.BLANK;
	private String speaking = StringPool.BLANK;
	private String salutation = StringPool.BLANK;
	private String crnNumber = StringPool.BLANK;

	private JSONArray academicQualification;
	private JSONArray professionalQualification;
	private JSONArray currentlyPursuing;
	private JSONArray awardsGrid;
	private JSONArray pastEmployments;
	private JSONArray programmeDetails;
	private JSONArray atoDetails;

	private String currentEmploymentDesignation = StringPool.BLANK;
	private String currentEmploymentLetter = StringPool.BLANK;
	private String currentEmploymentCountry = StringPool.BLANK;
	private String currentEmploymentOrganizationName = StringPool.BLANK;
	private String currentEmploymentStartingDate = StringPool.BLANK;
	private String currentEmploymentIndustrySector = StringPool.BLANK;
	private String currentEmploymentAppointment = StringPool.BLANK;
	private String currentEmploymentStatus = StringPool.BLANK;
	private String currentEmploymentJobCategory = StringPool.BLANK;
	private String currentEmploymentPeopleReporting = StringPool.BLANK;

	private boolean invigilator = false;
	private boolean candidate = false;
	private String lastModifiedBy = StringPool.BLANK;
	private String lastModifiedDate = StringPool.BLANK;

	public Persona(String response, long userId) {
		try {
			JSONObject responseJson = JSONFactoryUtil.createJSONObject();
			responseJson = JSONFactoryUtil.createJSONObject(response);

			String lmb = responseJson.getString("lastModifiedBy");
			if (lmb != null && !lmb.equals("")) {
				User lastModifiedByUser = UserLocalServiceUtil.getUser(userId);
				;
				this.lastModifiedBy = lastModifiedByUser.getFirstName();
			}

			JSONObject contentJson = responseJson.getJSONObject("contentJson");
			if (contentJson != null && contentJson.length() > 0) {
				this.firstName = contentJson.getString("FirstName");
				this.lastName = contentJson.getString("LastName");
				this.countryOfStay = contentJson.getString("Country");
				this.primaryEmail = contentJson.getString("PrimaryEmailAddress");
				this.secondaryEmai = responseJson.getString("secondaryEmailAddress");
				this.contactNumber = contentJson.getString("ContactNumberSingapore");
				this.otherContact = contentJson.getString("ContactNumberOthers");
				this.postalCode = contentJson.getString("PostalCode");
				this.houseBlockNo = contentJson.getString("HouseBlockNo");
				this.streetName = contentJson.getString("StreetName");
				this.buildingName = contentJson.getString("BuildingName");
				this.nric = contentJson.getString("NRICNo");
				this.passport = contentJson.getString("Passport");
				this.gender = contentJson.getString("Gender");
				this.salutation = contentJson.getString("Salutation");
				this.maritalStatus = contentJson.getString("MaritialStatus");
				this.countryOfNationality = contentJson.getString("CountryofNationality");
				this.race = contentJson.getString("Race");
				this.religion = contentJson.getString("Religion");
				this.writing = contentJson.getString("Writing");
				this.reading = contentJson.getString("Reading");
				this.speaking = contentJson.getString("Speaking");
				this.crnNumber = contentJson.getString("SrnNumber");
				this.invigilator = contentJson.getBoolean("Invigilator");
				this.candidate = contentJson.getBoolean("Candidate");

				// education
				this.academicQualification = contentJson.getJSONArray("AcademicQualification");
				this.professionalQualification = contentJson.getJSONArray("ProfessionalQualification");
				this.currentlyPursuing = contentJson.getJSONArray("CurrentlyPursuing");
				this.awardsGrid = contentJson.getJSONArray("AwardsGrid");
				this.atoDetails = contentJson.getJSONArray("AtoDetails");

				this.programmeDetails = contentJson.getJSONArray("ProgrammeDetails");

				// employment
				this.pastEmployments = contentJson.getJSONArray("PastEmployments");
				this.currentEmploymentDesignation = contentJson.getString("CurrentEmploymentDesignation");
				this.currentEmploymentLetter = contentJson.getString("CurrentEmploymentLetter");
				this.currentEmploymentCountry = contentJson.getString("CurrentEmploymentCountry");
				this.currentEmploymentOrganizationName = contentJson.getString("CurrentEmploymentOrganizationName");
				this.currentEmploymentIndustrySector = contentJson.getString("CurrentEmploymentIndustrySector");
				this.currentEmploymentAppointment = contentJson.getString("CurrentEmploymentAppointment");
				this.currentEmploymentStatus = contentJson.getString("CurrentEmploymentStatus");
				this.currentEmploymentJobCategory = contentJson.getString("CurrentEmploymentJobCategory");
				this.currentEmploymentPeopleReporting = contentJson.getString("CurrentEmploymentPeopleReporting");
				populateDateFields(contentJson, responseJson);
				if (_log.isDebugEnabled()) {
					_log.debug("Persona : " + toString());
				}
			} else {
				populateDefaultValues(userId);
			}
		} catch (Exception e) {
			_log.error(e);
			populateDefaultValues(userId);
		}
	}

	private void populateDateFields(JSONObject contentJson, JSONObject responseJson) {
		SimpleDateFormat tzformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		SimpleDateFormat tzformat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dateOfBirth = simpleformat.format(tzformat.parse(contentJson.getString("DateOfBirth")));
			if (responseJson.getString("lastModifiedDate") != null) {
				this.lastModifiedDate = simpleformat
				        .format(tzformat1.parse(responseJson.getString("lastModifiedDate")));
			}
			if (contentJson.getString("CurrentEmploymentStartingDate") != null) {
				this.currentEmploymentStartingDate = simpleformat
				        .format(tzformat.parse(contentJson.getString("CurrentEmploymentStartingDate")));
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void populateDefaultValues(long userId) {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
			this.firstName = user.getFirstName();
			this.lastName = user.getLastName();
			this.primaryEmail = user.getEmailAddress();
		} catch (PortalException | SystemException e1) {
			_log.error(e1);
		}
	}

	public boolean isCandidate() {
		return candidate;
	}

	public void setCandidate(boolean candidate) {
		this.candidate = candidate;
	}

	public boolean isInvigilator() {
		return invigilator;
	}

	public void setInvigilator(boolean invigilator) {
		this.invigilator = invigilator;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public JSONArray getAtoDetails() {
		return atoDetails;
	}

	public void setAtoDetails(JSONArray atoDetails) {
		this.atoDetails = atoDetails;
	}

	public JSONArray getProgrammeDetails() {
		return programmeDetails;
	}

	public void setProgrammeDetails(JSONArray programmeDetails) {
		this.programmeDetails = programmeDetails;
	}

	public String getCrnNumber() {
		return crnNumber;
	}

	public void setCrnNumber(String crnNumber) {
		this.crnNumber = crnNumber;
	}

	public JSONArray getAcademicQualification() {
		return academicQualification;
	}

	public void setAcademicQualification(JSONArray academicQualification) {
		this.academicQualification = academicQualification;
	}

	public JSONArray getProfessionalQualification() {
		return professionalQualification;
	}

	public void setProfessionalQualification(JSONArray professionalQualification) {
		this.professionalQualification = professionalQualification;
	}

	public JSONArray getCurrentlyPursuing() {
		return currentlyPursuing;
	}

	public void setCurrentlyPursuing(JSONArray currentlyPursuing) {
		this.currentlyPursuing = currentlyPursuing;
	}

	public JSONArray getAwardsGrid() {
		return awardsGrid;
	}

	public void setAwardsGrid(JSONArray awardsGrid) {
		this.awardsGrid = awardsGrid;
	}

	public JSONArray getPastEmployments() {
		if (pastEmployments == null) {
			return JSONFactoryUtil.createJSONArray();
		}
		return pastEmployments;
	}

	public void setPastEmployments(JSONArray pastEmployments) {
		this.pastEmployments = pastEmployments;
	}

	public String getCurrentEmploymentDesignation() {
		return currentEmploymentDesignation;
	}

	public void setCurrentEmploymentDesignation(String currentEmploymentDesignation) {
		this.currentEmploymentDesignation = currentEmploymentDesignation;
	}

	public String getCurrentEmploymentLetter() {
		return currentEmploymentLetter;
	}

	public void setCurrentEmploymentLetter(String currentEmploymentLetter) {
		this.currentEmploymentLetter = currentEmploymentLetter;
	}

	public String getCurrentEmploymentCountry() {
		return currentEmploymentCountry;
	}

	public void setCurrentEmploymentCountry(String currentEmploymentCountry) {
		this.currentEmploymentCountry = currentEmploymentCountry;
	}

	public String getCurrentEmploymentOrganizationName() {
		return currentEmploymentOrganizationName;
	}

	public void setCurrentEmploymentOrganizationName(String currentEmploymentOrganizationName) {
		this.currentEmploymentOrganizationName = currentEmploymentOrganizationName;
	}

	public String getCurrentEmploymentStartingDate() {
		return currentEmploymentStartingDate;
	}

	public void setCurrentEmploymentStartingDate(String currentEmploymentStartingDate) {
		this.currentEmploymentStartingDate = currentEmploymentStartingDate;
	}

	public String getCurrentEmploymentIndustrySector() {
		return currentEmploymentIndustrySector;
	}

	public void setCurrentEmploymentIndustrySector(String currentEmploymentIndustrySector) {
		this.currentEmploymentIndustrySector = currentEmploymentIndustrySector;
	}

	public String getCurrentEmploymentAppointment() {
		return currentEmploymentAppointment;
	}

	public void setCurrentEmploymentAppointment(String currentEmploymentAppointment) {
		this.currentEmploymentAppointment = currentEmploymentAppointment;
	}

	public String getCurrentEmploymentStatus() {
		return currentEmploymentStatus;
	}

	public void setCurrentEmploymentStatus(String currentEmploymentStatus) {
		this.currentEmploymentStatus = currentEmploymentStatus;
	}

	public String getCurrentEmploymentJobCategory() {
		return currentEmploymentJobCategory;
	}

	public void setCurrentEmploymentJobCategory(String currentEmploymentJobCategory) {
		this.currentEmploymentJobCategory = currentEmploymentJobCategory;
	}

	public String getCurrentEmploymentPeopleReporting() {
		return currentEmploymentPeopleReporting;
	}

	public void setCurrentEmploymentPeopleReporting(String currentEmploymentPeopleReporting) {
		this.currentEmploymentPeopleReporting = currentEmploymentPeopleReporting;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getCountryOfStay() {
		return countryOfStay;
	}

	public void setCountryOfStay(String countryOfStay) {
		this.countryOfStay = countryOfStay;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getCountryOfNationality() {
		return countryOfNationality;
	}

	public void setCountryOfNationality(String countryOfNationality) {
		this.countryOfNationality = countryOfNationality;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getWriting() {
		return writing;
	}

	public void setWriting(String writing) {
		this.writing = writing;
	}

	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public String getSpeaking() {
		return speaking;
	}

	public void setSpeaking(String speaking) {
		this.speaking = speaking;
	}

	public long getId() {
		return id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String toString() {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append(this.getClass().getName());
		result.append(" Object {");
		result.append(newLine);

		// determine fields declared in this class only (no fields of
		// superclass)
		Field[] fields = this.getClass().getDeclaredFields();

		// print field names paired with their values
		for (Field field : fields) {
			result.append("  ");
			try {
				result.append(field.getName());
				result.append(": ");
				// requires access to private field:
				result.append(field.get(this));
			} catch (IllegalAccessException ex) {
				_log.error(ex);
			}
			result.append(newLine);
		}
		result.append("}");

		return result.toString();
	}

}
