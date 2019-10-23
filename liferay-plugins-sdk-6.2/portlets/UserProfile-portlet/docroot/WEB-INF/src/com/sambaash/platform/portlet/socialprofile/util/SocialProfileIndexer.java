package com.sambaash.platform.portlet.socialprofile.util;

import java.io.Serializable;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserConstants;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.NoSuchCategoryException;
import com.liferay.portlet.asset.NoSuchVocabularyException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.socialprofile.util.ProfileConstants.Fields_Constants;
import com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException;
import com.sambaash.platform.srv.extendedprofile.model.SPCertification;
import com.sambaash.platform.srv.extendedprofile.model.SPCompetency;
import com.sambaash.platform.srv.extendedprofile.model.SPJobRole;
import com.sambaash.platform.srv.extendedprofile.service.SPCertificationLocalServiceUtil;
import com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalServiceUtil;
import com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalServiceUtil;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;
import com.sambaash.platform.srv.spservices.model.MembershipPackage;
import com.sambaash.platform.srv.spservices.service.MembershipPackageLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SocialProfileIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { SocialProfile.class.getName() };

	public static final String PORTLET_ID = "UserProfile_WAR_UserProfileportlet";

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		SocialProfile socialProfile = (SocialProfile) obj;
		Document document = new DocumentImpl();
		document.addUID(PORTLET_ID, socialProfile.getUserId());
		SearchEngineUtil.deleteDocument(getSearchEngineId(),
				socialProfile.getCompanyId(), document.get(Field.UID),
				isCommitImmediately());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		SocialProfile socialProfile = (SocialProfile) obj;
		long userId = socialProfile.getUserId();

		Document document = getBaseModelDocument(PORTLET_ID, socialProfile);

		document.addUID(PORTLET_ID, userId);

		long companyId = socialProfile.getCompanyId();

		document.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		document.addKeyword(Field.COMPANY_ID, companyId);
		document.addKeyword(Field.USER_ID, userId);

		String location = socialProfile.getLocation();

		// SocialProfile Document

