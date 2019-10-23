package com.sambaash.platform.pe.course.enroll;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.sambaash.platform.constant.FormConstants;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEEntityClassRegister;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.cache.PEProcessDirectoryHelper;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.convert.PEFormDS;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEApplicantFileUploadHelper;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jsp.PEJSPHelper;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class CourseEnrollRegisterInterestJSPHelper extends PEJSPHelper{

	private JSONObject params; 

	private CourseEnrollRegisterInterestJSPHelper(PEDataSource ds, PEJSP jspNode){
		super(ds,jspNode);
	}
	
	private void initParams(String dataStr){
		try {
			params = JSONFactoryUtil.createJSONObject(dataStr);
		} catch (JSONException e) {
			_log.error(e);
			params = JSONFactoryUtil.createJSONObject();
		}
	}
	
	public static CourseEnrollRegisterInterestJSPHelper getInstance(PEDataSource ds, PEJSP jspNode){
		return new CourseEnrollRegisterInterestJSPHelper(ds, jspNode);
	}
	
	/**
	 *  Method used to get the data submitted by user.
	 * @return
	 */
	public String getData(){
		PEProcessAudit  audit = null;
		String dataStr = StringPool.BLANK;
		try{
			  audit = PEProcessAuditLocalServiceUtil.getLatestAudit(ds.getProcessState().getSpPEProcessStateId(), jspNode.getNodeId());
		}catch(Exception ex){
			_log.error(ex);
		}
		if(audit != null){
			dataStr = audit.getData1();
			
			//Get CV title and Download url
			initParams(dataStr);
			long cvFeId = params.getLong("CVFileEntryId");
			if(cvFeId != 0){
				FileEntry fileEntry;
				try {
					fileEntry = DLAppServiceUtil.getFileEntry(cvFeId);
					String url = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), null, "");
					params.put("CVTitle", fileEntry.getTitle());
					params.put("CVDownloadUrl", url);
					dataStr = params.toString();
				} catch (PortalException | SystemException e) {
					_log.error(e);
				}
			}
			
			//Get the product name
			if(Validator.isNotNull(params.getLong("productId"))){
				long productId = params.getLong("productId");
				params.put("productName", getProductName(productId));
			}
			dataStr = params.toString();
		}else{
			params = JSONFactoryUtil.createJSONObject();
			// Fetch from first screen.. first time
			String firstName = ds.getDataFromProcessState("firstName");
			String lastName  = ds.getDataFromProcessState("lastName");
			String email = ds.getDataFromProcessState("emailAddress");
			String mobile = ds.getDataFromProcessState("mobileNumber");
			//if the application coming from product catalog select the product by default
			if(PEEntityClassRegister.getName(ds.getProcessState().getEntityClassId()).equals(Product.class.getName())){
				params.put("productName", getProductName(ds.getProcessState().getEntityId()));
				params.put("productId", ds.getProcessState().getEntityId());
			}
			
			
			params.put("firstName", firstName);
			params.put("lastName", lastName);
			params.put("emailAddress", email);
  			params.put("mobileNumber", mobile);
  			
  			JSONObject info =  getProfileAttachementInfo();

  			if(Validator.isNotNull(info)){
				String title = info.getString(FormConstants.KEY_ATTACHMENT_NAME);
				
				if(Validator.isNotNull(title)){
					String url = info.getString(PEFormDS.KEY_FULL_URL);
					params.put("CVTitle", title);
					params.put("CVDownloadUrl", url);
					params.put("CVFileEntryId", url);
				}
  			}
  			
  			String value;
			try {
				value = SambaashUtil.getParameter(PEConstants.PERSONA_SUB_PERSONA_FIELD_NAMES, 0);

				String[] fieldNames = value.split(StringPool.COMMA);

				String config = SambaashUtil.getParameter(SambaashConstants.SOCIAL_PROFILE_INDEXER_EXTRA_INFO_CONFIG, 0);
				JSONObject configJ = JSONFactoryUtil.createJSONObject(config);
				
				JSONObject personaConfJ = JSONFactoryUtil.createJSONObject(configJ.getString("persona"));
				String personaFormName = personaConfJ.getString("formName");
				
				JSONObject subPersonaConfJ = JSONFactoryUtil.createJSONObject(configJ.getString("subPersona"));
				String subPersonaFormName = subPersonaConfJ.getString("formName");
				
				String personaName = getUserInfoValue(ds.getProcessState()
						.getUserIdProcess(), personaFormName, fieldNames[0]);
				String subPersonaName = getUserInfoValue(ds
						.getProcessState().getUserIdProcess(), subPersonaFormName, fieldNames[1]);

				params.put("persona", String.valueOf(getAsssetCategoryId(personaName)));
				params.put("subPersona", String.valueOf(getAsssetCategoryId(subPersonaName)));

			} catch (Exception e) {
				_log.error(e);
			}
  			
			dataStr = params.toString();
			
		}
		return dataStr;
	}
	
	private JSONObject getProfileAttachementInfo(){
		PEProcessDirectoryHelper helper = PEProcessDirectoryHelper.getPEDirectoryHelper(ds.getDirectory());
		try {
			PEForm formNode = helper.getNodeForFieldId("profile");
			String formFieldId = formNode.getFormFieldIdForProcessField("profile");
			PEFormDS formDs = new PEFormDS(ds, formNode);
			return formDs.getAttachmentInfo(formFieldId);
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}
		return null;
	}
	
	private String validate() {
		String email = params.getString("emailAddress");
		if (Validator.isNull(email) || !Validator.isEmailAddress(email)) {
			return "Undeliverable - Invalid Email Address";
		}
		boolean emailAddressVerification = GetterUtil.getBoolean(params
				.getString("emailAddressVerification"));

		if (emailAddressVerification) {
			// Call to ApI
			RestTemplate restTemplate = new RestTemplate();
			
			String url = SambaashUtil.getParameter(SambaashConstants.API_EMAIL_VALIDATION, SambaashConstants.DEFAULT_GROUP_ID_LONG);
			url = StringUtil.replace(url, new String[]{"[EMAIL_ADDRESS]"}, 
					new String[]{String.valueOf(email)});
			
			String str = restTemplate.getForEntity(url, String.class).getBody();
			try {
				JSONObject obj = JSONFactoryUtil.createJSONObject(str);
				String result = obj.getString("result");
				if (result.equalsIgnoreCase("undeliverable")) {
					return "Undeliverable - Invalid Email Address";
				} else if (result.equalsIgnoreCase("unknown")) {
					return "Unknown - The destination mail server is too slow or temporarily unavailable. In some cases, retrying your request after about 5 minutes will return a valid or invalid response. If you still want to continue, click on Save";
				} else if (result.equalsIgnoreCase("risky")) {
					return "Risky - The email address has quality issues that may result in a bounce or low engagement. If you still want to continue, click on Save";
				}

			} catch (JSONException e) {
				_log.error(e);
				return "Error while verifying emailaddress";
			}
		}

		return StringPool.BLANK;
	}

	public PESimpleOutput save() throws PEException {

		initParams(ds.getFormJspData());

		// Validations

		PESimpleOutput output = new PESimpleOutput();
		String error = validate();

		if (Validator.isNotNull(error)) {
			output.addValidationMsg(error);
			return output;
		}
	
		// Move the file from temp folder to actual folder
		PEApplicantFileUploadHelper uploader = PEApplicantFileUploadHelper
				.getInstance(ds.getRequestData().getScopeGroupId(), ds
						.getRequestData().getCompanyId(), ds.getProcessState()
						.getSpPEProcessStateId());
		String fileUrl = params.getString("CVFileEntryId");
		long fileEntryId = params.getLong("CVFileEntryId");
		
		if(fileEntryId > 0 ){
			try {
				uploader.moveFileToApplicantFolder(fileEntryId);
			} catch (PortalException | SystemException e) {
				_log.error(e);
				output.addValidationMsg("Error while uploading your Curriculum Vitae");
				return output;
			}
		}else if(fileUrl.startsWith("http")){
			//This case happend when file is copied from first step and the file is not changed by user
			try {
				JSONObject info =  getProfileAttachementInfo();
				if (Validator.isNotNull(info)){
					String title = info.getString(FormConstants.KEY_ATTACHMENT_NAME);
					if(Validator.isNotNull(title)){
						String url = info.getString(PEFormDS.KEY_FULL_URL);
						FileEntry fileEntry = uploader.storeFileToApplicantFolder(url, title);
						params.put("CVFileEntryId", fileEntry.getFileEntryId());
					}
				}
			} catch (PortalException | SystemException | IOException e) {
				_log.error("Error while saving the file");
				_log.error(e);
			}
		}

		// Audit
		audit(params.toString());

		// update user
		User user;
		try {
			user = UserLocalServiceUtil.getUser(ds.getProcessState().getUserIdProcess());
			user.setFirstName(params.getString("firstName"));
			user.setLastName(params.getString("lastName"));
			user.setEmailAddress(StringUtil.toLowerCase(params.getString("emailAddress").trim()));
			user.setModifiedDate(new Date());
			UserLocalServiceUtil.updateUser(user);
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}
		
		//update user profile
		updateUserProfile(ds.getProcessState().getUserIdProcess());
	

		// Success message
		output.setSuccessMsg("Details saved successfully");
		output.setData(params);
		return output;
	}

	public String loadProducts() { 
		JSONArray array = JSONFactoryUtil.createJSONArray();
		try {
			List<Product> productList = ProductLocalServiceUtil.findByStatus(1, -1, -1);
			for (Product product : productList) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				String productName = getProductName(product);
				obj.put("code", productName);
				obj.put("key", product.getSpProductId());
				array.put(obj);
			}
		} catch (SystemException |  PortalException e) {
			_log.error(e);
		}
		
		if (array.length() > 0) {
			return JSONFactoryUtil.looseSerialize(array);
		} else {
			return StringPool.BLANK;
		}
	}
	
	private String getProductName(long productId) {
		Product product;
		try {
			product = ProductLocalServiceUtil.getProduct(productId);
			return getProductName(product);
		} catch (PortalException | SystemException e) {
			return StringPool.BLANK;
		}
	}
	private String getProductName(Product product){
		if(product != null){
			AssetCategory cAsset;
			try {
				if(GetterUtil.getLong(product.getCountryId()) > 0){
					cAsset = AssetCategoryLocalServiceUtil.getAssetCategory(GetterUtil.getLong(product.getCountryId()));
					String productName = product.getProductName() + " - " + cAsset.getName();
					return productName;
				}
			} catch ( PortalException | SystemException e) {
				return product.getProductName();
			}
		}
		return StringPool.BLANK;
	}
	
	public void updateUserProfile(long userId){
		try {
			
			SocialProfile profileUser = SocialProfileLocalServiceUtil.getSocialProfile(userId);
			
			String subPersona = AssetCategoryLocalServiceUtil.getCategory(GetterUtil.getLong(params.getString("subPersona"))).getName();
			String persona = AssetCategoryLocalServiceUtil.getCategory(GetterUtil.getLong(params.getString("persona"))).getName();
			
			String[] fieldValues = {persona, subPersona};
		
			
			String value = SambaashUtil.getParameter(PEConstants.PERSONA_SUB_PERSONA_FIELD_NAMES, 0);
			String[] fieldNames = value.split(StringPool.COMMA);
			for (int i=0; i < fieldNames.length; i++){
				String resultXML = SocialProfileLocalServiceUtil
						.updateSingleNodeField(profileUser.getUserInfo(),
								fieldNames[i], fieldValues[i]);
				profileUser.setUserInfo(resultXML);
			}
			
			SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		
	}
	

	public String getUserInfoValue(long userId, String formName, String fieldName){
		return SocialProfileLocalServiceUtil.getFormFieldValue(userId, formName, fieldName);
	}
	
	
	public long getAsssetCategoryId(String assetCategoryName) {
		long assetCatId = 0;
		try {
			String optionId = SambaashUtil.getParameter(PEConstants.PERSONA_VOCABULARY_ID, 0);
			List<AssetCategory> assetCatList = AssetCategoryLocalServiceUtil.getVocabularyCategories(GetterUtil.getLong(optionId), -1, -1, null);

			for (AssetCategory assetCat : assetCatList) {
				if (assetCat.getName().equalsIgnoreCase(assetCategoryName)) {
					assetCatId = assetCat.getCategoryId();
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return assetCatId;
	}
	

	private static final Log _log = LogFactoryUtil.getLog(CourseEnrollRegisterInterestJSPHelper.class);
}
