package com.sambaash.platform.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.util.PortalUtil;

public class URLUtil {
	private static final Log LOG = LogFactoryUtil.getLog(URLUtil.class);

	private URLUtil() {
		// cannot instantiate
	}

    public static String encodeUrl(String urlStr) throws UnsupportedEncodingException, MalformedURLException {
        URL aURL = new URL(urlStr);
        String origPath = aURL.getPath();
        String path = origPath.contains("/api/jsonws") ? encodePath(origPath) : origPath;
        String query = aURL.getQuery()!= null ? encodeQuery(aURL.getQuery()) : "";
        return String.format("%s://%s%s?%s", aURL.getProtocol(),aURL.getAuthority(),path,query);
    }

    private static String encodePath(String path) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (String pathname : path.split("/")) {
            if (!"".equals(pathname)) {
            	sb.append("/").append(encodeValue(pathname));                
            }
        }
        return sb.toString();
    }

    private static String encodeQuery(String query) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (String queryParam : query.split("&")) {
            String[] param = queryParam.split("=", 2);
            sb.append(param[0]).append("=").append(encodeValue(param[1]));                
        }
        return sb.toString();
    }

    public static String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

	public static String autoResolveUrl(PortletRequest portletRequest, String apiUrl) {
		if (apiUrl.startsWith(StringPool.FORWARD_SLASH)) {
			try {
				HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(portletRequest);
				portletRequest.getParameter("p_auth");
				apiUrl = String.format("%s://%s:%d/%s", httpReq.getScheme(), httpReq.getServerName(), httpReq.getServerPort(), apiUrl); 
				
				apiUrl = apiUrl.contains(StringPool.QUESTION)
						? String.format("%s&p_auth=%s", apiUrl, AuthTokenUtil.getToken(httpReq))
						: String.format("%s?p_auth=%s", apiUrl, AuthTokenUtil.getToken(httpReq));				
			} catch (Exception e) {
				LOG.error("Unable to add auth token", e);
			}

			LOG.debug("API qualified URL :  " + apiUrl);
		}
		return apiUrl;
	}    
}
