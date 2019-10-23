package com.sambaash.platform.model;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

public class Programme {

	private static final Log log = LogFactoryUtil.getLog(Programme.class);

	public Programme(String response) {
		super();
		JSONObject responseJson = JSONFactoryUtil.createJSONObject();
		try {
			responseJson = JSONFactoryUtil.createJSONObject(response);
		} catch (JSONException e) {
			log.error(e);
		}
		JSONObject contentJson = responseJson.getJSONObject("contentJson");
		if (contentJson != null) {
			this.regulationType = contentJson.getString("RegulationType");
			this.programmeCode = contentJson.getString("ProgrammeCode");
			this.programmeTitle = contentJson.getString("ProgrammeTitle");
			this.programmeDescription = contentJson.getString("ProgrammeDescription");
			this.status = contentJson.getString("Status");
			if(contentJson.has("link")){
				this.link = contentJson.getString("link");
			}
			else{
				this.link = "";
			}
			if(contentJson.has("programmeImage")){
				this.programmeImage = contentJson.getJSONArray("programmeImage").getJSONObject(0).getString("url");
			}
			try {
				JSONArray jsonArray = contentJson.getJSONArray("learningMaterial");
				for (int i = 0; i < jsonArray.length(); i++) {
					learningMaterial.add(jsonArray.getString(i));
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}

		} else {

		}
	}

	long id;
	String regulationType = StringPool.BLANK;
	String programmeCode = StringPool.BLANK;
	String programmeTitle = StringPool.BLANK;
	String programmeDescription = StringPool.BLANK;
	String status = StringPool.BLANK;
	String link = StringPool.BLANK;
	String programmeImage = StringPool.BLANK;

	List<String> learningMaterial = new ArrayList<String>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegulationType() {
		return regulationType;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<String> getLearningMaterial() {
		return learningMaterial;
	}

	public void setLearningMaterial(List<String> learningMaterial) {
		this.learningMaterial = learningMaterial;
	}

	public void setRegulationType(String regulationType) {
		this.regulationType = regulationType;
	}

	public String getProgrammeCode() {
		return programmeCode;
	}

	public void setProgrammeCode(String programmeCode) {
		this.programmeCode = programmeCode;
	}

	public String getProgrammeTitle() {
		return programmeTitle;
	}

	public void setProgrammeTitle(String programmeTitle) {
		this.programmeTitle = programmeTitle;
	}

	public String getProgrammeDescription() {
		return programmeDescription;
	}

	public void setProgrammeDescription(String programmeDescription) {
		this.programmeDescription = programmeDescription;
	}

	public String getProgrammeImage() {
		return programmeImage;
	}

	public void setProgrammeImage(String programmeImage) {
		this.programmeImage = programmeImage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
