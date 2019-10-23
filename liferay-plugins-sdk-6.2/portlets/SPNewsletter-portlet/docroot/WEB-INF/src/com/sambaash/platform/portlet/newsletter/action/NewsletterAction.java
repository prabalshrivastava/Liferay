package com.sambaash.platform.portlet.newsletter.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.sambaash.platform.srv.mail.SPMailCampaignSubscribersEmailException;
import com.sambaash.platform.srv.mail.SPMailCampaignSubscribersFirstNameException;
import com.sambaash.platform.srv.mail.SPMailCampaignSubscribersLastNameException;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;

import java.io.IOException;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * Portlet implementation class NewsletterAction
 */
public class NewsletterAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			long spMailCampaignId = -1L;
			try {
				spMailCampaignId = Long.parseLong(preferences.getValue("spMailCampaignId", StringPool.BLANK));
			} catch (NumberFormatException nfe) {
				_log.error(nfe.getMessage());
			}

			List<SPMailCampaign> lstSpMailCampaign = SPMailCampaignLocalServiceUtil.getActiveCampaigns(0,
					SPMailCampaignLocalServiceUtil.getSPMailCampaignsCount());
			renderRequest.setAttribute("spMailCampaignId", spMailCampaignId);
			renderRequest.setAttribute("lstMailCampaign", lstSpMailCampaign);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String emailOnly = preferences.getValue("emailOnly", StringPool.FALSE);
			long spMailCampaignId = -1L;
			try {
				spMailCampaignId = Long.parseLong(preferences.getValue("spMailCampaignId", StringPool.BLANK));
			} catch (NumberFormatException nfe) {
				_log.error(nfe.getMessage());
			}

			if (spMailCampaignId > 0) {
				_log.error("doView : else : spMailCampaignId : " + spMailCampaignId);
				renderRequest.setAttribute("spMailCampaignId", spMailCampaignId);
				renderRequest.setAttribute("emailOnly", emailOnly);
				renderRequest.setAttribute("success", renderRequest.getParameter("success"));
			} else {
				renderRequest.setAttribute("errorMsg", "Setup is incomplete. Please link newsletter to campaign.");
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		try {
			PortletPreferences preferences = actionRequest.getPreferences();
			String action = ParamUtil.getString(actionRequest, "action");
			String emailOnly = ParamUtil.getString(actionRequest, "emailOnly", StringPool.FALSE);
			String spMailCampaignId = actionRequest.getParameter("spMailCampaignId");
			_log.error("processAction");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				preferences.setValue("spMailCampaignId", spMailCampaignId);
				_log.error("processAction : EDIT : spMailCampaignId : " + spMailCampaignId);
				preferences.setValue("emailOnly", emailOnly);
				preferences.store();
				actionResponse.setPortletMode(PortletMode.VIEW);
			} else {
				if (Validator.isNotNull(spMailCampaignId)) {
					_log.error("processAction : else : spMailCampaignId : " + spMailCampaignId);
					String firstName = ParamUtil.getString(actionRequest, "firstName");
					String lastName = ParamUtil.getString(actionRequest, "lastName");
					String email = ParamUtil.getString(actionRequest, "email");

					if (Validator.isNull(email)) {
						throw new SPMailCampaignSubscribersEmailException("1");
					}

					if (StringPool.TRUE.equalsIgnoreCase(emailOnly)) {
						if (Validator.isNull(firstName)) {
							throw new SPMailCampaignSubscribersFirstNameException();
						}

						if (Validator.isNull(lastName)) {
							throw new SPMailCampaignSubscribersLastNameException();
						}
					}

					SPMailCampaignSubscribersLocalServiceUtil.addNewsLetterCampaignSubscriber(firstName, lastName,
							email, StringPool.TRUE.equalsIgnoreCase(emailOnly) ? true : false,
							Long.parseLong(spMailCampaignId));
					actionResponse.setRenderParameter("success", StringPool.TRUE);
				} else {
					actionResponse.setRenderParameter("errorMsg",
							"Setup is incomplete. Please link newsletter to campaign.");
				}
			}
		} catch (Exception e) {
			if (e instanceof SPMailCampaignSubscribersFirstNameException ||
				e instanceof SPMailCampaignSubscribersLastNameException ||
				e instanceof SPMailCampaignSubscribersEmailException) {
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			} else {
				_log.error(e.getMessage(), e);
			}
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		try {

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	private static Log _log = LogFactoryUtil.getLog(NewsletterAction.class);

}