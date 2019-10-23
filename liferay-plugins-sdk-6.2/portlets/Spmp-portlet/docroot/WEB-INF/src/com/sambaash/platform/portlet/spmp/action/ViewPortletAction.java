package com.sambaash.platform.portlet.spmp.action;

public class ViewPortletAction {
	/**extends com.sp.portal.struts.SPPortletAction {
	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res)
	throws Exception {

		setForward(req,"spmp.view");
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
	throws Exception {

		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		}

		return mapping.findForward("spmp.view");
	}**/

}