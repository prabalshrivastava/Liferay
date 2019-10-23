package com.sambaash.platform.portlet.documentlibrary.action;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;
import javax.portlet.PortletConfig;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.TicketConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ldap.LDAPSettingsUtil;
import com.liferay.portal.security.ldap.PortalLDAPUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.PwdGenerator;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.sharing.model.SPSharing;
import com.sambaash.platform.srv.sharing.service.SPSharingLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class ShareFileAndFolderAction extends PortletAction {
	
	private static final String SHARING_ID = "sharingId";
	private static final String TITLE = "title";
	private static final String INTERNAL_SHARE = "internalShare";
	private static final String USERID = "userId";
	private static final String SHARED_NAME = "sharedName";
	private static final String DURATION = "duration";
	private static final String IS_EXTEND = "isExtend";
	private static final String INDEX = "index";
	private static final String SHOW_EXTEND = "showExtend";
	private static final String WRITE_ACCESS = "writeAccess";
	private static final String SHARE_USER_ID = "shareUserId";
	private static final String SHARE_USER_EMAIL = "shareUserEmail";

	private static Log _log = LogFactoryUtil.getLog(ShareFileAndFolderAction.class);
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String durationList = StringPool.BLANK;

		/** List of files & folders shared **/

		_log.debug("renderrequest fileentryid " + renderRequest.getParameter("fileEntryId"));
		String fileEId = renderRequest.getParameter("fileEntryId");
		String foldId = renderRequest.getParameter("folderId");
		String fileEIds = renderRequest.getParameter("fileEntryIds");
		String foldIds = renderRequest.getParameter("folderIds");
		_log.debug("fileEId " + fileEId + " foldId " + foldId);
		_log.debug("fileEIds " + fileEIds + " foldIds " + foldIds);

		long classNameId = PortalUtil.getClassNameId(DLFileEntry.class.getName());
		String sharedFileName = "File / Folder";

		if (Validator.isNull(foldId) && Validator.isNotNull(foldIds)) {
			foldId = foldIds;
		}
		if (Validator.isNull(foldId) && Validator.isNull(foldIds)) {
			foldId = "0";
		}

		if (Validator.isNull(fileEId) && Validator.isNotNull(fileEIds)) {
			fileEId = fileEIds;
		}
		if (Validator.isNull(fileEId) && Validator.isNull(fileEIds)) {
			fileEId = "0";
		}

		StringBuilder sb = new StringBuilder();
		List<Map<String, String>> sharings = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		int index = 2;
		Date today = new Date();
		if (!fileEId.equalsIgnoreCase("0")) {
			String[] indFileEIds = fileEId.split(",");
			for (String indFileEId : indFileEIds) {
				long fileEntryId = Long.parseLong(indFileEId);
				List<SPSharing> spSharing = SPSharingLocalServiceUtil.getFileSharing(themeDisplay.getUserId(), fileEntryId,
						classNameId);
				_log.debug("spSharing " + spSharing + " " + PortalUtil.getClassNameId(DLFileEntry.class.getName())
						+ " " + fileEntryId);
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
				sharedFileName = "File >> " + fileEntry.getTitle();
				for (SPSharing indShare : spSharing) {
					map = new HashMap<String, String>();
					
					String sharedEmail = StringPool.BLANK;
					String sharedName = StringPool.BLANK;
					_log.info("indShare.getUserId() = " + indShare.getUserId());
					if(Long.valueOf(indShare.getUserId()).equals(0L)) {
						_log.info("getting data from ldap");
						List<Map<String, String>> userList = searchLdap(themeDisplay.getCompanyId(),
								indShare.getEmailAddress());
						if(userList.size() > 0) {
							Map<String, String> userMap = userList.get(0);
							sharedEmail = userMap.get(SambaashConstants.LDAP_MAIL);
							sharedName = userMap.get(SambaashConstants.LDAP_SAM_ACC_NAME);
						} else {
							sharedEmail = indShare.getEmailAddress();
						}
					} else {
						try{
							User user = UserLocalServiceUtil.getUser(indShare.getUserId());
							sharedEmail = user.getEmailAddress();
							sharedName = user.getScreenName();
							
						}catch(NoSuchUserException nse){
							continue;
						}
					}
					
					String isExtend = StringPool.BLANK;
					if (themeDisplay.getUser().getScreenName().equalsIgnoreCase(indShare.getUserName())) {

						Calendar cal = resetTime(Calendar.getInstance());
						cal.add(Calendar.DATE, 30);
						if (cal.before(indShare.getEndDate())) {
							isExtend = "Extend";
						}
					}

					map.put(SHARING_ID, String.valueOf(indShare.getSpSharingId()));
					map.put(TITLE, GetterUtil.getString(fileEntry.getTitle()));
					map.put(INTERNAL_SHARE, String.valueOf(indShare.getInternalShare()));
					map.put(USERID, String.valueOf(indShare.getUserId()));
					map.put(SHARED_NAME, GetterUtil.getString(sharedName + "(" + sharedEmail + ")"));
					map.put(DURATION,
							GetterUtil.getString(dateFormat.format(indShare.getStartDate()) + " to "
									+ dateFormat.format(indShare.getEndDate())));
					map.put(WRITE_ACCESS, indShare.isWritePermission()? "Enabled" : "Disabled");
					map.put(IS_EXTEND, GetterUtil.getString(isExtend));
					map.put(INDEX, String.valueOf(index));
					long diff = indShare.getEndDate().getTime() - today.getTime();
					long days = diff / (24 * 60 * 60 * 1000);
					if (days <= 30) {
						map.put(SHOW_EXTEND, "true");
					} else {
						map.put(SHOW_EXTEND, "false");
					}
					index = index + 1;

					sharings.add(map);

					sb.append("'");
					sb.append(sharedEmail);
					sb.append("'");
					sb.append(",");
				}
			}
		}
		if (!foldId.equalsIgnoreCase("0")) {
			String[] indFoldIds = foldId.split(",");
			for (String indFoldId : indFoldIds) {
				long folderId = Long.parseLong(indFoldId);
				classNameId = PortalUtil.getClassNameId(DLFolder.class.getName());
				List<SPSharing> spSharing = SPSharingLocalServiceUtil.getFileSharing(themeDisplay.getUserId(), folderId,
						classNameId);
				DLFolder folderEntry = DLFolderLocalServiceUtil.getFolder(folderId);
				sharedFileName = "Folder >> " + folderEntry.getName();
				for (SPSharing indShare : spSharing) {
					map = new HashMap<String, String>();
					String sharedEmail = StringPool.BLANK;
					String sharedName = StringPool.BLANK;
					_log.info("indShare.getUserId() = " + indShare.getUserId());
					if(Long.valueOf(indShare.getUserId()).equals(0L)) {
						_log.info("getting data from ldap");
						List<Map<String, String>> userList = searchLdap(themeDisplay.getCompanyId(),
								indShare.getEmailAddress());
						if(userList.size() > 0) {
							Map<String, String> userMap = userList.get(0);
							sharedEmail = userMap.get(SambaashConstants.LDAP_MAIL);
							sharedName = userMap.get(SambaashConstants.LDAP_SAM_ACC_NAME);
						} else {
							sharedEmail = indShare.getEmailAddress();
						}
					} else {
						User user = UserLocalServiceUtil.getUser(indShare.getUserId());
						sharedEmail = user.getEmailAddress();
						sharedName = user.getScreenName();
					}
					String isExtend = StringPool.BLANK;
					Calendar cal = resetTime(Calendar.getInstance());
					cal.add(Calendar.DATE, 30);

					if (cal.before(indShare.getEndDate())) {
						isExtend = "Extend";
					}

					map.put(SHARING_ID, String.valueOf(indShare.getSpSharingId()));
					map.put(TITLE, GetterUtil.getString(folderEntry.getName()));
					map.put(INTERNAL_SHARE, String.valueOf(indShare.getInternalShare()));
					map.put(USERID, String.valueOf(indShare.getUserId()));
					map.put(SHARED_NAME, GetterUtil.getString(sharedName + "(" + sharedEmail + ")"));
					map.put(DURATION,
							GetterUtil.getString(dateFormat.format(indShare.getStartDate()) + " to "
									+ dateFormat.format(indShare.getEndDate())));
					map.put(WRITE_ACCESS, indShare.isWritePermission()? "Enabled" : "Disabled");
					map.put(IS_EXTEND, GetterUtil.getString(isExtend));
					map.put(INDEX, String.valueOf(index));
					index = index + 1;

					long diff = indShare.getEndDate().getTime() - today.getTime();
					long days = diff / (24 * 60 * 60 * 1000);
					if (days <= 30) {
						map.put(SHOW_EXTEND, "true");
					} else {
						map.put(SHOW_EXTEND, "false");
					}

					sharings.add(map);
					sb.append("'");
					sb.append(sharedEmail);
					sb.append("'");
					sb.append(",");
				}
			}
		}
		durationList = getShareDuration(themeDisplay.getScopeGroupId());

		renderRequest.setAttribute("durationList", durationList);
		if (sb.length() > 0) {
			if (sb.charAt(sb.length() - 1) == ',') {
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		renderRequest.setAttribute("sharedEmailList", sb.toString());

		renderRequest.setAttribute("sharingList", sharings);
		renderRequest.setAttribute("indexVal", index);
		renderRequest.setAttribute("sharedFileName", sharedFileName);
		_log.debug("durationList " + durationList);

		return mapping.findForward(getForward(renderRequest, "portlet.document_library.share_file_entry"));
	}

	public void serveResource(ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = resourceRequest.getPreferences();
		String type = ParamUtil.getString(resourceRequest, "action");
		String sharingId = resourceRequest.getParameter(SHARING_ID);
		String sharedToUser = resourceRequest.getParameter("sharedToUser");
		String extendDuration = resourceRequest.getParameter("extendDuration");
		if (type.equalsIgnoreCase("Delete")) {
			SPSharing share = null;
			try {
				share = SPSharingLocalServiceUtil.getSPSharing(GetterUtil.getLong(sharingId));
				SPSharingLocalServiceUtil.deleteSPSharing(Long.parseLong(sharingId));

			} catch (Exception e) {
				_log.debug("Shared data not deleted for " + sharedToUser + " " + e.getMessage());
			}
			resourceResponse.setContentType("application/json");
			resourceResponse.setCharacterEncoding("utf-8");
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			if (Validator.isNotNull(share)) {
				obj.put("sharedEmail", share.getEmailAddress());
			}
			obj.put("status", "Success");
			resourceResponse.getWriter().append(obj.toString());
		}
		if (type.equalsIgnoreCase("extendDate")) {
			SPSharing sharingData = SPSharingLocalServiceUtil.getSPSharing(Long.parseLong(sharingId));
			Calendar cal = resetTime(Calendar.getInstance());

			Date dt = sharingData.getEndDate();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			cal.setTime(dt);
			cal.add(Calendar.DATE, Integer.valueOf(extendDuration));

			String output = sdf.format(cal.getTime());
			_log.debug("Output :: " + output);

			sharingData.setEndDate(cal.getTime());
			sharingData = SPSharingLocalServiceUtil.updateSPSharing(sharingData);
			String updatedDuration = dateFormat.format(sharingData.getStartDate()) + " to "
					+ dateFormat.format(sharingData.getEndDate());
			resourceResponse.getWriter().write(updatedDuration);
		}
		if (type.equalsIgnoreCase("findInvitePeopleSuggestions")) {
			String inviteBy = resourceRequest.getParameter("invite_by");
			resourceResponse.setContentType("application/json");
			resourceResponse.setCharacterEncoding("utf-8");
			if ("email".equalsIgnoreCase(inviteBy)) {
				resourceResponse.getWriter().write(findUsers(resourceRequest, themeDisplay.getCompanyId()));
			}

		} else if (type.equalsIgnoreCase("changePermission")) {
			Boolean writeAccess = ParamUtil.getBoolean(resourceRequest,
					WRITE_ACCESS);
			try { 
				SPSharing sharingData = SPSharingLocalServiceUtil.getSPSharing(Long
						.parseLong(sharingId));
				sharingData.setWritePermission(writeAccess);
				SPSharingLocalServiceUtil.updateSPSharing(sharingData);
				_log.debug("Changed write access of sharing Id " + sharingId
						+ " to " + writeAccess);
			} catch (Exception e) {
				_log.error("Error while udpating writeaccess status", e);
			}
		} else if (type.equalsIgnoreCase("inviteFriends")) {
			String inviteBy = resourceRequest.getParameter("invite_by");
			resourceResponse.setContentType("application/json");
			resourceResponse.setCharacterEncoding("utf-8");
			if ("email".equalsIgnoreCase(inviteBy)) {
				resourceResponse.getWriter().write(
						inviteFriendsByEmailJsonString(themeDisplay, resourceRequest, resourceResponse, preferences));
			}

		}
	}

	@SuppressWarnings("unchecked")
	private String findUsers(ResourceRequest resourceRequest, long companyId) throws SystemException, PortalException {

		String q = ParamUtil.getString(resourceRequest, "q");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String mailIcon = themeDisplay.getPathThemeImages() + "/send_by_email.png";
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray itemsJSONArray = JSONFactoryUtil.createJSONArray();

		String suggestion = "<div data-autocomplete-dom-id=\"option\" data-user-id=\""
				+ "%d"
				+ "\" data-user-mail=\""
				+ "%s"
				+ "\" %s><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Autocomplete Image\" data-autocomplete-dom-id=\"option-img\" src=\""
				+ "%s"
				+ "\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><span data-autocomplete-dom-id=\"option-name\" class=\"sp-group-fwb\">"
				+ "%s" + "</span>(<span data-autocomplete-dom-id=\"option-email\" class=\"sp-group-fwb\">" + "%s"
				+ "</span>)</div></div></div></div></div>";

		String suggestinByMail = "<div data-autocomplete-dom-id=\"option\" data-user-id=\"0\" class=\"ip-sb-option\"><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Autocomplete Image\" src=\""
				+ mailIcon
				+ "\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><div class=\"sp-group-ui-lh1 mtxs mbs\">Send an email to</div><div data-autocomplete-dom-id=\"option-email\" class=\"sp-group-ui-lh1 sp-group-fwb\">"
				+ "%s" + "</div></div></div></div></div></div>";

		List<User> matchedUsers = new ArrayList<User>();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
				.forClass(User.class, PortalClassLoaderUtil.getClassLoader());

		if (Validator.isNotNull(q)) {
			try {
				dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil.getClassLoader());
				Criterion criterion = RestrictionsFactoryUtil.ilike("emailAddress", q + "%");
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("screenName", q + "%"));

				String[] firstAndLastnameQ = StringUtil.split(q, StringPool.SPACE);
				if (firstAndLastnameQ.length == 2) {
					String firstNameQ = firstAndLastnameQ[0].trim();
					String lastNameQ = firstAndLastnameQ[1].trim();
					criterion = RestrictionsFactoryUtil.or(criterion,
							RestrictionsFactoryUtil.ilike("firstName", firstNameQ + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion,
							RestrictionsFactoryUtil.ilike("lastName", lastNameQ + "%"));
				}

				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("firstName", q + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("lastName", q + "%"));

				dynamicQuery.add(PropertyFactoryUtil.forName("emailAddressVerified").eq(new Boolean(true)));
				dynamicQuery.add(criterion);

				matchedUsers = UserLocalServiceUtil.dynamicQuery(dynamicQuery);

				long userId;
				String username;
				String userImage;
				String html;
				String email;
				String sharedTypeToGetUserList = ParamUtil.getString(resourceRequest, "sharedTypeToGetUserList");
				String htmlClass;
				boolean process = false;
				boolean isInternalShare = "internalShare".equalsIgnoreCase(sharedTypeToGetUserList);
				boolean isExternalShare = "externalShare".equalsIgnoreCase(sharedTypeToGetUserList);
				boolean first = true;
				for (User user : matchedUsers) {
					userId = user.getUserId();
					username = user.getScreenName();
					userImage = "/../image/user_male_portrait?img_id=" + user.getPortraitId();
					process = false;
					email = user.getEmailAddress();
					String domain = email.substring(email.indexOf('@') + 1);
					if (isInternalShare) {
						if (domain.toLowerCase().contains("menariniapac")) {
							process = true;
						}
					} else if (isExternalShare) {
						if (!domain.toLowerCase().contains("menariniapac")) {
							process = true;
						}
					}
					if (process) {
						if (first) {
							first = false;
							htmlClass = "class=\"ip-sb-option hover\"";
						} else {
							htmlClass = "class=\"ip-sb-option\"";
						}
						html = String.format(suggestion, userId, user.getEmailAddress(), htmlClass, userImage,
								username, user.getEmailAddress());
						JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
						htmlJSONObject.put("html", html);
						itemsJSONArray.put(htmlJSONObject);

					}

				}

				if (isInternalShare && matchedUsers.isEmpty()) {
					List<Map<String, String>> list = searchLdap(companyId, q);
					first = true;
					userImage = "/../image/user_male_portrait?img_id=0";
					for (Map<String, String> map : list) {
						if (first) {
							first = false;
							htmlClass = "class=\"ip-sb-option hover\"";
						} else {
							htmlClass = "class=\"ip-sb-option\"";
						}
						String mail = map.get(SambaashConstants.LDAP_USER_PRINCIPLE_NAME);
						if (Validator.isNotNull(mail)) {
							html = String.format(suggestion, 0, mail, htmlClass,
									userImage, map.get(SambaashConstants.LDAP_DISPLAYNAME),	mail);
							JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
							htmlJSONObject.put("html", html);
							itemsJSONArray.put(htmlJSONObject);
						}
					}
				}
				process = false;
				if (isExternalShare && matchedUsers.isEmpty() && Validator.isEmailAddress(q)) {
					String domain = q.substring(q.indexOf('@') + 1);
					if (!domain.toLowerCase().contains("menariniapac")) {
						process = true;
					}
				}
				if (process) {
					email = q;
					html = String.format(suggestinByMail, email);
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

	private String inviteFriendsByEmailJsonString(ThemeDisplay themeDisplay, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, PortletPreferences preferences) throws PortalException, SystemException,
			WindowStateException, PortletModeException {

		String fileEntryIds = ParamUtil.getString(resourceRequest, "fileEntryId");
		String folderIds = ParamUtil.getString(resourceRequest, "folderId");
		String shareUserList = ParamUtil.getString(resourceRequest, "send_to");
		long userId = themeDisplay.getUserId();
		boolean internalShare = ParamUtil.getBoolean(resourceRequest, "shareType");
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject singleDataJSONObject = JSONFactoryUtil.createJSONObject();
		String[] fileEntryId = fileEntryIds.split(StringPool.COMMA);
		String[] folderId = folderIds.split(StringPool.COMMA);
		if (fileEntryId.length > 0) {
			for (String flEntryId : fileEntryId) {
				if (Long.parseLong(flEntryId) > 0) {
					singleDataJSONObject = share(resourceRequest, userId, internalShare, shareUserList, themeDisplay,
							flEntryId, "0");
					dataJSONObject.put(flEntryId, singleDataJSONObject);
				}
			}
		}
		if (folderId.length > 0) {
			for (String fdEntryId : folderId) {
				if (Long.parseLong(fdEntryId) > 0) {
					singleDataJSONObject = share(resourceRequest, userId, internalShare, shareUserList, themeDisplay,
							"0", fdEntryId);
					dataJSONObject.put(fdEntryId, singleDataJSONObject);
				}
			}
		}

		_log.debug("dataJSONObject " + dataJSONObject);
		return dataJSONObject.toString();
	}

	private JSONObject share(ResourceRequest resourceRequest, long userId, boolean internalShare, String shareUserList,
			ThemeDisplay themeDisplay, String fileEntryId, String folderId) {
		JSONObject sharingList = JSONFactoryUtil.createJSONObject();

		String durationList = ParamUtil.getString(resourceRequest, "durationList");
		String permissionList = ParamUtil.getString(resourceRequest, "permissionList");
		if (!shareUserList.isEmpty()) {
			String[] shareUsers = shareUserList.split(StringPool.SEMICOLON);
			_log.debug("shareUserIds " + shareUsers);
			_log.debug("fileEntryId pp " + fileEntryId);
			_log.debug("folderId pp " + folderId);

			long classNameId = 0;
			long classPK = 0;
			String sharedFileName = StringPool.BLANK;

			try {
				if (Long.parseLong(fileEntryId) > 0) {
					classNameId = PortalUtil.getClassNameId(DLFileEntry.class.getName());
					classPK = Long.parseLong(fileEntryId);
					DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(classPK);
					sharedFileName = fileEntry.getTitle();
				} else {
					classNameId = PortalUtil.getClassNameId(DLFolder.class.getName());
					classPK = Long.parseLong(folderId);
					DLFolder folders = DLFolderLocalServiceUtil.getFolder(classPK);
					sharedFileName = folders.getName();
				}
				int durationCounter = 0;
				String[] intDuration = null;
				if (Validator.isNotNull(durationList)) {
					intDuration = durationList.split(",");
				}
				
				String[] permissionArray = null;
				if (Validator.isNotNull(permissionList)) {
					permissionArray = permissionList.split(",");
				}
				
				for (String shareUser : shareUsers) {
					boolean newUser = false;
					long sendToUserId = 0;
					try {
						sendToUserId = Long.valueOf(shareUser);
					} catch (NumberFormatException nfe) {
						// do nothing
					}
					if (sendToUserId != 0) {
						try {
							User toUser = UserLocalServiceUtil.getUser(sendToUserId);
							shareUser = toUser.getEmailAddress();
						} catch (com.liferay.portal.NoSuchUserException nsue) {

						}
					}
					String isExtend = StringPool.BLANK;
					long sharedUserId = 0 ;
					String firstName = StringPool.BLANK;
					String screenName = StringPool.BLANK;
					if (!shareUser.equalsIgnoreCase("0")) {
						shareUser = shareUser.toLowerCase();
						String password = StringPool.BLANK;
						JSONObject sharingDetails = JSONFactoryUtil.createJSONObject();
						_log.debug("shareUserId " + shareUser);
						User user = null;
						try {
							SPSharingLocalServiceUtil.getSharing(shareUser, classNameId, classPK, internalShare);
							sharingList.put("error_" + shareUser, "Already shared with " + shareUser + " by a different user");
							_log.warn(shareUser + " already exist in share table. No record is created in Share table");
							continue;
						} catch (Exception ex) {
							_log.debug(shareUser + " does not exist in share table creating new record");

							Calendar startDate = resetTime(Calendar.getInstance());

							long sharingId = CounterLocalServiceUtil.increment("Sharing.class");
							SPSharing shareFiles = SPSharingLocalServiceUtil.createSPSharing(sharingId);
							shareFiles.setSpSharingId(sharingId);
							shareFiles.setClassNameId(classNameId);

							shareFiles.setClassPK(classPK);

							shareFiles.setCompanyId(themeDisplay.getCompanyId());
							shareFiles.setCreateDate(Calendar.getInstance().getTime());

							shareFiles.setCreatedBy(userId);
							shareFiles.setExpired(false);
							shareFiles.setGroupId(themeDisplay.getScopeGroupId());
							shareFiles.setModifiedDate(Calendar.getInstance().getTime());
							shareFiles.setStartDate(startDate.getTime());
							shareFiles.setUserName(themeDisplay.getUser().getScreenName());
							shareFiles.setInternalShare(internalShare);
							shareFiles.setWritePermission(Boolean.valueOf(permissionArray[durationCounter]));
							
							int duration = 0;
							if (Validator.isNotNull(durationList)) {
								duration = Integer.valueOf(intDuration[durationCounter]);
							}
							_log.debug("duration " + duration);
							Calendar endDate = resetTime(Calendar.getInstance());

							endDate.add(Calendar.DATE, duration);
							shareFiles.setEndDate(endDate.getTime());

							if (startDate.getTime().before(endDate.getTime())) {
								isExtend = "Extend";
							}
							
							sharingDetails.put(SHARING_ID, String.valueOf(sharingId));
							sharingDetails.put("sharedFileName", sharedFileName);
							sharingDetails.put("shareType", String.valueOf(internalShare));
							sharingDetails.put(WRITE_ACCESS,
									Boolean.valueOf(permissionArray[durationCounter]) ? "Enabled"
											: "Disabled");
							
							durationCounter = durationCounter + 1;
							shareFiles.setEmailAddress(shareUser);

							if (internalShare) {
								try {
									user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(),
											shareUser);
									sharingDetails.put(SHARE_USER_ID, user.getUserId());
									sharingDetails.put(SHARE_USER_EMAIL, user.getScreenName() + "(" + shareUser + ")");
									shareFiles.setUserId(user.getUserId());
									sharedUserId = user.getUserId();
									firstName = user.getFirstName();
									screenName = user.getScreenName();
								} catch (NoSuchUserException e) {
									List<Map<String, String>> userList = searchLdap(themeDisplay.getCompanyId(),
											shareUser);
									if(userList != null && userList.size() > 0 ){
										Map<String,String>userMap = userList.get(0);
										screenName = GetterUtil.getString(userMap.get(SambaashConstants.LDAP_SAM_ACC_NAME));
										try{
											 user = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), screenName);
											 sharingDetails.put(SHARE_USER_ID, user.getUserId());
											 sharingDetails.put(SHARE_USER_EMAIL, user.getScreenName() + "(" + shareUser + ")");
											 shareFiles.setUserId(user.getUserId());
											 sharedUserId = user.getUserId();
											 firstName = user.getFirstName();
											 screenName = user.getScreenName();
											 shareFiles.setEmailAddress(user.getEmailAddress());
										}catch(NoSuchUserException e1){
											sharingDetails.put(SHARE_USER_ID, 0);
											sharingDetails.put(SHARE_USER_EMAIL,
													userMap.get(SambaashConstants.LDAP_DISPLAYNAME) + "(" + shareUser
													+ ")");
											sharedUserId = 0;
											firstName = GetterUtil.getString(userMap.get(SambaashConstants.LDAP_GIVEN_NAME));
										}
										
									}else{
										sharingList.put("error_" + shareUser, "Unable to find user " + shareUser + ". Please type the email address and pick from auto suggestions.");
										continue;
									}
								}
							} else {
								_log.debug("emailext " + shareUser);
								try {
									user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(),
											shareUser);

									user.getExpandoBridge().setAttribute(SambaashConstants.USER.END_DATE,
											endDate.getTime());

									UserLocalServiceUtil.updateUser(user);

									sharingDetails.put(SHARE_USER_ID, user.getUserId());
									sharingDetails.put(SHARE_USER_EMAIL, user.getScreenName() + "(" + shareUser + ")");
									
									sharedUserId = user.getUserId();
									firstName = user.getFirstName();
									screenName = user.getScreenName();

								} catch (NoSuchUserException e) {
									newUser = true;
									password = PwdGenerator.getPassword();
									ServiceContext serviceContext = new ServiceContext();
									Map<String, Serializable> expandoAttributes = new HashMap<String, Serializable>();
								/*	user = SocialProfileLocalServiceUtil.addUserPlatform(
											shareUser.substring(0, shareUser.indexOf("@")),
											shareUser.substring(0, shareUser.indexOf("@")), shareUser, password, false,
											serviceContext); */
									firstName = shareUser.substring(0, shareUser.indexOf("@"));
									String lastName = shareUser.substring(0, shareUser.indexOf("@"));
									String emailAddress = shareUser; 
									user = UserServiceUtil.addUser(themeDisplay.getCompanyId(), false, // auto

											// password

											password, password, true, // auto

											// screen name
											StringPool.BLANK, // screen name
											emailAddress, new Long(0), // facebookId
											StringPool.BLANK, // open id
											LocaleUtil.getDefault(), firstName, StringPool.BLANK, // middle

											// name

											lastName, 0, // prefix id
											0, // suffix id
											true, 1, 1, 1970, // birthdate
											StringPool.BLANK, // job title
											null, // group ids
											null, // organization ids
											null, // role ids
											null, // usegroup ids
											false, // send email
											serviceContext);
									
									user.setStatus(0);
									user.setEmailAddressVerified(true);
									user.setPasswordReset(true);
									UserLocalServiceUtil.updateUser(user);

									expandoAttributes.put(SambaashConstants.USER.NON_AD, true);
									expandoAttributes.put(SambaashConstants.USER.START_DATE, startDate.getTime());
									expandoAttributes.put(SambaashConstants.USER.END_DATE, endDate.getTime());

									List<Role> roleList = RoleServiceUtil.getUserRoles(user.getUserId());

									for (Role role : roleList) {
										UserLocalServiceUtil.deleteRoleUser(role.getRoleId(), user.getUserId());
									}

									Role defaultNonADRole = null;

									try {
										defaultNonADRole = RoleLocalServiceUtil.getRole(user.getCompanyId(),
												SambaashConstants.DEFAULT_NON_AD_ROLE);
									} catch (NoSuchRoleException ne) {
										_log.error("Default Non AD role not found, will add it");
										Map<Locale, String> titleMap = new HashMap<Locale, String>();
										titleMap.put(LocaleUtil.getDefault(), SambaashConstants.DEFAULT_NON_AD_ROLE);

										Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
										descriptionMap.put(LocaleUtil.getDefault(),
												"This is default role for NON AD users with limited access");

										defaultNonADRole = RoleLocalServiceUtil.addRole(SambaashUtil.getAdminUserId(),
												user.getCompanyId(), SambaashConstants.DEFAULT_NON_AD_ROLE, titleMap,
												descriptionMap, RoleConstants.TYPE_REGULAR);
									}

									serviceContext.setExpandoBridgeAttributes(expandoAttributes);
									user.setExpandoBridgeAttributes(serviceContext);
									user.setEmailAddressVerified(false);
									UserLocalServiceUtil.updateUser(user);
									UserLocalServiceUtil.addRoleUsers(defaultNonADRole.getRoleId(),
											new long[] { user.getUserId() });

									sharingDetails.put(SHARE_USER_ID, user.getUserId());
									sharingDetails.put(SHARE_USER_EMAIL, user.getScreenName() + "(" + shareUser + ")");
									
									sharedUserId = user.getUserId();
									firstName = user.getFirstName();
									screenName = user.getScreenName();
								}
							}
							sharingDetails.put(DURATION, dateFormat.format(shareFiles.getStartDate()) + " to "
									+ dateFormat.format(shareFiles.getEndDate().getTime()));
							sharingDetails.put("extend", isExtend);
//							shareFiles.setUserId(user.getUserId());
							shareFiles.setUserId(sharedUserId);
							String shareLink = generateShareLink(PortalUtil.getHttpServletRequest(resourceRequest),
									shareFiles);
							shareFiles.setUrl(shareLink);
							SPSharingLocalServiceUtil.addSPSharing(shareFiles);
//							sharingList.put(String.valueOf(user.getUserId()), sharingDetails);
							sharingList.put(String.valueOf(sharedUserId), sharingDetails);

							_log.error("sharingList " + sharingList);
/*							sendShareMail(resourceRequest, internalShare, shareUser, user.getScreenName(), password,
									user.getUserId(), shareLink, sharedFileName, user.getFirstName(), themeDisplay
											.getUser().getFirstName(), shareFiles.getSharingId(), newUser,
									shareFiles.getEndDate(), themeDisplay.getUser().getEmailAddress()); */
							sendShareMail(resourceRequest, internalShare, shareUser, screenName, password,
									sharedUserId, shareLink, sharedFileName, firstName, themeDisplay
									.getUser().getFirstName(), shareFiles.getSpSharingId(), newUser,
									shareFiles.getEndDate(), themeDisplay.getUser().getEmailAddress());
						}
					}
				}
			} catch (Exception e) {
				_log.error("Error adding record to Sharing table for internal share - " + internalShare , e);
			}
		}
		return sharingList;
	}

	private void sendShareMail(PortletRequest request, boolean internalShare, String emailAddress, String screenName,
			String password, long userId, String shareUrl, String sharedFileName, String sharedTo, String sharedBy,
			long shareId, boolean newUser, Date endDate, String fromUserEmailAddress) {
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			Ticket ticket = null;
			String  activationLink  =  StringPool.BLANK;
			boolean resendActivationLink = false;
			try{
				 User sharedUser = UserLocalServiceUtil.getUserById(userId);
				 if(sharedUser.getLastLoginDate() == null){
					 resendActivationLink = true;
				 }
			}catch(Exception ex){
				_log.error(ex);
			}
			
			_log.debug("resendActivationLink = " + resendActivationLink +  " newUser= " + newUser);
			if(resendActivationLink || newUser){
				Calendar tktExpiry = Calendar.getInstance();
				tktExpiry.set(Calendar.YEAR, tktExpiry.get(Calendar.YEAR)+2);
				ticket = TicketLocalServiceUtil.addTicket(themeDisplay.getCompanyId(), User.class.getName(), userId,
						TicketConstants.TYPE_EMAIL_ADDRESS, emailAddress, tktExpiry.getTime(), serviceContext);
				String activationKey = ticket.getKey();

				activationLink = serviceContext.getPortalURL() + serviceContext.getPathMain()
						+ "/portal/verify_email_address?modulename=esnSharing&ticketKey=" + activationKey
						+ "&destinationUrl=" + generateShareLink(PortalUtil.getHttpServletRequest(request), shareId);
				_log.debug("Activation Link for shareId " + shareId + "  " + activationLink);
			}

			

			String signinFriendlyUrl = StringPool.SLASH
					+ SambaashUtil.getParameter(SambaashConstants.SIGNIN_PAGE, themeDisplay.getScopeGroupId());
			long signinPlid = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false,
					signinFriendlyUrl).getPlid();

			activationLink = activationLink + "&p_l_id=" + signinPlid;
			
			SPMailTemplate spMailTemplate = internalShare ? getInternalSharingTemplate()
					: getExternalSharingTemplate(newUser,resendActivationLink);
			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			
			//URL TO CONSTRUCT : https://uat.menariniapac.com/signin?p_p_id=58&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_58_struts_action=%2Flogin%2Fforgot_password&_58_screenName=anc
			String signin = SambaashUtil.getParameter(SambaashConstants.SIGNIN_PAGE, 0);
			String resetpasswordlink = themeDisplay.getPortalURL();
			if(resetpasswordlink.endsWith(StringPool.FORWARD_SLASH)){
				resetpasswordlink = resetpasswordlink + signin;
			}else{
				resetpasswordlink = resetpasswordlink + StringPool.FORWARD_SLASH + signin;
				
			}
			resetpasswordlink = HttpUtil.addParameter(resetpasswordlink, "p_p_id", "58");
			resetpasswordlink = HttpUtil.addParameter(resetpasswordlink, "p_p_lifecycle", "0");
			resetpasswordlink = HttpUtil.addParameter(resetpasswordlink, "p_p_lifecycle", "normal");
			resetpasswordlink = HttpUtil.addParameter(resetpasswordlink, "p_p_mode", "view");
			resetpasswordlink = HttpUtil.addParameter(resetpasswordlink, "p_p_col_id", "column-1");
			resetpasswordlink = HttpUtil.addParameter(resetpasswordlink, "p_p_col_count", "1");
			resetpasswordlink = HttpUtil.addParameter(resetpasswordlink, "_58_screenName", screenName);
			resetpasswordlink = HttpUtil.addParameter(resetpasswordlink, "_58_struts_action", "/login/forgot_password");
			//resetpasswordlink = HttpUtil.encodeURL(resetpasswordlink);
			if (spMailTemplate != null) {

				mailMessage.setSubject(formatTemplate(spMailTemplate.getSubject(), emailAddress, screenName, password,
						activationLink, shareUrl, sharedFileName, sharedTo, sharedBy,
						dateFormat.format(endDate.getTime()), fromUserEmailAddress,resetpasswordlink));

				mailMessage.setHtmlBody(formatTemplate(spMailTemplate.getHtmlContent(), emailAddress, screenName,
						password, activationLink, shareUrl, sharedFileName, sharedTo, sharedBy,
						dateFormat.format(endDate.getTime()), fromUserEmailAddress,resetpasswordlink));
				_log.debug(formatTemplate(spMailTemplate.getHtmlContent(), emailAddress, screenName,
						password, activationLink, shareUrl, sharedFileName, sharedTo, sharedBy,
						dateFormat.format(endDate.getTime()), fromUserEmailAddress,resetpasswordlink));

			} else {
				mailMessage.setSubject(DEFAULT_SUBJECT);
				mailMessage.setSubject(formatTemplate(internalShare ? DEFAULT_CONTENT_INTERNAL
						: ( (resendActivationLink || newUser )? DEFAULT_CONTENT_EXTERNAL_NEW_ACCOUNT : DEFAULT_CONTENT_EXTERNAL), emailAddress,
						screenName, password, activationLink, shareUrl, sharedFileName, sharedTo, sharedBy, dateFormat
								.format(endDate.getTime()), fromUserEmailAddress,resetpasswordlink));
			}
			_log.debug(mailMessage);
			mailMessage.setToAddress(emailAddress);
			SPMailLocalServiceUtil.sendMail(mailMessage);
		} catch (Exception e) {
			_log.error("Error sending mail " + e.getMessage());
		}

	}

	private String formatTemplate(String content, String emailAddress, String screenName, String password,
			String activationLink, String shareUrl, String sharedFileName, String sharedTo, String sharedBy,
			String endDate, String fromUserEmailAddress,String resetpasswordlink) {
		return StringUtil.replace(content, new String[] { "[$TO_ADDRESS$]", "[$TO_NAME$]", "[$SHARED_BY$]",
				"[$LOGIN_ID$]", "[$PASSWORD$]", "[$ACTIVATION_LINK$]", "[$SHARE_URL$]", "[$END_DATE$]",
				"[$FROM_USER_EMAILADDRESS$]", "[$RESET_PASSWORD_LINK$]" }, new String[] { emailAddress,
				(Validator.isNotNull(sharedTo) ? sharedTo : screenName), sharedBy, screenName, password,
				activationLink, shareUrl, endDate, fromUserEmailAddress,resetpasswordlink });
	}

	public static String getShareDuration(long groupId) {

		String durationList = StringPool.BLANK;
		try {
			List<SPListType> duration = SPListTypeLocalServiceUtil.getByKey(
					"documentLibrary.fileFolder.share.duration", groupId);

			if (duration == null) {
				return null;
			} else {
				for (SPListType spListType : duration) {
					String type = spListType.getItemValue();
					if (durationList.length() > 0) {
						durationList += ",";
					}
					durationList += type;
				}
			}
			_log.debug("durationList " + durationList);
		} catch (SystemException e) {
			_log.error("Error getting share duration types");
		}

		return durationList;
	}

	private SPMailTemplate getInternalSharingTemplate() {

		String templateId = SambaashUtil.getParameter(SambaashConstants.TEMPLATE_INTERNAL_SHARE_NOTIFICATION_ID,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
		SPMailTemplate template = null;
		try {
			template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long.parseLong(templateId));
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return template;
	}

	private SPMailTemplate getExternalSharingTemplate(boolean newAccount,boolean resendActivationLink) {
		String templateId = StringPool.BLANK;
		if (newAccount || resendActivationLink) {
			templateId = SambaashUtil.getParameter(
					SambaashConstants.TEMPLATE_EXTERNAL_SHARE_NOTIFICATION_ID_NEW_ACCOUNT,
					Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));

		}else {
			templateId = SambaashUtil.getParameter(SambaashConstants.TEMPLATE_EXTERNAL_SHARE_NOTIFICATION_ID,
					Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
		}
		SPMailTemplate template = null;
		try {
			template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long.parseLong(templateId));
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return template;
	}

	private Calendar resetTime(Calendar calendar) {
		calendar.set(Calendar.HOUR, 00);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		calendar.set(Calendar.MILLISECOND, 00);
		return calendar;
	}

	private String generateShareLink(HttpServletRequest request, SPSharing share) {
		_log.error(PortalUtil.getPortalURL(request) + "/signin?redirect=" + HttpUtil.encodeURL("/share?token=")
				+ SambaashUtil.encrypt(Long.toString(share.getSpSharingId())));
		return PortalUtil.getPortalURL(request) + "/signin?redirect=" + HttpUtil.encodeURL("/share?token=")
				+ SambaashUtil.encrypt(Long.toString(share.getSpSharingId()));
	}

	private String generateShareLink(HttpServletRequest request, long sharingId) {
		_log.debug(HttpUtil.encodeURL("/share?token=") + SambaashUtil.encrypt(Long.toString(sharingId)));
		return HttpUtil.encodeURL("/share?token=") + SambaashUtil.encrypt(Long.toString(sharingId));
	}

	public List<Map<String, String>> searchLdap(long companyId, String email) {
		_log.debug("Checking user in ldap " + email);
		long[] ldapServerIds = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			ldapServerIds = StringUtil.split(PrefsPropsUtil.getString(companyId, "ldap.server.ids"), 0L);
		} catch (Exception e) {
			_log.error("error while fetching ldapserver id");
			return list;
		}
		Map<String, String> map;
		for (long ldapServerId : ldapServerIds) {
			String postfix = LDAPSettingsUtil.getPropertyPostfix(ldapServerId);
			try {
				LdapContext ldapContext = PortalLDAPUtil.getContext(ldapServerId, companyId);

				if (ldapContext == null) {
					return list;
				}
				String baseDN = PrefsPropsUtil.getString(companyId, PropsKeys.LDAP_BASE_DN + postfix);
				String filterFormat = "(|(sAMAccountName=%s)(mail=%s)(cn=%s)(userPrincipalName=%s))";
				String filterVal = email + "*";
				String filter = String.format(filterFormat, filterVal, filterVal, filterVal, filterVal);
				_log.debug("ldap user search filter " + filter);
				SearchControls searchControls = new SearchControls(SearchControls.SUBTREE_SCOPE, 1, 0, new String[] {
						SambaashConstants.LDAP_MAIL, SambaashConstants.LDAP_DISPLAYNAME,SambaashConstants.LDAP_GIVEN_NAME,SambaashConstants.LDAP_SAM_ACC_NAME , SambaashConstants.LDAP_USER_PRINCIPLE_NAME}, false, false);

				NamingEnumeration<SearchResult> enu = ldapContext.search(baseDN, filter, searchControls);

				if (enu.hasMoreElements()) {
					map = new HashMap<String, String>();
					SearchResult result = enu.nextElement();
					Attributes attrs = result.getAttributes();
					map.put(SambaashConstants.LDAP_MAIL, getAttributeValue(attrs.get(SambaashConstants.LDAP_MAIL)));
					map.put(SambaashConstants.LDAP_DISPLAYNAME,
							getAttributeValue(attrs.get(SambaashConstants.LDAP_DISPLAYNAME)));
					map.put(SambaashConstants.LDAP_GIVEN_NAME, getAttributeValue(attrs.get(SambaashConstants.LDAP_GIVEN_NAME)));
					map.put(SambaashConstants.LDAP_SAM_ACC_NAME, getAttributeValue(attrs.get(SambaashConstants.LDAP_SAM_ACC_NAME)));
					map.put(SambaashConstants.LDAP_USER_PRINCIPLE_NAME, getAttributeValue(attrs.get(SambaashConstants.LDAP_USER_PRINCIPLE_NAME)));
					
					list.add(map);
					break;
				}
			} catch (Exception ex) {
				_log.error("Error while checking user in ldap " + email);
			}
		}
		return list;
	}

	private String getAttributeValue(Attribute attribute) {
		String value = StringPool.BLANK;
		try {
			if (Validator.isNotNull(attribute) && Validator.isNotNull(attribute.get())) {
				value = (String) attribute.get();
			}
		} catch (NamingException e) {
		}
		return value;
	}

	public static final String DEFAULT_TABLE_NAME = "CUSTOM_FIELDS";
	private static final String DEFAULT_SUBJECT = "File shared with you";
	private static final String DEFAULT_CONTENT_INTERNAL = "<h2>To address : [$TO_ADDRESS$]</h2><h2>To name : [$TO_NAME$]</h2><h2>&nbsp;Shared by : [$SHARED_BY$]</h2><h2>Share Link : [$SHARE_URL$]</h2>";
	private static final String DEFAULT_CONTENT_EXTERNAL_NEW_ACCOUNT = "<h2>To address : [$TO_ADDRESS$]</h2><h2>To name : [$TO_NAME$]</h2><h2>&nbsp;Shared by : [$SHARED_BY$]</h2><h2>UserName : [$LOGIN_ID$]</h2><h2>Account Activation Link : [$ACTIVATION_LINK$]</h2><h2>Share Link : [$SHARE_URL$]</h2>";
	private static final String DEFAULT_CONTENT_EXTERNAL = "<h2>To address : [$TO_ADDRESS$]</h2><h2>To name : [$TO_NAME$]</h2><h2>&nbsp;Shared by : [$SHARED_BY$]</h2><h2>Share Link : [$SHARE_URL$]</h2>";


}
