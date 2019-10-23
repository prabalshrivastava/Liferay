/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.saml.transport;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import java.util.List;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpVersion;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.params.HttpParams;

import org.opensaml.ws.transport.http.HTTPOutTransport;
import org.opensaml.xml.security.credential.Credential;

/**
 * @author Mika Koivisto
 */
public class HttpClientOutTransport implements HTTPOutTransport {

	public HttpClientOutTransport(PostMethod postMethod) {
		_postMethod = postMethod;
	}


	public void addParameter(String name, String value) {
	}


	public Object getAttribute(String name) {
		return null;
	}


	public String getCharacterEncoding() {
		NameValuePair nameValuePair = _postMethod.getParameter(
			"http.protocol.content-charset");

		return nameValuePair.getValue();
	}


	public String getHeaderValue(String name) {
		Header header =_postMethod.getRequestHeader(name);

		return header.getValue();
	}


	public String getHTTPMethod() {
		NameValuePair nameValuePair = _postMethod.getParameter(
			"http.protocol.version");

		return nameValuePair.getValue();
	}


	public Credential getLocalCredential() {
		return null;
	}


	public OutputStream getOutgoingStream() {
		ByteArrayOutputStream byteArrayOutputStream =
			new ByteArrayOutputStream();

		RequestEntity requestEntity = new OutputStreamRequestEntity(
			byteArrayOutputStream);

		_postMethod.setRequestEntity(requestEntity);

		return byteArrayOutputStream;
	}


	public String getParameterValue(String name) {
		return null;
	}


	public List<String> getParameterValues(String name) {
		return null;
	}


	public Credential getPeerCredential() {
		return null;
	}

	public PostMethod getPostMethod() {
		return _postMethod;
	}


	public int getStatusCode() {
		return -1;
	}


	public HTTP_VERSION getVersion() {
		HttpMethodParams httpMethodParams = _postMethod.getParams();

		HttpVersion httpVersion = (HttpVersion)httpMethodParams.getParameter(
			"http.protocol.version");

		if (httpVersion == HttpVersion.HTTP_1_1) {
			return HTTP_VERSION.HTTP1_1;
		}

		return HTTP_VERSION.HTTP1_0;
	}


	public boolean isAuthenticated() {
		return false;
	}


	public boolean isConfidential() {
		try {
			URI uri = _postMethod.getURI();

			String scheme = uri.getScheme();

			if (scheme.equals("https")) {
				return true;
			}
		}
		catch (URIException urie) {
		}

		return false;
	}


	public boolean isIntegrityProtected() {
		return false;
	}


	public void sendRedirect(String redirect) {
	}


	public void setAttribute(String name, Object value) {
	}


	public void setAuthenticated(boolean uthenticated) {
	}


	public void setCharacterEncoding(String characterEncoding) {
		HttpMethodParams httpMethodParams = _postMethod.getParams();

		httpMethodParams.setParameter(
			"http.protocol.content-charset", characterEncoding);
	}


	public void setConfidential(boolean confidential) {
	}


	public void setHeader(String name, String value) {
		_postMethod.setRequestHeader(name, value);
	}


	public void setIntegrityProtected(boolean integrityProtected) {
	}


	public void setStatusCode(int statusCode) {
	}


	public void setVersion(HTTP_VERSION http_version) {
		HttpParams httpParams = _postMethod.getParams();

		switch (http_version) {
			case HTTP1_0:
				httpParams.setParameter(
					"http.protocol.version", HttpVersion.HTTP_1_0);

				break;

			case HTTP1_1:
				httpParams.setParameter(
					"http.protocol.version", HttpVersion.HTTP_1_1);

				break;
		}
	}

	private PostMethod _postMethod;

}