/*		document.addKeyword(Fields_Constants.LOCATION, location);
		document.addText(Fields_Constants.ABOUT, HtmlUtil.extractText(Validator
				.isNotNull(socialProfile.getAbout()) ? socialProfile.getAbout()
				: ""));
		document.addText(Fields_Constants.SKILLS_QUALIFICATION,
				socialProfile.getSkillsQualification());
		document.addText(Fields_Constants.TRAINING_EDUCATION,
				socialProfile.getTrainingEducation());
		document.addText(Fields_Constants.TITLE, socialProfile.getTitle().trim());
		document.addText(Fields_Constants.INTEREST, socialProfile.getInterest());
		document.addText(Fields_Constants.HONORS, socialProfile.getHonors());
		document.addText(Fields_Constants.GROUP_ASSOCIATION,
				socialProfile.getGroupAssociation());*/
		document.addKeyword(Fields_Constants.USER_REGISTRATION_STATUS,
				socialProfile.getUserRegistrationStatus());
		document.addKeyword(Fields_Constants.USER_REGISTRATION_TYPE,
				socialProfile.getUserType().toLowerCase());
		document.addText(Fields_Constants.PROFILE_VIEW_COUNT,
				String.valueOf(socialProfile.getProfileViewCount()));
		
		long mpId = socialProfile.getMemberPackage();
		try {
			MembershipPackage membershipPackage = MembershipPackageLocalServiceUtil
					.getMembershipPackage(mpId);

			if (membershipPackage != null) {
				document.addText(Fields_Constants.MEMBERSHIP_PACKAGE,
						membershipPackage.getName().toLowerCase());
			}
		} catch (NoSuchMembershipPackageException nsmpe) {
		}
		
		fetchExtraInfoDetails (socialProfile, document);
		
		// User Document

		User user = UserLocalServiceUtil.getUserById(companyId, userId);
		document.addText(Fields_Constants.FIRST_NAME, user.getFirstName());
		document.addText(Fields_Constants.LAST_NAME, user.getLastName());
		document.addText(Fields_Constants.MIDDLE_NAME, user.getMiddleName());
		document.addText(Fields_Constants.FULL_NAME, user.getFullName());
		document.addKeyword(PEConstantsGlobal.FULL_NAME_SEARCHABLE,getSearchableString(user.getFullName().toLowerCase()));
		document.addText(Fields_Constants.EMAIL_ADDRESS, user.getEmailAddress());
		document.addText(Fields_Constants.SCREENNAME, user.getScreenName());
		document.addDate(Field.MODIFIED_DATE, user.getModifiedDate());
		document.addDate(Field.CREATE_DATE, user.getCreateDate());

		document.addKeyword(Fields_Constants.PORTRAIT_ID,
				String.valueOf(user.getPortraitId()));
		document.addKeyword(Field.STATUS, user.getStatus());
		document.addKeyword(Fields_Constants.USER_STATUS, user.getGreeting());

		String defaultCommunityName = PropsUtil
				.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);
		Group group = GroupLocalServiceUtil.getGroup(companyId,
				defaultCommunityName);

		document.addKeyword(Field.GROUP_ID, group.getGroupId());
		document.addText("userImageUrl",UserConstants.getPortraitURL("/image", true, user.getPortraitId()));
		try {
			
			// indexing of multi instance fields 
			//Commenting this code as social profile logic is no longer being used.
			//Map<String, List<String>> indexableFieldsMap = SocialProfileLocalServiceUtil.getIndexableFieldsMap(companyId);
			Map<String, List<String>> indexableFieldsMap = new HashMap<String, List<String>>();
			userId = socialProfile.getUserId();
			List<Date> endDates = new ArrayList<Date>();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			for (Map.Entry<String, List<String>> entry : indexableFieldsMap
					.entrySet()) {
				List<String> indexableFields = entry.getValue();
				
				for (String indexableField : indexableFields) {
					_log.debug("indexableField " + indexableField);
					String indexableFieldValue = StringPool.BLANK;
					if(indexableField.equalsIgnoreCase("twitter") || indexableField.equalsIgnoreCase("websites") || indexableField.equalsIgnoreCase("facebook") || indexableField.equalsIgnoreCase("linkedin") || indexableField.equalsIgnoreCase("email") || indexableField.equalsIgnoreCase("messenger")){
						 indexableFieldValue = SocialProfileLocalServiceUtil.getFieldValue(
									socialProfile.getUserId(),
									socialProfile.getUserInfo(), indexableField+"_url");
						 indexableFieldValue = indexableFieldValue.replaceAll(StringPool.EXCLAMATION+StringPool.AMPERSAND, StringPool.SPACE);
					}
					else{
						indexableFieldValue = SocialProfileLocalServiceUtil.getFieldValue(
							socialProfile.getUserId(),
							socialProfile.getUserInfo(), indexableField);
					}	
					
					if(indexableField.equalsIgnoreCase("end_date")){
						indexableFieldValue = indexableFieldValue.replaceAll(StringPool.EXCLAMATION+StringPool.AMPERSAND, StringPool.COMMA_AND_SPACE);
						Date latest = new Date();
						if(indexableFieldValue.contains("Present")){
							indexableFieldValue = indexableFieldValue.replace("Present", "");
							//latest = formatter.parse(latest);
						}else{
							try{
								if(Validator.isNotNull(indexableFieldValue)){
									endDates.add(formatter.parse(indexableFieldValue));
									latest = Collections.max(endDates);
								}	
							}catch(Exception e){
								_log.error("erreor getting end date value " + e.getMessage());
							}
						}
						String currentJobStatus = getCurrentJobTitle(latest,socialProfile);
						String[] currentJobStatusArray = currentJobStatus.split("//");
						
						if(currentJobStatusArray.length > 2){
							document.addText("currentJobTitle",currentJobStatusArray[0]);
							document.addText("currentCompany",currentJobStatusArray[1]);
							document.addText("currentIndustry",currentJobStatusArray[2]);
						}	
					}
					
					document.addText(indexableField,indexableFieldValue);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

		try {
			SPJobRole jobRole = SPJobRoleLocalServiceUtil.findByJobRole(userId);
			long functionalGroupId = jobRole.getFunctionalGroupId();
			long jobLevelId = jobRole.getJobLevelId();

			try {
				AssetCategory functionalGroupAssetCategory = AssetCategoryLocalServiceUtil
						.getAssetCategory(functionalGroupId);
				document.addText(Fields_Constants.FUNCTIONAL_GROUP,
						functionalGroupAssetCategory.getName());
			} catch (NoSuchCategoryException nsce) {

				// do nothing

			}

			try {
				AssetVocabulary jobLevelAssetVocabulary = AssetVocabularyLocalServiceUtil
						.getAssetVocabulary(jobLevelId);
				document.addText(Fields_Constants.JOB_ROLE,
						jobLevelAssetVocabulary.getName());
			} catch (NoSuchVocabularyException nsve) {

				// do nothing

			}
		} catch (NoSuchSPJobRoleException nsjre) {

			// do nothing

		}

		String competencyNamesStr = StringPool.BLANK;
		List<SPCompetency> competencies = SPCompetencyLocalServiceUtil
				.findByCompetencyList(userId);

		for (SPCompetency competency : competencies) {
			long competencyCategoryId = competency.getCompetencyId();
			try {
				AssetCategory competencyCategory = AssetCategoryLocalServiceUtil
						.getAssetCategory(competencyCategoryId);

				if (competencyNamesStr.length() > 0) {
					competencyNamesStr += StringPool.COMMA;
				}

				competencyNamesStr += competencyCategory.getName();
			} catch (NoSuchCategoryException nsce) {

				// do nothing

			}
		}

		if (competencyNamesStr.length() > 0) {
			document.addText(Fields_Constants.COMPETENCY,
					StringUtil.split(competencyNamesStr, StringPool.COMMA));
		}

		String certificationNamesStr = StringPool.BLANK;
		List<SPCertification> certifications = SPCertificationLocalServiceUtil
				.findByUserId(userId);

		for (SPCertification certification : certifications) {
			long certificationCategoryId = certification.getCertificationId();
			try {
				AssetCategory certificationCategory = AssetCategoryLocalServiceUtil
						.getAssetCategory(certificationCategoryId);

				if (certificationNamesStr.length() > 0) {
					certificationNamesStr += StringPool.COMMA;
				}

				certificationNamesStr += certificationCategory.getName();
			} catch (NoSuchCategoryException nsce) {

				// do nothing

			}
		}

		document.addText(Fields_Constants.CERTIFICATE,
				StringUtil.split(certificationNamesStr, StringPool.COMMA));
		_log.debug("full name in indexer "+document.get(FULL_NAME));
		return document;
	}

	private String getCurrentJobTitle(Date latest, SocialProfile socialProfile) {
		// TODO Auto-generated method stub
		String currentJobTitle = StringPool.BLANK;
		String currentCompany = StringPool.BLANK;
		String currentIndustry = StringPool.BLANK;
		XMLManipulator manipulator = new XMLManipulator(socialProfile.getUserInfo());
		NodeList targetNodeList = manipulator.findNodeList("//profile/workhistory/work_details");
		if (Validator.isNotNull(targetNodeList)) {
			for (int i = 0; i <= targetNodeList.getLength()-1; i++) {
				Node targetNode = targetNodeList.item(i);
				NodeList childNodes = targetNode.getChildNodes();
				for (int k = 0; k < childNodes.getLength()-1; k++) {
					Node childNode = childNodes.item(k);
					if(childNode.getNodeName().equalsIgnoreCase("end_date")){
						DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						try {
							Date endDate = new Date();
							if(!childNode.getTextContent().isEmpty()){
								if(!childNode.getTextContent().trim().contains("Present")){
									endDate = formatter.parse(childNode.getTextContent().trim());
									if(latest.compareTo(endDate) == 0){
										currentJobTitle = childNodes.item(1).getTextContent();
										currentCompany = childNodes.item(3).getTextContent();
										currentIndustry = childNodes.item(11).getTextContent();
										break;
									}
								}else{
									currentJobTitle = childNodes.item(1).getTextContent();
									currentCompany = childNodes.item(3).getTextContent();
									currentIndustry = childNodes.item(11).getTextContent();
									break;
								}
								
								
							}	
						} catch (DOMException e) {
							// TODO Auto-generated catch block
							_log.error("DOMException " + e.getMessage());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							_log.error("ParseException " + e.getMessage());
						}
					}
				}
			}
		}
		return currentJobTitle + "//" + currentCompany + "//" + currentIndustry;	
	}
	
	private List<AssetCategory> getAssetCatgsIds(JSONObject formJson,org.w3c.dom.Document doc ){
		String formName = formJson.getString("formName");
		String fieldName = formJson.getString("fieldName");
		return getAssetCatgsIds(formName, fieldName, doc);
	}
	private long getVocIdForDDField(JSONObject fieldInfo){
		String formName = fieldInfo.getString("formName");
		String fieldName = fieldInfo.getString("fieldName");
		long vocId = UserProfileUtil.getVocId(formName, fieldName);
		return vocId;
	}
	private List<AssetCategory> getAssetCatgsIds(String formName,String fieldName,org.w3c.dom.Document doc ){
		List<AssetCategory> catgList = new ArrayList<AssetCategory>();
		//This formNode lenght is always one
		NodeList formNodeList = doc.getElementsByTagName(formName);
		//checking if it is dropdown type
	//	long vocId = UserProfileUtil.getVocId(formName, fieldName);
		if(formNodeList.getLength() > 0){
			Node formNode = formNodeList.item(0);
			Element formElmnt = (Element) formNode;
			NodeList fieldNodes = formElmnt.getElementsByTagName(fieldName);
			for(int nodeIndex = 0; nodeIndex < fieldNodes.getLength(); nodeIndex++){
				Node fieldNode = fieldNodes.item(nodeIndex);
				Element fieldElmnt = (Element) fieldNode;
				String assetCategoryName = fieldElmnt.getTextContent();
				if(Validator.isNotNull(assetCategoryName)){
					long vocId = GetterUtil.getLong(fieldElmnt.getAttribute("optionId"));
					if(vocId > 0){
						AssetCategory catg = getAssetCategory(assetCategoryName, vocId);
						if(catg != null){
							catgList.add(catg);
						}
					}
				}
			}
		}
		
		return catgList;
	}
		
	
	public void fetchExtraInfoDetails(SocialProfile socialProfile, Document document){
		try{
			
			//Fetching all the configurations
			String config = SambaashUtil.getParameter(SambaashConstants.SOCIAL_PROFILE_INDEXER_EXTRA_INFO_CONFIG, 0);
			if(Validator.isNull(config)){
				return;
			}
			// Build xml document for userinfo
			String userInfo = socialProfile.getUserInfo();
			org.w3c.dom.Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new InputSource(new StringReader(userInfo)));
			
			User user = UserLocalServiceUtil.getUserById(socialProfile.getUserId());
			
			document.addKeyword(FIRST_NAME, user.getFirstName());
			document.addKeyword(LAST_NAME, user.getLastName());
			document.addKeyword(FULL_NAME, user.getFullName());
			document.addKeyword(EMAIL_ADDRESS, user.getEmailAddress());

			/** User profile extra fields: these extra fields info ( form name and field id ) have to read from spparameter.
			 *  Each field is represented as one json object in main config json. 
			 *      {
			 *         userType : {
			 *         		"formName" : "processInfo",
			 *              "fieldName" : "userType_id_1
			 *         },
			 *         courseId : {
			 *         		"formName" : "courseInfo",
			 *              "fieldName" : "courseId_1
			 *         }
			 *      }  
			 */
			JSONObject configJ = JSONFactoryUtil.createJSONObject(config);
			
			//user type
			JSONObject userTypeConfigJ = JSONFactoryUtil.createJSONObject(configJ.getString("userType"));
			List<AssetCategory> userTypeList = getAssetCatgsIds(userTypeConfigJ, doc);
			long[] userTypeIds = StringUtil.split(
					ListUtil.toString(userTypeList, AssetCategory.CATEGORY_ID_ACCESSOR), 0L);
			document.addKeyword(USER_TYPE, userTypeIds);
			
			//profile tagging
			JSONObject profileTaggingConfigJ = JSONFactoryUtil.createJSONObject(configJ.getString("profileTagging"));
			List<AssetCategory> profileTaggingList = getAssetCatgsIds(profileTaggingConfigJ, doc);
			long[] profileTaggingIds = StringUtil.split(
					ListUtil.toString(profileTaggingList, AssetCategory.CATEGORY_ID_ACCESSOR), 0L);
			document.addKeyword(PROFILE_TAGGING, profileTaggingIds);
			
			//Course Name
			JSONObject cnConfJ = JSONFactoryUtil.createJSONObject(configJ.getString("courseName"));
			List<AssetCategory> cnList = getAssetCatgsIds(cnConfJ, doc);
			long[] cnCatgIds = StringUtil.split(
					ListUtil.toString(cnList, AssetCategory.CATEGORY_ID_ACCESSOR), 0L);
			document.addKeyword(COURSE_NAME, cnCatgIds);

			// Country of Residence
			JSONObject crConfJ = JSONFactoryUtil.createJSONObject(configJ.getString("countryOfResidence"));
			List<AssetCategory> crList = getAssetCatgsIds(crConfJ, doc);
			long[] crCatgIds = StringUtil.split(
					ListUtil.toString(crList, AssetCategory.CATEGORY_ID_ACCESSOR), 0L);
			document.addKeyword(COUNTRY_OF_RESIDENCE, crCatgIds);
			_log.debug("Country of residence for User Id : "+socialProfile.getUserId()+" is "+crCatgIds);
			
			//Persona
			JSONObject personaConfJ = JSONFactoryUtil.createJSONObject(configJ.getString("persona"));
			List<AssetCategory> personaList = getAssetCatgsIds(personaConfJ, doc);
			long[] personaCatgIds = StringUtil.split(
					ListUtil.toString(personaList, AssetCategory.CATEGORY_ID_ACCESSOR), 0L);
			document.addKeyword(PERSONA, personaCatgIds);
			
			//Sub-Persona
			JSONObject subPersonaConfJ = JSONFactoryUtil.createJSONObject(configJ.getString("subPersona"));
			List<AssetCategory> subPersonaList = getAssetCatgsIds(subPersonaConfJ, doc);
			long[] subPersonaCatgIds = StringUtil.split(
					ListUtil.toString(subPersonaList, AssetCategory.CATEGORY_ID_ACCESSOR), 0L);
			document.addKeyword(SUB_PERSONA, subPersonaCatgIds);
			
			String DATE_FORMAT_PATTERN = "yyyyMMddHHmmss";
			// Date of Birthd
			JSONObject dobConfJ = JSONFactoryUtil.createJSONObject(configJ.getString("dateOfBirth"));
			String dobStr = getSingleInstanceFields(dobConfJ, doc);
			Date date = getDate4rDDMMYYYY(dobStr);
			document.addDate(DOB, date);
		} catch (Exception e){
			_log.error("Exception while indexing extra info of user." , e);
		}
		addPEData(document, socialProfile);
	}
	public void addPEData(Document document,SocialProfile socialProfile){
		try {
			long produtcClassNameId = ClassNameLocalServiceUtil.getClassName(Product.class.getCanonicalName()).getClassNameId();
			long []nonDealStageIdArr = PEEngineLocalServiceUtil.getNonDealStageIds();

			// Deriving data from process applications submitted by user
			//: get all process states of this user and process. 
			// Tag non deal stages and deal stages
			// Tag sales supervisor and agent
			// Tag product ids
			// Tag product country ids
			// Tag product specialization
			List<Long>nonDealStgIdsUsr = new ArrayList<Long>();
			List<Long>dealStagIdsUsr = new ArrayList<Long>();
			List<Long>supervisorIds = new ArrayList<Long>();
			List<Long>agentIds = new ArrayList<Long>();
			List<String>agentNames = new ArrayList<String>();
			List<String>userModifiedDate = new ArrayList<String>();
			List<Long>productIdsUsr = new ArrayList<Long>();
			List<Long>productCountryIdsUsr = new ArrayList<Long>();
			List<AssetCategory>splzCatIdsUsr = new ArrayList<AssetCategory>();
			
			List<PEProcessState> list = PEProcessStateLocalServiceUtil.findByuserIdProcess(socialProfile.getUserId());
			boolean pendingAppExists = false;
			for (PEProcessState processState : list) {
				
				if(PEEngineLocalServiceUtil.isOpenApplication(processState)){
					pendingAppExists = true;
				}
				if(!PEEngineLocalServiceUtil.isRejectedApplicaiton(processState) && PEEngineLocalServiceUtil.isActiveApplicaiton(processState)){
					// Find Non-Deal stage ids
					for(long id: nonDealStageIdArr){
						if(processState.getSpPEProcessStageId() == id){
							nonDealStgIdsUsr.add(id); 
							break;
						}
					}
				}
				
				// Product Ids,specializations,product country ids
				if(processState.getEntityClassId() ==  produtcClassNameId){
					productIdsUsr.add(processState.getEntityId());
					try{
						Product product = ProductLocalServiceUtil.getProduct(processState.getEntityId());
						productCountryIdsUsr.add(GetterUtil.getLong(product.getCountryId()));
						splzCatIdsUsr.addAll(ProductLocalServiceUtil.getSpecializationCatgIds(product));
					}catch(Exception e){
						_log.error("Error while fetching product.Id= " + processState.getEntityClassId() + e.getMessage());
					}
				}
				supervisorIds.add(processState.getUserIdSupervisor());
				agentIds.add(processState.getUserIdAgent());
				if(processState.getUserIdAgent() > 0 ){
					User user = UserLocalServiceUtil.getUser(processState.getUserIdAgent());
					agentNames.add(user.getFullName());
				}
				
				Date modDate = processState.getModifiedDate();
		        Date dt2 = new Date();
		        String diffDates = "Today";
		        long diff = dt2.getTime() - modDate.getTime();
		        long diffSeconds = diff / 1000 % 60;
		        long diffMinutes = diff / (60 * 1000) % 60;
		        long diffHours = diff / (60 * 60 * 1000);
		        int diffInDays = (int) ((dt2.getTime() - modDate.getTime()) / (1000 * 60 * 60 * 24));

		        if (diffInDays > 1) {
		        	diffDates = String.valueOf(diffInDays);
		        } else if (diffHours > 24) {

		        	diffDates = "1";
		        } else if ((diffHours == 24) && (diffMinutes >= 1)) {
		        	diffDates = "Today";
		        }
				userModifiedDate.add(diffDates);
				
				// Find deal stage ids. Application which are not closed will be treated as pending (Stage id is 0).
				if (processState.getClosedStageId() > 0){
					dealStagIdsUsr.add(processState.getClosedStageId());
 
				} 
			}
			
			// Usefult to fetch user having pending applicaitons
			if(pendingAppExists){
				dealStagIdsUsr.add(-1l);
			}
			

			long[] specializationIds = StringUtil.split(
					ListUtil.toString(splzCatIdsUsr, AssetCategory.CATEGORY_ID_ACCESSOR), 0L);
			document.addKeyword(SPECIALIZATION, specializationIds);
			document.addKeyword(PRODUCT_COUNTRY, productCountryIdsUsr.toArray(new Long[productCountryIdsUsr.size()]));
			document.addKeyword(STAGE, nonDealStgIdsUsr.toArray(new Long[nonDealStgIdsUsr.size()]));
			document.addKeyword(DEAL_STAGE, dealStagIdsUsr.toArray(new Long[dealStagIdsUsr.size()]));
			document.addKeyword(PRODUCT, productIdsUsr.toArray(new Long[productIdsUsr.size()]));
			document.addKeyword(SALES_SUPERVISOR, supervisorIds.toArray(new Long[supervisorIds.size()]));
			document.addKeyword(SALES_AGENT, agentIds.toArray(new Long[agentIds.size()]));
			document.addKeyword(SALES_AGENTNAME, agentNames.toArray(new String[agentIds.size()]));
			document.addKeyword(USER_MODIFIEDDATE, userModifiedDate.toArray(new String[agentIds.size()]));
			
			
			_log.debug("Deal Stage for User Id : "+socialProfile.getUserId()+" is "+dealStagIdsUsr.toArray(new Long[dealStagIdsUsr.size()]));
			
			_log.debug("NonDeal Stage for User Id : "+socialProfile.getUserId()+" is "+nonDealStgIdsUsr.toArray(new Long[nonDealStgIdsUsr.size()]));
			
		} catch (Exception e) {
			 _log.error("Exception while adding process engine details",e);
		}
	}
	public static Date getDate4rDDMMYYYY(String str){
		if(Validator.isNotNull(str)){
			try{
				String format = "dd/MM/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				Date date = df.parse(str);
				return date;
			}catch(Exception ex){
				try {
					String format = "dd-MMM-yyyy";
					SimpleDateFormat df = new SimpleDateFormat(format);
					Date date = df.parse(str);
					return date;
				}catch(Exception ex1){
					_log.error("Error while format String to date. String=" + str);
				}
				_log.error("Error while format String to date. String=" + str);
			}
			
		}
		return null;
	}
	
	public String getSingleInstanceFields(JSONObject jsonObj, org.w3c.dom.Document doc){
		String value = StringPool.BLANK;
		try {
			String formName = jsonObj.getString("formName");
			String fieldName = jsonObj.getString("fieldName");
			NodeList formNodeList = doc.getElementsByTagName(formName);
			if(formNodeList.getLength() > 0){
				Element formElement = (Element)formNodeList.item(0);
				NodeList fieldList = formElement.getElementsByTagName(fieldName);
				if(fieldList.getLength() > 0){
					Element element = (Element) fieldList.item(0);
					value = element.getTextContent();
				}
				return value;
			}
		}	
		catch (Exception e){
			_log.error(e);
		}
		return value;
	}
	
	public void addLeadAndOpportunity(String catgName, String spParameterName, SocialProfile socialProfile, List<AssetCategory> userTypeList, long userTypeVocabularyId){
		try {
			String processIdsStr = SambaashUtil.getParameter(spParameterName, 0);
			String[] processIdsStrArr = StringUtil.split(processIdsStr, ",");
			List<PEProcessState> peProcessStateList = null;
		
			long[] processIds = new long[processIdsStrArr.length];   
			for (int i = 0; i < processIdsStrArr.length; i++) {   
				processIds[i] = Long.parseLong(processIdsStrArr[i]);   
			}
			
			if (catgName.equalsIgnoreCase("Lead")){
				peProcessStateList = PEProcessStateLocalServiceUtil.findByProcessStateLead(processIds, socialProfile.getUserId());
			}
			else{
				peProcessStateList = PEProcessStateLocalServiceUtil.findByProcessStateOpportunity(processIds, socialProfile.getUserId());
			}
		
			if (peProcessStateList.size() > 0){
				AssetCategory catg = getAssetCategory(catgName, userTypeVocabularyId);
				if(catg != null){
					userTypeList.add(catg);
				}
			}
		}
		catch (Exception e){
			_log.error(e);
		}
	}
	
	public AssetCategory getAssetCategory(String name, long vocabularyId) {
		try {
			List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(vocabularyId, -1, -1, null);
			for (AssetCategory assetCategory : assetCategories) {
				if (assetCategory.getName().equalsIgnoreCase(name))
					return assetCategory;
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return null;
	}
	
	
	public long getAssetVocabId(String name) {
		try {
			List<AssetVocabulary> assetVocabList = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
			for (AssetVocabulary assetVocab : assetVocabList) {
				if (assetVocab.getName().equalsIgnoreCase(name))
					return assetVocab.getVocabularyId();
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return 0;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		SocialProfile socialProfile = (SocialProfile) obj;
		Document document = getDocument(socialProfile);

//		Map<String, List<String>> indexableFieldsMap = SocialProfileLocalServiceUtil.getIndexableFieldsMap(socialProfile
//				.getCompanyId());
		Map<String, List<String>> indexableFieldsMap = new HashMap<String, List<String>>();
		long userId = socialProfile.getUserId();
		try {
			User user = UserLocalServiceUtil.getUserById(userId);

			if (SambaashConstants.DEFAULT_USER_EMAIL_ADDRESS
					.equalsIgnoreCase(user.getEmailAddress())) {
				return;
			}

		} catch (NoSuchUserException nsue) {
			_log.error(nsue.getMessage());
		}

		for (Map.Entry<String, List<String>> entry : indexableFieldsMap
				.entrySet()) {
			List<String> indexableFields = entry.getValue();

			for (String indexableField : indexableFields) {
				String fieldVal = SocialProfileLocalServiceUtil.getFieldValue(
						socialProfile.getUserId(), socialProfile.getUserInfo(),
						indexableField);

				if (Validator.isNotNull(fieldVal)) {
					fieldVal = HtmlUtil.unescape(fieldVal);
					fieldVal = HtmlUtil.stripHtml(fieldVal);
				}

				document.addText(indexableField, fieldVal.toLowerCase());
			}
		}

		SearchEngineUtil.updateDocument(getSearchEngineId(),
				socialProfile.getCompanyId(), document, isCommitImmediately());

	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		List<SocialProfile> socialProfiles = SocialProfileLocalServiceUtil
				.getSocialProfiles(-1, -1);
		_log.error("Total socialProfiles to reindex: " + socialProfiles.size());

		if (socialProfiles.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

//		Map<String, List<String>> indexableFieldsMap = SocialProfileLocalServiceUtil.getIndexableFieldsMap(companyId);
		Map<String, List<String>> indexableFieldsMap = new HashMap<String, List<String>>();

		for (SocialProfile socialProfile : socialProfiles) {
			long userId = socialProfile.getUserId();
			System.out.println("Indexing for user " + userId);
			try {
				User user = UserLocalServiceUtil.getUserById(userId);

				if (user.getStatus() != 0
						|| SambaashConstants.DEFAULT_USER_EMAIL_ADDRESS
								.equalsIgnoreCase(user.getEmailAddress())) {
					continue;
				}
			} catch (NoSuchUserException nsue) {
				_log.error(nsue.getMessage());
			}

			Document document = getDocument(socialProfile);

			for (Map.Entry<String, List<String>> entry : indexableFieldsMap
					.entrySet()) {
				List<String> indexableFields = entry.getValue();

				for (String indexableField : indexableFields) {
					document.addText(
							indexableField,
							SocialProfileLocalServiceUtil.getFieldValue(
									socialProfile.getUserId(),
									socialProfile.getUserInfo(), indexableField));
				}
			}

			documents.add(document);
		}

		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId,
				documents, isCommitImmediately());
	}

	

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		SocialProfile socialProfile = SocialProfileLocalServiceUtil
				.getSocialProfile(classPK);
		doReindex(socialProfile);
	}

	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		searchContext.setUserId(0);
		return super.search(searchContext);
	}

	@Override
	protected void addSearchKeywords(BooleanQuery searchQuery,
			SearchContext searchContext) throws Exception {
		String keywords = searchContext.getKeywords();

		if (Validator.isNull(keywords)) {
			return;
		}

		searchQuery.addTerms(_DEFAULT_KEYWORDS_FIELDS, keywords);
		searchQuery
				.addTerms(getDynamicSearchabelKeywordsFields(searchContext
						.getCompanyId()), keywords);
	}

	@Override
	protected void postProcessFullQuery(BooleanQuery fullQuery,
			SearchContext searchContext) throws Exception {
		String prefix = "custom_";
		BooleanQuery filterQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		Map<String, Serializable> attributes = searchContext.getAttributes();

		for (Map.Entry<String, Serializable> entry : attributes.entrySet()) {
			String key = entry.getKey();

			if (key.startsWith(prefix)) {
				String value = (String) entry.getValue();

				if (Validator.isNotNull(value)) {
					key = key.substring(prefix.length(), key.length());

					if (!"membershipPackages".equalsIgnoreCase(key)) {
						if (Validator.isNotNull(value)) {
							fullQuery.addRequiredTerm(key, value, false);
						}
					} else {
						String[] mpArray = StringUtil.split(value,
								StringPool.COMMA);

						for (String mp : mpArray) {
							if (Validator.isNotNull(mp)) {
								filterQuery.addTerm(
										Fields_Constants.MEMBERSHIP_PACKAGE, mp
												.trim().toLowerCase(), false);
							}
						}
					}
				}
			}
		}

		if (!filterQuery.clauses().isEmpty()) {
			fullQuery.add(filterQuery, BooleanClauseOccur.MUST);
		}

		String userRegistrationType = "individual";
		fullQuery.addRequiredTerm(Fields_Constants.USER_REGISTRATION_TYPE,
				userRegistrationType, false);
	}

	private static final String[] _DEFAULT_KEYWORDS_FIELDS = {
			Field.ASSET_TAG_NAMES, Field.COMMENTS, Field.CONTENT,
			Field.DESCRIPTION, Field.PROPERTIES, Field.TITLE, Field.URL,
			Field.USER_NAME, Fields_Constants.LOCATION, Fields_Constants.ABOUT,
			Fields_Constants.SKILLS_QUALIFICATION,
			Fields_Constants.TRAINING_EDUCATION, Fields_Constants.TITLE,
			Fields_Constants.INTEREST, Fields_Constants.HONORS,
			Fields_Constants.GROUP_ASSOCIATION, Fields_Constants.FIRST_NAME,
			Fields_Constants.LAST_NAME, Fields_Constants.MIDDLE_NAME,
			Fields_Constants.EMAIL_ADDRESS, Fields_Constants.PORTRAIT_ID,
			Fields_Constants.USER_REGISTRATION_TYPE,
			Fields_Constants.SCREENNAME, Fields_Constants.FULL_NAME,
			Fields_Constants.PROFILE_VIEW_COUNT,
			Fields_Constants.MEMBERSHIP_PACKAGE,
			Fields_Constants.FUNCTIONAL_GROUP, Fields_Constants.JOB_ROLE,
			Fields_Constants.CERTIFICATE, Fields_Constants.COMPETENCY };

	private String[] getDynamicSearchabelKeywordsFields(long companyId)
			throws PortalException, SystemException {
		List<String> dynamicSearchableKeywordsFields = new ArrayList<String>();

		String defaultCommunityName = PropsUtil
				.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);
		Group group = GroupLocalServiceUtil.getGroup(companyId,
				defaultCommunityName);
		long scopeGroupId = group.getGroupId();

		String profielFriendlyURL = StringPool.SLASH
				+ SambaashUtil.getParameter("profile.page.url.private", 0);
		Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(
				scopeGroupId, false, profielFriendlyURL);
		long plid = layout.getPlid();

		ClassLoader cl = PortalClassLoaderUtil.getClassLoader();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
				com.liferay.portal.model.PortletPreferences.class, cl);
		dynamicQuery
				.add(PropertyFactoryUtil.forName("plid").eq(new Long(plid)));
		dynamicQuery.add(PropertyFactoryUtil.forName("portletId").like(
				PORTLET_ID + "%"));

		@SuppressWarnings("unchecked")
		List<PortletPreferences> portletPreferencesList = PortletPreferencesLocalServiceUtil
				.dynamicQuery(dynamicQuery);
		List<String> searchableFields = new ArrayList<String>();

		for (PortletPreferences portletPreferences : portletPreferencesList) {
			String portletId = portletPreferences.getPortletId();
			javax.portlet.PortletPreferences prefs = PortletPreferencesFactoryUtil
					.getPortletPreferencesFactory().getLayoutPortletSetup(
							layout, portletId);

			String xslName = prefs.getValue("name", "");

			if (Validator.isNull(xslName)) {
				continue;
			}

			Map<String, String[]> preferences = prefs.getMap();

			for (Map.Entry<String, String[]> entry : preferences.entrySet()) {
				String key = entry.getKey();

				if ("name".equalsIgnoreCase(key)) {
					continue;
				}

				String[] values = entry.getValue();
				String value = "";

				if (values.length > 0) {
					value = values[0];
				}

				String[] valueArray = value.split(StringPool.COMMA);

				for (int i = 0; i < valueArray.length; i++) {
					String v = valueArray[i];

					if (v.startsWith("searchable")) {
						String[] searchableStaff = v.split(StringPool.COLON);

						if (searchableStaff.length >= 2) {
							if ("true".equalsIgnoreCase(searchableStaff[1])) {
								searchableFields.add(key);
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < searchableFields.size(); i++) {
			String searchableField = searchableFields.get(i);
			dynamicSearchableKeywordsFields.add(searchableField);
			// dynamicSearchableKeywordsFields[i] = searchableField;
		}

		String[] arrayDynamicSearchable = dynamicSearchableKeywordsFields
				.toArray(new String[dynamicSearchableKeywordsFields.size()]);

		return arrayDynamicSearchable;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {

		String firstName = document.get("firstName");
		String middleName = document.get("middleName");
		String lastName = document.get("lastName");

		String title = getFullName(firstName, middleName, lastName);
		String content = null;

		return new Summary(title, content, portletURL);
	}

	private String getFullName(String firstName, String middleName,
			String lastName) {
		String fullName = buildFullName(firstName, middleName, lastName, false);

		if (fullName.length() <= 75) {
			return fullName;
		}

		if (_log.isInfoEnabled()) {
			StringBundler sb = new StringBundler(5);

			sb.append("Full name exceeds ");
			sb.append(75);
			sb.append(" characters for user ");
			sb.append(fullName);
			sb.append(". Full name has been shortened.");

			_log.info(sb.toString());
		}

		fullName = buildFullName(firstName, middleName, lastName, true);

		if (fullName.length() <= 75) {
			return fullName;
		}

		return fullName.substring(0, 75);
	}

	private String buildFullName(String firstName, String middleName,
			String lastName, boolean useInitials) {
		StringBundler sb = new StringBundler(5);

		if (useInitials) {
			firstName = firstName.substring(0, 1);
		}

		sb.append(firstName);

		if (Validator.isNotNull(middleName)) {
			if (useInitials) {
				middleName = middleName.substring(0, 1);
			}

			sb.append(" ");
			sb.append(middleName);
		}

		if (Validator.isNotNull(lastName)) {
			sb.append(" ");
			sb.append(lastName);
		}

		return sb.toString();
	}
	
	public static String getSearchableString(String str){
		str = GetterUtil.getString(str);
		str = str.toLowerCase();
		str = str.replace("?", "");
		str = str.replace("*", "");
		str = str.replace("'", "");
		str = str.replace(" ", "");
		str = str.replace("-", "");
		str = str.replace("_", "");
		str = str.replace("+", "");
		str = str.replace("@", "");
		str = str.replace("&", "");
		str = str.replace(":", "");
		return str;
	}
	
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String FULL_NAME = "fullName";
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String USER_TYPE = "userType";
	public static final String COURSE_NAME = "courseName";

	public static final String PROFILE_TAGGING = "profileTagging";

	public static final String PERSONA = "persona";
	public static final String SUB_PERSONA = "subPersona";

	public static final String COUNTRY_OF_RESIDENCE = "countryOfResidence";
	public static final String SPECIALIZATION = PEConstantsGlobal.SPECIALIZAITON;
	public static final String PRODUCT_COUNTRY = PEConstantsGlobal.PRODUCT_COUNTRY;
	public static final String STAGE = PEConstantsGlobal.STAGE_ID;
	public static final String DEAL_STAGE = PEConstantsGlobal.DEAL_STAGE;
	public static final String PRODUCT = PEConstantsGlobal.ENTITY_ID;
	public static final String SALES_SUPERVISOR = PEConstantsGlobal.USER_ID_SUPERVISOR;
	public static final String SALES_AGENT = PEConstantsGlobal.USER_ID_AGENT;
	public static final String SALES_AGENTNAME = "salesAgentName";
	public static final String USER_MODIFIEDDATE = "userModifiedDate";
	public static final String DOB = "dob";
	
	public Map<String, String> getIndexedFields() {
		Map<String, String> map = new HashMap<String, String>(super.getIndexedFields());
		map.put(FIRST_NAME, "First Name");
		map.put(LAST_NAME, "Last Name");
		map.put(FULL_NAME, "Full Name");
		map.put(PEConstantsGlobal.FULL_NAME_SEARCHABLE, "Full Name Searchable");
		map.put(EMAIL_ADDRESS, "Email Address");
		map.put(USER_TYPE, "User Type");
		map.put(COURSE_NAME, "Course Name (Category List)");
		map.put(COUNTRY_OF_RESIDENCE, "Country Of Residence");
		map.put(SPECIALIZATION, "Specialization");
		map.put(PRODUCT_COUNTRY, "Product Country");
		map.put(STAGE, "Stage");
		map.put(DEAL_STAGE, "Deal Stage");
		map.put(PRODUCT, "Product");
		map.put(SALES_SUPERVISOR, "Sales Supervisor");
		map.put(SALES_AGENT, "Sales Agent");
		map.put(SALES_AGENTNAME, "Sales Agent Name");
		map.put(USER_MODIFIEDDATE, "User Modified Date");
		map.put(PERSONA, "Persona");
		map.put(SUB_PERSONA, "Sub Persona");
		map.put(DOB, "Date of Birth");
		map.put(PROFILE_TAGGING, "Profile Tagging");
		
		return map;
	}

	private static Log _log = LogFactoryUtil.getLog(SocialProfileIndexer.class);

}
