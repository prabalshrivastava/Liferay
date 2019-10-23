package com.sambaash.platform.portlet.spmail.action;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.sambaash.platform.comparator.SPMailTemplateModifiedDateComparator;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

import java.io.IOException;

import java.util.ArrayList;
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

import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class SPMailTemplateListingAction
 */
public class SPMailTemplateListingAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SPMailTemplateListingAction.class);

	@SuppressWarnings("unchecked")
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String rsvpId = httpRequest.getParameter("rsvpId");

		if (rsvpId != null) {
			renderRequest.setAttribute("rsvpRedirect", httpRequest.getParameter("redirect"));
			renderRequest.setAttribute("rsvpId", httpRequest.getParameter("rsvpId"));
		}

		String successMessage = httpRequest.getParameter("flag");

		if (Validator.isNotNull(successMessage)) {
			renderRequest.setAttribute("updateMessage", true);
		}


		int totalCount = 0;
		List<SPMailTemplate> lstResult = new ArrayList<SPMailTemplate>();
		long preTemplateId = 0;
		try {
			// List<SPMailTemplate> lstParent =
			// SPMailTemplateLocalServiceUtil.getSPMailTemplates(-1, -1);
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailTemplate.class);
			List<SPMailTemplate> lstParent = SPMailTemplateLocalServiceUtil.dynamicQuery(dynamicQuery, -1, -1,
					new SPMailTemplateModifiedDateComparator());

			for (SPMailTemplate sp : lstParent) {
				if (preTemplateId != sp.getParentTempalteId()) {
					preTemplateId = sp.getParentTempalteId();
					lstResult.add(sp);
				}
			}
		} catch (Exception e) {
		}

		if (lstResult.size() > 0) {

			// get list of mail templates

			if (lstResult.size() < 20) {
				renderRequest.setAttribute("lstMailTemplate", lstResult);
				renderRequest.setAttribute("totalCount", 1);
			} else {
				totalCount = lstResult.size() / 20;

				if ((lstResult.size() % 20) != 0) {
					totalCount += 1;
				}

				_log.error(totalCount);
				renderRequest.setAttribute("totalCount", totalCount);
			}

			// end get list of mail templates

		}

		PortletPreferences preferences = renderRequest.getPreferences();
		String templatePage = preferences.getValue("templatePage", StringPool.BLANK);
		renderRequest.setAttribute("hasAccess",
				(SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
						|| SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())));
		renderRequest.setAttribute("templatePage", templatePage);
		renderRequest.setAttribute("previewIcon", "/SPMail-portlet/images/Preview01.png");
		renderRequest.setAttribute("textcontentIcon", "/SPMail-portlet/images/texticon.png");
		renderRequest.setAttribute("testIcon", "/SPMail-portlet/images/email.png");
		renderRequest.setAttribute("archiveIcon", "/SPMail-portlet/images/archive.png");

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		String action = actionRequest.getParameter("action");
		PortletPreferences preferences = actionRequest.getPreferences();
		if ("mailTemplate".equals(action)) {
			String templatePage = actionRequest.getParameter("templatePage");
			preferences.setValue("templatePage", templatePage);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		}

	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();
		String templatePage = preferences.getValue("templatePage", StringPool.BLANK);
		renderRequest.setAttribute("templatePage", templatePage);

		super.doEdit(renderRequest, renderResponse);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String filterName = resourceRequest.getParameter("filterName");
		String filterValue = resourceRequest.getParameter("filterValue");
		_log.error("filterName " + filterName + " filterValue " + filterValue);

		if ("pageChange".equals(filterName)) {
			JSONObject lstObjectObject = JSONFactoryUtil.createJSONObject();
			int count = 0;
			List<SPMailTemplate> lstMailTemplate = new ArrayList<SPMailTemplate>();

			List<SPMailTemplate> lstResult = new ArrayList<SPMailTemplate>();
			long preTemplateId = 0;
			try {
				// List<SPMailTemplate> lstParent =
				// SPMailTemplateLocalServiceUtil.getSPMailTemplates(-1, -1);
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailTemplate.class);
				dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(new Boolean(false)));
				dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));
				List<SPMailTemplate> lstParent = SPMailTemplateLocalServiceUtil.dynamicQuery(dynamicQuery, -1, -1,
						new SPMailTemplateModifiedDateComparator());

				for (SPMailTemplate sp : lstParent) {
					if (preTemplateId != sp.getParentTempalteId()) {
						preTemplateId = sp.getParentTempalteId();
						lstResult.add(sp);
					}
				}
			} catch (Exception e) {
				_log.error(e.getMessage() + " " + e);
			}

			try {
				if (Integer.valueOf(filterValue) == 1) {
					count = 0;

					lstMailTemplate = new ArrayList<SPMailTemplate>();
					int i = 0;

					for (SPMailTemplate sp : lstResult) {
						lstMailTemplate.add(sp);
						i++;

						if (i > 20) {
							break;
						}
					}
				} else {
					count = (Integer.valueOf(filterValue) - 1) * 20;
					int total = Integer.valueOf(filterValue) * 20;
					lstMailTemplate = new ArrayList<SPMailTemplate>();

					for (int i = count; i < total; i++) {
						if (i < lstResult.size()) {
							lstMailTemplate.add(lstResult.get(i));
						}

					}

				}

				for (SPMailTemplate spMailTemplate : lstMailTemplate) {
					JSONObject spMailTemplateObject = JSONFactoryUtil.createJSONObject();
					spMailTemplateObject.put("id", spMailTemplate.getSpMailTemplateId());
					spMailTemplateObject.put("title", spMailTemplate.getTemplateName());
					spMailTemplateObject.put("subject", spMailTemplate.getSubject());
					String userFullName = StringPool.BLANK;
					try {
						userFullName = UserLocalServiceUtil.getUser(spMailTemplate.getModifiedBy()).getFullName();
					} catch (Exception e) {
						_log.error(e.getMessage() + " " + e);
					}
					spMailTemplateObject.put("modifiedBy", userFullName);
					spMailTemplateObject.put("modifiedDate", spMailTemplate.getModifiedDate());
					spMailTemplateObject.put("status", spMailTemplate.getStatus());

					if (Validator.isNotNull(spMailTemplate.getVersionNumber())) {
						spMailTemplateObject.put("version", spMailTemplate.getVersionNumber());
					} else {
						spMailTemplateObject.put("version", "1");
					}

					if (spMailTemplate.getHtmlUpload() == true) {
						spMailTemplateObject.put("htmlUpload", "Upload Template");
					} else {
						spMailTemplateObject.put("htmlUpload", "Add By Editor");
					}

					lstObjectObject.put(String.valueOf(spMailTemplate.getSpMailTemplateId()), spMailTemplateObject);
				}
				resourceResponse.getWriter().append(lstObjectObject.toString());
			} catch (Exception e) {
				_log.error(e.getMessage() + " " + e);
			}

		} else if ("templateDetail".equals(filterName)) {

			JSONObject lstObject = JSONFactoryUtil.createJSONObject();
			try {
				SPMailTemplate spMailTemplate = SPMailTemplateLocalServiceUtil
						.getSPMailTemplate(Long.valueOf(filterValue));

				JSONObject spMailTemplateObject = JSONFactoryUtil.createJSONObject();
				spMailTemplateObject.put("subject", spMailTemplate.getSubject());
				spMailTemplateObject.put("htmlContent", spMailTemplate.getHtmlContent());
				spMailTemplateObject.put("textContent", spMailTemplate.getTextContent());
				spMailTemplateObject.put("name", spMailTemplate.getTemplateName());
				lstObject.put(filterValue, spMailTemplateObject);
				resourceResponse.getWriter().append(lstObject.toString());
			} catch (Exception e) {

			}

		} else if ("testTemplate".equalsIgnoreCase(filterName)) {
			long templateId = Long.valueOf(filterValue);
			SPMailLocalServiceUtil.testTemplate(templateId);
			resourceResponse.getWriter().append("success");
		} else if ("archive".equalsIgnoreCase(filterName)) {
			long spMailTemplateId = Long.valueOf(filterValue);
			archive(spMailTemplateId);
			resourceResponse.getWriter().append("success");
		}

	}

	private void archive(long spMailTemplateId) {
		try {
			SPMailTemplate spMailTemplate = SPMailTemplateLocalServiceUtil.getSPMailTemplate(spMailTemplateId);
			spMailTemplate.setStatus(true);
			SPMailTemplateLocalServiceUtil.updateSPMailTemplate(spMailTemplate);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

	}

}
