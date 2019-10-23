package com.sambaash.platform.portlet.legalandcontract.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
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
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.pdfbox.exceptions.COSVisitorException;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.reports.ReportGenerator;
import com.sambaash.platform.portlet.legalandcontract.reports.ReportPayload;
import com.sambaash.platform.portlet.legalandcontract.reports.ReportRecord;
import com.sambaash.platform.portlet.legalandcontract.schedular.RenewalAlertMailHelper;
import com.sambaash.platform.portlet.legalandcontract.search.AgencySearch;
import com.sambaash.platform.portlet.legalandcontract.search.LegalContractSearch;
import com.sambaash.platform.portlet.legalandcontract.search.LitigationSearch;
import com.sambaash.platform.portlet.legalandcontract.search.TrademarksSearch;
import com.sambaash.platform.portlet.legalandcontract.util.AgencyConstants;
import com.sambaash.platform.portlet.legalandcontract.util.DateBean;
import com.sambaash.platform.portlet.legalandcontract.util.FilesUpload;
import com.sambaash.platform.portlet.legalandcontract.util.LegalConstants;
import com.sambaash.platform.portlet.legalandcontract.util.LitigationConstants;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksBulkupload;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;
import com.sambaash.platform.portlet.legalandcontract.util.UIUtils;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class TradeMarksMaster
 */
