package com.sambaash.platform.portlet.spmp.action;

/**
import com.liferay.portlet.PortletURLFactoryUtil;**/
import com.liferay.util.bridges.mvc.MVCPortlet;

/**import sambaash.platform.srv.membershippackage.model.MembershipPackageAddonServices;
import sambaash.platform.srv.membershippackage.service.MembershipPackageAddonServicesLocalServiceUtil;
**/
public class MembershipPackageAddonServicesAction extends MVCPortlet {
	/**@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String step = renderRequest.getParameter("step");
		renderRequest.setAttribute("step", step);
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest req, ActionResponse res) throws IOException, PortletException {
		try {
			String author = UserLocalServiceUtil.getUser(Long.parseLong(req.getRemoteUser())).getFullName();
			_log.info("author of addon services" + author);
			String cmd = req.getParameter("CMD");

			if (cmd != null && cmd.equals("process")) {
				long pKey = CounterLocalServiceUtil.increment("MembershipPackageAddonServices.class");

				String serviceId = req.getParameter("scId");
				String serviceName = req.getParameter("scName");
				String serviceDescription = req.getParameter("description");
				String paramFrom = req.getParameter("paramFrom");
				String paramUpto = req.getParameter("paramUpto");
				String paramType = req.getParameter("paramType");
				String duration = req.getParameter("duration");
				String durationType = req.getParameter("durationType");
				String serviceChargesCurrency = req.getParameter("serviceChargesCurrency");
				String serviceCharges = req.getParameter("serviceCharges");
				String serviceChargesPeriodType = req.getParameter("serviceChargesPeriodType");
				String status = req.getParameter("status");

				MembershipPackageAddonServices entityImpl = MembershipPackageAddonServicesLocalServiceUtil.createMembershipPackageAddonServices(pKey);

				entityImpl.setPrimaryKey(pKey);
				entityImpl.setScId(serviceId);
				entityImpl.setScName(serviceName);
				entityImpl.setDescription(serviceDescription);
				entityImpl.setParamFrom(paramFrom);
				entityImpl.setParamUpto(paramUpto);
				entityImpl.setParamType(paramType);
				entityImpl.setDuration(duration);
				entityImpl.setDurationType(durationType);
				entityImpl.setServiceChargesCurrency(serviceChargesCurrency);
				entityImpl.setServiceCharges(Float.parseFloat(serviceCharges));
				entityImpl.setServiceChargesPeriodType(serviceChargesPeriodType);
				entityImpl.setStatus(status);
				entityImpl.setCreatedBy(author);
				entityImpl.setModifiedBy(author);
				entityImpl.setDateAdded(Calendar.getInstance().getTime());
				entityImpl.setDateModified(Calendar.getInstance().getTime());
				entityImpl.setExtra5(Calendar.getInstance().getTime());
				entityImpl.setExtra6(Calendar.getInstance().getTime());
				MembershipPackageAddonServicesLocalServiceUtil.addMembershipPackageAddonServices(entityImpl);
				SessionMessages.add(req, "added");
			} else if (cmd != null && cmd.equals("delete")) {
				String[] pKeys = req.getParameterValues("deleteItem");

				if ((pKeys != null) && (pKeys.length != 0)) {
					for (int i = 0; i < pKeys.length; i++) {
						MembershipPackageAddonServicesLocalServiceUtil.deleteMembershipPackageAddonServices(Long.parseLong(pKeys[i]));
					}
				}

				SessionMessages.add(req, "deleted");
			} else if (cmd != null && cmd.equals("edit")) {
				String recId = req.getParameter("recId");
				long pKey = Long.parseLong(recId);

				// MembershipPackageAddonServices entityImpl = new
				// MembershipPackageAddonServicesImpl();

				String serviceId = req.getParameter("scId");
				String serviceName = req.getParameter("scname");
				String serviceDescription = req.getParameter("description");
				String paramFrom = req.getParameter("paramFrom");
				String paramUpto = req.getParameter("paramUpto");
				String paramType = req.getParameter("paramType");
				String duration = req.getParameter("duration");
				String durationType = req.getParameter("durationType");
				String serviceChargesCurrency = req.getParameter("serviceChargesCurrency");
				String serviceCharges = req.getParameter("serviceCharges");
				String serviceChargesPeriodType = req.getParameter("serviceChargesPeriodType");
				String status = req.getParameter("status");

				MembershipPackageAddonServices entityImpl = MembershipPackageAddonServicesLocalServiceUtil.getMembershipPackageAddonServices(pKey);

				// entityImpl =
				// (MembershipPackageAddonServicesImpl)UIHelper.getObject(req,
				// MembershipPackageAddonServicesImpl.class);

				entityImpl.setPrimaryKey(pKey);
				entityImpl.setScId(serviceId);
				entityImpl.setScName(serviceName);
				entityImpl.setDescription(serviceDescription);
				entityImpl.setParamFrom(paramFrom);
				entityImpl.setParamUpto(paramUpto);
				entityImpl.setParamType(paramType);
				entityImpl.setDuration(duration);
				entityImpl.setDurationType(durationType);
				entityImpl.setServiceChargesCurrency(serviceChargesCurrency);
				entityImpl.setServiceCharges(Float.parseFloat(serviceCharges));
				entityImpl.setServiceChargesPeriodType(serviceChargesPeriodType);
				entityImpl.setStatus(status);
				_log.info("author of update addon services" + author);

				// MembershipPackageAddonServices actualImpl =
				// MembershipPackageAddonServicesLocalServiceUtil.getMembershipPackageAddonServices(pKey);
				// UIHelper.copyBean(actualImpl, entityImpl, req);

				entityImpl.setModifiedBy(author);
				entityImpl.setDateModified(Calendar.getInstance().getTime());
				entityImpl.setExtra5(Calendar.getInstance().getTime());
				entityImpl.setExtra6(Calendar.getInstance().getTime());
				MembershipPackageAddonServicesLocalServiceUtil.updateMembershipPackageAddonServices(entityImpl);
				SessionMessages.add(req, "updated");
			}

			PortletURL url = ((ActionResponseImpl)res).createRenderURL();
			url.setParameter("struts_action", "/spmp/membershippackageaddonservices_action");
			res.sendRedirect(url.toString());

			ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
			String portletName = (String)req.getAttribute(WebKeys.PORTLET_ID);
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), portletName, themeDisplay.getLayout()
					.getPlid(), PortletRequest.RENDER_PHASE);

			cmd = req.getParameter("CMD");
			String recId = req.getParameter("recId");

			if (cmd != null && cmd.equals("addonform")) {
				redirectURL.setParameter("recId", recId);
				redirectURL.setParameter("jspPage", "/html/membershippackageaddonservices_form.jsp");
				res.sendRedirect(redirectURL.toString());

				// return
				// mapping.findForward("spmp.membershippackageaddonservices.form");

			} else if (cmd != null && cmd.equals("detail")) {
				redirectURL.setParameter("recId", recId);
				redirectURL.setParameter("jspPage", "/html/membershippackageaddonservices_detail.jsp");
				res.sendRedirect(redirectURL.toString());
				req.setAttribute("recId", recId);

				// return
				// mapping.findForward("spmp.membershippackageaddonservices.detail");

			} else if (cmd != null && cmd.equals("edit")) {
				redirectURL.setParameter("recId", recId);
				redirectURL.setParameter("jspPage", "/html/membershippackageaddonservices_edit.jsp");
				res.sendRedirect(redirectURL.toString());
				req.setAttribute("recId", recId);

				// return
				// mapping.findForward("spmp.membershippackageaddonservices.edit");

			} else if (cmd != null && cmd.equals("lookup")) {
				redirectURL.setParameter("recId", recId);
				redirectURL.setParameter("jspPage", "/html/membershippackageaddonservices_lookup.jsp");
				res.sendRedirect(redirectURL.toString());
				req.setAttribute("recId", recId);

				// return
				// mapping.findForward("spmp.membershippackageaddonservices.lookup");

			} else {
				redirectURL.setParameter("jspPage", "/html/membershippackageaddonservices_list.jsp");
				res.sendRedirect(redirectURL.toString());
			}
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	
	private static Log _log = LogFactoryUtil.getLog(MembershipPackageAddonServicesAction.class);**/

}