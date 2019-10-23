package com.sambaash.platform.pe.course.enroll;

import static com.silanis.esl.sdk.builder.DocumentBuilder.newDocumentWithName;
import static com.silanis.esl.sdk.builder.PackageBuilder.newPackageNamed;
import static com.silanis.esl.sdk.builder.SignatureBuilder.captureFor;
import static com.silanis.esl.sdk.builder.SignerBuilder.newSignerWithEmail;

import java.io.File;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jsp.PEJSPHelper;
import com.sambaash.platform.srv.model.CourseEnrollContract;
import com.sambaash.platform.srv.model.CourseEnrollEsignInfo;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.service.CourseEnrollEsignInfoLocalServiceUtil;
import com.silanis.esl.sdk.AuthenticationClient;
import com.silanis.esl.sdk.DocumentPackage;
import com.silanis.esl.sdk.EslClient;
import com.silanis.esl.sdk.PackageId;
import com.silanis.esl.sdk.PackageStatus;
import com.silanis.esl.sdk.SigningStatus;
import com.silanis.esl.sdk.builder.CeremonyLayoutSettingsBuilder;
import com.silanis.esl.sdk.builder.DocumentBuilder;
import com.silanis.esl.sdk.builder.DocumentPackageSettingsBuilder;
import com.silanis.esl.sdk.builder.FieldBuilder;
import com.silanis.esl.sdk.builder.PackageBuilder;
import com.silanis.esl.sdk.io.Files;

/**
 * This class is used to handle Esign integration for Course enrollment
 * 
 * @author nareshchebolu
 *
 */
public class CourseEnrollEsignEngine extends PEJSPHelper {

	

	public static String COMPLETED = "completed";
	private static String STATUS_SIGNING_PENDING = "SIGNING_PENDING";
	
	public CourseEnrollEsignEngine(PEDataSource ds,PEJSP jspNode){
		super(ds, jspNode);
	}
	
	public static CourseEnrollEsignEngine getInstance(PEDataSource ds,PEJSP jspNode){
		return new CourseEnrollEsignEngine(ds,jspNode);	
	}
	
	public boolean isExternalDataSubmission(){
		return true;
	}
	
	/**
	 *  This method returns the values as below
	 *  
	 * @return url to contract where user able to put his signature
	 *       If the signing process not yet initiated or in pending
	 *       
	 *       PEEsignEngine.COMPLETED if the signing process is already completed
	 * 
	 * @throws PEException
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public String getSignInUrl() throws PEException, SystemException, PortalException{
		// check the status
		// if status is in progress then just create the url and return it
		// if status is completed return "completed"
		// otherwise createpacakge and return the url
		PEProcessState processState = ds.getProcessState();
		CourseEnrollEsignInfo info = CourseEnrollEsignInfoHelper.getEsignInfo(processState.getSpPEProcessStateId(), false);
		String url = StringPool.BLANK;
		EslClient  eslClient = new EslClient(CourseEnrollEsignHelper.getApiKey(ds),CourseEnrollEsignHelper.getApiUrl(ds),CourseEnrollEsignHelper.getWebPageUrl(ds.getRequestData()));

		// check for info created ..
		if(!CourseEnrollEsignInfoHelper.isEsignInfoExists(processState.getSpPEProcessStateId())){
			// Esign Info does not exist. so go ahead with creating new package
			url = createEsignPkgAndGetUrl();
		}else{
			// package already created. so check the status whether user has completed signing process
			
			// Commenting the below code because the authentication token expires in 30mins. So the learner will not be able to download the signed contract after 30 mins.
			/*String status = CourseEnrollEsignHelper.getStatus(eslClient, info);
			if(STATUS_SIGNING_PENDING.equalsIgnoreCase(status)){
				// User not yet completed the signature. So generate new url ( new session toke) and send it
				url = generatedLinkToSigningSession(eslClient, info.getPackageId(), info.getSignerId());
				info.setLastGeneratedUrl(url);
				CourseEnrollEsignHelper.updateEsignInfo(info, ds.getRequestData());;
				//EsignInfoLocalServiceUtil.updateEsignInfo(info);
			}else{
				// looks process is completed.
				url = COMPLETED;
			}*/

