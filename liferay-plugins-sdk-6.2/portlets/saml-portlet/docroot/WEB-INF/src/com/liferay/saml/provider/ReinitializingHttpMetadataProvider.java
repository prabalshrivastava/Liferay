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

package com.liferay.saml.provider;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.httpclient.HttpClient;

import org.opensaml.saml2.metadata.provider.HTTPMetadataProvider;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;

/**
 * @author Mika Koivisto
 */
public class ReinitializingHttpMetadataProvider extends HTTPMetadataProvider {

	public ReinitializingHttpMetadataProvider(
			Timer timer, HttpClient httpClient, String url)
		throws MetadataProviderException {

		super(timer, httpClient, url);

		_timer = timer;
	}


	public synchronized void initialize() throws MetadataProviderException {
		try {
			super.initialize();

			if (!super.isInitialized()) {
				scheduleReinitialization();
			}
		}
		catch (MetadataProviderException mpe) {
			scheduleReinitialization();

			throw mpe;
		}
	}

	protected void scheduleReinitialization() {
		TimerTask timerTask = new ReinitializingTimerTask(_timer, this);

		_timer.schedule(timerTask, getMinRefreshDelay());
	}

	private Timer _timer;

}