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

import java.io.File;

import java.util.Timer;
import java.util.TimerTask;

import org.opensaml.saml2.metadata.provider.FilesystemMetadataProvider;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;

/**
 * @author Mika Koivisto
 */
public class ReinitializingFilesystemMetadataProvider
	extends FilesystemMetadataProvider {

	public ReinitializingFilesystemMetadataProvider(Timer timer, File file)
		throws MetadataProviderException {

		super(timer, file);

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