			CourseEnrollEsignInfo esignInfo = CourseEnrollEsignInfoHelper.getEsignInfo(processState.getSpPEProcessStateId(),false);
			url = esignInfo.getLastGeneratedUrl();
		}

		return url;
	}
	public boolean isCompleted(){
		try {
			boolean completed  = isSigningCompleted();
			if(!completed){
				try {
						// to generate the package upfront if it's not created yet..
					if (jspNode.isSubmittableByUser()){
						getSignInUrl();
					}
				} catch (PortalException | PEException e) {
					_log.error(e);
				}
				//TODO:Generate the url
			}
			return completed;
		} catch (SystemException e) {
			_log.error(e);
		}
		return false;
	}
	public boolean isSigningCompleted() throws SystemException {
		// check the status
		// if status is in progress then just create the url and return it
		// if status is completed return "completed"
		// otherwise createpacakge and return the url
		PEProcessState processState = ds.getProcessState();
		CourseEnrollEsignInfo info = CourseEnrollEsignInfoHelper.getEsignInfo(processState.getSpPEProcessStateId(), false);
		
		// check for info created ..
		if(!CourseEnrollEsignInfoHelper.isEsignInfoExists(processState.getSpPEProcessStateId())){
			return false;
		}else{
			EslClient  eslClient = new EslClient(CourseEnrollEsignHelper.getApiKey(ds),CourseEnrollEsignHelper.getApiUrl(ds),CourseEnrollEsignHelper.getWebPageUrl(ds.getRequestData()));
			// package already created. so check the status whether user has completed signing process
			String status = CourseEnrollEsignHelper.getStatus(eslClient, info);
			if(STATUS_SIGNING_PENDING.equalsIgnoreCase(status)){
				return false;
			}
		}
		return true;
	}
	public void extraCallBackAfterSubmit(){
		ds.setNodeIdDataSubmitted(jspNode.getNodeId());
	}
	public void preprocess(){
		try {
			// just to make sure esign package getting created in first visit to this jsp node.
			if (jspNode.isSubmittableByUser()){
				getSignInUrl();
			}
		} catch (SystemException | PortalException | PEException e) {
			
			_log.error(e);
		}
	}
	public String downloadSignedDocuments(){

		String filePath = StringPool.BLANK;
		// connect to e-SignLive
		EslClient eslClient = new EslClient(CourseEnrollEsignHelper.getApiKey(ds), CourseEnrollEsignHelper.getApiUrl(ds));

		CourseEnrollEsignInfo esignInfo;
		try {
			esignInfo = CourseEnrollEsignInfoHelper.getEsignInfo(ds.getProcessState().getSpPEProcessStateId(), false);
		} catch (SystemException e) {
			_log.error(e);
			return filePath;
		}
		// create a packageId using you packageId string
		PackageId packageId = new PackageId(esignInfo.getPackageId());

		// get your package
		DocumentPackage sentPackage = eslClient.getPackage(packageId);

		// checking package status
		PackageStatus status = sentPackage.getStatus();
		_log.debug("package Id = " + esignInfo.getPackageId() + ". Status=" + status);

		// checking signing status
		SigningStatus sentSigningStatus = eslClient.getSigningStatus(packageId,
				null, null);
		_log.debug("package Id = " + esignInfo.getPackageId() + ". Signing Status=" + sentSigningStatus.getToken());

		// if signing is complete, download all documents
		if (sentSigningStatus.getToken() == "SIGNING_PENDING") {
			_log.debug("package Id = " + esignInfo.getPackageId() + ". Cannot Download: Signing not complete");
		} else {
			// download zip file
			byte[] documentZip = eslClient.downloadZippedDocuments(packageId);
			filePath = generateFilePath();
			Files.saveTo(documentZip, filePath);
			_log.debug("Document Zip File Downloaded");

		}
	
		return filePath;
	}
	
	private String generateFilePath(){
		String name = "contract" + "_" + System.currentTimeMillis() + "_"
				+ ds.getRequestData().getUserId() + ".zip";
		return System.getProperty("java.io.tmpdir") + File.separator + name;
	}
	
	/**
	 *  Method used to create the esign pacakge.
	 * 
	 * @return
	 * @throws PEException
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	private String createEsignPkgAndGetUrl() throws PEException, SystemException, PortalException{
		// signature will be created for applicant
		User applicant = ds.getApplicant();
		String signerId = CourseEnrollEsignHelper.getSignerId();
		_log.debug("Esign SignerId " + signerId);
		
		
		EslClient  eslClient = new EslClient(CourseEnrollEsignHelper.getApiKey(ds),CourseEnrollEsignHelper.getApiUrl(ds),CourseEnrollEsignHelper.getWebPageUrl(ds.getRequestData()));
    	
		PackageBuilder packageBuilder= newPackageNamed(CourseEnrollEsignHelper.getPackageName(applicant))
	                .describedAs("Contract")
	                .withSigner(newSignerWithEmail(applicant.getEmailAddress())
	                        .withFirstName(applicant.getFirstName())
	                        .withLastName(applicant.getLastName())
	                        .withTitle(applicant.getJobTitle())
	                        //.withCompany(applicant.getco)
	                        .withCustomId(signerId)
	                )

	                .withSettings(DocumentPackageSettingsBuilder.newDocumentPackageSettings()
	                        .withoutInPerson()
	                        .withoutOptOut()
	                        .withOptOutReason("Decline terms.")
	                        .withoutLanguageDropDown()
	                        .hideOwnerInPersonDropDown()
	                        .disableFirstAffidavit()
	                        .disableSecondAffidavit()
	                        .withoutDecline()
	                        .withoutWatermark()
	                        .withoutCaptureText()
	                        
	                        /*.withHandOverLinkHref(CourseEnrollEsignHelper.getHandOverLink())
	                        .withHandOverLinkText("Exit to site")
	                        .withHandOverLinkTooltip("You will redirected to  dashboard")*/
	                        .withDocumentToolbarDownloadButton()
	                        .withoutDialogOnComplete()
	                        .withCeremonyLayoutSettings(CeremonyLayoutSettingsBuilder.newCeremonyLayoutSettings()
	                                .withoutNavigator()
	                                .withoutGlobalNavigation()
	                                .withoutBreadCrumbs()
	                                .withoutSessionBar()
	                                .withoutTitle()
	                                .withProgressBar()
	                                .withIFrame()
	                                .withoutGlobalConfirmButton()
	                                .withoutGlobalDownloadButton()
	                                .withoutGlobalSaveAsLayoutButton()
	                                ));
		
		CourseEnrollContractHelper contractHelper = CourseEnrollContractHelper.getContractHelper(ds);
		List<CourseEnrollContract> contractDocList = contractHelper.getContractTemplates();
		CourseEnrollDataAdapter dataAdapter = CourseEnrollDataAdapter.getCourseEnrollAdapter(ds);
		for (CourseEnrollContract contractDoc : contractDocList) {
			if(dataAdapter.isStudentMinor()){
				if(!contractDoc.getDocType().equalsIgnoreCase("advisoryNoteMajor")){
					packageBuilder.withDocument(getDocumentBuilder(contractDoc.getExtraInfo(), contractHelper.getContractFilePath(contractDoc),contractDoc.getDocType(), dataAdapter));
				}
			}else{
				if(!contractDoc.getDocType().equalsIgnoreCase("advisoryNoteMinor")){
					packageBuilder.withDocument(getDocumentBuilder(contractDoc.getExtraInfo(), contractHelper.getContractFilePath(contractDoc),contractDoc.getDocType(), dataAdapter));
				}
			}
		}

        DocumentPackage packageToCreate = packageBuilder.build();
		
        PackageId packageId = eslClient.createPackage(packageToCreate);
  	   // Send the package to be signed by the participants
	    eslClient.sendPackage( packageId );
	    _log.debug("Esign Package created. Package id " + packageId.getId());
	    _log.debug(packageId);
        
