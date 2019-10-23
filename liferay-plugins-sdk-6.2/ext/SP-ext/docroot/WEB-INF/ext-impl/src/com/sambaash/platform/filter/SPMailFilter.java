package com.sambaash.platform.filter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.servlet.filters.BasePortalFilter;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SambaashConstants.SPMAIL;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.model.SPMailLinkTracking;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalServiceUtil;

public class SPMailFilter extends BasePortalFilter {

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws Exception {

		HttpSession session = request.getSession();

		ServletContext _servletContext = session.getServletContext();

		try {

			String path = HttpUtil.fixPath(request.getPathInfo());

			String[] pathArray = StringUtil.split(path, CharPool.SLASH);
			if (_log.isDebugEnabled()) {
				_log.debug("path : " + path);
				_log.debug("pathArray : " + pathArray.length);
				_log.debug("PortalUtil.getPortalURL(request) : " + PortalUtil.getPortalURL(request));
			}

			long subscriberId = -1L;
			long campaignId = -1L;
			long trackingId = -1L;

			String ipAddress = request.getRemoteAddr();
			String url = StringPool.BLANK;

			if (pathArray[0].endsWith(".png") || pathArray[0].endsWith(".gif")) {
				subscriberId = Long.parseLong(SPMailLocalServiceUtil
						.decryptLink(pathArray[0].substring(0, pathArray[0].lastIndexOf(CharPool.PERIOD))));
				url = pathArray[0].endsWith(".png") ? SambaashConstants.SPMAIL.MAIL_PATH + "image/png"
						: SambaashConstants.SPMAIL.MAIL_PATH + "image/gif";

			} else {

				String link = SPMailLocalServiceUtil.decryptLink(pathArray[0]);

				String[] params = StringUtil.split(link, CharPool.SLASH);

				campaignId = Long.parseLong(params[0]);

				subscriberId = Long.parseLong(params[1]);

				trackingId = Long.parseLong(params[2]);

				// url = link.substring(
				// (params[0] + CharPool.SLASH + params[1] + CharPool.SLASH +
				// params[2]).length() + 1,
				// link.length());

				if (_log.isErrorEnabled()) {
					_log.error("params[0] + CharPool.SLASH + params[1] + CharPool.SLASH + params[2])" + params[0]
							+ CharPool.SLASH + params[1] + CharPool.SLASH + params[2]);

					// _log.debug("length : "
					// + (params[0] + CharPool.SLASH + params[1] +
					// CharPool.SLASH + params[2]).length() + 1);

					_log.error("original link " + link);

					// _log.debug("After substring : " + url);

				}

			}

			if (_log.isErrorEnabled()) {
				_log.error("campaignId : " + campaignId + " : subscriberId : " + subscriberId + " : trackingId : "
						+ trackingId + " : url : " + url);
			}

			SPMailCampaignSubscribers subscriber = SPMailCampaignSubscribersLocalServiceUtil
					.updateSubscriber(subscriberId, ipAddress, getUserAgent(request));

			if (subscriber != null) {

				SPMailCampaign campaign = null;

				if (campaignId > 0) {
					campaign = SPMailCampaignLocalServiceUtil.getCampaign(campaignId);
				}

				if (campaign != null && subscriber != null) {

					SPMailLinkTracking spMailLinkTracking = SPMailLinkTrackingLocalServiceUtil
							.getSPMailLinkTracking(trackingId);

					SPMailLinkTrackingLocalServiceUtil.trackLink(trackingId);

					url = spMailLinkTracking.getLink();

					_log.error("url from db : " + url);

					request.setAttribute("subscriber", subscriber);
					request.setAttribute("campaign", campaign);

					if (url.endsWith(SPMAIL.UNSUBSCRIBE_URL)) {
						SPMailUnsubscribeLocalServiceUtil.unsubscribe(subscriber, campaign);
						url = SambaashConstants.SPMAIL.MAIL_PATH + SPMAIL.UNSUBSCRIBE_URL;
					} else if (url.endsWith(SPMAIL.WEBVERSION_URL)) {
						url = SambaashConstants.SPMAIL.MAIL_PATH + SPMAIL.WEBVERSION_URL;
					} else if (url.endsWith(SPMAIL.FORWARD_TO_FRIEND_URL)) {
						url = SambaashConstants.SPMAIL.MAIL_PATH + SPMAIL.FORWARD_TO_FRIEND_URL;
					} else if (url.endsWith(SPMAIL.PREFERENCES_URL)) {
						url = StringPool.FORWARD_SLASH + SPMAIL.PREFERENCES_URL + "?subscriberId=" + subscriberId;
					} else if (url.startsWith(PortalUtil.getPortalURL(request))) {
						response.sendRedirect(url);
						return;
					} else if (url.startsWith(StringPool.FORWARD_SLASH)) {
						url = PortalUtil.getPortalURL(request) + url;
						_log.error("url after attaching portal url : " + url);
						response.sendRedirect(url);
						return;
					} else if (!url.startsWith("http") && !url.startsWith("https") && !url.startsWith("www")) {
						_log.error("url without http, www and slash : " + url);
						response.sendRedirect(PortalUtil.getPortalURL(request));
						return;
					} else {
						response.sendRedirect(url);
						return;
					}

					if (_log.isDebugEnabled()) {
						_log.debug("url : " + url);
					}

					RequestDispatcher requestDispatcher = _servletContext.getRequestDispatcher(url);
					requestDispatcher.forward(request, response);
					// return;
				} else if (subscriberId > 0 && (url.endsWith("image/png") || url.endsWith("image/gif"))) {

					if (_log.isDebugEnabled()) {
						_log.debug("forwarding for tacking image : " + url);
					}

					RequestDispatcher requestDispatcher = _servletContext.getRequestDispatcher(url);
					requestDispatcher.forward(request, response);
				}

			}

		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.error("forwarding : " + PortalUtil.getPortalURL(request));
			response.sendRedirect(PortalUtil.getPortalURL(request));
			return;
		}

		filterChain.doFilter(request, response);
	}

	private String getUserAgent(HttpServletRequest request) {
		String userAgent = StringPool.BLANK;

		if (request != null) {
			userAgent = (String) request.getAttribute(HttpHeaders.USER_AGENT);

			if (userAgent == null) {
				String userAgentHeader = request.getHeader(HttpHeaders.USER_AGENT);

				if (userAgentHeader != null) {
					userAgent = userAgentHeader.toLowerCase();
				} else {
					userAgent = StringPool.BLANK;
				}

				request.setAttribute(HttpHeaders.USER_AGENT, userAgent);
			}
		}

		return userAgent;
	}

	private static Log _log = LogFactoryUtil.getLog(SPMailFilter.class);

}
