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

package com.sambaash.platform.srv.processbuilder.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for PEEngine. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author nareshchebolu
 * @see PEEngineLocalServiceUtil
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEEngineLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.impl.PEEngineLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PEEngineLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PEEngineLocalServiceUtil} to access the p e engine local service. Add custom service methods to {@link com.sambaash.platform.srv.processbuilder.service.impl.PEEngineLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform .srv.processbuilder.service.PEEngineLocalServiceUtil}
	* to access the p e engine local service.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getStatusString(long userIdProcess, long processId,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getStatusString(long processStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* This method is being called by EsignNotificationServlet. It's call back
	* servlet.After completing the contract signing, esignlive will call the
	* servlet.
	*/
	public void runProcessEngineUsingEsignPackagId(java.lang.String packageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.processbuilder.model.PEProcessState runProcessEngineUsingFormId(
		long entityClassId, long classPK, long processId, long formId,
		java.lang.String formData,
		java.util.Map<java.lang.String, java.lang.String[]> params);

	public com.sambaash.platform.srv.processbuilder.model.PEProcessState runProcessEngineUsingFormIdWithException(
		javax.portlet.PortletRequest portletRequest, long entityClassId,
		long classPK, long processId, long formId, java.lang.String formData,
		java.util.Map<java.lang.String, java.lang.String[]> params)
		throws java.lang.Exception;

	public void runProcessEngineProductApp(long entityClassId, long classPK,
		long processId, long formId, java.lang.String countryName,
		java.lang.String formData);

	public com.sambaash.platform.pe.PESubmitAppResponse submitApplciaiton(
		com.sambaash.platform.pe.PESubmitAppRequest submitAppRequest);

	public com.sambaash.platform.pe.v2.PESubmitAppResponseV2 submitApplicationV2(
		com.sambaash.platform.pe.v2.PESubmitAppRequestV2 request);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getFirstFormIdToLoad(long processId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isAgent(com.liferay.portal.model.User user, long processId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isSupervisor(com.liferay.portal.model.User user,
		long processId);

	public java.lang.String addExtraParamsToFormUrl(boolean isSignedIn,
		com.liferay.portal.model.User user, long processId,
		java.lang.String urlLoadForm);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getNonDealStageIds();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getDealStageIds();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getLeadProcessId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getOpportunityProcessIds();

	public long[] toLong(java.lang.String[] strArr);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isOpenApplication(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isRejectedApplicaiton(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isActiveApplicaiton(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isConvertedToOtherApplication(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getApplicationDisplayUrl(
		com.liferay.portal.model.User loggedInUser, long processStateId,
		com.liferay.portal.theme.ThemeDisplay themedisplay);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getApplicationDisplayFriendlyUrl(
		com.liferay.portal.model.User loggedInUser, long processStateId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.pe.PEEntity getPeEntity(long classNameId,
		long classPk);
}