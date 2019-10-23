package com.sambaash.platform.portlet.spmp.action;

/**
**/
public class MembershipPackageGrpServicesAction {
	/**extends com.sp.portal.struts.SPPortletAction
	 * public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res) throws Exception {
			String cmd = req.getParameter("CMD");

			if (cmd != null && cmd.equals("process")) {
				long pKey = CounterLocalServiceUtil.increment("MembershipPackageGrpServices.class");

//				MembershipPackageGrpServices entityImpl = new MembershipPackageGrpServicesImpl();
				MembershipPackageGrpServices entityImpl = MembershipPackageGrpServicesLocalServiceUtil.createMembershipPackageGrpServices(pKey);

//				entityImpl = (MembershipPackageGrpServicesImpl)UIHelper.getObject(req, MembershipPackageGrpServicesImpl.class);
				entityImpl.setPrimaryKey(pKey);
				MembershipPackageGrpServicesLocalServiceUtil.addMembershipPackageGrpServices(entityImpl);
			} else if (cmd != null && cmd.equals("delete")) {
					String[] pKeys = req.getParameterValues("deleteItem");

					if ((pKeys != null) && (pKeys.length != 0)) {
					for (int i = 0; i<pKeys.length; i++) {
						MembershipPackageGrpServicesLocalServiceUtil.deleteMembershipPackageGrpServices(Long.parseLong(pKeys[i]));
					}
				}
			} else if (cmd != null && cmd.equals("edit")) {
				String recId = req.getParameter("recId");
				long pKey = Long.parseLong(recId);
//				MembershipPackageGrpServices entityImpl = new MembershipPackageGrpServicesImpl();
//				entityImpl = (MembershipPackageGrpServicesImpl)UIHelper.getObject(req, MembershipPackageGrpServicesImpl.class);
//				entityImpl.setPrimaryKey(pKey);
				MembershipPackageGrpServices actualImpl = MembershipPackageGrpServicesLocalServiceUtil.getMembershipPackageGrpServices(pKey);
//				UIHelper.copyBean(actualImpl, entityImpl, req);
				MembershipPackageGrpServicesLocalServiceUtil.updateMembershipPackageGrpServices(actualImpl);
			}

			PortletURL url = ((ActionResponseImpl)res).createRenderURL();
			url.setParameter("struts_action", "/spmp/membershippackagegrpservices_action");
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
				return mapping.findForward("spmp.membershippackagegrpservices.form");
			} else if (cmd != null && cmd.equals("detail")) {
				String recId = req.getParameter("recId");
				req.setAttribute("recId", recId);
				return mapping.findForward("spmp.membershippackagegrpservices.detail");
			} else if (cmd != null && cmd.equals("edit")) {
				String recId = req.getParameter("recId");
				req.setAttribute("recId", recId);
				return mapping.findForward("spmp.membershippackagegrpservices.edit");
			}

			return mapping.findForward("spmp.membershippackagegrpservices.list");
		}

**/
}