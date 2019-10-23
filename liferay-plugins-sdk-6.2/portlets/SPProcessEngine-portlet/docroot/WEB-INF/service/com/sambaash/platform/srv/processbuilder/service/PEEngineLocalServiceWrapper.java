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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PEEngineLocalService}.
 *
 * @author nareshchebolu
 * @see PEEngineLocalService
 * @generated
 */
public class PEEngineLocalServiceWrapper implements PEEngineLocalService,
	ServiceWrapper<PEEngineLocalService> {
	public PEEngineLocalServiceWrapper(
		PEEngineLocalService peEngineLocalService) {
		_peEngineLocalService = peEngineLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _peEngineLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_peEngineLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _peEngineLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform .srv.processbuilder.service.PEEngineLocalServiceUtil}
	* to access the p e engine local service.
	*/
	@Override
	public java.lang.String getStatusString(long userIdProcess, long processId,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peEngineLocalService.getStatusString(userIdProcess, processId,
			classNameId, classPK);
	}

	@Override
	public java.lang.String getStatusString(long processStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peEngineLocalService.getStatusString(processStateId);
	}

	/**
	* This method is being called by EsignNotificationServlet. It's call back
	* servlet.After completing the contract signing, esignlive will call the
	* servlet.
	*/
	@Override
	public void runProcessEngineUsingEsignPackagId(java.lang.String packageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_peEngineLocalService.runProcessEngineUsingEsignPackagId(packageId);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState runProcessEngineUsingFormId(
		long entityClassId, long classPK, long processId, long formId,
		java.lang.String formData,
		java.util.Map<java.lang.String, java.lang.String[]> params) {
		return _peEngineLocalService.runProcessEngineUsingFormId(entityClassId,
			classPK, processId, formId, formData, params);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState runProcessEngineUsingFormIdWithException(
		javax.portlet.PortletRequest portletRequest, long entityClassId,
		long classPK, long processId, long formId, java.lang.String formData,
		java.util.Map<java.lang.String, java.lang.String[]> params)
		throws java.lang.Exception {
		return _peEngineLocalService.runProcessEngineUsingFormIdWithException(portletRequest,
			entityClassId, classPK, processId, formId, formData, params);
	}

	@Override
	public void runProcessEngineProductApp(long entityClassId, long classPK,
		long processId, long formId, java.lang.String countryName,
		java.lang.String formData) {
		_peEngineLocalService.runProcessEngineProductApp(entityClassId,
			classPK, processId, formId, countryName, formData);
	}

	@Override
	public com.sambaash.platform.pe.PESubmitAppResponse submitApplciaiton(
		com.sambaash.platform.pe.PESubmitAppRequest submitAppRequest) {
		return _peEngineLocalService.submitApplciaiton(submitAppRequest);
	}

	@Override
	public com.sambaash.platform.pe.v2.PESubmitAppResponseV2 submitApplicationV2(
		com.sambaash.platform.pe.v2.PESubmitAppRequestV2 request) {
		return _peEngineLocalService.submitApplicationV2(request);
	}

	@Override
	public long getFirstFormIdToLoad(long processId) {
		return _peEngineLocalService.getFirstFormIdToLoad(processId);
	}

	@Override
	public boolean isAgent(com.liferay.portal.model.User user, long processId) {
		return _peEngineLocalService.isAgent(user, processId);
	}

	@Override
	public boolean isSupervisor(com.liferay.portal.model.User user,
		long processId) {
		return _peEngineLocalService.isSupervisor(user, processId);
	}

	@Override
	public java.lang.String addExtraParamsToFormUrl(boolean isSignedIn,
		com.liferay.portal.model.User user, long processId,
		java.lang.String urlLoadForm) {
		return _peEngineLocalService.addExtraParamsToFormUrl(isSignedIn, user,
			processId, urlLoadForm);
	}

	@Override
	public long[] getNonDealStageIds() {
		return _peEngineLocalService.getNonDealStageIds();
	}

	@Override
	public long[] getDealStageIds() {
		return _peEngineLocalService.getDealStageIds();
	}

	@Override
	public long getLeadProcessId() {
		return _peEngineLocalService.getLeadProcessId();
	}

	@Override
	public long[] getOpportunityProcessIds() {
		return _peEngineLocalService.getOpportunityProcessIds();
	}

	@Override
	public long[] toLong(java.lang.String[] strArr) {
		return _peEngineLocalService.toLong(strArr);
	}

	@Override
	public boolean isOpenApplication(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		return _peEngineLocalService.isOpenApplication(processState);
	}

	@Override
	public boolean isRejectedApplicaiton(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		return _peEngineLocalService.isRejectedApplicaiton(processState);
	}

	@Override
	public boolean isActiveApplicaiton(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		return _peEngineLocalService.isActiveApplicaiton(processState);
	}

	@Override
	public boolean isConvertedToOtherApplication(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		return _peEngineLocalService.isConvertedToOtherApplication(processState);
	}

	@Override
	public java.lang.String getApplicationDisplayUrl(
		com.liferay.portal.model.User loggedInUser, long processStateId,
		com.liferay.portal.theme.ThemeDisplay themedisplay) {
		return _peEngineLocalService.getApplicationDisplayUrl(loggedInUser,
			processStateId, themedisplay);
	}

	@Override
	public java.lang.String getApplicationDisplayFriendlyUrl(
		com.liferay.portal.model.User loggedInUser, long processStateId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return _peEngineLocalService.getApplicationDisplayFriendlyUrl(loggedInUser,
			processStateId, themeDisplay);
	}

	@Override
	public com.sambaash.platform.pe.PEEntity getPeEntity(long classNameId,
		long classPk) {
		return _peEngineLocalService.getPeEntity(classNameId, classPk);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PEEngineLocalService getWrappedPEEngineLocalService() {
		return _peEngineLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPEEngineLocalService(
		PEEngineLocalService peEngineLocalService) {
		_peEngineLocalService = peEngineLocalService;
	}

	@Override
	public PEEngineLocalService getWrappedService() {
		return _peEngineLocalService;
	}

	@Override
	public void setWrappedService(PEEngineLocalService peEngineLocalService) {
		_peEngineLocalService = peEngineLocalService;
	}

	private PEEngineLocalService _peEngineLocalService;
}