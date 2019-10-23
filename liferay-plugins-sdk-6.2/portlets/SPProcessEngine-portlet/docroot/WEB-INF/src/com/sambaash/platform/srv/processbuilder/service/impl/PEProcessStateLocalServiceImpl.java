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

package com.sambaash.platform.srv.processbuilder.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.base.PEProcessStateLocalServiceBaseImpl;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessStateUtil;

/**
 * The implementation of the p e process state local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEProcessStateLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil
 */
public class PEProcessStateLocalServiceImpl extends PEProcessStateLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil}
	 * to access the p e process state local service.
	 */

	public PEProcessState createWithPrimaryKeyZero() throws SystemException {
		PEProcessState peProcessState = peProcessStatePersistence.create(0);
		return peProcessState;
	}

	public PEProcessState create() throws SystemException {
		PEProcessState peProcessState = peProcessStatePersistence.create(getNewPrimaryKey());
		return peProcessState;
	}

	public long getNewPrimaryKey() throws SystemException {
		return counterLocalService.increment("PEProcessState");
	}

	public List<Object> getOfflineFinancereport(Date startDate, Date endDate, Date startDate1, Date endDate1,
			Date startDate2, Date endDate2) throws SystemException {
		return peProcessStateFinder.getOfflineFinancereport(startDate, endDate, startDate1, endDate1, startDate2,
				endDate2);
	}

	public List<Object> getOnlineFinancereport(Date startDate, Date endDate, Date startDate1, Date endDate1,
			Date startDate2, Date endDate2) throws SystemException {
		return peProcessStateFinder.getOnlineFinancereport(startDate, endDate, startDate1, endDate1, startDate2,
				endDate2);
	}

	public PEProcessState findByPEProcessStatePK(long userIdProcess, long processId, long classPK)
			throws NoSuchPEProcessStateException, SystemException {
		PEProcessState processState = null;
		try {
			processState = PEProcessStateUtil.findByprocessStatePK(userIdProcess, processId, classPK);
		} catch (NoSuchPEProcessStateException e) {
			_log.error("ProcessState does not exist with userIdProcess=  " + userIdProcess + " prcessId = " + processId
					+ "  classPk = " + classPK);
			throw e;
		}

		return processState;
	}

	public List<PEProcessState> findByUserIdProcessAndPEProcessId(long userIdProcess, long processId)
			throws NoSuchPEProcessStateException, SystemException {
		List<PEProcessState> processState = null;
		try {
			processState = PEProcessStateUtil.findByuserIdProcessPEProcessId(userIdProcess, processId);
		} catch (Exception e) {
			_log.error(
					"ProcessState does not exist with userIdProcess=  " + userIdProcess + " prcessId = " + processId);
		}

		return processState;
	}

	public List<PEProcessState> findByProcessId(long processId) throws SystemException {
		return PEProcessStateUtil.findByPEProcessId(processId);
	}

	public List<PEProcessState> findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(long userId,
			long processId, long entityClassId, long entityId, int activeStatus) throws SystemException {
		return PEProcessStateUtil.findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userId, processId,
				entityClassId, entityId, activeStatus);
	}

	public PEProcessState clearCacheAndGetProcessState(PEProcessState processState) {
		try {
			PEProcessStateUtil.clearCache(processState);
			return PEProcessStateLocalServiceUtil.getPEProcessState(processState.getSpPEProcessStateId());
		} catch (Exception ex) {
			_log.error(ex);
		}
		return processState;
	}

	public List getDistinctEntityIdClasseIdProcessIdList() {
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PEProcessState.class,
					PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.property(PEConstants.COLUMN_ENTITY_ID));
			proList.add(ProjectionFactoryUtil.property(PEConstants.COLUMN_ENTITY_CLASS_ID));
			proList.add(ProjectionFactoryUtil.property(PEConstants.COLUMN_PROCESS_ID));

			proList.add(ProjectionFactoryUtil.groupProperty(PEConstants.COLUMN_ENTITY_ID));
			proList.add(ProjectionFactoryUtil.groupProperty(PEConstants.COLUMN_ENTITY_CLASS_ID));
			proList.add(ProjectionFactoryUtil.groupProperty(PEConstants.COLUMN_PROCESS_ID));
			dynamicQuery.setProjection(proList);

			return peProcessStateLocalService.dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	public List<PEProcessState> findByProcessStateLead(long[] processIds, long userId) throws SystemException {
		List<PEProcessState> processStates = null;
		processStates = PEProcessStateUtil.findByProcessStateLead(processIds, userId);
		return processStates;
	}

	public List<PEProcessState> findByProcessStateOpportunity(long[] processIds, long userId) throws SystemException {
		List<PEProcessState> processStates = null;
		processStates = PEProcessStateUtil.findByProcessStateOpportunity(processIds, userId);
		return processStates;
	}

	public List<PEProcessState> findByuserIdProcess(long userIdProcess) throws SystemException {
		List<PEProcessState> processStates = null;
		processStates = PEProcessStateUtil.findByuserIdProcess(userIdProcess);
		return processStates;
	}

	public List<PEProcessState> findByuserIdProcessPEProcessStageId(long userIdProcess, long spPEProcessStageId)
			throws SystemException {
		List<PEProcessState> processStates = null;
		processStates = PEProcessStateUtil.findByuserIdProcessPEProcessStageId(userIdProcess, spPEProcessStageId);
		return processStates;
	}

	public int findByuserIdProcessPEProcessStageIdCount(long userIdProcess, long spPEProcessStageId)
			throws SystemException {
		List<PEProcessState> processStates = null;
		int count = 0;
		processStates = PEProcessStateUtil.findByuserIdProcessPEProcessStageId(userIdProcess, spPEProcessStageId);
		count = processStates.size();
		return count;
	}

	public PEProcessState updatePEProcessState(PEProcessState peProcessState) throws SystemException {
		PEProcessState processState = null;
		try {
			processState = peProcessStatePersistence.update(peProcessState);
			Indexer indexer = IndexerRegistryUtil.getIndexer(PEProcessState.class);
			indexer.reindex(processState);
		} catch (SearchException e) {
			_log.error(e);
		}
		return processState;
	}

	private static Log _log = LogFactoryUtil.getLog(PEProcessStateLocalServiceImpl.class);

	public List<Object> getOfflineFinancereport() throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> getOnlineFinancereport() throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getOfflineFinancereport(Date arg0, Date arg1) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getOnlineFinancereport(Date arg0, Date arg1) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject checkForPreviousSubmissions(long loggedInUserId, String emailAddress, long processId,
			long entityClassId, long entityId) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		boolean isAllowed = true;
		boolean validationRequired = true;
		try {
			PEProcess peProcess = PEProcessLocalServiceUtil.fetchPEProcess(processId);

			if (loggedInUserId > 0 && Validator.isNotNull(loggedInUserId)) {
				List<Role> uerRoles = RoleLocalServiceUtil.getUserRoles(loggedInUserId);
				if (Validator.isNotNull(peProcess)){
					if (Validator.isNotNull(peProcess.getAgentRoleIds())) {
						List<String> peProcessAgentRoleList = Arrays.asList(peProcess.getAgentRoleIds().split(","));
						outer: for (Role userRole : uerRoles) {
							long roleId = userRole.getRoleId();
							for (String agentRoleId : peProcessAgentRoleList) {
								if (agentRoleId.equalsIgnoreCase(String.valueOf(roleId))) {
									validationRequired = false;
									break outer;
								}
							}
						}
					}
				}
			}

			if (validationRequired && peProcess.getEnableSingleSubmission()) {
				long scheduleModelIdFromProcess = peProcess.getScheduleModelId();
				User user = UserLocalServiceUtil.getUserByEmailAddress(peProcess.getCompanyId(),
						emailAddress.toLowerCase());

				List<PEProcessState> peProcessStates = PEProcessStateLocalServiceUtil
						.findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(user.getUserId(), processId,
								entityClassId, entityId, 1);

				if (Validator.isNotNull(scheduleModelIdFromProcess) && scheduleModelIdFromProcess > 0) {
					for (PEProcessState peProcessState : peProcessStates) {
						if("Rejected".equalsIgnoreCase(peProcessState.getStatus())){
							continue;
						}
						PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter
								.getProcessStateDataAdapter(peProcessState);
						if (scheduleModelIdFromProcess == GetterUtil
								.getLong(dataAdapter.getDataFromProcessState("scheduleModelId"))) {
							isAllowed = false;
							break;
						}
					}
				} else {
					if (peProcessStates.size() > 0) {
						isAllowed = false;
					}
				}
			}

			json.put("isAllowed", isAllowed);

			if (!isAllowed) {
				json.put("message", "Not allowed to enroll");
			} else {
				json.put("message", "Can proceed to enroll");
			}

		} catch (NoSuchUserException e) {
			_log.error(e);
			json.put("isAllowed", true);
			json.put("message", "Can proceed to enroll");
		} catch (Exception e) {
			_log.error(e);
			json.put("isAllowed", false);
			json.put("message", "Not allowed to enroll");
		}

		return json;
	}

	public List<PEProcessState> findByuserIdProcessAndPEProcessIdAndEntityClassIdAndEntityIdAndActiveStatus(long userId, long processId, long entityClassId, long entityId, int activeStatus) 
			throws SystemException 
	{
		List<PEProcessState> list = new ArrayList<>();
		list.addAll(PEProcessStateUtil.findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userId, processId, entityClassId, entityId, activeStatus));
		list.addAll(PEProcessStateUtil.findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(userId, processId, entityClassId, entityId, activeStatus));
		return list;
	}

}
