package com.sambaash.platform.spchallenge.helper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.time.DateUtils;
import org.omg.CORBA.SystemException;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.wrapper.HttpServletRequestWrapperExtended;

public class SPChallengeHelper {

	private static final Log logger = LogFactoryUtil.getLog(SPChallengeHelper.class);

	public static JSONObject handleSearch(ResourceRequest resourceRequest, int itemsPerPage) {
		String searchItems = ParamUtil.getString(resourceRequest, SPChallengeConstants.PARAM_SEARCH_ITEMS);
		int pageNo = ParamUtil.getInteger(resourceRequest, SPChallengeConstants.PARAM_SEARCH_PAGE_NO);
		String searchType = ParamUtil.getString(resourceRequest, SPChallengeConstants.PARAM_SEARCH_TYPE);
		return handleSearch(searchItems, null, pageNo, itemsPerPage, searchType, resourceRequest);
	}

	@SuppressWarnings("unchecked")
	public static JSONObject handleSearch(String searchItems, String query, int pageNo, int itemsPerPage,
			String searchType, PortletRequest resourceRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		try {
			if (Validator.isNull(searchType)) {
				searchType = SPChallengeConstants.ATTRIB_CHALLENGE;
			}
			if (searchType.equals(SPChallengeConstants.ATTRIB_CHALLENGE)) {
				int start = (pageNo * itemsPerPage);
				int end = start + itemsPerPage;
				Map<String, Object> results = handleChallengeSearch(resourceRequest, searchItems, query, start, end,
						searchType, themeDisplay.getCompanyId());
				JSONArray array = getChallengesJson((List<Document>) results.get(SPChallengeConstants.RESULTS),
						resourceRequest, start);
				obj.put(SPChallengeConstants.ITEMS, array);
				obj.put(SPChallengeConstants.PARAM_SEARCH_PAGE_NO, pageNo + 1);
				obj.put(SPChallengeConstants.MORE_DOCS_AVAILABLE,
						GetterUtil.getBoolean(results.get(SPChallengeConstants.MORE_DOCS_AVAILABLE)));
				logger.debug("returning search results " + obj);
				return obj;
			} else {
				logger.error(searchType + " search cant be handled");
			}
		} catch (Exception e) {
			logger.error("Error handling search, returning empty object", e);
		}
		return obj;
	}

	private static Map<Long, String> parseSearchFilters(String searchCatIds) {
		Map<Long, String> map = new HashMap<Long, String>();
		if (Validator.isNotNull(searchCatIds)) {
			String ids[] = searchCatIds.split(StringPool.COMMA);
			for (String id : ids) {
				String[] temp = id.split(StringPool.UNDERLINE);
				if (temp.length > 1) {
					long vocId = GetterUtil.getLong(temp[0]);
					long catId = GetterUtil.getLong(temp[1]);
					String catIds = map.get(vocId);
					if (Validator.isNull(catIds)) {
						catIds = String.valueOf(catId);
					} else {
						catIds = catIds + " " + String.valueOf(catId);
					}
					map.put(vocId, catIds);
				}
			}
		}
		logger.debug("search filters " + map);
		return map;
	}

	public static Map<String, Object> handleChallengeSearch(PortletRequest request, String searchItems, String query,
			int start, int end, String searchType, long companyId) {
		try {
			if (Validator.isNull(query)) {
				if (Validator.isNotNull(searchItems)) {
					Map<Long, String> map = parseSearchFilters(searchItems);
					for (long key : map.keySet()) {
						if (Validator.isNull(query)) {
							query = "( assetCategoryIds:(" + map.get(key) + ") )";
						} else {
							query = query + "  AND (assetCategoryIds:(" + map.get(key) + "))";
						}
					}
				}
			}
			logger.debug("query = " + query);
			return getSearchResults(request, companyId, start, end, query, true);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new HashMap<String, Object>();
	}

	public static Map<String, Object> getSearchResults(PortletRequest request, long companyId, int start, int end,
			String query, boolean activeOnly) {
		Map<String, Object> map = new HashMap<String, Object>();
		Hits results = SPChallengeLocalServiceUtil.searchChallenges(request, companyId, start, end, query, activeOnly);
		List<Document> list = new ArrayList<Document>();
		if (Validator.isNotNull(results)) {
			map.put(SPChallengeConstants.TOTAL_DOCS, results.getLength());
			if (end < results.getLength()) {
				map.put(SPChallengeConstants.MORE_DOCS_AVAILABLE, true);
			} else {
				map.put(SPChallengeConstants.MORE_DOCS_AVAILABLE, false);
			}
			int length = results.getDocs().length;
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				list.add(doc);
			}
		}
		map.put(SPChallengeConstants.RESULTS, list);
		return map;

	}

