package com.sambaash.platform.portlet.spsc.action;

/**
import javax.portlet.RenderResponse;**/
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ViewPortletAction extends MVCPortlet {
/**
	public void processAction(ActionRequest req, ActionResponse res) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		String portletName = (String)req.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(req), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);

		try {

		String cmd = req.getParameter("CMD");
		_log.info("render->cmd:"+cmd);

		if (cmd != null && cmd.equals("search")) {
			redirectURL.setParameter("jspPage", "/html/search.jsp");
			res.sendRedirect(redirectURL.toString());
		}

		redirectURL.setParameter("jspPage", "/html/servicecomponentgroup_list.jsp");
		res.sendRedirect(redirectURL.toString());
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	private static Log _log = LogFactoryUtil.getLog(ViewPortletAction.class);*/	

}