//        Document document = packageToCreate.getDocument(DOCUMENT_NAME);
  //      _log.debug("Esign Document Id " + document.getId().getId());
        PEProcessState processState = ds.getProcessState();
        
        CourseEnrollEsignInfo esignInfo = CourseEnrollEsignInfoHelper.getEsignInfo(processState.getSpPEProcessStateId(),true);
        esignInfo.setSignerId(signerId);
        esignInfo.setPackageId(packageId.getId());
    //    esignInfo.setDocumentId(document.getId().getId());
        
        String url = generatedLinkToSigningSession(eslClient, packageId,signerId);
        esignInfo.setLastGeneratedUrl(url);
        PEProcessStateDataAdapter processDataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(processState);
        processDataAdapter.store("packageId", esignInfo.getPackageId());
        processDataAdapter.store("esignUrl", url);
        
        addExtraInfo(esignInfo);
        CourseEnrollEsignHelper.updateEsignInfo(esignInfo, ds.getRequestData());;
        _log.info("Esign Info created for process state." + processState.getSpPEProcessStateId()) ;
        return url;
	}
	
	private String generatedLinkToSigningSession(EslClient eslClient,PackageId packageId, String signerId){
		
		// Commenting the below code because the authentication token expires in 30mins. So the learner will not be able to download the signed contract after 30 mins.
		/*final String signerAuthenticationToken = eslClient.getAuthenticationTokensService().createSignerAuthenticationToken(packageId, signerId);
		_log.debug("signerAuthenticationToken : " + signerAuthenticationToken);
         This value is ready to be used in a cookie header (or alternatively set as a cookie on the browser).
         * It is a signing session valid in the same way as clicking in an email except it is limited to signing operations on the package for which
         * it was created (accept consent, sign, fill-out fields).
         
        AuthenticationClient authenticationClient = new AuthenticationClient(CourseEnrollEsignHelper.getApiUrl());
        String sessionIdForSigner = authenticationClient.getSessionIdForSignerAuthenticationToken(signerAuthenticationToken);

        _log.debug("sessionIdForSigner : " + sessionIdForSigner);

        String generatedLinkToSigningSession = authenticationClient.buildRedirectToSigningForSigner(signerAuthenticationToken, packageId);

        _log.debug("generatedLinkToSigningSession : " + generatedLinkToSigningSession);*/
        
        
		String generatedLinkToSigningSession = eslClient.getPackageService().getSigningUrl(packageId, signerId);
        _log.debug("Esign Contract generated Url for signing " + generatedLinkToSigningSession);
        return generatedLinkToSigningSession;
	}
	

	
	
	
	private DocumentBuilder getDocumentBuilder(String signingINfo,String filePath,String docName, CourseEnrollDataAdapter dataAdapter ) throws PEException, PortalException, SystemException{
		try{
			// Getting sign posistion
			int signPageNumber = 0;
			int signXPosition = 0;
			int signYPosition = 0;
			int datePageNumber = 0;
			int dateXPosition = 0;
			int dateYPosition = 0;
			int dateWidth = 85;
			int dateHeight = 35;
			try{
				JSONObject obj = JSONFactoryUtil.createJSONObject(signingINfo);
				// to check whether Gaurdian is requred
				if(dataAdapter.isStudentMinor()){
					signXPosition = obj.getInt("gaurdianSignXPosition");
					signYPosition = obj.getInt("gaurdianSignYPosition");
					dateXPosition = obj.getInt("gaurdianSignDateXPosition");
					dateYPosition = obj.getInt("gaurdianSignDateYPosition");
					signPageNumber = obj.getInt("gaurdianSignPageNumber");
					datePageNumber = obj.getInt("gaurdianSignDatePageNumber");
					dateWidth = obj.getInt("gaurdianSignDateWidth");
					dateHeight = obj.getInt("gaurdianSignDateHeight");
				}else{
					signXPosition = obj.getInt("studentSignXPosition");
					signYPosition = obj.getInt("studentSignYPosition");
					dateXPosition = obj.getInt("studentSignDateXPosition");
					dateYPosition = obj.getInt("studentSignDateYPosition");
					signPageNumber = obj.getInt("studentSignPageNumber");
					datePageNumber = obj.getInt("studentSignDatePageNumber");
					dateWidth = obj.getInt("studentSignDateWidth");
					dateHeight = obj.getInt("studentSignDateHeight");
				}
				
			}catch(Exception ex){
				_log.error("Error while reading sign info",ex);
				throw new PEException("Error while reading Sign info");
			}
			
			User applicant = ds.getApplicant();
			DocumentBuilder documentBuilder = newDocumentWithName(docName)
					.fromFile(filePath)
					.withSignature(captureFor( applicant.getEmailAddress())
							.onPage(signPageNumber)
							.atPosition(signXPosition,signYPosition).withField(FieldBuilder.signatureDate()
																.onPage( datePageNumber ) 
															    .atPosition( dateXPosition, dateYPosition)
															    .withSize( dateWidth, dateHeight))
							);
			return documentBuilder;
			
		}finally{
			try {
				//contractTemplIS.close();
			} catch (Exception e) {
				_log.error(e);
			}
		}
	}
	
	private void addExtraInfo(CourseEnrollEsignInfo info){
		try{
			JSONObject extra = JSONFactoryUtil.createJSONObject(GetterUtil.getString(info.getExtraInfo()));
			PERequestData  requestData =ds.getRequestData();
			extra.put(PEConstants.KEY_PORTAL_URL, requestData.getPortalUrl());
			extra.put(PEConstants.KEY_SIGNIN_URL, requestData.getSignInUrl());
			info.setExtraInfo(extra.toString());
		}catch(Exception ex){
			_log.error(ex);
		}
	}
	
	private static final Log _log = LogFactoryUtil.getLog(CourseEnrollEsignEngine.class);
	private static final String DOCUMENT_NAME ="studentcontract";
}
