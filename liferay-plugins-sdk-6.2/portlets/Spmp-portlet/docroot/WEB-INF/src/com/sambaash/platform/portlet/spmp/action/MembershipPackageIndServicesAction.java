package com.sambaash.platform.portlet.spmp.action;

/**
**/
public class MembershipPackageIndServicesAction {
/** extends com.sp.portal.struts.SPPortletAction {
	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res) throws Exception {
			String cmd = req.getParameter("CMD");

			if (cmd != null && cmd.equals("process")) {
				long pKey = CounterLocalServiceUtil.increment("MembershipPackageIndServices.class");

//				MembershipPackageIndServices entityImpl = new MembershipPackageIndServicesImpl();
//				entityImpl = (MembershipPackageIndServicesImpl)UIHelper.getObject(req, MembershipPackageIndServicesImpl.class);

				MembershipPackageIndServices entityImpl = MembershipPackageIndServicesLocalServiceUtil.createMembershipPackageIndServices(pKey);
				entityImpl.setPrimaryKey(pKey);
				MembershipPackageIndServicesLocalServiceUtil.addMembershipPackageIndServices(entityImpl);
			} else if (cmd != null && cmd.equals("delete")) {
					String[] pKeys = req.getParameterValues("deleteItem");

					if ((pKeys != null) && (pKeys.length != 0)) {
					for (int i = 0; i<pKeys.length; i++) {
						MembershipPackageIndServicesLocalServiceUtil.deleteMembershipPackageIndServices(Long.parseLong(pKeys[i]));
					}
				}
			} else if (cmd != null && cmd.equals("edit")) {
				String recId = req.getParameter("recId");
				long pKey = Long.parseLong(recId);
//				MembershipPackageIndServices entityImpl = new MembershipPackageIndServicesImpl();
//				entityImpl = (MembershipPackageIndServicesImpl)UIHelper.getObject(req, MembershipPackageIndServicesImpl.class);

				MembershipPackageIndServices entityImpl = MembershipPackageIndServicesLocalServiceUtil.createMembershipPackageIndServices(pKey);
				entityImpl.setPrimaryKey(pKey);
				MembershipPackageIndServices actualImpl = MembershipPackageIndServicesLocalServiceUtil.getMembershipPackageIndServices(pKey);
				//UIHelper.copyBean(actualImpl, entityImpl, req);
				MembershipPackageIndServicesLocalServiceUtil.updateMembershipPackageIndServices(actualImpl);
			}

			PortletURL url = ((ActionResponseImpl)res).createRenderURL();
			url.setParameter("struts_action", "/spmp/membershippackageindservices_action");
			res.sendRedirect(url.toString());
		}

		public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
				throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req));
			}

			String cmd = req.getParameter("CMD");

			if (cmd != null && cmd.equals("form")) {
				return mapping.findForward("spmp.membershippackageindservices.form");
			} else if (cmd != null && cmd.equals("detail")) {
				String recId = req.getParameter("recId");
				req.setAttribute("recId", recId);
				return mapping.findForward("spmp.membershippackageindservices.detail");
			} else if (cmd != null && cmd.equals("edit")) {
				String recId = req.getParameter("recId");
				req.setAttribute("recId", recId);
				return mapping.findForward("spmp.membershippackageindservices.edit");
			}

			return mapping.findForward("spmp.membershippackageindservices.list");
		}**/

}