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

package com.liferay.saml;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.io.Serializable;

import org.opensaml.common.binding.SAMLMessageContext;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.Response;

/**
 * @author Mika Koivisto
 */
public class SamlSsoRequestContext implements Serializable {

	public static final int STAGE_AUTHENTICATED = 1;

	public static final int STAGE_INITIAL = 0;

	public SamlSsoRequestContext(
		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext) {

		_samlMessageContext = samlMessageContext;
	}

	public SAMLMessageContext<AuthnRequest, Response, NameID>
		getSAMLMessageContext() {

		return _samlMessageContext;
	}

	public String getSamlSsoSessionId() {
		return _samlSsoSessionId;
	}

	public int getStage() {
		return _stage;
	}

	public User getUser() {
		try {
			return UserLocalServiceUtil.fetchUserById(_userId);
		}
		catch (Exception e) {
			return null;
		}
	}

	public long getUserId() {
		return _userId;
	}

	public boolean isNewSession() {
		return _isNewSession;
	}

	public void setNewSession(boolean isNewSession) {
		_isNewSession = isNewSession;
	}

	public void setSamlSsoSessionId(String samlSsoSessionId) {
		_samlSsoSessionId = samlSsoSessionId;
	}

	public void setStage(int stage) {
		_stage = stage;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private boolean _isNewSession;
	private SAMLMessageContext<AuthnRequest, Response, NameID>
		_samlMessageContext;
	private String _samlSsoSessionId;
	private int _stage;
	private long _userId;

}