package com.sambaash.platform.spperiscopedata.builder;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class PeriscopedataRequestBuilder {
	
	private static Log _log = LogFactoryUtil.getLog(PeriscopedataRequestBuilder.class);
	
	
	private static final String URL_FORMAT = "https://www.periscopedata.com%s&signature=%s";
	private static final String HMAC_SHA256 = "HmacSHA256";
	private static final String QUOTED_PARAMETER = "\"%s\":\"%s\",";
	private static final String UNQUOTED_PARAMETER = "\"%s\":%s,";
	
	private final String apiKey;
	private final long dashboardId;
	private List<PeriscopeData> dataList = new ArrayList<PeriscopeData>();
	
	public PeriscopedataRequestBuilder(String apiKey, long dashboardId) {
		super();
		this.apiKey = apiKey;
		this.dashboardId = dashboardId;
	}
	
	public PeriscopedataRequestBuilder setParameter(APIOptions option, String value) {
		PeriscopeData data = new PeriscopeData(option.getAttribute(), value, option.isQuoted());
		dataList.add(data);
		return this;
	}

	
	public String buildRequestUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(String.format(UNQUOTED_PARAMETER, APIOptions.DASHBOARD.getAttribute(), dashboardId));
		if (dataList.size()>0) {
			for (PeriscopeData data: dataList) {
				if (data.isQuoted()) {
					sb.append(String.format(QUOTED_PARAMETER, data.getDataKey(), data.getStringValue()));
				} else {
					sb.append(String.format(UNQUOTED_PARAMETER, data.getDataKey(), data.getStringValue()));
				}
			}
		}
		
		// add expiry so URL will change for extra security.
		Calendar expiry = Calendar.getInstance();    
		expiry.add(Calendar.DATE, 1);
		sb.append(String.format(UNQUOTED_PARAMETER, APIOptions.EXPIRY, expiry.getTimeInMillis()));
		
		sb.append("}");
		
		String url = "";
		try {
			String data = sb.toString().replace(",}", "}");
			String dataEscaped = URLEncoder.encode(data, "UTF-8");
	        String dashboardUri = String.format("/api/embedded_dashboard?data=%s", dataEscaped);
	        
	        Mac sha256_HMAC = Mac.getInstance(HMAC_SHA256);
	        SecretKeySpec secret_key = new SecretKeySpec(apiKey.getBytes(), HMAC_SHA256);
	        sha256_HMAC.init(secret_key);
	        String signature = Hex.encodeHexString(sha256_HMAC.doFinal(dashboardUri.getBytes()));
	        url = String.format(URL_FORMAT, dashboardUri, signature);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return url;
	}
	
	public PeriscopedataRequestBuilder reset() {
		dataList.clear();
		return this;
	}
	
	private class PeriscopeData {
		private String dataKey;
		private String stringValue;
		private boolean quoted;
		
		public PeriscopeData(String dataKey, String stringValue, boolean quoted) {
			super();
			this.dataKey = dataKey;
			this.stringValue = stringValue;
			this.quoted = quoted;
		}
		
		public String getDataKey() {
			return dataKey;
		}
		public String getStringValue() {
			return stringValue;
		}
		public boolean isQuoted() {
			return quoted;
		}
	}

	public enum APIOptions {
		DASHBOARD("dashboard", false),
		EMBED_VERSION("embed", true),
		NUMBER_OF_DAYS("daterange",  true),
		DATE_RANGE("daterange",  false),
		AGGREGATION("aggregation",  true),
		FILTERS("filters", false),
		VISIBLE_FILTERS("visible",  false),
		BORDER("border", true),
		DATA_LATENCY("data_ts", false),
		EXPIRY("expires_at", false);
		
		private APIOptions(String attribute, boolean quoted) {
			this.attribute = attribute;
			this.quoted = quoted;
		}
		
		private String attribute;
		private boolean quoted;
		
		public String getAttribute() {
			return attribute;
		}
		public boolean isQuoted() {
			return quoted;
		}
	}
}