	public static JSONArray getChallengesJson(List<Document> docs, PortletRequest resourceRequest, int start) {
		JSONArray array = JSONFactoryUtil.createJSONArray();
		// ThemeDisplay themeDisplay = (ThemeDisplay)
		// resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// boolean isAdmin =
		// SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(),
		// themeDisplay.getUserId());
		if (Validator.isNotNull(docs)) {
			for (Document doc : docs) {
				// boolean isDraft =
				// GetterUtil.getBoolean(doc.get(SPChallengeConstants.DRAFT));
				// if (!isDraft
				// || isAdmin
				// || Long.valueOf(themeDisplay.getUserId()).compareTo(
				// GetterUtil.getLong(doc.get(Field.USER_ID))) == 0)
				array.put(documentToJSON(doc, resourceRequest, start++));
			}
		}
		return array;
	}

	public static boolean isChallengeRunning(Date startDate, Date endDate) {
		boolean running = false;
		try {
			Date date = new Date();
			if (DateUtils.isSameDay(date, startDate) || DateUtils.isSameDay(date, endDate)
					|| (date.after(startDate) && date.before(endDate))) {
				running = true;
			}
		} catch (Exception e) {
			logger.error("Error checking start dates", e);
		}
		return running;
	}

	public static JSONObject documentToJSON(Document doc, PortletRequest resourceRequest, int index) {
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (Validator.isNotNull(doc)) {
			obj = JSONFactoryUtil.createJSONObject();
			long challengeId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
			boolean isDraft = GetterUtil.getBoolean(doc.get(SPChallengeConstants.DRAFT));
			String temp = "";
			if (isDraft)
				temp = "[Draft] ";
			temp = temp + doc.get(SPChallengeConstants.NAME);
			obj.put(SPChallengeConstants.NAME, temp);
			obj.put(SPChallengeConstants.DESCRIPTION, doc.get(SPChallengeConstants.DESCRIPTION));
			obj.put(SPChallengeConstants.CHALLENGE_ID, challengeId);
			if (SPChallengePermissionHelper.canUpdateChallenge(resourceRequest, challengeId))
				obj.put(SPChallengeConstants.FRIENDLY_EDIT_URL, editChallengeFriendlyURL(themeDisplay, challengeId));
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				Date startDate = sdf.parse((String) doc.get(SPChallengeConstants.START_DATE));
				Date endDate = sdf.parse((String) doc.get(SPChallengeConstants.END_DATE));

				if (isChallengeRunning(startDate, endDate)) {
					obj.put("canApply", "true");
				}
				String DATE_FORMAT_MMMDDYYYY = "MMM dd, yyyy";
				SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_MMMDDYYYY);
				obj.put(SPChallengeConstants.END_DATE, df.format(endDate));
			} catch (Exception e) {
				logger.error("Error checking start dates", e);
			}
			obj.put(SPChallengeConstants.FRIENDLY_URL,
					displayChallengeFriendlyURL(themeDisplay, challengeId, "" + index));
			obj.put(Field.USER_NAME, doc.get(Field.USER_NAME));
			obj.put(SPChallengeConstants.POSITION_INDEX, index);
			String logoUrl = SambaashUtil.getDLFileIconUrl(resourceRequest,
					GetterUtil.getLong(doc.get(SPChallengeConstants.FILE_ENTRY_ID)));
			obj.put(SPChallengeConstants.LOGO_URL, logoUrl);
		}
		return obj;
	}

	public static boolean canEditChallenge(PortletRequest request, Long userId) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
		return isAdmin || (userId.compareTo(Long.valueOf(themeDisplay.getUserId())) == 0);
	}

	public static String findUsers(ResourceRequest resourceRequest, long companyId)
			throws SystemException, PortalException {

		String q = ParamUtil.getString(resourceRequest, "q");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String mailIcon = themeDisplay.getPathThemeImages() + "/send_by_email.png";
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray itemsJSONArray = JSONFactoryUtil.createJSONArray();

		String suggestion = "<div data-autocomplete-dom-id=\"option\" data-user-id=\"" + "%d" + "\" data-user-mail=\""
				+ "%s"
				+ "\" %s><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Auto Complete Image\" data-autocomplete-dom-id=\"option-img\" src=\""
				+ "%s"
				+ "\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><span data-autocomplete-dom-id=\"option-name\" class=\"sp-group-fwb\">"
				+ "%s" + "</span>(<span data-autocomplete-dom-id=\"option-email\" class=\"sp-group-fwb\">" + "%s"
				+ "</span>)</div></div></div></div></div>";

		String suggestinByMail = "<div data-autocomplete-dom-id=\"option\" data-user-id=\"0\" class=\"ip-sb-option\"><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Auto Complete Image\" src=\""
				+ mailIcon
				+ "\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><div class=\"sp-group-ui-lh1 mtxs mbs\">Send an email to</div><div data-autocomplete-dom-id=\"option-email\" class=\"sp-group-ui-lh1 sp-group-fwb\">"
				+ "%s" + "</div></div></div></div></div></div>";

		List<User> matchedUsers = new ArrayList<User>();

		if (Validator.isNotNull(q)) {
			try {
				matchedUsers = getMatchedUsers(q);
				long userId;
				String username;
				String userImage;
				String html;
				String email;
				String htmlClass;
				boolean first = true;
				for (User user : matchedUsers) {
					userId = user.getUserId();
					username = user.getScreenName();
					userImage = "/../image/user_male_portrait?img_id=" + user.getPortraitId();
					email = user.getEmailAddress();
					if (first) {
						first = false;
						htmlClass = "class=\"ip-sb-option hover\"";
					} else {
						htmlClass = "class=\"ip-sb-option\"";
					}
					html = String.format(suggestion, userId, email, htmlClass, userImage, username, email);
					JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
					htmlJSONObject.put("html", html);
					itemsJSONArray.put(htmlJSONObject);
				}

			} catch (Exception nsue) {
				String email = q;
				String html = String.format(suggestinByMail, email);
				JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
				htmlJSONObject.put("html", html);
				itemsJSONArray.put(htmlJSONObject);
			}
		} else {
		}
		dataJSONObject.put("items", itemsJSONArray);
		return dataJSONObject.toString();
	}

	@SuppressWarnings("unchecked")
	private static List<User> getMatchedUsers(String query) {
		List<User> matchedUsers = null;

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class,
					PortalClassLoaderUtil.getClassLoader());
			Criterion criterion = RestrictionsFactoryUtil.ilike("emailAddress", query + "%");
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("screenName", query + "%"));

			String[] firstAndLastnameQ = StringUtil.split(query, StringPool.SPACE);
			if (firstAndLastnameQ.length == 2) {
				String firstNameQ = firstAndLastnameQ[0].trim();
				String lastNameQ = firstAndLastnameQ[1].trim();
				criterion = RestrictionsFactoryUtil.or(criterion,
						RestrictionsFactoryUtil.ilike("firstName", firstNameQ + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion,
						RestrictionsFactoryUtil.ilike("lastName", lastNameQ + "%"));
			}

			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("firstName", query + "%"));
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("lastName", query + "%"));

			dynamicQuery.add(PropertyFactoryUtil.forName("emailAddressVerified").eq(new Boolean(true)));
			dynamicQuery.add(criterion);

			matchedUsers = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (Exception e) {
			logger.error("Error while getting matched users");
		}

		return matchedUsers;

	}

	public static boolean hasUserAppliedForChallenge(long challengeId, long orgId) {
		SPChallengeApplicant applicant = SPChallengeApplicantLocalServiceUtil
				.findByChallengeIdApplicantRefId(challengeId, orgId);
		if (Validator.isNotNull(applicant)) {
			return true;
		}
		return false;
	}

	public static String displayStartupProfileFriendlyURL(ThemeDisplay themeDisplay, long orgId) {
		return OrganizationLocalServiceUtil.displayFriendlyURL(themeDisplay, orgId);
	}

	public static String displayChallengeFriendlyURL(ThemeDisplay themeDisplay, long challengeId, String index) {
		String format = "%s/-/spchallenge/view/challenge/%s/%s";
		return String.format(format, SPChallengeHelper.getChallengesPath(), challengeId, index);
	}

	public static String applyChallengeFriendlyURL(ThemeDisplay themeDisplay, long challengeId, boolean external) {
		String format = external ? "%s/-/spchallenge/apply/challenge/ext/%s/"
				: "%s/-/spchallenge/apply/challenge/%s/";
		return String.format(format, SPChallengeHelper.getChallengesPath(), challengeId);
	}

	public static String createChallengeFriendlyURL(ThemeDisplay themeDisplay) {

		if (themeDisplay.isSignedIn()) {
			return String.format("%s/-/spchallenge/create/challenge", getChallengesPath());
		} else {

			String loginUrl = SambaashUtil.getSignInURL(themeDisplay.getScopeGroupId(), themeDisplay, true);
			return String.format("%s%sredirect=%s/-/spchallenge/create/challenge", loginUrl,
					loginUrl.contains("?") ? "&" : "?", getChallengesPath());
		}
	}

	public static String editChallengeFriendlyURL(ThemeDisplay themeDisplay, long challengeId) {
		if (themeDisplay.isSignedIn()) {
			return String.format("%s/-/spchallenge/edit/challenge/%s", getChallengesPath(), challengeId);
		} else {

			String loginUrl = SambaashUtil.getSignInURL(themeDisplay.getScopeGroupId(), themeDisplay, true);
			return String.format("%s%sredirect=%s/-/spchallenge/edit/challenge/%s", loginUrl,
					loginUrl.contains("?") ? "&" : "?", getChallengesPath(), challengeId);
		}
	}

	public static String applyChallengeFriendlyURL(ThemeDisplay themeDisplay, long challengeId, long orgId) {
		if (themeDisplay.isSignedIn()) {
			return String.format("%s/-/spchallenge/create/applicant/%s/%s", getChallengesPath(), challengeId, orgId);
		} else {

			String loginUrl = SambaashUtil.getSignInURL(themeDisplay.getScopeGroupId(), themeDisplay, true);
			return String.format("%s%sredirect=%s/-/spchallenge/create/applicant/%s/%s", loginUrl,
					loginUrl.contains("?") ? "&" : "?", getChallengesPath(), challengeId, orgId);
		}
	}

	public static String displayApplicationFriendlyURL(ThemeDisplay themeDisplay, long applicantId) {
		return 	SPChallengeLocalServiceUtil.displayApplicationFriendlyURL(themeDisplay, applicantId);
	}

	public static String editApplicationFriendlyURL(ThemeDisplay themeDisplay, long applicantId) {
		return 	SPChallengeLocalServiceUtil.editApplicationFriendlyURL(themeDisplay, applicantId);
	}

	public static String createOrgFriendlyURL(ThemeDisplay themeDisplay) {
		return OrganizationLocalServiceUtil.createFriendlyURL(themeDisplay);
	}

	public static String editOrgFriendlyURL(ThemeDisplay themeDisplay, long orgId) {
		return OrganizationLocalServiceUtil.editFriendlyURL(themeDisplay, orgId);
	}

	public static String getStartupCreatePath() {
		String pageHome = "";
		try {
			pageHome = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(0, SPChallengeConstants.SP_PARAM_STARTUP_CREATE).getValue();
		} catch (Exception e) {
			pageHome = "/startupprofile";
		}
		return pageHome;
	}

	public static String getStartupDisplayPath() {
		String pageHome = "";
		try {
			pageHome = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(0, SPChallengeConstants.SP_PARAM_STARTUP_DISP).getValue();
		} catch (Exception e) {
			pageHome = "/display-startup";
		}
		return pageHome;
	}

	public static String getChallengesPath() {
		return 	SPChallengeLocalServiceUtil.getChallengesPath();
	}

	public static String getChallengesListPath() {
		String pageHome = "";
		try {
			pageHome = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(0, SPChallengeConstants.SP_PARAM_CHALLENGE_LIST_HOME).getValue();
		} catch (Exception e) {
			pageHome = "/briefs";
		}
		return pageHome;
	}
	
	public static String extractDescription(String mydata) {
		// mydata =
		// "<?xml version='1.0' encoding='UTF-8'?><root
		// available-locales=\"en_US\"
		// default-locale=\"en_US\"><Description>Creative
		// Crowdsourcing</Description></root>";
		int start = mydata.indexOf(">", mydata.indexOf("<Description")) + 1;
		int end = mydata.indexOf("</", start);
		if (start > 0 && end > 0)
			return mydata.substring(start, end);
		else
			return "";
	}

	public static HttpServletRequestWrapper getHttpRequestWrapper(PortletRequest request) {
		return new HttpServletRequestWrapperExtended(PortalUtil.getHttpServletRequest(request));
	}

	public static HttpServletRequestWrapper getHttpRequestWrapperMultiPart(PortletRequest request,
			Map<String, String> paramMap) {
		return new HttpServletRequestWrapperExtended(PortalUtil.getHttpServletRequest(request), paramMap);
	}

	public static long[] getFoundryAdminIds(ThemeDisplay themeDisplay) throws Exception {
		String temp = SambaashUtil.getParameter("foundry.admin.rolenames", 0);
		if (Validator.isNull(temp)) {
			temp = "Foundry Admin";
		}
		Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), temp);
		long[] userIds = UserLocalServiceUtil.getRoleUserIds(role.getRoleId());
		return userIds;
	}

	public static void prepareNextPrevUrls(PortletRequest request, ThemeDisplay themeDisplay) {
		try {
			String posIndex = request.getParameter(SPChallengeConstants.POSITION_INDEX);
			int pos = -1;
			if (Validator.isNull(posIndex) || posIndex.equals(StringPool.DASH)) {
				pos = findCurrentIndex(request, themeDisplay);
			} else {
				pos = Integer.parseInt(posIndex);
			}
			Hits hits = SPChallengeLocalServiceUtil.searchChallenges(request, themeDisplay.getCompanyId(), pos, pos + 1,
					null, true);
			int end = hits.getLength() - 1;
			int prevIndex = pos - 1;
			int nextIndex = pos + 1;
			if (nextIndex > end) {
				nextIndex = 0;
			}
			if (prevIndex < 0) {
				prevIndex = end;
			}
			hits = SPChallengeLocalServiceUtil.searchChallenges(request, themeDisplay.getCompanyId(), prevIndex,
					prevIndex + 1, null, true);
			long challengeId = GetterUtil.getLong(hits.doc(0).get(Field.ENTRY_CLASS_PK));
			String url = SPChallengeHelper.displayChallengeFriendlyURL(themeDisplay, challengeId, "" + prevIndex);
			request.setAttribute("prevUrl", url);
			hits = SPChallengeLocalServiceUtil.searchChallenges(request, themeDisplay.getCompanyId(), nextIndex,
					nextIndex + 1, null, true);
			challengeId = GetterUtil.getLong(hits.doc(0).get(Field.ENTRY_CLASS_PK));
			url = SPChallengeHelper.displayChallengeFriendlyURL(themeDisplay, challengeId, "" + nextIndex);
			request.setAttribute("nextUrl", url);
		} catch (Exception e) {
			logger.error("Error while setting previous and next urls!! URL = " + themeDisplay.getURLCurrent(), e);
		}
	}

	private static int findCurrentIndex(PortletRequest request, ThemeDisplay themeDisplay) {

		try {

			long challengeId = ParamUtil.getLong(request, SPChallengeConstants.CHALLENGE_ID);

			if (Validator.isNotNull(challengeId)) {

				Hits hits = SPChallengeLocalServiceUtil.searchChallenges(request, themeDisplay.getCompanyId(), -1, -1,
						null, true);

				if (logger.isDebugEnabled()) {
					logger.debug("Search result size : " + hits.getLength());
				}

				if (Validator.isNotNull(hits)) {
					for (int i = 0; i < hits.getLength(); i++) {
						Document doc = hits.doc(i);
						long docChallengeId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
						if (docChallengeId == challengeId) {

							if (logger.isDebugEnabled()) {
								logger.debug(
										"Found the challenge with index : " + i + " : challengeId : " + challengeId);
							}

							return i;
						}
					}

				}
			}
		} catch (Exception e) {
			//ignore and consider as 0
		}
		return 0;
	}

	public static String generateExportFileName(long userId, String prefix, String suffix) {
		String tmp = prefix + "_" + System.currentTimeMillis() + "_" + userId + suffix;

		return System.getProperty("java.io.tmpdir") + File.separator + tmp;
	}
}
