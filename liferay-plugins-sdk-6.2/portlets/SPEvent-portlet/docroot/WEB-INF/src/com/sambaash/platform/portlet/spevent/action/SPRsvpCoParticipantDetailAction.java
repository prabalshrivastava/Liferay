package com.sambaash.platform.portlet.spevent.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail;
import com.sambaash.platform.srv.rsvp.service.RsvpCoParticipantDetailLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class SPRsvpCoParticipantDetailAction
 */
public class SPRsvpCoParticipantDetailAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			boolean isAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
			boolean isReport = SambaashUtil.isReportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());

			renderRequest.setAttribute("isAdmin", isAdmin);
			renderRequest.setAttribute("isReport", isReport);

			if (isAdmin || isReport) {
				PortletPreferences preferences = renderRequest.getPreferences();

				String identificationTypeVocabularyIdStr = preferences.getValue("identificationTypeVocabularyId", "0");
				long identificationTypeVocabularyId = 0;
				try {
					identificationTypeVocabularyId = Long.valueOf(identificationTypeVocabularyIdStr);
				}catch (NumberFormatException nfe) {

					// do nothing

				}

				List<AssetCategory> identificationTypeCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(identificationTypeVocabularyId, -1, -1, null);

				renderRequest.setAttribute("identificationTypeCategories", identificationTypeCategories);

				long rsvpDetailId = 0;
				long rsvpPaymentId = 0;

				HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
				HttpServletRequest originalServletRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);

				String rsvpDetailIdStr = originalServletRequest.getParameter("dId");
				String rsvpPaymentIdStr = originalServletRequest.getParameter("pId");

				try {
					rsvpDetailId = Long.valueOf(rsvpDetailIdStr);
					rsvpPaymentId = Long.valueOf(rsvpPaymentIdStr);
				}catch (NumberFormatException nfe) {

					// do nothing

				}

				List<RsvpCoParticipantDetail> coParticipantsDetailList = RsvpCoParticipantDetailLocalServiceUtil.findByRsvpDetailIdAndSPRsvpPaymentId(
						rsvpDetailId, rsvpPaymentId);

				renderRequest.setAttribute("rsvpDetailId", rsvpDetailId);
				renderRequest.setAttribute("rsvpPaymentId", rsvpPaymentId);
				renderRequest.setAttribute("coParticipantsDetailList", coParticipantsDetailList);

			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		try {
			PortletPreferences preferences = actionRequest.getPreferences();

			String action = ParamUtil.getString(actionRequest, "action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				String identificationTypeVocabularyId = ParamUtil.getString(actionRequest, "identificationTypeVocabularyId");
				preferences.setValue("identificationTypeVocabularyId", identificationTypeVocabularyId);
				preferences.store();

			}else {

				long rsvpDetailId = ParamUtil.getLong(actionRequest, "rsvpDetailId");
				long rsvpPaymentId = ParamUtil.getLong(actionRequest, "rsvpPaymentId");
				String redirect = ParamUtil.getString(actionRequest, "redirect");

				List<RsvpCoParticipantDetail> coParticipantsDetailList = RsvpCoParticipantDetailLocalServiceUtil
						.findByRsvpDetailIdAndSPRsvpPaymentId(rsvpDetailId, rsvpPaymentId);

				for (RsvpCoParticipantDetail coParticipantDetail : coParticipantsDetailList) {
					long rsvpCoParticipantDetailId = coParticipantDetail.getRsvpCoParticipantDetailId();
					String email = ParamUtil.getString(actionRequest, "email_" + rsvpCoParticipantDetailId);
					String firstName = ParamUtil.getString(actionRequest, "firstName_" + rsvpCoParticipantDetailId);
					String lastName = ParamUtil.getString(actionRequest, "lastName_" + rsvpCoParticipantDetailId);
					String identificationType = ParamUtil.getString(actionRequest, "identificationType_" + rsvpCoParticipantDetailId);
					String identificationNumber = ParamUtil.getString(actionRequest, "identificationNumber_" + rsvpCoParticipantDetailId);

					coParticipantDetail.setEmailAddress(email);
					coParticipantDetail.setFirstName(firstName);
					coParticipantDetail.setLastName(lastName);
					coParticipantDetail.setIdentificationType(identificationType);
					coParticipantDetail.setNric(identificationNumber);

					RsvpCoParticipantDetailLocalServiceUtil.updateRsvpCoParticipantDetail(coParticipantDetail);
				}

				if (Validator.isNotNull(redirect)) {
					actionResponse.sendRedirect(redirect);
				}

			}

			addSuccessMessage(actionRequest, actionResponse);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		super.serveResource(resourceRequest, resourceResponse);
	}

	private static Log _log = LogFactoryUtil.getLog(SPRsvpCoParticipantDetailAction.class);
}