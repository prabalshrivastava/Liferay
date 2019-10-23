package com.sambaash.platform.portlet.spms.action;

/**
**/
public class MembershipSubscriptionAddonServicesAction {
/**
	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res) throws Exception {
			String cmd = req.getParameter("CMD");

			if (cmd != null && cmd.equals("process")) {
				long pKey = CounterLocalServiceUtil.increment("MembershipSubscriptionAddonServices.class");
//				MembershipSubscriptionAddonServices entityImpl = new MembershipSubscriptionAddonServicesImpl();
//				entityImpl = (MembershipSubscriptionAddonServicesImpl)UIHelper.getObject(req, MembershipSubscriptionAddonServicesImpl.class);
				MembershipSubscriptionAddonServices entityImpl = MembershipSubscriptionAddonServicesLocalServiceUtil.createMembershipSubscriptionAddonServices(pKey);
				entityImpl.setPrimaryKey(pKey);
				MembershipSubscriptionAddonServicesLocalServiceUtil.addMembershipSubscriptionAddonServices(entityImpl);
			} else if (cmd != null && cmd.equals("delete")) {
					String[] pKeys = req.getParameterValues("deleteItem");

					if ((pKeys != null) && (pKeys.length != 0)) {
					for (int i = 0; i<pKeys.length; i++) {
						MembershipSubscriptionAddonServicesLocalServiceUtil.deleteMembershipSubscriptionAddonServices(Long.parseLong(pKeys[i]));
					}
				}
			} else if (cmd != null && cmd.equals("edit")) {
				String recId = req.getParameter("recId");
				long pKey = Long.parseLong(recId);

//				MembershipSubscriptionAddonServices entityImpl = new MembershipSubscriptionAddonServicesImpl();
//				entityImpl = (MembershipSubscriptionAddonServicesImpl)UIHelper.getObject(req, MembershipSubscriptionAddonServicesImpl.class);

				MembershipSubscriptionAddonServices entityImpl = MembershipSubscriptionAddonServicesLocalServiceUtil.createMembershipSubscriptionAddonServices(pKey);
				entityImpl.setPrimaryKey(pKey);
				MembershipSubscriptionAddonServices actualImpl = MembershipSubscriptionAddonServicesLocalServiceUtil.getMembershipSubscriptionAddonServices(pKey);
				UIHelper.copyBean(actualImpl, entityImpl, req);
				MembershipSubscriptionAddonServicesLocalServiceUtil.updateMembershipSubscriptionAddonServices(actualImpl);
			}

			PortletURL url = ((ActionResponseImpl)res).createRenderURL();
			url.setParameter("struts_action", "/spms/membershipsubscriptionaddonservices_action");
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
				return mapping.findForward("spms.membershipsubscriptionaddonservices.form");
			} else if (cmd != null && cmd.equals("detail")) {
				String recId = req.getParameter("recId");
				req.setAttribute("recId", recId);
				return mapping.findForward("spms.membershipsubscriptionaddonservices.detail");
			} else if (cmd != null && cmd.equals("edit")) {
				String recId = req.getParameter("recId");
				req.setAttribute("recId", recId);
				return mapping.findForward("spms.membershipsubscriptionaddonservices.edit");
			}

			return mapping.findForward("spms.membershipsubscriptionaddonservices.list");
		}

		**/
}