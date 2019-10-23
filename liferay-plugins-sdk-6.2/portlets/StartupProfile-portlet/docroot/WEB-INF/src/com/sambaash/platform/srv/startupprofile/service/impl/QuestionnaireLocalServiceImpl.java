/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.startupprofile.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.startupprofile.model.Address;
import com.sambaash.platform.srv.startupprofile.model.Questionnaire;
import com.sambaash.platform.srv.startupprofile.service.base.QuestionnaireLocalServiceBaseImpl;

/**
 * The implementation of the questionnaire local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.startupprofile.service.QuestionnaireLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.startupprofile.service.base.QuestionnaireLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.QuestionnaireLocalServiceUtil
 */
public class QuestionnaireLocalServiceImpl
	extends QuestionnaireLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.startupprofile.service.QuestionnaireLocalServiceUtil} to access the questionnaire local service.
	 */
	
	public Questionnaire create() throws SystemException{
		long orgId = CounterLocalServiceUtil.increment("Questionnnaire");
		return questionnairePersistence.create(orgId);
	}
}