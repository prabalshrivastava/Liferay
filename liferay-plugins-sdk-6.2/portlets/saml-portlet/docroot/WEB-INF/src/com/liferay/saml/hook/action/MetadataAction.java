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

package com.liferay.saml.hook.action;

import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.saml.metadata.MetadataManagerUtil;
import com.liferay.saml.util.OpenSamlUtil;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opensaml.saml2.metadata.EntityDescriptor;

/**
 * @author Mika Koivisto
 */
public class MetadataAction extends BaseSamlStrutsAction {


	protected String doExecute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		response.setContentType(ContentTypes.TEXT_XML);

		EntityDescriptor entityDescriptor =
			MetadataManagerUtil.getEntityDescriptor(request);

		String metadata = OpenSamlUtil.marshallSamlObject(entityDescriptor);

		PrintWriter printWriter = response.getWriter();

		printWriter.print(metadata);

		return null;
	}

}