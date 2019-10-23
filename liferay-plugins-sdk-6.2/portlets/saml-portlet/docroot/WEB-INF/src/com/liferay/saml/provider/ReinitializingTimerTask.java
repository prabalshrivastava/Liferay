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

import org.opensaml.saml2.metadata.provider.AbstractReloadingMetadataProvider;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;

/**
 * @author Mika Koivisto
 */
public class ReinitializingTimerTask extends TimerTask {

	public ReinitializingTimerTask(
		Timer timer,
		AbstractReloadingMetadataProvider abstractReloadingMetadataProvider) {

		_timer = timer;
		_abstractReloadingMetadataProvider = abstractReloadingMetadataProvider;
	}


	public void run() {
		try {
			_abstractReloadingMetadataProvider.initialize();
		}
		catch (MetadataProviderException mpe) {
			TimerTask timerTask = new ReinitializingTimerTask(
				_timer, _abstractReloadingMetadataProvider);

			_timer.schedule(
				timerTask,
				_abstractReloadingMetadataProvider.getMinRefreshDelay());
		}
	}

	private AbstractReloadingMetadataProvider
		_abstractReloadingMetadataProvider;
	private Timer _timer;

}