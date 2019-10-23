package com.sambaash.platform.spchallenge.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.time.StopWatch;

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.OpenSearch;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.spchallenge.helper.SPChallengeConstants;
import com.sambaash.platform.spchallenge.helper.SPChallengeHelper;
import com.sambaash.platform.spchallenge.helper.SPChallengeMailHelper;
import com.sambaash.platform.spchallenge.helper.SPChallengePermissionHelper;
import com.sambaash.platform.spchallenge.reports.ChallengeApplicantsExporter;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class SPChallengeApplicantAction
 */
public class SPChallengeApplicantAction extends MVCPortlet {

	private static final String PITCH_DAY = "pitchDay";
	private static final String INTRODUCTION = "introduction";

	private static final Log logger = LogFactoryUtil
			.getLog(SPChallengeApplicantAction.class);

	public void searchAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		search(actionRequest, actionResponse);
		actionResponse.setRenderParameter("jspPage",
				"/html/spchallengeapplicant/view.jsp");
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		this.search(renderRequest, renderResponse);
		super.doView(renderRequest, renderResponse);
	}

	public void search(PortletRequest request, PortletResponse response)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String viewMode = GetterUtil.getString(request
				.getParameter(SPChallengeConstants.VOC_VIEW_MODE));

		if (Validator.isNull(viewMode)) {
			viewMode = request.getPreferences().getValue(
					SPChallengeConstants.VOC_VIEW_MODE,
					SPChallengeConstants.VOC_VIEW_SLIDER);
		}

		request.setAttribute(SPChallengeConstants.VOC_VIEW_MODE, viewMode);

		if (!viewMode.equalsIgnoreCase(SPChallengeConstants.VOC_VIEW_SLIDER)) {
			String action = getActionParam(request);

			List<String> headerNames = new ArrayList<String>();
			headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.startup"));
			headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.challenge.applied"));
			boolean responseMode = SPChallengeConstants.ACTION_RESPOND_TO_APPLICANTS.equals(action);
			request.setAttribute("responseMode", responseMode);
			if (responseMode) {
				headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.email"));
				headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.successful"));
				headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.maybe"));
				headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.unsuccessful"));
			} else {
				headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.applied.on"));
				headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.challenge.end.date"));
				headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.successful"));
				headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.maybe"));
				headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.unsuccessful"));
				headerNames.add(LabelUtil.getLabel(portletConfig,themeDisplay,"label.actions"));				
			}

			PortletURL portletURL = getRenderUrl(
					SPChallengeConstants.APPLICANT_PORTLET_ID, request,
					themeDisplay);
			SearchContainer<SPChallengeApplicantAction> searchContainer = new SearchContainer<SPChallengeApplicantAction>(
					request, null, null, SearchContainer.DEFAULT_CUR_PARAM,
					SearchContainer.DEFAULT_DELTA, portletURL, headerNames,
					responseMode?"No Updated Applications to be Notified!":"No Applications received!");

			addSearchAttributes(request, portletURL);
			portletURL.setParameter(searchContainer.getCurParam(),
					String.valueOf(searchContainer.getCur()));
			portletURL.setParameter(SPChallengeConstants.VOC_VIEW_MODE,
					SPChallengeConstants.VOC_VIEW_LIST);
			portletURL.setParameter(SPChallengeConstants.VOC_VIEW_MODE,
					SPChallengeConstants.VOC_VIEW_LIST);

			Hits results = searchDocuments(themeDisplay, request,
					searchContainer.getStart(), searchContainer.getEnd());
			boolean hasRows = results.getLength() > 0;
			request.setAttribute("hasRows", hasRows);
			try {
				if (results != null) {
					searchContainer.setTotal(results.getLength());
					List<ResultRow> resultRows = searchContainer
							.getResultRows();
					int length = results.getDocs().length;
					for (int i = 0; i < length; i++) {
						try {
							Document doc = results.doc(i);
							long classPK = GetterUtil.getLong(doc
									.get(Field.ENTRY_CLASS_PK));
							ResultRow row = new ResultRow(doc, classPK, i);

							String orgName = doc
									.get(SPChallengeConstants.ORGANIZATION_NAME);
							String startupProfileUrl = SPChallengeHelper.displayStartupProfileFriendlyURL(
									themeDisplay,
									GetterUtil.getLong(doc
											.get(SPChallengeConstants.APPLICANT_REF_ID)));
							String challengeUrl = SPChallengeHelper.displayChallengeFriendlyURL(
									themeDisplay,
									GetterUtil.getLong(doc
											.get(SPChallengeConstants.CHALLENGE_ID)),
									StringPool.DASH);
							
							String applAcceptedClass = "statuspending";
							String applRejectedClass = "statuspending";
							String applMaybeClass = "statuspending";
							int applStatus = GetterUtil.getInteger(doc.get(SPChallengeConstants.APPLICATION_STATUS));
							if (SPChallengeConstants.APPLICATION_ACCEPTED==applStatus) {
								applAcceptedClass = "Sucess";
								applRejectedClass = "";
								applMaybeClass = "";
							} else if (SPChallengeConstants.APPLICATION_REJECTED==applStatus){
								applAcceptedClass = "";
								applRejectedClass = "Sucess";
								applMaybeClass = "";
							} else if (SPChallengeConstants.APPLICATION_KEEP_IN_VIEW==applStatus){
								applAcceptedClass = "";
								applRejectedClass = "";
								applMaybeClass = "Sucess";
							}
							
							row.addText("<div class='applicantStartup'><p><a href='"
									+ startupProfileUrl
									+ "'>" + orgName + "</a></p></div>");

							String challengeName = doc
									.get(SPChallengeConstants.CHALLENGE_NAME);
							row.addText("<div class='applicantChallenge'> <p><a href='"
									+ challengeUrl
									+ "'>"
									+ challengeName + "</a></p></div>");
							if (responseMode) {
								row.addText(doc.get(SPChallengeConstants.ORGANIZATION_OWNER));
							} else {
								row.addText(DateUtil.getDate(
										doc.getDate(Field.MODIFIED_DATE),
										"MMM dd, yyyy", Locale.ENGLISH));

								row.addText(DateUtil.getDate(
										doc.getDate(SPChallengeConstants.END_DATE),
										"MMM dd, yyyy", Locale.ENGLISH));								
							}
							
							String onClickStatus = "";
//							if (responseMode) {
								onClickStatus = "onclick='updateApplicationStatus(this, "+ doc.get(SPChallengeConstants.CHALLENGE_APPLICANT_ID) + ")'";
//							}
							
							row.addText("<div class='cmi-applicationstatus' style='width: 100%;' id='successColumn_"+ doc.get(SPChallengeConstants.CHALLENGE_APPLICANT_ID) + "'>"
                            +"<div class='statusSec "+applAcceptedClass+"'>"
                            +"    <a href='#' op='approve' "+ onClickStatus + " >"
                            +"        <svg version='1.1' id='Layer_1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' x='0px' y='0px' viewBox='0 0 24 24' style='enable-background:new 0 0 24 24;' xml:space='preserve'>"
                            +"            <g>"
                            +"                <path class='sucessImage' d='M11.8,0c-3.1,0-5.9,1.2-8,3.2c-2.2,2.1-3.7,5-3.8,8.3c0,0,0,0,0,0.1l0,0c0,0,0,0,0,0s0,0.1,0,0.1C-0.2,18.2,5,23.7,11.6,24c6.6,0.3,12.2-4.9,12.4-11.5C24.2,5.8,19.1,0.2,12.4,0C12.2,0,12,0,11.8,0L11.8,0z M11.8,0.4c0.2,0,0.4,0,0.6,0C18.8,0.6,23.9,6,23.6,12.4c-0.2,6.4-5.6,11.4-12.1,11.2C5.1,23.4,0.1,18,0.3,11.6v0c0,0,0,0,0,0v0c0.1-3.2,1.6-6,3.7-8.1C6.1,1.6,8.9,0.4,11.8,0.4L11.8,0.4z' />"
                            +"                <polygon class='sucessImage' points='10.8,16.3 7.3,12.7 7.7,12.4 11.1,15.8 16.3,9 16.7,9.3 11.5,16.2 ' />"
                            +"            </g>"
                            +"        </svg>"
                            +"    </a>"
                            +"    <span class='tooltiptext'>"
                            +"     Successful"
                            +"    </span>"
                            +"</div>"
                            +"</div>");	
							
							row.addText("<div class='cmi-applicationstatus' style='width: 100%;' id='mayBeColumn_"+ doc.get(SPChallengeConstants.CHALLENGE_APPLICANT_ID) + "'>"
		                            +"<div class='maybbeStatus statusSec "+applMaybeClass+"'>"
		                            +"    <a href='#' op='maybe' "+ onClickStatus + " >"
		                            +"        <svg xmlns='http://www.w3.org/2000/svg' width='48' height='48' viewBox='0 0 48 48'>"
		                            +" 			<g>"
		                            +"   			<path class='maybeImage' d='M24,47.5 C11.0213084,47.5 0.5,36.9786916 0.5,24 C0.5,11.0213084 11.0213084,0.5 24,0.5 C36.9786916,0.5 47.5,11.0213084 47.5,24 C47.5,36.9786916 36.9786916,47.5 24,47.5 Z'/>"
		                            +"				<text font-family='Multicolore, Multicolore' font-size='21' font-weight='300' fill-opacity='0.8'>"
		                            +" 					<tspan x='18' y='33'>?</tspan>"
		                            +"				</text>"		
		                            +"			</g>"
		                            +"		</svg>"
		                            +"    </a>"
		                            +"    <span class='tooltiptext'>"
		                            +"     Maybe"
		                            +"    </span>"
		                            +"</div>"
		                            +"</div>");
							
							row.addText("<div class='cmi-applicationstatus' style='width: 100%;' id='unsuccessColumn_"+ doc.get(SPChallengeConstants.CHALLENGE_APPLICANT_ID) + "'>"
		                            +"<div class='statusSec "+applRejectedClass+"'>"
		                            +"    <a href='#' op='reject' "+ onClickStatus + " >"
		                            +"        <svg version='1.1' id='Layer_3' xmlns:cc='http://creativecommons.org/ns#' xmlns:dc='http://purl.org/dc/elements/1.1/' xmlns:inkscape='http://www.inkscape.org/namespaces/inkscape' xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#' xmlns:sodipodi='http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd' xmlns:svg='http://www.w3.org/2000/svg' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' x='0px' y='0px' viewBox='0 0 70 70' style='enable-background:new 0 0 70 70;' xml:space='preserve'>"
		                            +"			 <path class='unsucess' d='M34.4,0c-8.9,0.1-17.1,3.6-23.2,9.3C4.7,15.3,0.5,23.8,0,33.4c0,0.1,0,0.1,0,0.2l0,0c0,0,0,0,0,0.1s0,0.2,0,0.2c-0.6,19.2,14.5,35.3,33.7,36c19.2,0.8,35.5-14.3,36.2-33.6S55.5,0.7,36.2,0C35.6,0,35,0,34.4,0L34.4,0z M34.5,1.1c0.6,0,1.1,0,1.7,0C55,1.8,69.6,17.6,68.8,36.3C68.1,55,52.4,69.7,33.7,68.9C15,68.3,0.4,52.6,1,33.9v-0.1c0,0,0,0,0-0.1v-0.1C1.4,24.4,5.6,16,11.8,10.2C17.9,4.6,25.8,1.2,34.5,1.1L34.5,1.1z M26.6,26.1c-0.3,0.1-0.5,0.3-0.5,0.7c0,0.1,0.1,0.3,0.2,0.3l8.7,8.7l-8.7,8.7c-0.2,0.2-0.2,0.5,0,0.8c0.2,0.2,0.5,0.2,0.8,0l8.7-8.7l8.7,8.7c0.2,0.2,0.5,0.2,0.8,0c0.2-0.2,0.2-0.5,0-0.8l-8.7-8.7l8.7-8.7c0.2-0.2,0.2-0.5,0-0.8c-0.1-0.1-0.3-0.2-0.4-0.2c-0.2,0-0.3,0.1-0.4,0.2l-8.7,8.7l-8.7-8.7C26.9,26.1,26.8,26,26.6,26.1L26.6,26.1z' />"
		                            +"        </svg>"
		                            +"    </a>"
		                            +"    <span class='tooltiptext'>"
                            		+"     Unsuccessful"
                            		+"    </span>"
		                            +"</div>"
		                            +"</div>");							
							if (!responseMode) {
								String viewApplicantUrl = SPChallengeHelper
										.displayApplicationFriendlyURL(
												themeDisplay,
												GetterUtil.getLong(doc
														.get(SPChallengeConstants.CHALLENGE_APPLICANT_ID)));
								PortletURL exportUrl = PortletURLFactoryUtil
										.create(request,
												SPChallengeConstants.APPLICANT_PORTLET_ID,
												themeDisplay.getPlid(),
												PortletRequest.RESOURCE_PHASE); // renderResponse.createActionURL();
								exportUrl.setParameter("action", "exportPdf");
								exportUrl
										.setParameter(
												SPChallengeConstants.CHALLENGE_APPLICANT_ID,
												String.valueOf(classPK));
								Map<String, Object> data = row.getData();
								if (Validator.isNull(data)) {
									data = new HashMap<String, Object>();
								}
								data.put("viewApplicantUrl", viewApplicantUrl);
								data.put("onClickStatusUrl", onClickStatus);
								data.put("exportUrl", exportUrl.toString());
								data.put("startupProfileUrl", startupProfileUrl);
								data.put("challengeUrl", challengeUrl);
								row.setData(data);
								row.addJSP("/html/spchallengeapplicant/sub-menu.jsp");								
							}
							
							resultRows.add(row);
						} catch (Exception e) {
							logger.error("Error while creating display applicant container"
									+ e.getMessage());
						}
					}
				}
			} catch (Exception e) {
				logger.error("Error while creating the search container", e);
			}
			request.setAttribute("searchContainer", searchContainer);
		}

	}

	protected boolean download(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, String fileName) {

		try {
			String contentType = MimeTypesUtil.getContentType(fileName);
			File file = new File(fileName);
			boolean exists = file.exists();
			if (!exists) {
				logger.info("File does not exists");
			}

			Integer length = new Integer(file.length() + "");
			resourceResponse.setContentType(contentType);
			resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL,
					"max-age=3600, must-revalidate");
			resourceResponse.addProperty("Content-Disposition",
					"attachment; filename=\"" + file.getName() + "\"");
			resourceResponse.setContentLength(length);
			logger.info("File length ==" + file.length());
			if (file.length() <= 0) {
				return false;
			}

			final FileInputStream fos = new FileInputStream(file);
			BufferedOutputStream output = null;
			output = new BufferedOutputStream(
					resourceResponse.getPortletOutputStream(), length);
			byte[] buffer = new byte[length];
			while ((length = fos.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			if (fos != null) {
				fos.close();
			}

		} catch (Exception e) {
			if (logger.isWarnEnabled()) {
				logger.warn(e, e);
			}
		}
		return true;
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String action = ParamUtil.getString(resourceRequest,
				SPChallengeConstants.ACTION);
		if ("exportPdf".equalsIgnoreCase(action)) {
			try {
				long applicantId = ParamUtil.getLong(resourceRequest,
						SPChallengeConstants.CHALLENGE_APPLICANT_ID);
				SPChallengeApplicant applicant = SPChallengeApplicantLocalServiceUtil
						.getSPChallengeApplicant(applicantId);
				Organization org = OrganizationLocalServiceUtil
						.getOrganization(applicant.getApplicantRefId());
				String fileName = OrganizationLocalServiceUtil
						.exportStartupDetails(themeDisplay, org, applicant);
				if (SPChallengePermissionHelper.canViewApplication(
						resourceRequest, applicantId)) {
					download(resourceRequest, resourceResponse, fileName);
				} else {
					logger.error("User does not have permission to view application so unable to export to pdf report");
				}
			} catch (Exception ex) {
				logger.error(ex);
			}
			return;
		} else if ("exportResults".equalsIgnoreCase(action)) {
			logger.debug("Brief Application export started");
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();
			Hits results = searchDocuments(themeDisplay, resourceRequest, -1,
					-1);
			stopWatch.stop();
			logger.debug("Brief Application export retrieved "+results.getLength()+" in "+stopWatch.getTime()+" ms");
			stopWatch.reset();
			
			try {
				logger.debug("ChallengeApplicantsExporter started");
				stopWatch.start();
				String fileName = ChallengeApplicantsExporter.exportDoc(
						results.getDocs(), themeDisplay, resourceRequest);
				stopWatch.stop();
				logger.debug("ChallengeApplicantsExporter finished in "+stopWatch.getTime()+" ms");
				
				stopWatch.reset();
				stopWatch.start();
				if (!download(resourceRequest, resourceResponse, fileName))
					logger.error("File was not generated");
				stopWatch.stop();
				logger.debug("File generated in "+stopWatch.getTime()+" ms");
			} catch (Exception e) {
				logger.error("Error while exporting applicants", e);
			}
			return;
		} else if ("sendApplicationResponse".equalsIgnoreCase(action)) {
			Hits results = searchDocuments(themeDisplay, resourceRequest, -1,
					-1);
			if (results != null && results.getDocs() != null) {
				for(Document doc: results.getDocs()) {
					try {
						SPChallengeApplicant applicant = SPChallengeApplicantLocalServiceUtil
								.getSPChallengeApplicant(Long.parseLong(doc.get(SPChallengeConstants.CHALLENGE_APPLICANT_ID)));		
						try {
							SPChallengeMailHelper.sendMailForApplicationResponse(doc, themeDisplay,resourceRequest);	
							applicant.setNotificationStatus(SPChallengeConstants.NOTIFICATION_SUCCESS);
						} catch (Exception e) {
							logger.error("Error while responding to applicants", e);
							applicant.setNotificationStatus(SPChallengeConstants.NOTIFICATION_FAILED);
						}						
						SPChallengeApplicantLocalServiceUtil.updateSPChallengeApplicant(applicant);						
					} catch (Exception e) {
						logger.error("Error while searching the applicant", e);
					}
				}
			}
//			return;
		}

		try {
			HttpServletRequestWrapper httpRequest = SPChallengeHelper
					.getHttpRequestWrapper(resourceRequest);
			AuthTokenUtil.check(httpRequest);
		} catch (PortalException e1) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put(SPChallengeConstants.ERROR_MSG,
					SPChallengeConstants.MSG_UNAUTH);
			logger.error(e1.getMessage());
			resourceResponse.getWriter().write(obj.toString());
			return;
		}

		if (action.equals(SPChallengeConstants.ACTION_SET_APPLICANT_STATUS)) {
			String statusType = ParamUtil.getString(resourceRequest,
					"statusType");
			long applicantId = ParamUtil.getLong(resourceRequest,
					SPChallengeConstants.CHALLENGE_APPLICANT_ID);
			boolean status = ParamUtil.getBoolean(resourceRequest,
					SPChallengeConstants.ACTIVE);
			try {
				if (Validator.isNull(statusType) || applicantId == 0)
					throw new IllegalArgumentException("invalid arguments");
				SPChallengeApplicant applicant = SPChallengeApplicantLocalServiceUtil
						.getSPChallengeApplicant(applicantId);
				if (statusType.equals(PITCH_DAY)) {
					applicant.setCustomStatus2(status);
				} else if (statusType.equals(INTRODUCTION)) {
					applicant.setCustomStatus1(status);
				} else {
					throw new IllegalArgumentException(
							"invalid argument statusType");
				}
				SPChallengeApplicantLocalServiceUtil
						.updateSPChallengeApplicant(applicant);
			} catch (Exception e) {
				logger.error(e.getMessage());
				logger.error("Error setting status for applicantId = "
						+ applicantId);
				resourceResponse.getWriter().write(SPChallengeConstants.FAIL);
				return;
			}
			resourceResponse.getWriter().write(SPChallengeConstants.SUCCESS);
			return;
		} else if(SPChallengeConstants.ACTION_SET_APPLICATION_STATUS.equals(action)) {
			int applStatus = ParamUtil.getInteger(resourceRequest, "applicationStatus");
			long applicantId = ParamUtil.getLong(resourceRequest,SPChallengeConstants.CHALLENGE_APPLICANT_ID);
			try {
				SPChallengeApplicant applicant = SPChallengeApplicantLocalServiceUtil
						.getSPChallengeApplicant(applicantId);		
				if (applicant.getApplicationStatus() != applStatus) { 	// if not same as old status
					applicant.setNotificationStatus(0);					// mark for email notification
				}
				applicant.setApplicationStatus(applStatus);
				SPChallengeApplicantLocalServiceUtil.updateSPChallengeApplicant(applicant);
			} catch (Exception e) {
				logger.error("Error setting application status for applicantId = " + applicantId);
			}
		}

		try {
			int start = ParamUtil.getInteger(resourceRequest,
					SPChallengeConstants.PARAM_SEARCH_PAGE_NO);
			int itemsPerPage = GetterUtil.getInteger(resourceRequest
					.getPreferences().getValue(
							SPChallengeConstants.VOC_ITEMS_PER_PAGE, "3"));
			int end = start + itemsPerPage;

			SearchContext searchContext = new SearchContext();
			searchContext.setStart(start);
			searchContext.setEnd(end);
			searchContext.setCompanyId(themeDisplay.getUser().getCompanyId());

			boolean isAdmin = SambaashUtil.isAdmin(themeDisplay
					.getScopeGroupId(), themeDisplay.getUser().getUserId());

			if (!isAdmin
					&& !SambaashUtil.isFoundryAdmin(themeDisplay.getUser())) {
				BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
				bq.addTerm(SPChallengeConstants.CHALLENGE_OWNER, themeDisplay
						.getUser().getEmailAddress());
				BooleanClause[] clauses = new BooleanClause[1];
				BooleanClause clause = BooleanClauseFactoryUtil.create(
						searchContext, bq, BooleanClauseOccur.MUST.getName());
				clauses[0] = clause;
				searchContext.setBooleanClauses(clauses);
			}

			Indexer indexer = IndexerRegistryUtil
					.getIndexer(SPChallengeApplicant.class.getName());
			Hits results = null;
			try {
				results = indexer.search(searchContext);
			} catch (SearchException e) {
				logger.error(e.getMessage(), e);
			}
			if (results != null) {
				boolean hasMore = false;
				if (end < results.getLength())
					hasMore = true;
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				JSONArray array = createApplicantArray(resourceRequest, results);
				obj.put(SPChallengeConstants.ITEMS, array);
				obj.put(SPChallengeConstants.PARAM_SEARCH_PAGE_NO, start + 1);
				obj.put(SPChallengeConstants.MORE_DOCS_AVAILABLE, hasMore);
				resourceResponse.getWriter().write(
						HtmlUtil.stripHtml(obj.toString()));
			}
		} catch (Exception e) {
			logger.error("Error while preparing applicant slider infos", e);
		}

	}

	private JSONArray createApplicantArray(PortletRequest request, Hits results)
			throws Exception {
		int length = results.getDocs().length;
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		JSONArray array = JSONFactoryUtil.createJSONArray();
		for (int i = 0; i < length; i++) {
			Document doc = results.doc(i);
			JSONObject obj = JSONFactoryUtil.createJSONObject();

			obj.put(SPChallengeConstants.CHALLENGE_NAME,
					doc.get(SPChallengeConstants.CHALLENGE_NAME));
			obj.put("challengeUrl", SPChallengeHelper
					.displayChallengeFriendlyURL(themeDisplay,
							GetterUtil.getLong(doc
									.get(SPChallengeConstants.CHALLENGE_ID)),
							StringPool.DASH));

			obj.put("startupUrl",
					SPChallengeHelper.displayStartupProfileFriendlyURL(
							themeDisplay,
							GetterUtil.getLong(doc
									.get(SPChallengeConstants.APPLICANT_REF_ID))));
			obj.put(SPChallengeConstants.ORGANIZATION_NAME,
					doc.get(SPChallengeConstants.ORGANIZATION_NAME));

			Organization org = OrganizationLocalServiceUtil
					.fetchOrganization(GetterUtil.getLong(doc
							.get(SPChallengeConstants.APPLICANT_REF_ID)));
			String logoUrl = SambaashUtil
					.getDLFileUrl(request, org.getLogoId());
			obj.put(SPChallengeConstants.LOGO_URL, logoUrl);

			String challengeLogoUrl = SambaashUtil.getDLFileUrl(request,
					GetterUtil.getLong(doc
							.get(SPChallengeConstants.FILE_ENTRY_ID)));
			obj.put(SPChallengeConstants.CHALLENGE_LOGO_URL, challengeLogoUrl);

			obj.put(SPChallengeConstants.FRIENDLY_URL,
					SPChallengeHelper.displayApplicationFriendlyURL(
							themeDisplay,
							GetterUtil.getLong(doc
									.get(SPChallengeConstants.CHALLENGE_APPLICANT_ID))));
			obj.put(SPChallengeConstants.CHALLENGE_APPLICANT_ID,
					doc.get(SPChallengeConstants.CHALLENGE_APPLICANT_ID));

			obj.put(Field.MODIFIED_DATE, doc.get(Field.MODIFIED_DATE));
			array.put(obj);
		}
		return array;
	}

	private PortletURL getRenderUrl(String portledId, PortletRequest request,
			ThemeDisplay themeDisplay) {
		PortletURL portletURL = PortletURLFactoryUtil.create(request,
				portledId, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.setParameter("formPage",
				ParamUtil.getString(request, "formPage"));
		return portletURL;
	}

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			HttpServletRequest request = PortalUtil
					.getHttpServletRequest(renderRequest);
			ServletContext servletContext = request.getSession()
					.getServletContext();
			List<Portlet> portlets = getEnabledOpenSearchPortlets(themeDisplay,
					servletContext);

		} catch (SystemException e) {
			logger.error("Error while getting portlets", e);
		}
		super.doEdit(renderRequest, renderResponse);
	}

	public void savePreferences(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		PortletPreferences preferences = actionRequest.getPreferences();
		String viewMode = ParamUtil.getString(actionRequest,
				SPChallengeConstants.VOC_VIEW_MODE,
				SPChallengeConstants.VOC_VIEW_SLIDER);
		String itemsPerPage = ParamUtil.getString(actionRequest,
				SPChallengeConstants.VOC_ITEMS_PER_PAGE, "3");
		preferences.setValue(SPChallengeConstants.VOC_ITEMS_PER_PAGE,
				itemsPerPage);
		preferences.setValue(SPChallengeConstants.VOC_VIEW_MODE, viewMode);
		preferences.store();
		actionResponse.setPortletMode(PortletMode.VIEW);
	}

	private List<Portlet> getEnabledOpenSearchPortlets(
			ThemeDisplay themeDisplay, ServletContext servletContext)
			throws SystemException {
		List<Portlet> portlets = PortletLocalServiceUtil.getPortlets();
		Iterator<Portlet> itr = portlets.iterator();
		while (itr.hasNext()) {
			Portlet portlet = (Portlet) itr.next();

			if (Validator.isNull(portlet.getOpenSearchClass())) {
				itr.remove();
				continue;
			}

			OpenSearch openSearch = portlet.getOpenSearchInstance();

			if (!openSearch.isEnabled()) {
				itr.remove();
				continue;
			}
		}
		return portlets;
	}

	private void addSearchAttributes(PortletRequest request,
			PortletURL portletURL) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		List<Document> challenges = SPChallengeLocalServiceUtil.getChallenges(request, 
				themeDisplay.getCompanyId(), -1, -1, null, false);
		request.setAttribute(SPChallengeConstants.ATTRIB_CHALLENGES, challenges);

		String searchStartupName = ParamUtil.getString(request,
				SPChallengeConstants.PARAM_SEARCH_STARTUP_NAME);
		request.setAttribute(SPChallengeConstants.PARAM_SEARCH_STARTUP_NAME,
				searchStartupName);
		portletURL.setParameter(SPChallengeConstants.PARAM_SEARCH_STARTUP_NAME,
				searchStartupName);

		String selectedChallengeId = ParamUtil.getString(request,
				SPChallengeConstants.PARAM_SEARCH_CHALLENGE);
		String challengeId = getChallengeIdParam(request);
		if (challengeId != null) {
			selectedChallengeId = challengeId;
		}
		
		request.setAttribute(SPChallengeConstants.PARAM_SEARCH_CHALLENGE,
				selectedChallengeId);
		portletURL.setParameter(SPChallengeConstants.PARAM_SEARCH_CHALLENGE,
				selectedChallengeId);

	}

	private BooleanClause addSearchClause(SearchContext searchContext,
			String key, String value, boolean isLike) throws Exception {
		BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
		bq.addTerm(key, value, isLike);
		
		BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext,
				bq, BooleanClauseOccur.MUST.getName());
		return clause;
	}

	private Hits searchDocuments(ThemeDisplay themeDisplay,
			PortletRequest request, int start, int end) {
		Hits results = null;
		try {
			SearchContext searchContext = new SearchContext();
			searchContext.setStart(start);
			searchContext.setEnd(end);
			searchContext.setCompanyId(themeDisplay.getUser().getCompanyId());

			Sort sort1 = SortFactoryUtil.create(
					SPChallengeConstants.CHALLENGE_NAME, Sort.STRING_TYPE,
					false);
			Sort sort2 = SortFactoryUtil.create(Field.CREATE_DATE,
					Sort.LONG_TYPE, false);
			Sort[] sorts = new Sort[] { sort1, sort2 };
			searchContext.setSorts(sorts);

			boolean isAdmin = SambaashUtil.isAdmin(themeDisplay
					.getScopeGroupId(), themeDisplay.getUser().getUserId());

			List<BooleanClause> clauses = new ArrayList<BooleanClause>();
			if (!isAdmin
					&& !SambaashUtil.isFoundryAdmin(themeDisplay.getUser())) {
				BooleanClause clause = addSearchClause(searchContext,
						SPChallengeConstants.CHALLENGE_OWNER, themeDisplay
								.getUser().getEmailAddress(), true);
				clauses.add(clause);
			}

			String searchStartupName = ParamUtil.getString(request,
					SPChallengeConstants.PARAM_SEARCH_STARTUP_NAME);
			String selectedChallengeId = ParamUtil.getString(request,
					SPChallengeConstants.PARAM_SEARCH_CHALLENGE);
			
			String challengeId = getChallengeIdParam(request);
			if (challengeId != null) {
				selectedChallengeId = challengeId;
			}

			if (Validator.isNotNull(searchStartupName)) {
				BooleanClause clause = addSearchClause(searchContext,
						SPChallengeConstants.ORGANIZATION_NAME,
						searchStartupName, true);
				clauses.add(clause);
			}
			if (Validator.isNotNull(selectedChallengeId)) {
				BooleanClause clause = addSearchClause(searchContext,
						SPChallengeConstants.CHALLENGE_ID, selectedChallengeId,
						false);
				clauses.add(clause);
			}

			boolean responseMode = SPChallengeConstants.ACTION_RESPOND_TO_APPLICANTS.equals(getActionParam(request))
					|| "sendApplicationResponse".equals(ParamUtil.getString(request, SPChallengeConstants.ACTION));
			BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
			if (responseMode) {
				BooleanClause clause = addSearchClause(searchContext,
						SPChallengeConstants.NOTIFICATION_STATUS, "0",	// notification pending
						false);
				clauses.add(clause);				
				
				// to display only non-pending rejected and successful,maybe applications
				
				booleanQuery = BooleanQueryFactoryUtil.create(searchContext);

				booleanQuery.addTerm(SPChallengeConstants.APPLICATION_STATUS, "1",true);
				BooleanQuery paramQuery2 = BooleanQueryFactoryUtil.create(searchContext);
				paramQuery2.addTerm(SPChallengeConstants.APPLICATION_STATUS, "2");
				booleanQuery.add(paramQuery2, BooleanClauseOccur.SHOULD.getName());
				logger.error("booleanQuery " + booleanQuery);
				BooleanClause booleanClause = BooleanClauseFactoryUtil.create(searchContext, booleanQuery, BooleanClauseOccur.MUST.getName());
				
				clauses.add(booleanClause);	
			}

			if (clauses.size() > 0) {
				searchContext.setBooleanClauses((BooleanClause[]) clauses
						.toArray(new BooleanClause[clauses.size()]));
			}

			Indexer indexer = IndexerRegistryUtil
					.getIndexer(SPChallengeApplicant.class.getName());

			results = indexer.search(searchContext);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return results;
	}

	private String getChallengeIdParam(PortletRequest request) {
		return PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)).getParameter("_spchallengeapplicantaction_WAR_SPChallengeportlet_challengeId");
	}

	private String getActionParam(PortletRequest request) {
		return PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)).getParameter("_spchallengeapplicantaction_WAR_SPChallengeportlet_javax.portlet.action");
	}

}
