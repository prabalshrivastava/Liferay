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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PEEngine. This utility wraps
 * {@link com.sambaash.platform.srv.processbuilder.service.impl.PEEngineLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nareshchebolu
 * @see PEEngineLocalService
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEEngineLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.impl.PEEngineLocalServiceImpl
 * @generated
 */
public class PEEngineLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.processbuilder.service.impl.PEEngineLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform .srv.processbuilder.service.PEEngineLocalServiceUtil}
	* to access the p e engine local service.
	*/
	public static java.lang.String getStatusString(long userIdProcess,
		long processId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getStatusString(userIdProcess, processId, classNameId,
			classPK);
	}

	public static java.lang.String getStatusString(long processStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStatusString(processStateId);
	}

	/**
	* This method is being called by EsignNotificationServlet. It's call back
	* servlet.After completing the contract signing, esignlive will call the
	* servlet.
	*/
	public static void runProcessEngineUsingEsignPackagId(
		java.lang.String packageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().runProcessEngineUsingEsignPackagId(packageId);
	}

	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState runProcessEngineUsingFormId(
		long entityClassId, long classPK, long processId, long formId,
		java.lang.String formData,
		java.util.Map<java.lang.String, java.lang.String[]> params) {
		return getService()
				   .runProcessEngineUsingFormId(entityClassId, classPK,
			processId, formId, formData, params);
	}

	public static com.sambaash.platform.srv.processbuilder.model.PEProcessState runProcessEngineUsingFormIdWithException(
		javax.portlet.PortletRequest portletRequest, long entityClassId,
		long classPK, long processId, long formId, java.lang.String formData,
		java.util.Map<java.lang.String, java.lang.String[]> params)
		throws java.lang.Exception {
		return getService()
				   .runProcessEngineUsingFormIdWithException(portletRequest,
			entityClassId, classPK, processId, formId, formData, params);
	}

	public static void runProcessEngineProductApp(long entityClassId,
		long classPK, long processId, long formId,
		java.lang.String countryName, java.lang.String formData) {
		getService()
			.runProcessEngineProductApp(entityClassId, classPK, processId,
			formId, countryName, formData);
	}

	public static com.sambaash.platform.pe.PESubmitAppResponse submitApplciaiton(
		com.sambaash.platform.pe.PESubmitAppRequest submitAppRequest) {
		return getService().submitApplciaiton(submitAppRequest);
	}

	public static com.sambaash.platform.pe.v2.PESubmitAppResponseV2 submitApplicationV2(
		com.sambaash.platform.pe.v2.PESubmitAppRequestV2 request) {
		return getService().submitApplicationV2(request);
	}

	public static long getFirstFormIdToLoad(long processId) {
		return getService().getFirstFormIdToLoad(processId);
	}

	public static boolean isAgent(com.liferay.portal.model.User user,
		long processId) {
		return getService().isAgent(user, processId);
	}

	public static boolean isSupervisor(com.liferay.portal.model.User user,
		long processId) {
		return getService().isSupervisor(user, processId);
	}

	public static java.lang.String addExtraParamsToFormUrl(boolean isSignedIn,
		com.liferay.portal.model.User user, long processId,
		java.lang.String urlLoadForm) {
		return getService()
				   .addExtraParamsToFormUrl(isSignedIn, user, processId,
			urlLoadForm);
	}

	public static long[] getNonDealStageIds() {
		return getService().getNonDealStageIds();
	}

	public static long[] getDealStageIds() {
		return getService().getDealStageIds();
	}

	public static long getLeadProcessId() {
		return getService().getLeadProcessId();
	}

	public static long[] getOpportunityProcessIds() {
		return getService().getOpportunityProcessIds();
	}

	public static long[] toLong(java.lang.String[] strArr) {
		return getService().toLong(strArr);
	}

	public static boolean isOpenApplication(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		return getService().isOpenApplication(processState);
	}

	public static boolean isRejectedApplicaiton(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		return getService().isRejectedApplicaiton(processState);
	}

	public static boolean isActiveApplicaiton(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		return getService().isActiveApplicaiton(processState);
	}

	public static boolean isConvertedToOtherApplication(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		return getService().isConvertedToOtherApplication(processState);
	}

	public static java.lang.String getApplicationDisplayUrl(
		com.liferay.portal.model.User loggedInUser, long processStateId,
		com.liferay.portal.theme.ThemeDisplay themedisplay) {
		return getService()
				   .getApplicationDisplayUrl(loggedInUser, processStateId,
			themedisplay);
	}

	public static java.lang.String getApplicationDisplayFriendlyUrl(
		com.liferay.portal.model.User loggedInUser, long processStateId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return getService()
				   .getApplicationDisplayFriendlyUrl(loggedInUser,
			processStateId, themeDisplay);
	}

	public static com.sambaash.platform.pe.PEEntity getPeEntity(
		long classNameId, long classPk) {
		return getService().getPeEntity(classNameId, classPk);
	}

	public static void clearService() {
		_service = null;
	}

	public static PEEngineLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PEEngineLocalService.class.getName());

			if (invokableLocalService instanceof PEEngineLocalService) {
				_service = (PEEngineLocalService)invokableLocalService;
			}
			else {
				_service = new PEEngineLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PEEngineLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PEEngineLocalService service) {
	}

	private static PEEngineLocalService _service;
}