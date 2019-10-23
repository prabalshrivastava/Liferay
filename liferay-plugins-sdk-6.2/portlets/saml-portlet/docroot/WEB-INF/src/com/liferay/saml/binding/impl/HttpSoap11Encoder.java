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

package com.liferay.saml.binding.impl;

import com.liferay.saml.transport.HttpClientOutTransport;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import org.opensaml.saml2.binding.encoding.HTTPSOAP11Encoder;
import org.opensaml.ws.message.MessageContext;
import org.opensaml.ws.message.encoder.MessageEncodingException;
import org.opensaml.ws.transport.OutTransport;

/**
 * @author Mika Koivisto
 */
public class HttpSoap11Encoder extends HTTPSOAP11Encoder {

	public HttpSoap11Encoder() {
		this(new HttpClient());
	}

	public HttpSoap11Encoder(HttpClient httpClient) {
		_httpClient = httpClient;
	}


	public void encode(MessageContext messageContext)
		throws MessageEncodingException {

		super.encode(messageContext);

		OutTransport outTransport =
			messageContext.getOutboundMessageTransport();

		if (outTransport instanceof HttpClientOutTransport) {
			HttpClientOutTransport httpClientTransport =
				(HttpClientOutTransport)outTransport;

			PostMethod postMethod = httpClientTransport.getPostMethod();

			try {
				_httpClient.executeMethod(postMethod);
			}
			catch (Exception e) {
				throw new MessageEncodingException(e);
			}
		}
	}

	private HttpClient _httpClient;

}