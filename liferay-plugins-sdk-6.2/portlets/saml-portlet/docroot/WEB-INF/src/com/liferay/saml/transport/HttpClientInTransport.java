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

import java.io.IOException;
import java.io.InputStream;

import java.util.List;

import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.PostMethod;

import org.opensaml.ws.transport.http.HTTPInTransport;
import org.opensaml.xml.security.credential.Credential;

/**
 * @author Mika Koivisto
 */
public class HttpClientInTransport implements HTTPInTransport {

	public HttpClientInTransport(PostMethod postMethod, String location) {
		_postMethod = postMethod;
		_location = location;
	}


	public Object getAttribute(String name) {
		return null;
	}


	public String getCharacterEncoding() {
		return _postMethod.getResponseCharSet();
	}


	public String getHeaderValue(String name) {
		return null;
	}


	public String getHTTPMethod() {
		return _postMethod.getName();
	}


	public InputStream getIncomingStream() {
		try {
			return _postMethod.getResponseBodyAsStream();
		}
		catch (IOException ioe) {
			return null;
		}
	}

	public String getLocalAddress() {
		return _location;
	}


	public Credential getLocalCredential() {
		return null;
	}


	public String getParameterValue(String name) {
		return null;
	}


	public List<String> getParameterValues(String name) {
		return null;
	}


	public String getPeerAddress() {
		return null;
	}


	public Credential getPeerCredential() {
		return null;
	}


	public String getPeerDomainName() {
		return null;
	}


	public int getStatusCode() {
		return _postMethod.getStatusCode();
	}


	public HTTP_VERSION getVersion() {
		return null;
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


	public void setAuthenticated(boolean authenticated) {
	}


	public void setConfidential(boolean confidential) {
	}


	public void setIntegrityProtected(boolean integrityProtected) {
	}

	private String _location;
	private PostMethod _postMethod;

}