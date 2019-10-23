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

package com.liferay.saml.util;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.StreamUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import org.opensaml.saml2.metadata.EntityDescriptor;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.parse.ParserPool;

import org.w3c.dom.Document;

/**
 * @author Mika Koivisto
 */
public class MetadataUtil {

	public static InputStream getMetadata(String url) {
		GetMethod getMethod = new GetMethod(url);

		try {
			_httpClient.executeMethod(getMethod);

			if (getMethod.getStatusCode() != HttpStatus.SC_OK) {
				return null;
			}

			InputStream inputStream = getMethod.getResponseBodyAsStream();

			Header header = getMethod.getResponseHeader(
				HttpHeaders.CONTENT_ENCODING);

			if (header != null) {
				String contentEncoding = header.getValue();

				if (contentEncoding.equalsIgnoreCase("deflate")) {
					inputStream = new InflaterInputStream(inputStream);
				}
				else if (contentEncoding.equalsIgnoreCase("gzip")) {
					inputStream = new GZIPInputStream(inputStream);
				}
			}

			UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
				new UnsyncByteArrayOutputStream();

			StreamUtil.transfer(inputStream, unsyncByteArrayOutputStream);

			byte[] bytes = unsyncByteArrayOutputStream.toByteArray();

			return new ByteArrayInputStream(bytes);
		}
		catch (Exception e) {
			_log.warn("Unable to get metadata from " + url, e);
		}
		finally {
			getMethod.releaseConnection();
		}

		return null;
	}

	public static String parseMetadataXml(
			InputStream inputStream, String entityId)
		throws Exception {

		try {
			_log.debug("Create a document from the input stream");
			Document document = _parserPool.parse(inputStream);

			_log.debug("Create an XM object"); 
			XMLObject xmlObject = OpenSamlUtil.unmarshallXMLObject(
				document.getDocumentElement());

			_log.debug("Get the entity '" + entityId + "' from the XML");
			EntityDescriptor entityDescriptor =
				SamlUtil.getEntityDescriptorById(entityId, xmlObject);

			if (entityDescriptor == null) {
				return null;
			}

			return OpenSamlUtil.marshallElement(entityDescriptor.getDOM());
		}
		finally {
			if (inputStream != null) {
				StreamUtil.cleanUp(inputStream);
			}
		}
	}

	public void setHttpClient(HttpClient httpClient) {
		_httpClient = httpClient;
	}

	public void setParserPool(ParserPool parserPool) {
		_parserPool = parserPool;
	}

	private static Log _log = LogFactoryUtil.getLog(MetadataUtil.class);

	private static HttpClient _httpClient;
	private static ParserPool _parserPool;

}