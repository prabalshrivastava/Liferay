package com.sambaash.platform.portlet.spfeedback.action;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.srv.feedback.service.SPFeedbackLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;

/**
 * Portlet implementation class SPFeedback
 */
public class SPFeedback extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SPFeedback.class);

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		PortletPreferences preferences = renderRequest.getPreferences();

		List<AssetVocabulary> assetVocabulary = null;
		try {
			assetVocabulary = getAssetVocabularies();
		} catch (SystemException e) {
			_log.error(e);
		}

		renderRequest.setAttribute("assetVocabularies", assetVocabulary);
		String tyMsg = preferences.getValue("tyMsg", "");
		String typeVoc = preferences.getValue("typeVoc", "");
		String rcvEmail = preferences.getValue("rcvEmail", "");

		renderRequest.setAttribute("tyMsg", tyMsg);
		renderRequest.setAttribute("typeVoc", typeVoc);
		renderRequest.setAttribute("rcvEmail", rcvEmail);

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		PortletPreferences preferences = renderRequest.getPreferences();
		boolean isPreferencesSet = checkPreferences(renderRequest);
		String typeVoc = preferences.getValue("typeVoc", "");
		List<AssetCategory> assetCategories = null;
		try {
			if (Validator.isNotNull(typeVoc)) {
				assetCategories = getInterestCategories(Long.parseLong(typeVoc));
			}

		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		renderRequest.setAttribute("assetCategories", assetCategories);
		renderRequest.setAttribute("isPreferencesSet", isPreferencesSet);
		super.doView(renderRequest, renderResponse);

	}

	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		PortletPreferences preferences = request.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		String bccAddress = "alerts@sambaash.com";
		String toAddressList = preferences.getValue("rcvEmail", bccAddress);
		String defaultThankMsg = LanguageUtil.get(themeDisplay.getLocale(), "feedback.submit.msg");
		String thankMsg = preferences.getValue("tyMsg", defaultThankMsg);

		String feedBackType = request.getParameter("feedBackType");
		String feedBackDetail = request.getParameter("feedBackDetail");
		User user = themeDisplay.getUser();
		long userId = user.getUserId();
		String userEmail = user.getEmailAddress();
		String userName = user.getFirstName() + " " + user.getLastName();
		String successMsg = thankMsg;

		try {
			String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);

			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			long spFeedbackId = CounterLocalServiceUtil.increment("SPFeedback.class");
			com.sambaash.platform.srv.feedback.model.SPFeedback spFeedback = SPFeedbackLocalServiceUtil
					.createSPFeedback(spFeedbackId);
			spFeedback.setSpFeedbackId(spFeedbackId);
			spFeedback.setGroupId(themeDisplay.getScopeGroupId());
			spFeedback.setCompanyId(themeDisplay.getCompanyId());
			spFeedback.setUserId(userId);
			spFeedback.setUserName(userName);
			spFeedback.setCreateDate(Calendar.getInstance().getTime());
			spFeedback.setModifiedDate(Calendar.getInstance().getTime());
			spFeedback.setDescription(feedBackDetail);
			spFeedback.setType(feedBackType);

			SPFeedbackLocalServiceUtil.addSPFeedback(spFeedback);

			String subject = "FeedBack";
			StringBuilder content = new StringBuilder();

			content.append("Name - ").append(userName).append("<br/>Email Address : ").append(userEmail);
			content.append("<br/>FeedBack Type : ").append(feedBackType);
			content.append("<br/>Details of FeedBack : ").append(feedBackDetail);
			String[] toAddress = toAddressList.split(StringPool.COMMA);

			for (int a = 0; a < toAddress.length; a++) {
				MailMessage mailMessage = new MailMessage();
				mailMessage.setFromAddress(fromAddress);
				mailMessage.setFromName(fromName);
				mailMessage.setSubject(subject);
				mailMessage.setToAddress(toAddress[a]);
				if ((a + 1) == toAddress.length) {
					mailMessage.setBccAddress(bccAddress);
				}
				mailMessage.setHtmlBody(content.toString());
				if (_log.isDebugEnabled()) {
					_log.error("mailMessage " + mailMessage.toString());
				}
				SPMailLocalServiceUtil.sendMail(mailMessage);
			}
		} catch (Exception e) {
			successMsg = LanguageUtil.get(themeDisplay.getLocale(), "feedback.submit.error.msg");
		}
		response.getWriter().write(successMsg);

		super.serveResource(request, response);

	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {

		PortletPreferences preferences = actionRequest.getPreferences();
		String action = actionRequest.getParameter("action");
		if (Constants.EDIT.equalsIgnoreCase(action)) {
			String msg = actionRequest.getParameter("fdBack-msg");
			String typeVoc = actionRequest.getParameter("fdBack-type-voc");
			String rcvEmail = actionRequest.getParameter("fdBack-rcv-email");

			preferences.setValue("tyMsg", msg);
			preferences.setValue("typeVoc", typeVoc);
			preferences.setValue("rcvEmail", rcvEmail);
			preferences.store();

			actionResponse.setPortletMode(PortletMode.VIEW);
		}
		super.processAction(actionRequest, actionResponse);
	}

	public static List<AssetVocabulary> getAssetVocabularies() throws SystemException {

		List<AssetVocabulary> assetVocabularies = null;
		if (assetVocabularies == null) {
			assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
		}
		return assetVocabularies;
	}

	public static List<AssetCategory> getInterestCategories(long vocabularyId) throws SystemException {

		int noOfCategories = AssetCategoryLocalServiceUtil.getAssetCategoriesCount();
		List<AssetCategory> interestCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, 0,
				noOfCategories, null);
		return interestCategories;
	}

	private boolean checkPreferences(PortletRequest request) {
		PortletPreferences preferences = request.getPreferences();
		String tyMsg = preferences.getValue("tyMsg", "");
		String typeVoc = preferences.getValue("typeVoc", "");
		String rcvEmail = preferences.getValue("rcvEmail", "");
		boolean prefsAvailable = true;
		if (Validator.isNull(tyMsg) || Validator.isNull(typeVoc) || Validator.isNull(rcvEmail)) {
			prefsAvailable = false;
		}
		return prefsAvailable;
	}

}
