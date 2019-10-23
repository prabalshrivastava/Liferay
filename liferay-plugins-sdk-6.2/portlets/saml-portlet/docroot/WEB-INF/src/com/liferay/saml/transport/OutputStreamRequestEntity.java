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
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.httpclient.methods.RequestEntity;

/**
 * @author Mika Koivisto
 */
public class OutputStreamRequestEntity implements RequestEntity {

	public OutputStreamRequestEntity(
		ByteArrayOutputStream byteArrayOutputStream) {

		this(byteArrayOutputStream, null);
	}

	public OutputStreamRequestEntity(
		ByteArrayOutputStream byteArrayOutputStream, String contentType) {

		_byteArrayOutputStream = byteArrayOutputStream;
		_contentType = contentType;
	}


	public long getContentLength() {
		return _byteArrayOutputStream.size();
	}


	public String getContentType() {
		return _contentType;
	}


	public boolean isRepeatable() {
		return true;
	}


	public void writeRequest(OutputStream outputStream) throws IOException {
		_byteArrayOutputStream.writeTo(outputStream);
	}

	private ByteArrayOutputStream _byteArrayOutputStream;
	private String _contentType;

}