public class TrademarksAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(TrademarksAction.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		setAddPermission(renderRequest);
		boolean prefsAvailable = checkPreferences(renderRequest);
		renderRequest.setAttribute("prefsAvailable", prefsAvailable);
		if (!prefsAvailable) {
			return;
		}
		long trademarksId = GetterUtil.getLong(renderRequest.getParameter(TrademarksConstants.TRADEMARKS_ID));
		String action = renderRequest.getParameter("actionp");

		// To handle the request coming form friendly url
		if (trademarksId != 0 && "displayTrademarksDetails".equalsIgnoreCase(action)) {
			try {
				prepareTrademarksToDisplay(trademarksId, renderRequest, renderResponse);
				include("/html/trademarks/details.jsp", renderRequest, renderResponse);
			} catch (PortalException e) {
				_log.error(e);
			}
		} else {
			try {
				LegalPermissionUtil.authorize(renderRequest, TrademarksConstants.PORTLET_ID,
						TrademarksConstants.ACTION_KEY_BULKUPLOAD_TRADEMARK);
				renderRequest.setAttribute("bulkuploadTrademarksPermission", true);
			} catch (Exception e) {
				_log.error(e);
			}

			TrademarksSearch search = new TrademarksSearch(renderRequest, renderResponse);
			try {
				renderRequest.setAttribute("searchContainer", search.search());
				setDisplayAddTrademarkUrl(search, renderRequest);
			} catch (Exception e) {
				_log.error("Error while getting trademarks", e);
			}
			super.doView(renderRequest, renderResponse);
		}
	}

	private void setAddPermission(PortletRequest request) {
		try {
			LegalPermissionUtil.authorize(request, TrademarksConstants.PORTLET_ID,
					TrademarksConstants.ACTION_KEY_ADD_TRADEMARK);
			request.setAttribute("addTrademarksPermission", true);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private boolean checkPreferences(PortletRequest request) {
		PortletPreferences preferences = request.getPreferences();
		String countryVocId = preferences.getValue(TrademarksConstants.COUNTRY_VOC_ID, "");
		String classCodeVocId = preferences.getValue(TrademarksConstants.CLASS_CODE_VOC_ID, "");
		// String trademarkTypeVocId =
		// preferences.getValue(TrademarksConstants.TRADEMARK_TYPE_VOC_ID, "");
		String statusVocId = preferences.getValue(TrademarksConstants.STATUS_VOC_ID, "");
		String renewalAlertVocId = preferences.getValue(TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID, "");
		// String oppStatusVocId =
		// preferences.getValue(TrademarksConstants.OPPOSITION_STATUS_VOC_ID,
		// "");
		boolean prefsAvailable = true;
		if (Validator.isNull(countryVocId) || Validator.isNull(classCodeVocId) || Validator.isNull(statusVocId)
				|| Validator.isNull(renewalAlertVocId)) {
			prefsAvailable = false;
		}
		return prefsAvailable;
	}

	@SuppressWarnings("rawtypes")
	public void search(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException, SystemException {
		boolean prefsAvailable = checkPreferences(actionRequest);
		actionRequest.setAttribute("prefsAvailable", prefsAvailable);
		if (prefsAvailable) {
			setAddPermission(actionRequest);
			TrademarksSearch search = new TrademarksSearch(actionRequest, actionResponse);
			SearchContainer searchContainer = search.search();
			actionRequest.setAttribute("searchContainer", searchContainer);
			actionResponse.setRenderParameter("jspPage", "/html/trademarks/view.jsp");
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			setDisplayAddTrademarkUrl(search, actionRequest);
		}
	}

	public PortletURL setDisplayAddTrademarkUrl(TrademarksSearch search, PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL actionUrl = PortletURLFactoryUtil.create(request, TrademarksConstants.PORTLET_ID,
				themeDisplay.getPlid(), PortletRequest.ACTION_PHASE); // renderResponse.createActionURL();
		try {
			actionUrl.setWindowState(WindowState.MAXIMIZED);
			actionUrl.setParameter("javax.portlet.action", "displayAddTrademarks");
			search.addSearchParams(actionUrl);
			request.setAttribute("displayAddTrademarkURL", actionUrl);
		} catch (WindowStateException e) {
			_log.error("Error whiel setting window state", e);
		}
		return actionUrl;
	}

	public void displayAddTrademarks(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			LegalPermissionUtil.authorize(actionRequest, TrademarksConstants.PORTLET_ID,
					TrademarksConstants.ACTION_KEY_ADD_TRADEMARK);
		} catch (Exception ex) {
			_log.error("Someone tried access to trademarks but he is not authorized UserId " + themeDisplay.getUserId());
			SessionErrors.add(actionRequest, "unauthorized.trademarks.add");
			throw ex;
		}
		if (SessionErrors.get(actionRequest, "trademarks.add.errors.exists") == null) {
			DateBean dateBean = Utils.getDateBean(null);
			actionRequest.setAttribute(TrademarksConstants.APPLICATION_DATE, dateBean);
			actionRequest.setAttribute(TrademarksConstants.FIRST_REG_DATE, dateBean);
			actionRequest.setAttribute(TrademarksConstants.EXPIRY_DATE, dateBean);
			actionRequest.setAttribute(TrademarksConstants.PRIORITY_DATE, dateBean);
			// actionRequest.setAttribute(TrademarksConstants.CUSTOM_DATE_2,dateBean);
			// actionRequest.setAttribute(TrademarksConstants.CUSTOM_DATE_3,dateBean);
		}

		boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(themeDisplay.getUserId());
		actionRequest.setAttribute(TrademarksConstants.REGIONAL_ROLE_NAME, authorized);

		fillCategoryLists(actionRequest, actionResponse);
		actionResponse.setWindowState(WindowState.MAXIMIZED);
		actionResponse.setRenderParameter("jspPage", "/html/trademarks/addTrademark.jsp");
		String folderName = Utils.getUserFolderName(themeDisplay.getUserId());
		long[] folderIds = TrademarksSearch.getFolderIds(actionRequest, folderName);
		if (folderIds[0] != 0) {
			List<Map<String, String>> files = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(), folderIds[0], false);
			actionRequest.setAttribute(TrademarksConstants.ATTACHMENTS, files);
		}
		if (folderIds[1] != 0) {
			List<Map<String, String>> files = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(), folderIds[1], false);
			actionRequest.setAttribute(TrademarksConstants.CONF_ATTACHMENTS, files);
		}

		LegalContractSearch.copySearchParamsToResponse(actionRequest, actionResponse);
	}

	public void displayTrademarksDetails(ActionRequest request, ActionResponse response) throws IOException,
			PortletException, SystemException, PrincipalException, PortalException {
		long trademarkId = ParamUtil.getLong(request, TrademarksConstants.TRADEMARKS_ID);

		// request.setAttribute(TrademarksConstants.TRADEMARKS_ID, trademarkId +
		// "");
		prepareTrademarksToDisplay(trademarkId, request, response);
		response.setRenderParameter("jspPage", "/html/trademarks/details.jsp");
		PortalUtil.copyRequestParameters(request, response);
	}

	public void displayTrademarksDetailsAfterAddUpdate(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, SystemException, PrincipalException, PortalException {
		long trademarkId = GetterUtil.getLong(request.getAttribute(TrademarksConstants.TRADEMARKS_ID));

		// request.setAttribute(TrademarksConstants.TRADEMARKS_ID, trademarkId +
		// "");
		prepareTrademarksToDisplay(trademarkId, request, response);
		response.setRenderParameter("jspPage", "/html/trademarks/details.jsp");
	}

	private void prepareTrademarksToDisplay(long trademarksId, PortletRequest request, PortletResponse response)
			throws PortalException {
		_log.debug("Preparing data for Trademarks to display");
		TrademarksSearch search = new TrademarksSearch(request, response);
		request.setAttribute(TrademarksConstants.TRADEMARKS_ID, trademarksId + "");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(themeDisplay.getUserId());
			request.setAttribute(TrademarksConstants.REGIONAL_ROLE_NAME, authorized);
		} catch (SystemException e1) {
		}

		Map<String, String> map = null;
		Trademarks trademarks = null;
		try {
			trademarks = TrademarksLocalServiceUtil.getTrademarks(trademarksId);
			_log.debug("Trademark Application Num " + trademarks.getApplicationNo());
			map = search.getTrademarksMap(trademarks, true);
		} catch (Exception e) {
			_log.error(e);
		}
		request.setAttribute(TrademarksConstants.TRADEMARK, map);

		if (Validator.isNotNull(map) && Validator.isNotNull(trademarks)) {
			// Logic to fetch files attached to the trademark
			String folderName = TrademarksSearch.getTrademarksFolderName(trademarks.getRootSpTrademarksId());
			long[] folderIds = TrademarksSearch.getFolderIds(request, folderName);
			if (folderIds[0] != 0) {
				List<Map<String, String>> attachments = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(),
						folderIds[0], true);
				request.setAttribute(TrademarksConstants.ATTACHMENTS, attachments);

			}
			if (folderIds[1] != 0) {
				List<Map<String, String>> confAttachments = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(),
						folderIds[1], true);
				request.setAttribute(TrademarksConstants.CONF_ATTACHMENTS, confAttachments);
			}
			if (folderIds[2] != 0) {
				List<Map<String, String>> logos = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(), folderIds[2],
						true);
				if (Validator.isNotNull(logos) && !logos.isEmpty()) {
					request.setAttribute("logoUrl",
							Utils.getDLFileUrl(request, logos.get(0).get(LegalConstants.FILE_ENTRY_ID)));
				}
			}

			String litIdsStr = map.get(TrademarksConstants.LITIGATION_IDS);
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> litMap = null;
			if (Validator.isNotNull(litIdsStr)) {
				LitigationSearch litigationSearch = new LitigationSearch(request, response);
				String[] litIds = litIdsStr.split(",");

				for (String litId : litIds) {

					String tptan = GetterUtil.getString(litigationSearch.getThirdPartyTMNum(litId));
					if (Validator.isNull(tptan)) {
						tptan = litId;
					}
					String url = Utils.getLitigationDetailsFriendlyUrl(GetterUtil.getLong(litId));
					litMap = new LinkedHashMap<String, String>();
					litMap.put(LitigationConstants.LITIGATION_ID, litId);
					litMap.put(LitigationConstants.THRID_PARTY_APP_NUMBER, tptan);
					litMap.put(LitigationConstants.DETAILS_LINK, url);
					list.add(litMap);
				}
			}

			request.setAttribute(TrademarksConstants.CLASS_CODES,
					Utils.parseClassCodesJson(trademarks.getClassCodes(), true));
			request.setAttribute(TrademarksConstants.CONTENTIOUS_PROCEEDINGS, list);
			request.setAttribute(LegalConstants.CAN_DOWNLOAD_FILE, canDownLoadFile(request));
		}
	}

	public void displayEditTrademarks(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			LegalPermissionUtil.authorize(actionRequest, TrademarksConstants.PORTLET_ID,
					TrademarksConstants.ACTION_KEY_EDIT_TRADEMARK);
		} catch (Exception ex) {
			_log.error("Someone tried access to trademarks but he is not authorized UserId " + themeDisplay.getUserId());
			SessionErrors.add(actionRequest, "unauthorized.trademarks.update");
			throw ex;
		}
		boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(themeDisplay.getUserId());
		actionRequest.setAttribute(TrademarksConstants.REGIONAL_ROLE_NAME, authorized);
		fillCategoryLists(actionRequest, actionResponse);

		long trademarkId = ParamUtil.getLong(actionRequest, TrademarksConstants.TRADEMARKS_ID);
		Trademarks trademark = TrademarksLocalServiceUtil.fetchTrademarks(trademarkId);
		long countryVocId = GetterUtil.getLong(actionRequest.getPreferences().getValue(
				TrademarksConstants.COUNTRY_VOC_ID, "0"));
		boolean canAdd = Utils.checkUserPermissionOnCountry(actionRequest, countryVocId, trademark.getCountry());
		if (!canAdd) {
			SessionErrors.add(actionRequest, "unauthorized.trademarks.update");
			return;
		}
		actionRequest.setAttribute(TrademarksConstants.TRADEMARK, trademark);
		actionRequest.setAttribute(TrademarksConstants.TRADEMARKS_ID, trademark.getSpTrademarksId());
		actionRequest.setAttribute(TrademarksConstants.APPLICATION_DATE,
				Utils.getDateBean(trademark.getApplicationDate()));
		actionRequest.setAttribute(TrademarksConstants.FIRST_REG_DATE,
				Utils.getDateBean(trademark.getFirstRegistrationDate()));
		actionRequest.setAttribute(TrademarksConstants.EXPIRY_DATE, Utils.getDateBean(trademark.getRenewalDate()));
		actionRequest.setAttribute(TrademarksConstants.PRIORITY_DATE, Utils.getDateBean(trademark.getCustomDate1()));
		// actionRequest.setAttribute(TrademarksConstants.CUSTOM_DATE_2,
		// Utils.getDateBean(trademark.getCustomDate2()));
		// actionRequest.setAttribute(TrademarksConstants.CUSTOM_DATE_3,
		// Utils.getDateBean(trademark.getCustomDate3()));
		List<Map<String, String>> classCodes = Utils.parseClassCodesJson(trademark.getClassCodes(), false);
		actionRequest.setAttribute(TrademarksConstants.CLASS_CODES, classCodes);
		actionRequest.setAttribute(TrademarksConstants.CLASS_CODES_SIZE, classCodes.size() + 1);

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(Trademarks.class.getName(), trademarkId);
		long categoryIds[] = assetEntry.getCategoryIds();
		// categoryIds =
		// TrademarksSearch.reorderCategoryIds(actionRequest.getPreferences(),
		// categoryIds);

		PortletPreferences prefs = actionRequest.getPreferences();
		actionRequest.setAttribute("countryCatId",
				Utils.getCategoryId(prefs, TrademarksConstants.COUNTRY_VOC_ID, categoryIds));
		long statusCatId = Utils.getCategoryId(prefs, TrademarksConstants.STATUS_VOC_ID, categoryIds);
		if (statusCatId == 0) {
			// As per requirement setting default selected value to filed if no
			// value is there
			long statusVocId = GetterUtil.getLong(prefs.getValue(TrademarksConstants.STATUS_VOC_ID, "0"));
			statusCatId = Utils.getCategoryId(statusVocId, "Filed");
		}
		actionRequest.setAttribute("statusCatId", statusCatId);
		long renewalCatId = Utils.getCategoryId(prefs, TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID, categoryIds);
		if (renewalCatId == 0) {
			// As per requirement setting default selected value to filed if no
			// value is there
			long renewalVocId = GetterUtil
					.getLong(prefs.getValue(TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID, "0"));
			renewalCatId = Utils.getCategoryId(renewalVocId, "60");
		}
		actionRequest.setAttribute("renewalAlertBeforeCatId", renewalCatId);
		// actionRequest.setAttribute("oppositionStatusCatId",
		// Utils.getCategoryId(prefs,
		// TrademarksConstants.OPPOSITION_STATUS_VOC_ID, categoryIds));
		actionRequest.setAttribute("customList1CatId",
				Utils.getCategoryId(prefs, TrademarksConstants.REGISTERED_OWNER_VOC_ID, categoryIds));
		// actionRequest.setAttribute("customList2CatId",
		// Utils.getCategoryId(prefs, TrademarksConstants.CUSTOM_LIST_2_VOC_ID,
		// categoryIds));
		// actionRequest.setAttribute("customList3CatId",
		// Utils.getCategoryId(prefs, TrademarksConstants.CUSTOM_LIST_3_VOC_ID,
		// categoryIds));

		// actionRequest.setAttribute(TrademarksConstants.CATEGORY_IDS,
		// categoryIds);
		actionResponse.setRenderParameter("jspPage", "/html/trademarks/editTrademark.jsp");

		setFilesList(actionRequest, String.valueOf(trademark.getRootSpTrademarksId()));

		LegalContractSearch.copySearchParamsToResponse(actionRequest, actionResponse);
	}

	private void setFilesList(PortletRequest actionRequest, String trademarkId) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// Logic to fetch files attached to the trademark
		String folderName = TrademarksSearch.getTrademarksFolderName(trademarkId);
		long[] folderIds = TrademarksSearch.getFolderIds(actionRequest, folderName);
		/*
		 * List<Map<String, String>> attachments = getTrademarksFiles(
		 * themeDisplay.getCompanyId(), folderIds[0]); List<Map<String, String>>
		 * confAttachments = getTrademarksFiles( themeDisplay.getCompanyId(),
		 * folderIds[1]);
		 */
		if (folderIds[0] != 0) {
			List<Map<String, String>> attachments = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(), folderIds[0],
					false);
			actionRequest.setAttribute(TrademarksConstants.ATTACHMENTS, attachments);
		}
		if (folderIds[1] != 0) {
			List<Map<String, String>> confAttachments = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(),
					folderIds[1], false);
			actionRequest.setAttribute(TrademarksConstants.CONF_ATTACHMENTS, confAttachments);
		}
		if (folderIds[2] != 0) {
			List<Map<String, String>> logos = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(), folderIds[2], false);
			if (Validator.isNotNull(logos) && !logos.isEmpty()) {
				Map<String, String> logo = logos.get(0);
				if (Validator.isNotNull(logo)) {
					String title = FilesUpload.removeLogoExtension(logo.get(Field.TITLE));
					logo.put(Field.TITLE, title);
				}
				actionRequest.setAttribute("logo", logos.get(0));
				actionRequest.setAttribute("logoUrl",
						Utils.getDLFileUrl(actionRequest, logos.get(0).get(LegalConstants.FILE_ENTRY_ID)));
			}

		}

		// Logic to fetch files uploaded using drag and drop and cancel the
		// transaction.Those file wil be in user_<id> folder
		folderName = Utils.getUserFolderName(themeDisplay.getUserId());
		folderIds = TrademarksSearch.getFolderIds(actionRequest, folderName);
		if (folderIds[0] != 0) {
			List<Map<String, String>> files = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(), folderIds[0], false);
			actionRequest.setAttribute(TrademarksConstants.PREV_ATTACHMENTS, files);
		}
		if (folderIds[1] != 0) {
			List<Map<String, String>> files = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(), folderIds[1], false);
			actionRequest.setAttribute(TrademarksConstants.PREV_CONF_ATTACHMENTS, files);
		}
	}

	protected String getPath(PortletRequest portletRequest) {
		String mvcPath = portletRequest.getParameter("mvcPath");

		// Check deprecated parameter

		if (mvcPath == null) {
			mvcPath = portletRequest.getParameter("jspPage");
		}

		return mvcPath;
	}

	public void fillTrademarksObject(Trademarks trademarks, Map<String, String> paramMap, ActionRequest actionRequest,
			Map<String, DateBean> dates) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(Trademarks.class.getName(), actionRequest);
			String type = paramMap.get(TrademarksConstants.TRADEMARK_TYPE);
			trademarks.setTrademarkType(type);
			if (TrademarksConstants.WORD.equalsIgnoreCase(type)) {
				String trademark = GetterUtil.getString(paramMap.get(TrademarksConstants.TRADEMARK));
				trademarks.setTrademark(trademark);
				/*
				 * boolean allEnglish = true; for(int i=0; i<
				 * trademark.length();i++){ if(trademark.charAt(i) > 200){
				 * trademarks
				 * .setTrademarkLocalized(paramMap.get(TrademarksConstants
				 * .TRADEMARK_LOCALIZED)); allEnglish = false; break; } }
				 */

				boolean nonEnglishFound = Utils.checkNonEnglishChars(trademark);
				if (nonEnglishFound) {
					trademarks.setTrademarkLocalized(paramMap.get(TrademarksConstants.TRADEMARK_LOCALIZED));
				} else {
					trademarks.setTrademarkLocalized("");
				}

			} else {
				String userFolderName = Utils.getUserFolderName(themeDisplay.getUserId());
				trademarks.setTrademark(getTrademarkLogoTitle(actionRequest, userFolderName));

			}
			trademarks.setRegistrationNumber(paramMap.get(TrademarksConstants.REGISTRATION_NUMBER));
			// trademarks.setRegisteredOwner(paramMap.get(TrademarksConstants.REGISTERED_OWNER));
			// trademarks.setGoodsServices(paramMap.get(TrademarksConstants.GOODS_SERVICES));
			trademarks.setPendingComments(paramMap.get(TrademarksConstants.REMARKS));
			trademarks.setSpAgencyId(GetterUtil.getLong(paramMap.get(TrademarksConstants.AGENCY_ID_DD)));
			trademarks.setClassDescription(GetterUtil.getString(paramMap.get(TrademarksConstants.CLASS_DESCRIPTION)));
			trademarks.setLegalConfRemarks(paramMap.get(TrademarksConstants.LEGAL_CONF_REMARKS));
			trademarks.setCustomField1(paramMap.get(TrademarksConstants.ACTIVE_IN_GREDIENTS));
			trademarks.setCustomField2(paramMap.get(TrademarksConstants.INTERNATIONAL_REG_NUM));
			trademarks.setCustomField3(paramMap.get(TrademarksConstants.CUSTOM_FIELD_3));
			trademarks.setGroupId(serviceContext.getScopeGroupId());
			trademarks.setModifiedDate(serviceContext.getModifiedDate(new Date()));

			if (Validator.isNotNull(dates)) {
				trademarks.setApplicationDate(UIUtils.getDate(themeDisplay,
						dates.get(TrademarksConstants.APPLICATION_DATE)));
				trademarks.setFirstRegistrationDate(UIUtils.getDate(themeDisplay,
						dates.get(TrademarksConstants.FIRST_REG_DATE)));
				trademarks.setRenewalDate(UIUtils.getDate(themeDisplay, dates.get(TrademarksConstants.EXPIRY_DATE)));
				trademarks.setCustomDate1(UIUtils.getDate(themeDisplay, dates.get(TrademarksConstants.PRIORITY_DATE)));
				// trademarks.setCustomDate2(UIUtils.getDate(themeDisplay,
				// dates.get(TrademarksConstants.CUSTOM_DATE_2)));
				// trademarks.setCustomDate3(UIUtils.getDate(themeDisplay,
				// dates.get(TrademarksConstants.CUSTOM_DATE_3)));
			}

			trademarks.setClassCodes(getClassCodeJsonString(paramMap));
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			throw e;
		}

	}

	private String getClassCodeJsonString(Map<String, String> paramMap) {
		Set<String> params = paramMap.keySet();
		JSONObject data;
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (String param : params) {
			if (param.startsWith(TrademarksConstants.CC_PREFIX)
					&& !TrademarksConstants.CC_PREFIX.equalsIgnoreCase(param)) {
				long code = GetterUtil.getLong(paramMap.get(param));
				String index = param.substring(TrademarksConstants.CC_PREFIX.length());
				String desc = GetterUtil.getString(paramMap.get(TrademarksConstants.CC_SPEC_PREFIX + index));
				data = JSONFactoryUtil.createJSONObject();

				data.put(TrademarksConstants.CC_PREFIX, Utils.getCategoryName(code));
				data.put(TrademarksConstants.CC_SPEC_PREFIX, desc);
				jsonArray.put(data);
			}
		}
		return jsonArray.toString();
	}

	private Map<String, DateBean> getDateBeanMap(ThemeDisplay themeDisplay, Map<String, String> paramMap) {
		Map<String, DateBean> map = new HashMap<String, DateBean>();
		try {
			String day = paramMap.get(TrademarksConstants.APPLICATION_DATE_DAY);
			String mon = paramMap.get(TrademarksConstants.APPLICATION_DATE_MONTH);
			String year = paramMap.get(TrademarksConstants.APPLICATION_DATE_YEAR);
			DateBean db = new DateBean(day, mon, year);
			map.put(TrademarksConstants.APPLICATION_DATE, db);

			day = paramMap.get(TrademarksConstants.FIRST_REG_DATE_DAY);
			mon = paramMap.get(TrademarksConstants.FIRST_REG_DATE_MONTH);
			year = paramMap.get(TrademarksConstants.FIRST_REG_DATE_YEAR);
			db = new DateBean(day, mon, year);
			map.put(TrademarksConstants.FIRST_REG_DATE, db);

			day = paramMap.get(TrademarksConstants.RENEWAL_DATE_DAY);
			mon = paramMap.get(TrademarksConstants.RENEWAL_DATE_MONTH);
			year = paramMap.get(TrademarksConstants.RENEWAL_DATE_YEAR);
			db = new DateBean(day, mon, year);
			map.put(TrademarksConstants.EXPIRY_DATE, db);

			day = paramMap.get(TrademarksConstants.PRIORITY_DATE_DAY);
			mon = paramMap.get(TrademarksConstants.PRIORITY_DATE_MONTH);
			year = paramMap.get(TrademarksConstants.PRIORITY_DATE_YEAR);
			db = new DateBean(day, mon, year);
			map.put(TrademarksConstants.PRIORITY_DATE, db);

			/*
			 * day = paramMap.get(TrademarksConstants.CUSTOM_DATE_2_DAY); mon =
			 * paramMap.get(TrademarksConstants.CUSTOM_DATE_2_MONTH); year =
			 * paramMap.get(TrademarksConstants.CUSTOM_DATE_2_YEAR); db = new
			 * DateBean(day, mon, year);
			 * map.put(TrademarksConstants.CUSTOM_DATE_2, db);
			 * 
			 * day = paramMap.get(TrademarksConstants.CUSTOM_DATE_3_DAY); mon =
			 * paramMap.get(TrademarksConstants.CUSTOM_DATE_3_MONTH); year =
			 * paramMap.get(TrademarksConstants.CUSTOM_DATE_3_YEAR); db = new
			 * DateBean(day, mon, year);
			 * map.put(TrademarksConstants.CUSTOM_DATE_3, db);
			 */
		} catch (Exception ex) {
			_log.error("Error while preparing date objects ", ex);
		}
		return map;
	}

	public long[] getCategoryIds(Map<String, String> paramMap) {
		long[] categoryIds = null;
		List<Long> list = new ArrayList<Long>();
		try {
			list.add(GetterUtil.getLong(paramMap.get(TrademarksConstants.COUNTRY_LIST)));
			list.add(GetterUtil.getLong(paramMap.get(TrademarksConstants.STATUS)));
			list.add(GetterUtil.getLong(paramMap.get(TrademarksConstants.RENEWAL_ALERT_BEFORE)));
			// list.add(GetterUtil.getLong(paramMap.get(TrademarksConstants.OPPOSITION_STATUS)));
			list.add(GetterUtil.getLong(paramMap.get(TrademarksConstants.REGISTERED_OWNER_LIST)));
			// list.add(GetterUtil.getLong(paramMap.get(TrademarksConstants.CUSTOM_LIST_2)));
			// list.add(GetterUtil.getLong(paramMap.get(TrademarksConstants.CUSTOM_LIST_3)));

			for (String param : paramMap.keySet()) {
				if (param.startsWith(TrademarksConstants.CC_PREFIX)
						&& !TrademarksConstants.CC_PREFIX.equalsIgnoreCase(param)) {
					long code = GetterUtil.getLong(paramMap.get(param));
					list.add(code);
				}
			}
			categoryIds = new long[list.size()];
			for (int i = 0; i < list.size(); i++) {
				categoryIds[i] = list.get(i);
			}

		} catch (Exception e) {
			_log.error(e);
		}

		return categoryIds;
	}

	@SuppressWarnings("unchecked")
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();

			String action = ParamUtil.getString(resourceRequest, "action");
			JSONObject data = JSONFactoryUtil.createJSONObject();
			String errMsg = "success";
			Utils.initalizeAdmin();
			if ("removeFile".equals(action)) {
				long fileEntryId = ParamUtil.getLong(resourceRequest, "fileEntryId");
				try {
					DLAppServiceUtil.deleteFileEntry(fileEntryId);
				} catch (Exception ex) {
					errMsg = "File Deletion Failed.";
					_log.error(ex);
				}
				data.put("errorMsg", errMsg);
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			} else if ("exportListPdf".equals(action)) {
				try {
					String path = exportTrademarksList(resourceRequest, resourceResponse);
					data.put("fileName", path);
				} catch (Exception ex) {
					data.put("errorMsg", "Error while generating the report");
				}
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			} else if ("exportDetailsPdf".equals(action)) {
				try {
					String path = exportTrademarksDetails(resourceRequest, resourceResponse);
					data.put("fileName", path);
				} catch (Exception ex) {
					data.put("errorMsg", "Error while generating the report");
				}
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			} else if ("exportListXls".equals(action)) {
				try {
					String path = exportTrademarksListXls(resourceRequest, resourceResponse);
					data.put("fileName", path);
				} catch (Exception ex) {
					data.put("errorMsg", "Error while generating the report");
				}
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			} else if ("exportDetailsXls".equals(action)) {
				try {
					String path = exportTrademarksDetailsXls(resourceRequest, resourceResponse);
					data.put("fileName", path);
				} catch (Exception ex) {
					data.put("errorMsg", "Error while generating the report");
				}
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			} else {
				try {

					Object objs[] = Utils.parseRequest(resourceRequest, resourceResponse);
					List<FileItem> files = (List<FileItem>) objs[1];
					Object temp[] = seperateAttachements(files);
					String folderName = Utils.getUserFolderName(themeDisplay.getUserId());
					long[] folderIds = TrademarksSearch.getFolderIds(resourceRequest, folderName);
					FilesUpload fu;
					List<FileEntry> fileList;

					List<FileItem> attachments = (List<FileItem>) temp[0];
					if (attachments.size() > 0) {
						fu = new FilesUpload();
						fileList = fu.uploadDocuments(resourceRequest, attachments, folderIds[0]);
						if (fu.getFailedCount() > 0) {
							errMsg = fu.getErrorMessage(attachments.get(0));
						}
						if (fileList.size() > 0) {
							data.put("fileEntryId", fileList.get(0).getFileEntryId());
						}
					}
					List<FileItem> confAttachments = (List<FileItem>) temp[1];
					if (confAttachments.size() > 0) {
						fu = new FilesUpload();
						fileList = fu.uploadDocuments(resourceRequest, confAttachments, folderIds[1]);
						if (fu.getFailedCount() > 0) {
							errMsg = fu.getErrorMessage(confAttachments.get(0));
						}
						if (fileList.size() > 0) {
							data.put("fileEntryId", fileList.get(0).getFileEntryId());
						}
					}

					List<FileItem> logo = (List<FileItem>) temp[2];
					if (logo.size() > 0) {
						fu = new FilesUpload();
						fileList = fu.uploadTrademarkLogo(resourceRequest, logo, folderIds[2]);
						if (fu.getFailedCount() > 0) {
							errMsg = fu.getErrorMessage(logo.get(0));
						}
						if (fileList.size() > 0) {
							data.put("fileEntryId", fileList.get(0).getFileEntryId());
						}
					}

				} catch (Exception ex) {
					_log.error(ex.getMessage(), ex);
					errMsg = "File upload failed";
				}
				data.put("errorMsg", errMsg);
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}
			// super.serveResource(resourceRequest, resourceResponse);
			Utils.resetToUser(user);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

	private void generateListReport(ResourceRequest request, ResourceResponse response, String fileName,
			ReportGenerator generator) throws COSVisitorException, IOException, PortalException {
		TrademarksSearch search = new TrademarksSearch(request, response);
		List<Document> trademarks = search.getTrademarks();
		List<ReportRecord> list = new ArrayList<ReportRecord>();
		long classCodeVocId = GetterUtil.getLong(request.getPreferences().getValue(
				TrademarksConstants.CLASS_CODE_VOC_ID, "0"));
		for (Document doc : trademarks) {
			List<Long> catIds = Utils.getCategoryIds(doc);
			String classCode = TrademarksSearch.getClassCodes(classCodeVocId, catIds);
			ReportRecord wrap = new ReportRecord();
			Map<String, String> trademark = search.getTrademarksMap(doc, false);
			Map<String, String> map = new LinkedHashMap<String, String>();
			// String applicationNo =
			// trademark.get(TrademarksConstants.APPLICATION_NO);
			// String country = doc.get(TrademarksConstants.COUNTRY);
			String rootTMId = doc.get(TrademarksConstants.ROOT_TRADEMARK_ID);
			String trademarkType = GetterUtil.getString(doc.get(TrademarksConstants.TRADEMARK_TYPE));
			String url = StringPool.BLANK;
			if (TrademarksConstants.LOGO.equalsIgnoreCase(trademarkType)) {
				url = TrademarksSearch.getTrademarksLogoDLUrl(request, rootTMId);
				wrap.addExtraData(TrademarksConstants.LOGO_FILE_ENTRY_ID,
						trademark.get(TrademarksConstants.LOGO_FILE_ENTRY_ID));
			} else {
				url = GetterUtil.getString(trademark.get(TrademarksConstants.TRADEMARK));
			}
			map.put(TrademarksConstants.TRADEMARK_COLUMN, url);
			String trademarkId = trademark.get(TrademarksConstants.TRADEMARKS_ID);
			String str = "";
			if (TrademarksConstants.LOGO.equalsIgnoreCase(trademarkType)) {
				str = GetterUtil.getString(trademark.get(TrademarksConstants.TRADEMARK));
			} else {
				str = GetterUtil.getString(trademark.get(TrademarksConstants.TRADEMARK_LOCALIZED));
			}

			map.put(TrademarksConstants.TRADEMARK_LOGO_TITLE_COLUMN, str);
			map.put(TrademarksConstants.COUNTRY_COLUMN, trademark.get(TrademarksConstants.COUNTRY));
			map.put(TrademarksConstants.REGISTERED_OWNER_COLUMN, trademark.get(TrademarksConstants.REGISTERED_OWNER));
			map.put(TrademarksConstants.APPLICATION_NO_COLUMN, trademark.get(TrademarksConstants.APPLICATION_NO));
			map.put(TrademarksConstants.REGISTRATION_NUMBER_COLUMN_1,
					trademark.get(TrademarksConstants.REGISTRATION_NUMBER));
			// map.put(TrademarksConstants.INTL_REG_NUMBER,
			// trademark.get(TrademarksConstants.INTERNATIONAL_REG_NUM));
			map.put(TrademarksConstants.STATUS_COLUMN, trademark.get(TrademarksConstants.STATUS));
			map.put(TrademarksConstants.APPLICATION_DATE_COLUMN, trademark.get(TrademarksConstants.APPLICATION_DATE));
			map.put(TrademarksConstants.EXPIRY_DATE_COLUMN, trademark.get(TrademarksConstants.EXPIRY_DATE));
			// map.put(TrademarksConstants.REMARKS_COLUMN,
			// trademark.get(TrademarksConstants.REMARKS));
			map.put(TrademarksConstants.CLASS_COLUMN, classCode);
			map.put(TrademarksConstants.DETAILS_LINK, Utils.getTrademarkDetailsFriendlyUrl(trademarkId));
			wrap.setDataMap(map);
			list.add(wrap);
		}
		ReportPayload payload = new ReportPayload();
		payload.setRecList(list);
		payload.useDefaultMap();
		payload.setType(ReportGenerator.TRADEMARK_LISTING);
		try {
			generator.generateReport(payload, new File(fileName));
		} catch (Exception e) {
			_log.error("Error while creating pdf file", e);
		}
	}

	private String exportTrademarksListXls(ResourceRequest request, ResourceResponse response)
			throws COSVisitorException, IOException, PortalException {
		String fileName = Utils.generateExportFileName(request, "trademarks", ".xlsx");
		ReportGenerator generator = ReportGenerator.getExcelGenerator();
		generateListReport(request, response, fileName, generator);
		return fileName;
	}

	private String exportTrademarksList(ResourceRequest request, ResourceResponse response) throws COSVisitorException,
			IOException, PortalException {
		String fileName = Utils.generateExportFileName(request, "trademarks", ".pdf");
		ReportGenerator generator = ReportGenerator.getPdfGenerator("trademark", "tmList",
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY));
		generateListReport(request, response, fileName, generator);
		return fileName;
	}

	private void generateDetailsReport(ResourceRequest request, ResourceResponse response, String fileName,
			ReportGenerator generator) throws PortalException {
		long trademarkId = ParamUtil.getLong(request, TrademarksConstants.TRADEMARKS_ID);
		ReportRecord rec = new ReportRecord();
		TrademarksSearch search = new TrademarksSearch(request, response);
		Map<String, String> map = null;
		Trademarks trademark = null;
		try {
			trademark = TrademarksLocalServiceUtil.getTrademarks(trademarkId);
			map = search.getTrademarksMap(trademark, false);
		} catch (Exception e) {
		}

		// String applicationNo = map.get(TrademarksConstants.APPLICATION_NO);
		// String country = map.get(TrademarksConstants.COUNTRY);
		Map<String, String> respMap = new LinkedHashMap<String, String>();

		String tmType = map.get(TrademarksConstants.TRADEMARK_TYPE);
		String url = StringPool.BLANK;
		if (TrademarksConstants.LOGO.equalsIgnoreCase(tmType)) {
			url = TrademarksSearch.getTrademarksLogoDLUrl(request, String.valueOf(trademark.getRootSpTrademarksId()));
			rec.addExtraData(TrademarksConstants.LOGO_FILE_ENTRY_ID, map.get(TrademarksConstants.LOGO_FILE_ENTRY_ID));
		} else {
			url = GetterUtil.getString(map.get(TrademarksConstants.TRADEMARK));
		}
		// url = url.equals("") ?
		// GetterUtil.getString(map.get(TrademarksConstants.TRADEMARK)) : url;

		respMap.put(TrademarksConstants.TRADEMARK_COLUMN, url);
		if (tmType.equalsIgnoreCase(TrademarksConstants.LOGO)) {
			respMap.put("Logo Title", map.get(TrademarksConstants.TRADEMARK));
		}
		respMap.put(TrademarksConstants.APPLICATION_NO_COLUMN, map.get(TrademarksConstants.APPLICATION_NO));
		respMap.put(TrademarksConstants.APPLICATION_DATE_COLUMN, map.get(TrademarksConstants.APPLICATION_DATE));

		if (Validator.isNotNull(map.get(TrademarksConstants.TRADEMARK_LOCALIZED)))
			respMap.put(TrademarksConstants.TRADEMARK_IN_ENGLISH, map.get(TrademarksConstants.TRADEMARK_LOCALIZED));

		respMap.put(TrademarksConstants.COUNTRY_COLUMN, map.get(TrademarksConstants.COUNTRY));
		respMap.put(TrademarksConstants.STATUS_COLUMN, map.get(TrademarksConstants.STATUS));
		respMap.put(TrademarksConstants.REGISTRATION_NUMBER_COLUMN, map.get(TrademarksConstants.REGISTRATION_NUMBER));
		respMap.put(TrademarksConstants.FIRST_REG_DATE_COLUMN, map.get(TrademarksConstants.FIRST_REG_DATE));
		respMap.put(TrademarksConstants.EXPIRY_DATE_COLUMN, map.get(TrademarksConstants.EXPIRY_DATE));
		respMap.put(TrademarksConstants.INTERNATIONAL_REG_NUM_COLUMN,
				map.get(TrademarksConstants.INTERNATIONAL_REG_NUM));
		respMap.put(TrademarksConstants.PRIORITY_DATE_COLUMN, map.get(TrademarksConstants.PRIORITY_DATE));
		String litIdsStr = map.get(TrademarksConstants.LITIGATION_IDS);
		String litigations = "";
		if (Validator.isNotNull(litIdsStr)) {
			LitigationSearch litigationSearch = new LitigationSearch(request, response);
			String[] litIds = litIdsStr.split(",");
			for (String litId : litIds) {
				String filedBy = GetterUtil.getString(litigationSearch.geLitigationFiledBy(litId));
				litigations = litigations.concat(", ").concat(filedBy);
			}
		}
		if (Validator.isNotNull(litigations))
			respMap.put(TrademarksConstants.CONTENTIOUS_PROCEEDINGS_COLUMN, litigations.substring(2));

		respMap.put(TrademarksConstants.REGISTERED_OWNER_COLUMN, map.get(TrademarksConstants.REGISTERED_OWNER));
		respMap.put(TrademarksConstants.ACTIVE_INGREDIENTS_COLUMN, map.get(TrademarksConstants.ACTIVE_IN_GREDIENTS));
		respMap.put(TrademarksConstants.RENEWAL_ALERT_BEFORE_COLUMN, map.get(TrademarksConstants.RENEWAL_ALERT_BEFORE));
		respMap.put(WordUtils.capitalize(TrademarksConstants.VERSION), map.get(TrademarksConstants.VERSION));
		respMap.put(TrademarksConstants.UPDATE_BY_COLUMN, map.get(TrademarksConstants.UPDATE_BY));
		respMap.put(TrademarksConstants.MODIFIED_DATE_COLUMN, map.get(TrademarksConstants.MODIFIED_DATE));
		respMap.put(TrademarksConstants.REMARKS_COLUMN, map.get(TrademarksConstants.REMARKS));
		respMap.put(TrademarksConstants.HISTORY_COLUMN, map.get(TrademarksConstants.CUSTOM_FIELD_3));

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean authorized = false;
		try {
			authorized = LegalPermissionUtil.isUserHavingRegionalRole(themeDisplay.getUserId());
			if (authorized)
				respMap.put(TrademarksConstants.LEGAL_CONF_REMARKS_COLUMN,
						map.get(TrademarksConstants.LEGAL_CONF_REMARKS));
		} catch (Exception e) {
		}

		List<Map<String, String>> classCodes = Utils.parseClassCodesJson(trademark.getClassCodes(), false);
		int i = 1;
		for (Map<String, String> ccMap : classCodes) {
			respMap.put(TrademarksConstants.CLASS_CODE_COLUMN + "#" + i, "Class # " + ccMap.get("cCode"));
			respMap.put(TrademarksConstants.CLASS_DESCRIPTION_COLUMN + "#" + i++, ccMap.get("cSpec"));
		}

		rec.setDataMap(respMap);
		List<ReportRecord> list = new ArrayList<ReportRecord>();
		list.add(rec);

		ReportPayload payload = new ReportPayload();
		payload.useDefaultMap();
		payload.setRecList(list);
		payload.setType(ReportGenerator.TRADEMARK_DETAILS);
		try {
			generator.generateReport(payload, new File(fileName));
		} catch (Exception e) {
			_log.error("Error while creating pdf file", e);
		}
	}

	private String exportTrademarksDetailsXls(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortalException {
		String fileName = Utils.generateExportFileName(resourceRequest, "trademark_details", ".xlsx");
		ReportGenerator generator = ReportGenerator.getExcelGenerator();
		this.generateDetailsReport(resourceRequest, resourceResponse, fileName, generator);
		return fileName;
	}

	private String exportTrademarksDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortalException {
		String fileName = Utils.generateExportFileName(resourceRequest, "trademark_details", ".pdf");
		ReportGenerator generator = ReportGenerator.getPdfGenerator("trademarkDetails", "trademark",
				(ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY));
		this.generateDetailsReport(resourceRequest, resourceResponse, fileName, generator);
		return fileName;
	}

	public void addTrademarks(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			Utils.logTheRequest(actionRequest, _log);
			LegalPermissionUtil.authorize(actionRequest, TrademarksConstants.PORTLET_ID,
					TrademarksConstants.ACTION_KEY_ADD_TRADEMARK);
		} catch (Exception ex) {
			_log.error("Somoone who is not authorized tried to add trademarks UserId " + themeDisplay.getUserId());
			SessionErrors.add(actionRequest, "unauthorized.trademarks.add");
			throw ex;
		}
		User user = themeDisplay.getUser();
		Map<String, String> paramMap = Utils.getParameterMap(actionRequest);
		long[] categoryIds = getCategoryIds(paramMap);
		String countryName = Utils.getCategoryName(categoryIds[0]);
		String applicationNo = paramMap.get(TrademarksConstants.APPLICATION_NO);
		long countryVocId = GetterUtil.getLong(actionRequest.getPreferences().getValue(
				TrademarksConstants.COUNTRY_VOC_ID, "0"));
		boolean canAdd = Utils.checkUserPermissionOnCountry(actionRequest, countryVocId, countryName);
		Map<String, DateBean> dates = getDateBeanMap(themeDisplay, paramMap);
		if (!canAdd && Validator.isNotNull(countryName)) {
			SessionErrors.add(actionRequest, "unauthorized.trademarks.country.add");
			onAddFail(actionRequest, actionResponse, paramMap, dates);
			return;
		}

		boolean valid = validate(actionRequest, paramMap, "add", dates);

		/*
		 * Object[] classCodeInfos = parseClassCodeInfo(paramMap, categoryIds);
		 * categoryIds = (long[]) classCodeInfos[0]; JSONArray array =
		 * (JSONArray) classCodeInfos[1];
		 */
		if (!valid) {
			onAddFail(actionRequest, actionResponse, paramMap, dates);
		} else {
			Trademarks trademark = null;
			try {
				trademark = TrademarksLocalServiceUtil.getNewTrademarks();
				fillTrademarksObject(trademark, paramMap, actionRequest, dates);
				trademark.setCountry(countryName);
				trademark.setApplicationNo(applicationNo);
				TrademarksLocalServiceUtil.addNewTrademarks(themeDisplay.getUserId(), trademark, categoryIds);
				SessionMessages.add(actionRequest, "request_processed", "Trademarks has been added");
				long statusId = GetterUtil.getLong(paramMap.get(TrademarksConstants.STATUS));
				setStatusMsg(statusId, actionRequest, trademark.getRootSpTrademarksId());
			} catch (Exception ex) {
				_log.error(ex.getMessage(), ex);
				SessionErrors.add(actionRequest, "trademarks.add.error");
				onAddFail(actionRequest, actionResponse, paramMap, dates);
				trademark = null;
			}
			if (Validator.isNotNull(trademark)) {
				try {
					Utils.initalizeAdmin();
					String folderName = getTrademarksFolderName(trademark);
					long[] folderIds = TrademarksSearch.getFolderIds(actionRequest, folderName);
					updateAndMoveDocuments(actionRequest, trademark.getSpTrademarksId(), folderIds[0],
							TrademarksConstants.FOLDER_NAME_ATTACHEMENTS);
					updateAndMoveDocuments(actionRequest, trademark.getSpTrademarksId(), folderIds[1],
							TrademarksConstants.FOLDER_NAME_CONF_ATTACHEMENTS);
					String type = paramMap.get(TrademarksConstants.TRADEMARK_TYPE);
					if (TrademarksConstants.LOGO.equalsIgnoreCase(type)) {
						updateAndMoveDocuments(actionRequest, trademark.getSpTrademarksId(), folderIds[2],
								TrademarksConstants.FOLDER_NAME_TRADEMARK_LOGOS);
					}
					clearTempLogoFolder(actionRequest);
					Utils.resetToUser(user);
				} catch (Exception ex) {
					_log.error(ex.getMessage(), ex);
					// SessionErrors.add(actionRequest,
					// "trademarks.file.upload.error");
					// onAddFail(actionRequest, actionResponse, paramMap,dates);
				}
				actionRequest.setAttribute(TrademarksConstants.TRADEMARKS_ID, trademark.getSpTrademarksId());
				displayTrademarksDetailsAfterAddUpdate(actionRequest, actionResponse);
			}

		}
	}

	private void setStatusMsg(long categoryId, PortletRequest request, long rootId) {
		String name = Utils.getCategoryName(categoryId).toLowerCase();
		_log.debug("status =" + name);
		if (TrademarksConstants.STATUS_CANCELLED.equalsIgnoreCase(name)
				|| TrademarksConstants.STATUS_OPPOSED.equalsIgnoreCase(name)
				|| TrademarksConstants.STATUS_REVOKED.equalsIgnoreCase(name)) {
			request.setAttribute("statusMsg", "Status is " + name + ". Create corresponding Contentious Proceedings");
			request.setAttribute("rootTMId", rootId);
		}
	}

	@SuppressWarnings("unused")
	private Object[] parseClassCodeInfo(Map<String, String> paramMap, long[] categoryIds) {
		List<Long> list = new ArrayList<Long>();
		JSONArray array = JSONFactoryUtil.createJSONArray();
		for (int i = 1; i <= TrademarksConstants.MAX_CLASS_CODES; i++) {
			String cCode = paramMap.get(TrademarksConstants.CC_PREFIX + i);
			if (cCode == null)
				break;
			list.add(GetterUtil.getLong(cCode));
			String cSpec = paramMap.get(TrademarksConstants.CC_SPEC_PREFIX + i);
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put(cCode, cSpec);
			array.put(obj);
		}
		for (int i = 0; i < categoryIds.length; i++) {
			list.add(categoryIds[i]);
		}
		return new Object[] { ArrayUtils.toPrimitive(list.toArray(new Long[list.size()])), array };
	}

	private void onAddFail(ActionRequest actionRequest, ActionResponse actionResponse, Map<String, String> paramMap,
			Map<String, DateBean> dates) throws Exception {
		SessionErrors.add(actionRequest, "trademarks.add.errors.exists");

		Set<String> keys = paramMap.keySet();
		for (String key : keys) {
			actionResponse.setRenderParameter(key, paramMap.get(key));
		}
		setDatesToRequest(actionRequest, dates);

		String ccJson = getClassCodeJsonString(paramMap);
		List<Map<String, String>> classCodes = Utils.parseClassCodesJson(ccJson, false);
		actionRequest.setAttribute(TrademarksConstants.CLASS_CODES, classCodes);
		actionRequest.setAttribute(TrademarksConstants.CLASS_CODES_SIZE, classCodes.size() + 1);

		displayAddTrademarks(actionRequest, actionResponse);
	}

	private void setDatesToRequest(ActionRequest actionRequest, Map<String, DateBean> dates) {
		if (Validator.isNotNull(dates)) {
			actionRequest.setAttribute(TrademarksConstants.APPLICATION_DATE,
					dates.get(TrademarksConstants.APPLICATION_DATE));
			actionRequest.setAttribute(TrademarksConstants.FIRST_REG_DATE,
					dates.get(TrademarksConstants.FIRST_REG_DATE));
			actionRequest.setAttribute(TrademarksConstants.EXPIRY_DATE, dates.get(TrademarksConstants.EXPIRY_DATE));
			actionRequest.setAttribute(TrademarksConstants.PRIORITY_DATE, dates.get(TrademarksConstants.PRIORITY_DATE));
			// actionRequest.setAttribute(TrademarksConstants.CUSTOM_DATE_2,dates.get(TrademarksConstants.CUSTOM_DATE_2));
			// actionRequest.setAttribute(TrademarksConstants.CUSTOM_DATE_3,dates.get(TrademarksConstants.CUSTOM_DATE_3));
		}
	}

	private void clearTempLogoFolder(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		// clear logo folder in user_<id> folder
		String userFolderName = Utils.getUserFolderName(themeDisplay.getUserId());
		long ufids[];
		try {
			ufids = TrademarksSearch.getFolderIds(request, userFolderName);
			List<FileEntry> fes = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), ufids[2]);
			for (FileEntry fe : fes) {
				DLAppServiceUtil.deleteFileEntry(fe.getFileEntryId());
			}
		} catch (Exception e) {
		}
	}

	private boolean validate(PortletRequest request, Map<String, String> paramMap, String action,
			Map<String, DateBean> dates) {
		boolean valid = true;
		// ThemeDisplay themeDisplay = (ThemeDisplay) request
		// .getAttribute(WebKeys.THEME_DISPLAY);
		// String type = paramMap.get(TrademarksConstants.TRADEMARK_TYPE);
		// //String trademark = paramMap.get(TrademarksConstants.TRADEMARK);
		// String classDescription =
		// paramMap.get(TrademarksConstants.CLASS_DESCRIPTION);
		String applicationNo = paramMap.get(TrademarksConstants.APPLICATION_NO);
		// String registerOwner =
		// paramMap.get(TrademarksConstants.REGISTERED_OWNER);
		// String goodsServices =
		// paramMap.get(TrademarksConstants.GOODS_SERVICES);
		// String pendingComments =
		// paramMap.get(TrademarksConstants.PENDING_COMMENTS);
		// String remarks =
		// paramMap.get(TrademarksConstants.LEGAL_CONF_REMARKS);
		// String regNum =
		// paramMap.get(TrademarksConstants.REGISTRATION_NUMBER);
		long categoryIds[] = getCategoryIds(paramMap);
		if ("add".equalsIgnoreCase(action)) {
			String countryName = Utils.getCategoryName(GetterUtil.getLong(paramMap
					.get(TrademarksConstants.COUNTRY_LIST)));
			if (Validator.isNull(applicationNo)) {
				valid = false;
				SessionErrors.add(request, "trademarks.applicationNo.required");
			}
			Trademarks temp = TrademarksLocalServiceUtil.findByApplicationNoCountry(applicationNo, countryName);
			if (temp != null) {
				valid = false;
				SessionErrors.add(request, "trademarks.duplicate");
			}
			if (categoryIds[0] == 0) {
				valid = false;
				SessionErrors.add(request, "trademarks.country.required");
			}
		} else {

		}
		boolean dateValid = UIUtils.validateDate(dates.get(TrademarksConstants.APPLICATION_DATE));
		if (!dateValid) {
			valid = false;
			SessionErrors.add(request, "trademarks.applicaiton.date");
		}
		dateValid = UIUtils.validateDate(dates.get(TrademarksConstants.FIRST_REG_DATE));
		if (!dateValid) {
			valid = false;
			SessionErrors.add(request, "trademarks.registration.date");
		}
		dateValid = UIUtils.validateDate(dates.get(TrademarksConstants.EXPIRY_DATE));
		if (!dateValid) {
			valid = false;
			SessionErrors.add(request, "trademarks.expiry.date");
		}
		dateValid = UIUtils.validateDate(dates.get(TrademarksConstants.PRIORITY_DATE));
		if (!dateValid) {
			valid = false;
			SessionErrors.add(request, "trademarks.priority.date");
		}

		String type = paramMap.get(TrademarksConstants.TRADEMARK_TYPE);
		if (TrademarksConstants.WORD.equalsIgnoreCase(type)) {
			String trademark = GetterUtil.getString(paramMap.get(TrademarksConstants.TRADEMARK));
			boolean nonEnglishFound = Utils.checkNonEnglishChars(trademark);
			if (nonEnglishFound) {
				if (Validator.isNull(paramMap.get(TrademarksConstants.TRADEMARK_LOCALIZED))) {
					valid = false;
					SessionErrors.add(request, "trademarks.trademark.localized.required");
				}
			} else {
				if (Validator.isNull(trademark)) {
					valid = false;
					SessionErrors.add(request, "trademarks.trademark.required");
				}
			}

		} else {
			// String userFolderName =
			// Utils.getUserFolderName(themeDisplay.getUserId());
			// trademarks.setTrademark(getTrademarkLogoTitle(actionRequest,userFolderName));

		}

		return valid;
	}

	private Object[] seperateAttachements(List<FileItem> files) {
		Object[] objs = new Object[3];
		List<FileItem> attachments = new ArrayList<FileItem>();
		List<FileItem> confAttachments = new ArrayList<FileItem>();
		List<FileItem> trademarksLog = new ArrayList<FileItem>();
		String fieldName;
		for (FileItem fileItem : files) {
			if (!Utils.nullOrEmpty(fileItem.getName())) {
				fieldName = fileItem.getFieldName();
				if (fieldName.endsWith(TrademarksConstants.CONF_ATTACHMENTS)) {
					confAttachments.add(fileItem);
				} else if (fieldName.endsWith(TrademarksConstants.ATTACHMENTS)) {
					attachments.add(fileItem);
				} else if (fieldName.endsWith(TrademarksConstants.TRADEMARK_LOGO)) {
					trademarksLog.add(fileItem);
				}
			}
		}
		objs[0] = attachments;
		objs[1] = confAttachments;
		objs[2] = trademarksLog;
		return objs;
	}

	private void updateAndMoveDocuments(PortletRequest request, long trademarksId, long destFolderId,
			String srcFolderName) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String userFolderName = Utils.getUserFolderName(themeDisplay.getUserId());
		try {
			long repositoryId = themeDisplay.getScopeGroupId();

			long legalFolderId = DLAppServiceUtil.getFolder(repositoryId, 0, LegalConstants.LEGAL_ROOT_FOLDER_NAME)
					.getFolderId();

			long trademarksRootFolderId = DLAppServiceUtil.getFolder(repositoryId, legalFolderId,
					TrademarksConstants.TRADEMARK_ROOT_FOLDER_NAME).getFolderId();

			long userFolderId = DLAppServiceUtil.getFolder(repositoryId, trademarksRootFolderId, userFolderName)
					.getFolderId();
			Folder srcUserFolder = DLAppServiceUtil.getFolder(repositoryId, userFolderId, srcFolderName);

			FilesUpload fu = new FilesUpload(trademarksId, request);
			if (srcFolderName.equals(TrademarksConstants.FOLDER_NAME_TRADEMARK_LOGOS)) {
				fu.updateAndUploadTrademarkLogo(srcUserFolder.getFolderId(), destFolderId);
			} else {
				fu.updateAndMoveDocuments(srcUserFolder.getFolderId(), destFolderId);
			}
		} catch (Exception ex) {
			_log.error(ex);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void updateTrademarks(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {
			Utils.logTheRequest(actionRequest, _log);
			LegalPermissionUtil.authorize(actionRequest, TrademarksConstants.PORTLET_ID,
					TrademarksConstants.ACTION_KEY_EDIT_TRADEMARK);
		} catch (Exception ex) {
			SessionErrors.add(actionRequest, "unauthorized.trademarks.update");
			throw ex;
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User loggedInUser = themeDisplay.getUser();

		Map<String, String> paramMap = Utils.getParameterMap(actionRequest);
		long[] categoryIds = getCategoryIds(paramMap);
		Map<String, DateBean> dates = getDateBeanMap(themeDisplay, paramMap);

		PortletPreferences preferences = actionRequest.getPreferences();
		String oldTmId = paramMap.get(TrademarksConstants.TRADEMARKS_ID);
		if (Validator.isNull(oldTmId) || GetterUtil.getLong(oldTmId) == 0) {
			SessionErrors.add(actionRequest, "trademarks.trademarksId.missing");
			onUpdateFail(actionRequest, actionResponse, paramMap, null, dates);
			return;
		}

		long oldTrademarkId = ParamUtil.getLong(actionRequest, TrademarksConstants.TRADEMARKS_ID);
		Trademarks oldTrademarks = TrademarksLocalServiceUtil.getTrademarks(oldTrademarkId);
		if (!TrademarksSearch.isTrademarkLatest(oldTrademarks)) {
			SessionErrors.add(actionRequest, "trademarks.not.working.copy");
			onUpdateFail(actionRequest, actionResponse, paramMap, oldTrademarks, dates);
			return;
		}
		// String applicationNo =
		// oldTrademarks.get(TrademarksConstants.APPLICATION_NO);
		long rootTMId = oldTrademarks.getRootSpTrademarksId();
		String country = oldTrademarks.getCountry();
		long countryId = Utils.getCategoryId(
				GetterUtil.getLong(preferences.getValue(TrademarksConstants.COUNTRY_VOC_ID, "0")), country);
		categoryIds[0] = countryId;
		boolean canEdit = Utils.checkUserPermissionOnCountry(actionRequest,
				GetterUtil.getLong(preferences.getValue(TrademarksConstants.COUNTRY_VOC_ID, "0")), country);
		if (!canEdit) {
			SessionErrors.add(actionRequest, "unauthorized.trademarks.country.update");
			onUpdateFail(actionRequest, actionResponse, paramMap, oldTrademarks, dates);
			return;
		}
		boolean valid = validate(actionRequest, paramMap, "update", dates);

		// String regNum =
		// oldTrademarks.get(TrademarksConstants.REGISTRATION_NUMBER);

		if (!valid) {
			onUpdateFail(actionRequest, actionResponse, paramMap, oldTrademarks, dates);
		} else {
			Trademarks newTrademark = null;
			try {
				newTrademark = TrademarksLocalServiceUtil.getNewTrademarks();
				// Setting legal conf remarks has been taken in impl class
				fillTrademarksObject(newTrademark, paramMap, actionRequest, dates);

				/*
				 * boolean authorized =
				 * LegalPermissionUtil.isUserHavingRegionalRole
				 * (themeDisplay.getUserId()); if(!authorized){
				 * newTrademark.setLegalConfRemarks
				 * (oldTrademarks.get(TrademarksConstants.LEGAL_CONF_REMARKS));
				 * }
				 */

				/*
				 * if(Validator.isNull(newTrademark.getTrademark())){ //String
				 * foldername =
				 * TrademarksSearch.getTrademarksFolderName(oldTrademarks.get(),
				 * country)
				 * newTrademark.setTrademark(oldTrademarks.get(TrademarksConstants
				 * .TRADEMARK)); }
				 */

				if (TrademarksConstants.LOGO.equalsIgnoreCase(newTrademark.getTrademarkType())) {
					if (Validator.isNull(newTrademark.getTrademark())) {
						String fname = TrademarksSearch.getTrademarksFolderName(rootTMId);
						newTrademark.setTrademark(getTrademarkLogoTitle(actionRequest, fname));
					}
				}

				TrademarksLocalServiceUtil.addNewTrademarksVersion(themeDisplay.getUserId(), oldTrademarkId,
						newTrademark, categoryIds);
				long statusId = GetterUtil.getLong(paramMap.get(TrademarksConstants.STATUS));
				TrademarksSearch tmSearch = new TrademarksSearch(actionRequest, actionResponse);
				Map<String, String> rootTM = tmSearch.getTrademarksMap(rootTMId, false);
				String litIdsStr = rootTM.get(TrademarksConstants.LITIGATION_IDS);
				_log.debug("Litigation String " + litIdsStr);
				if (Validator.isNull(litIdsStr)) {
					setStatusMsg(statusId, actionRequest, Long.valueOf(rootTMId).longValue());
				}
				SessionMessages.add(actionRequest, "request_processed", "Trademarks has been updated");
			} catch (Exception ex) {
				_log.error("Error while updating trademarks");
				_log.error(ex);
				SessionErrors.add(actionRequest, "trademarks.update.error");
				onUpdateFail(actionRequest, actionResponse, paramMap, oldTrademarks, dates);
				newTrademark = null;
			}
			if (Validator.isNotNull(newTrademark)) {
				try {
					Utils.initalizeAdmin();
					String folderName = getTrademarksFolderName(newTrademark);
					long folderIds[] = TrademarksSearch.getFolderIds(actionRequest, folderName);
					String idsStr = paramMap.get("hiddenFileList");
					if (idsStr != null && !idsStr.equals("")) {
						String[] idsArray = idsStr.split(",");
						List<Long> fileEntryIds = new ArrayList<Long>();
						for (String id : idsArray) {
							try {
								fileEntryIds.add(Long.parseLong(id));
							} catch (Exception ex) {
								_log.error(ex.getCause(), ex);
							}
						}
						Utils.markFileVersionsAsDelete(fileEntryIds);
						DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(DLFileEntry.class,
								PortalClassLoaderUtil.getClassLoader());
						Criterion criterion = RestrictionsFactoryUtil.in(TrademarksConstants.FILE_ENTRY_ID,
								(List) fileEntryIds);
						dynaQuery.add(criterion);
						List<DLFileEntry> filesToReindx = DLFileEntryLocalServiceUtil.dynamicQuery(dynaQuery);

						Indexer indexer = IndexerRegistryUtil.getIndexer(DLFileEntry.class.getName());
						for (DLFileEntry dlFileEntry : filesToReindx) {
							indexer.delete(dlFileEntry);
						}
					}
					updateAndMoveDocuments(actionRequest, newTrademark.getSpTrademarksId(), folderIds[0],
							TrademarksConstants.FOLDER_NAME_ATTACHEMENTS);
					updateAndMoveDocuments(actionRequest, newTrademark.getSpTrademarksId(), folderIds[1],
							TrademarksConstants.FOLDER_NAME_CONF_ATTACHEMENTS);
					String type = paramMap.get(TrademarksConstants.TRADEMARK_TYPE);
					if (TrademarksConstants.LOGO.equalsIgnoreCase(type)) {
						updateAndMoveDocuments(actionRequest, newTrademark.getSpTrademarksId(), folderIds[2],
								TrademarksConstants.FOLDER_NAME_TRADEMARK_LOGOS);
					}
					clearTempLogoFolder(actionRequest);
					Utils.resetToUser(loggedInUser);
				} catch (Exception ex) {
					SessionErrors.add(actionRequest, "trademarks.upload.error");
					onUpdateFail(actionRequest, actionResponse, paramMap, oldTrademarks, dates);
				}

				actionRequest.setAttribute(TrademarksConstants.TRADEMARKS_ID, newTrademark.getSpTrademarksId());
				displayTrademarksDetailsAfterAddUpdate(actionRequest, actionResponse);
			}
		}

	}

	private String getTrademarkLogoTitle(PortletRequest request, String folderName) {
		String title = "";
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			// String userFolderName =
			// Utils.getUserFolderName(themeDisplay.getUserId());
			long folderIds[] = TrademarksSearch.getFolderIds(request, folderName);
			List<FileEntry> list = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folderIds[2], 0, 1);
			if (Validator.isNotNull(list) && list.size() > 0) {
				FileEntry fe = list.get(0);
				title = request.getParameter("title_" + fe.getFileEntryId());
				if (Validator.isNull(title)) {
					title = fe.getTitle();
				}
				title = FilesUpload.removeLogoExtension(title);
			}
		} catch (Exception ex) {
			_log.error("Error while getting logo title" + ex.getMessage());
		}
		return title;
	}

	private void onUpdateFail(ActionRequest actionRequest, ActionResponse actionResponse, Map<String, String> paramMap,
			Trademarks oldTrademarks, Map<String, DateBean> dates) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Set<String> keys = paramMap.keySet();
		for (String key : keys) {
			actionResponse.setRenderParameter(key, paramMap.get(key));
		}
		String applicationNo = StringPool.BLANK;
		long rootTrademarkId = 0;
		long countryId = 0;
		long oldTrademarkId = ParamUtil.getLong(actionRequest, TrademarksConstants.TRADEMARKS_ID);

		if (Validator.isNotNull(oldTrademarks)) {
			applicationNo = oldTrademarks.getApplicationNo();
			rootTrademarkId = oldTrademarks.getRootSpTrademarksId();
			countryId = Utils.getCategoryId(GetterUtil.getLong(actionRequest.getPreferences().getValue(
					TrademarksConstants.COUNTRY_VOC_ID, "0")), GetterUtil.getString(oldTrademarks.getCountry()));
		}

		actionResponse.setRenderParameter(actionResponse.getNamespace() + TrademarksConstants.APPLICATION_NO,
				applicationNo);
		actionResponse.setRenderParameter(actionResponse.getNamespace() + TrademarksConstants.COUNTRY_LIST, countryId
				+ "");

		setDatesToRequest(actionRequest, dates);

		boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(themeDisplay.getUserId());
		actionRequest.setAttribute(TrademarksConstants.REGIONAL_ROLE_NAME, authorized);
		fillCategoryLists(actionRequest, actionResponse);
		setFilesList(actionRequest, String.valueOf(rootTrademarkId));
		actionRequest.setAttribute(TrademarksConstants.TRADEMARKS_ID, oldTrademarkId);
		actionResponse.setRenderParameter("jspPage", "/html/trademarks/editTrademark.jsp");

		String type = paramMap.get(TrademarksConstants.TRADEMARK_TYPE);
		actionRequest.setAttribute(TrademarksConstants.TRADEMARK_TYPE, type);

		String ccJson = getClassCodeJsonString(paramMap);
		List<Map<String, String>> classCodes = Utils.parseClassCodesJson(ccJson, false);
		actionRequest.setAttribute(TrademarksConstants.CLASS_CODES, classCodes);
		actionRequest.setAttribute(TrademarksConstants.CLASS_CODES_SIZE, classCodes.size() + 1);

	}

	private String getTrademarksFolderName(Trademarks trademark) {
		return TrademarksSearch.getTrademarksFolderName(trademark.getRootSpTrademarksId());
	}

	public void upload(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {
			LegalPermissionUtil.authorize(actionRequest, TrademarksConstants.PORTLET_ID,
					TrademarksConstants.ACTION_KEY_BULKUPLOAD_TRADEMARK);
		} catch (Exception ex) {
			SessionErrors.add(actionRequest, "unauthorized.trademarks.bulkupload");
			throw ex;
		}
		try {
			TrademarksBulkupload bu = new TrademarksBulkupload(actionRequest, actionResponse);
			bu.process();
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) {

		PortletPreferences preferences = actionRequest.getPreferences();

		String countryVocId = ParamUtil.getString(actionRequest, TrademarksConstants.COUNTRY_VOC_ID, "0");
		String classCodeVocId = ParamUtil.getString(actionRequest, TrademarksConstants.CLASS_CODE_VOC_ID, "0");
		// String trademarkTypeVocId =
		// ParamUtil.getString(actionRequest,TrademarksConstants.TRADEMARK_TYPE_VOC_ID,
		// "0");
		String statusVocId = ParamUtil.getString(actionRequest, TrademarksConstants.STATUS_VOC_ID, "0");
		String renewalAlertVocId = ParamUtil.getString(actionRequest, TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID,
				"0");
		// String oppStatusVocId =
		// ParamUtil.getString(actionRequest,TrademarksConstants.OPPOSITION_STATUS_VOC_ID,
		// "0");
		String customList1VocId = ParamUtil.getString(actionRequest, TrademarksConstants.REGISTERED_OWNER_VOC_ID, "0");
		// String customList2VocId =
		// ParamUtil.getString(actionRequest,TrademarksConstants.CUSTOM_LIST_2_VOC_ID,
		// "0");
		// String customList3VocId =
		// ParamUtil.getString(actionRequest,TrademarksConstants.CUSTOM_LIST_3_VOC_ID,
		// "0");
		String workflowEnabled = ParamUtil.getString(actionRequest, TrademarksConstants.WORKFLOW_ENABLED, "false");
		try {
			preferences.setValue(TrademarksConstants.COUNTRY_VOC_ID, countryVocId);
			preferences.setValue(TrademarksConstants.CLASS_CODE_VOC_ID, classCodeVocId);
			// preferences.setValue(TrademarksConstants.TRADEMARK_TYPE_VOC_ID,
			// trademarkTypeVocId);
			preferences.setValue(TrademarksConstants.STATUS_VOC_ID, statusVocId);
			preferences.setValue(TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID, renewalAlertVocId);
			// preferences.setValue(TrademarksConstants.OPPOSITION_STATUS_VOC_ID,
			// oppStatusVocId);
			preferences.setValue(TrademarksConstants.REGISTERED_OWNER_VOC_ID, customList1VocId);
			// preferences.setValue(TrademarksConstants.CUSTOM_LIST_2_VOC_ID,
			// customList2VocId);
			// preferences.setValue(TrademarksConstants.CUSTOM_LIST_3_VOC_ID,
			// customList3VocId );
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);

			Utils.saveSPParameter(SambaashConstants.TRADEMARK_WORKFLOW_ENABLED, workflowEnabled);
			Utils.saveSPParameter(SambaashConstants.TRADEMARKS_RENEWAL_ALERT_VOC_ID, renewalAlertVocId);
			Utils.saveSPParameter(SambaashConstants.TRADEMARKS_CLASS_CODE_VOC_ID, classCodeVocId);
			Utils.saveSPParameter(SambaashConstants.TRADEMARKS_REGISTERED_OWNER_VOC_ID, customList1VocId);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {

			PortletPreferences preferences = renderRequest.getPreferences();

			String countryVocId = preferences.getValue(TrademarksConstants.COUNTRY_VOC_ID, "0");
			String classCodeVocId = preferences.getValue(TrademarksConstants.CLASS_CODE_VOC_ID, "0");
			// String trademarkTypeVocId =
			// preferences.getValue(TrademarksConstants.TRADEMARK_TYPE_VOC_ID,
			// "0");
			String statusVocId = preferences.getValue(TrademarksConstants.STATUS_VOC_ID, "0");
			String renewalAlertVocId = preferences.getValue(TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID, "0");
			// String oppStatusVocId =
			// preferences.getValue(TrademarksConstants.OPPOSITION_STATUS_VOC_ID,
			// "0");
			String customList1VocId = preferences.getValue(TrademarksConstants.REGISTERED_OWNER_VOC_ID, "0");
			// String customList2VocId =
			// preferences.getValue(TrademarksConstants.CUSTOM_LIST_2_VOC_ID,
			// "0");
			// String customList3VocId =
			// preferences.getValue(TrademarksConstants.CUSTOM_LIST_3_VOC_ID,
			// "0");

			boolean trademarkWfEnabled = new Boolean(SambaashUtil.getParameter(
					SambaashConstants.TRADEMARK_WORKFLOW_ENABLED, 0));
			if (trademarkWfEnabled) {
				renderRequest.setAttribute(TrademarksConstants.WORKFLOW_ENABLED, "true");
			} else {
				renderRequest.setAttribute(TrademarksConstants.WORKFLOW_ENABLED, "false");
			}

			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
			renderRequest.setAttribute("assetVocabularies", assetVocabularies);
			renderRequest.setAttribute(TrademarksConstants.COUNTRY_VOC_ID, countryVocId);
			renderRequest.setAttribute(TrademarksConstants.CLASS_CODE_VOC_ID, classCodeVocId);
			// renderRequest.setAttribute(TrademarksConstants.TRADEMARK_TYPE_VOC_ID,
			// trademarkTypeVocId);
			renderRequest.setAttribute(TrademarksConstants.STATUS_VOC_ID, statusVocId);
			renderRequest.setAttribute(TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID, renewalAlertVocId);
			// renderRequest.setAttribute(TrademarksConstants.OPPOSITION_STATUS_VOC_ID,
			// oppStatusVocId);
			renderRequest.setAttribute(TrademarksConstants.REGISTERED_OWNER_VOC_ID, customList1VocId);
			// renderRequest.setAttribute(TrademarksConstants.CUSTOM_LIST_2_VOC_ID,
			// customList2VocId);
			// renderRequest.setAttribute(TrademarksConstants.CUSTOM_LIST_3_VOC_ID,
			// customList3VocId);

		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		}
		super.doEdit(renderRequest, renderResponse);
	}

	private void fillCategoryLists(ActionRequest actionRequest, ActionResponse actionResponse) {

		AgencySearch search = new AgencySearch(actionRequest, actionResponse);
		Map<String, String> agencies = search.geRootAgencies4mIndexer();
		actionRequest.setAttribute(AgencyConstants.AGENCIES, agencies);

		/*
		 * ClassSearch search1 = new ClassSearch(actionRequest, actionResponse);
		 * Map<String,String>classes = search1.getRootClasses4mIndexer();
		 * actionRequest.setAttribute(ClassMasterConstants.CLASSES, classes);
		 */

		PortletPreferences preferences = actionRequest.getPreferences();

		long countryVocId = GetterUtil.getLong(preferences.getValue(TrademarksConstants.COUNTRY_VOC_ID, "0"));
		// String trademarkTypeVocId =
		// preferences.getValue(TrademarksConstants.TRADEMARK_TYPE_VOC_ID, "0");
		String classCodeVocId = preferences.getValue(TrademarksConstants.CLASS_CODE_VOC_ID, "0");
		String statusVocId = preferences.getValue(TrademarksConstants.STATUS_VOC_ID, "0");
		String renewalAlertVocId = preferences.getValue(TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID, "0");
		// String oppStatusVocId =
		// preferences.getValue(TrademarksConstants.OPPOSITION_STATUS_VOC_ID,
		// "0");
		String customList1VocId = preferences.getValue(TrademarksConstants.REGISTERED_OWNER_VOC_ID, "0");
		// String customList2VocId =
		// preferences.getValue(TrademarksConstants.CUSTOM_LIST_2_VOC_ID, "0");
		// String customList3VocId =
		// preferences.getValue(TrademarksConstants.CUSTOM_LIST_3_VOC_ID, "0");

		List<AssetCategory> classCodeList = Utils
				.getCategories(Long.parseLong(classCodeVocId), LegalConstants.SORT_INT);
		List<AssetCategory> statusList = Utils.getCategories(Long.parseLong(statusVocId));
		List<AssetCategory> renewalAlertList = Utils.getCategories(Long.parseLong(renewalAlertVocId),
				LegalConstants.SORT_INT);
		/*
		 * List<AssetCategory> oppStatusList = Utils.getCategories(Long
		 * .parseLong(oppStatusVocId));
		 */
		List<AssetCategory> customList1 = Utils.getCategories(Long.parseLong(customList1VocId));
		/*
		 * List<AssetCategory> customList2 = Utils.getCategories(Long
		 * .parseLong(customList2VocId)); List<AssetCategory> customList3 =
		 * Utils.getCategories(Long .parseLong(customList3VocId));
		 */

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		LegalPermissionUtil pu = new LegalPermissionUtil();
		List<AssetCategory> countryList = pu.getPermissionedCountries(themeDisplay.getUserId(),
				themeDisplay.getScopeGroupId(), countryVocId);
		// List<AssetCategory>countryList = Utils.getCategories(countryVocId);

		// long countryVocId =
		// GetterUtil.getLong(actionRequest.getPreferences().getValue(TrademarksConstants.CLASS_CODE_VOC_ID,"0"));
		// List<AssetCategory> categories = Utils.getCategories(countryVocId);
		/*
		 * Collections.sort(classCodeList, new Comparator<AssetCategory>() {
		 * public int compare(AssetCategory o1, AssetCategory o2) { return new
		 * Long(o1.getCategoryId() - o2.getCategoryId()).intValue(); } });
		 */

		actionRequest.setAttribute(TrademarksConstants.COUNTRY_LIST, countryList);
		actionRequest.setAttribute(TrademarksConstants.CLASS_CODE, classCodeList);
		// actionRequest.setAttribute(TrademarksConstants.TRADEMARK_TYPE,
		// trademarkTypeList);
		actionRequest.setAttribute(TrademarksConstants.STATUS, statusList);
		actionRequest.setAttribute(TrademarksConstants.RENEWAL_ALERT_BEFORE, renewalAlertList);
		// actionRequest.setAttribute(TrademarksConstants.OPPOSITION_STATUS,
		// oppStatusList);
		actionRequest.setAttribute(TrademarksConstants.REGISTERED_OWNER_LIST, customList1);
		// actionRequest.setAttribute(TrademarksConstants.CUSTOM_LIST_2,
		// customList2);
		// actionRequest.setAttribute(TrademarksConstants.CUSTOM_LIST_3,
		// customList3);

	}

	private boolean canDownLoadFile(PortletRequest request) {
		boolean authorized = false;
		try {
			LegalPermissionUtil.authorize(request, TrademarksConstants.PORTLET_ID,
					TrademarksConstants.ACTION_KEY_DOWNLOAD_FILE);
			authorized = true;
		} catch (Exception ex) {
			// _log.error("Tradmark Download file Permission check failed ");
		}
		return authorized;
	}

	// For adding permissions to given role on all files and folders in Legal
	// folder. This action can be triggered Trademark Preferences page.
	// Usually permissions will be assigned when uploading file but to assign
	// permissions on all files and folders for particular role this can be
	// useful.
	public void addPermissions(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		Utils.initalizeAdmin();
		String roleName = ParamUtil.getString(actionRequest, "roleName");
		Folder srcFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, user, LegalConstants.DL_ROOT_FOLDER_ID,
				LegalConstants.LEGAL_ROOT_FOLDER_NAME, LegalConstants.FOLDER, false, false, false);
		addPermissions(srcFolder, themeDisplay.getCompanyId(), roleName);
		Utils.resetToUser(user);
	}

	// For sending mail alerts about expired trademarks to given roles.This
	// action can be triggered Trademark Preferences page.
	// This is a manual approach for triggering mails. We have Schedular job
	// which actually triggers mails.
	public void sendMailsForRoles(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String roleNames = ParamUtil.getString(actionRequest, "roleNames");
		RenewalAlertMailHelper.sendMailsToUsersHavingRole(themeDisplay.getCompanyId(), roleNames);
	}

	// For sending mail alerts about expired trademarks to users having
	// permissions.This action can be triggered Trademark Preferences page.
	// This is a manual approach for triggering mails. We have Schedular job
	// which actually triggers mails.
	public void sendMailsToUsersHavingPermissions(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		RenewalAlertMailHelper.sendMails();
	}

	private void addPermissions(Folder folder, long companyId, String roleName) throws PortalException,
			SystemException, IOException {
		try {
			Utils.addDefaultFolderPermissionsToRole(companyId, folder.getFolderId(), roleName);
			if (Validator.isNotNull(folder)) {
				List<Folder> childFolders = DLAppServiceUtil.getFolders(folder.getGroupId(), folder.getFolderId());
				for (Folder childFolder : childFolders) {
					addPermissions(childFolder, companyId, roleName);
				}
				List<FileEntry> fes = DLAppServiceUtil.getFileEntries(folder.getGroupId(), folder.getFolderId());
				for (FileEntry fe : fes) {
					try {
						Utils.addDefaultFilePermissionsToRole(companyId, fe.getFileEntryId(), roleName);
					} catch (Exception ex) {
						_log.error("Error while assigning permissions for file entry id " + fe.getFileEntryId());
					}
				}
			}
		} catch (Exception e) {
			_log.error("Error while assigning permissions");
		}
	}

}
