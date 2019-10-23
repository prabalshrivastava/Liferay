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

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.base.PEProcessAuditLocalServiceBaseImpl;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessAuditUtil;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the p e process audit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEProcessAuditLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil
 */

@SuppressWarnings("unchecked")
public class PEProcessAuditLocalServiceImpl extends PEProcessAuditLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.processbuilder.service.PEProcessAuditLocalServiceUtil} to access the
	 * p e process audit local service.
	 */

	private static Log _log = LogFactoryUtil.getLog(PEProcessAuditLocalServiceImpl.class);
	
	public PEProcessAudit create() throws SystemException {
		PEProcessAudit peProcessAudit = peProcessAuditPersistence.create(counterLocalService
				.increment("PEProcessAudit"));
		return peProcessAudit;
	}

	public PEProcessAudit create(long processStateId) throws SystemException {
		PEProcessAudit peProcessAudit = create();
		peProcessAudit.setSpPEProcessStateId(processStateId);
		return peProcessAudit;
	}

	public List<PEProcessAudit> findByPEProcessStateIdTypeCreateDateLT(long processStateId, String type, Date createDate)
			throws SystemException {

		// must be by createDate asc

		return PEProcessAuditUtil.findByPEProcessStateIdTypeCreateDateLT(type, createDate, processStateId, -1, -1,
				byCreatedDateAsc());
	}

	public List<PEProcessAudit> findByProcessStateId(long processStateId) throws SystemException {
		return PEProcessAuditUtil.findByPEProcessStateId(processStateId, -1, -1, byCreatedDateAsc());
	}

	public List<PEProcessAudit> findByProcessStateIdType(long processStateId, String type) throws SystemException {

		// must be by createDate asc

		return PEProcessAuditUtil.findByTypePEProcessStateId(type, processStateId, -1, -1, byCreatedDateAsc());
	}

	public PEProcessAudit getFormJspAuditForDates(long processStateId, Date date1, Date date2) throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PEProcessAudit.class,
				PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID));

		Criterion stateId = RestrictionsFactoryUtil.eq(PEConstants.COLUMN_PE_PROCESS_STATE_ID, processStateId);
		Criterion criterionJsp = RestrictionsFactoryUtil.eq(PEConstants.COLUMN_TYPE, PEAuditConstants.TYPE_JSP);
		Criterion criterionForm = RestrictionsFactoryUtil.eq(PEConstants.COLUMN_TYPE, PEAuditConstants.TYPE_FORM);
		Criterion jspOrForm = RestrictionsFactoryUtil.or(criterionJsp, criterionForm);

		Criterion between = RestrictionsFactoryUtil.between(PEConstants.COLUMN_CREATE_DATE, date1, date2);

		dynamicQuery.addOrder(OrderFactoryUtil.desc(PEConstants.COLUMN_CREATE_DATE));
		dynamicQuery.add(stateId).add(jspOrForm).add(between);
		List<PEProcessAudit> list = PEProcessAuditLocalServiceUtil.dynamicQuery(dynamicQuery);

		if (!list.isEmpty()) {
			return list.get(list.size() - 1);
		}

		return null;
	}

	public PEProcessAudit getFormJspBetweenStatusTypeAudits(PEProcessAudit audit1, PEProcessAudit audit2)
			throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PEProcessAudit.class,
				PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID));

		Criterion stateId = RestrictionsFactoryUtil.eq(PEConstants.COLUMN_PE_PROCESS_STATE_ID,
				audit1.getSpPEProcessStateId());

		Criterion criterionJsp = RestrictionsFactoryUtil.eq(PEConstants.COLUMN_TYPE, PEAuditConstants.TYPE_JSP);
		Criterion criterionForm = RestrictionsFactoryUtil.eq(PEConstants.COLUMN_TYPE, PEAuditConstants.TYPE_FORM);
		Criterion jspOrForm = RestrictionsFactoryUtil.or(criterionJsp, criterionForm);

		// created date must be greater than audit1 and less than or equal to
		// audit2

		Criterion createDate1 = RestrictionsFactoryUtil.gt(PEConstants.COLUMN_CREATE_DATE, audit1.getCreateDate());
		Criterion createDate2 = RestrictionsFactoryUtil.le(PEConstants.COLUMN_CREATE_DATE, audit2.getCreateDate());

		dynamicQuery.addOrder(OrderFactoryUtil.desc(PEConstants.COLUMN_CREATE_DATE));
		dynamicQuery.add(stateId).add(jspOrForm).add(createDate1).add(createDate2);
		List<PEProcessAudit> list = PEProcessAuditLocalServiceUtil.dynamicQuery(dynamicQuery);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	public PEProcessAudit getNearestFormJsp(final PEProcessAudit audit) throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PEProcessAudit.class,
				PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID));

		Criterion stateId = RestrictionsFactoryUtil.eq(PEConstants.COLUMN_PE_PROCESS_STATE_ID,
				audit.getSpPEProcessStateId());

		Criterion criterionJsp = RestrictionsFactoryUtil.eq(PEConstants.COLUMN_TYPE, PEAuditConstants.TYPE_JSP);
		Criterion criterionForm = RestrictionsFactoryUtil.eq(PEConstants.COLUMN_TYPE, PEAuditConstants.TYPE_FORM);
		Criterion jspOrForm = RestrictionsFactoryUtil.or(criterionJsp, criterionForm);

		Criterion createDate = RestrictionsFactoryUtil.le(PEConstants.COLUMN_CREATE_DATE, audit.getCreateDate());
		dynamicQuery.addOrder(OrderFactoryUtil.desc(PEConstants.COLUMN_CREATE_DATE));
		dynamicQuery.add(stateId).add(jspOrForm).add(createDate);
		List<PEProcessAudit> list = PEProcessAuditLocalServiceUtil.dynamicQuery(dynamicQuery);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	public PEProcessAudit getNearestStatusTypeAudit(final PEProcessAudit audit) throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PEProcessAudit.class,
				PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID));

		Criterion stateId = RestrictionsFactoryUtil.eq(PEConstants.COLUMN_PE_PROCESS_STATE_ID,
				audit.getSpPEProcessStateId());
		Criterion criterionType = RestrictionsFactoryUtil.eq(PEConstants.COLUMN_TYPE, PEAuditConstants.TYPE_STATUS);
		Criterion createDate = RestrictionsFactoryUtil.lt(PEConstants.COLUMN_CREATE_DATE, audit.getCreateDate());
		dynamicQuery.addOrder(OrderFactoryUtil.desc(PEConstants.COLUMN_CREATE_DATE));
		dynamicQuery.add(stateId).add(criterionType).add(createDate);
		List<PEProcessAudit> list = PEProcessAuditLocalServiceUtil.dynamicQuery(dynamicQuery);

		if (!list.isEmpty()) {
			return list.get(list.size() - 1);
		}

		return null;
	}
	
	public PEProcessAudit findByProcessStateIdFormId(long processStateId, long formId) throws SystemException{
		List<PEProcessAudit>list = PEProcessAuditUtil.findByPEProcessStateIdFormId(processStateId, String.valueOf(formId),-1,-1,byCreatedDateAsc());
		if(!list.isEmpty()){
			return list.get(list.size()-1);
		}
		return null;
	}
	
	public PEProcessAudit findByTypeField2PEProcessStateId(String type,String field2,long processStateId) throws NoSuchPEProcessAuditException,SystemException{
		return peProcessAuditPersistence.findByPEProcessStateIdTypeField2(processStateId,type, field2);
	}
	
	public List<PEProcessAudit> findByActionTypeField2(String action, String type, String field2) throws NoSuchPEProcessAuditException,SystemException{
		return peProcessAuditPersistence.findByActionTypeField2(action,type, field2);
	}
	
	// fetches audit record for given status type such that the audit record have form/jsp's node id in field5 
	public PEProcessAudit findStatusTypeAudit_DisplayNodeIdNotZero(long statusType,long processStateId) throws NoSuchPEProcessAuditException,SystemException{
		return findByTypeField2PEProcessStateId(PEAuditConstants.TYPE_STATUS, String.valueOf(statusType), processStateId);
	}
	
	public PEProcessAudit findLatestStatusTypeAudit(long statusType,long processStateId) throws NoSuchPEProcessAuditException,SystemException{
		return findByTypeField2PEProcessStateId(PEAuditConstants.TYPE_STATUS, String.valueOf(statusType), processStateId);
	}

	public List<PEProcessAudit> findByProcessStateIdNodeId(long processStateId, long nodeId) throws SystemException{
		return peProcessAuditPersistence.findByPEProcessStateIdNodeId(processStateId, nodeId, -1, -1, byCreatedDateAsc());
	}
	public PEProcessAudit findLatestByProcessStateIdNodeId(long processStateId, long nodeId) throws SystemException{
		List<PEProcessAudit> list = peProcessAuditPersistence.findByPEProcessStateIdNodeId(processStateId, nodeId, -1, -1, byCreatedDateAsc());
		if(!list.isEmpty()){
			return list.get(list.size()-1);
		}
		return null;
	}
	
	public PEProcessAudit findByProcessStateIdNodeIdAction(long processStateId, long nodeId,String action) throws NoSuchPEProcessAuditException,SystemException{
		return peProcessAuditPersistence.findByPEProcessStateIdNodeIdAction(processStateId, nodeId,action);
	}
	
	public PEProcessAudit getLatestAudit(long processStateId, long nodeId) throws SystemException{
		List<PEProcessAudit> list = findByProcessStateIdNodeId(processStateId,nodeId);
		
		if(!list.isEmpty()){
			//last record is the latest record
			return list.get(list.size()-1);
		}
		
		return null;
	}
	
	public List<PEProcessAudit> findStatusTypeAudits(long processStateId) throws SystemException{
		return peProcessAuditPersistence.findByPEProcessStateIdType(processStateId, PEAuditConstants.TYPE_STATUS, -1, -1, byCreatedDateAsc());
	}

	private OrderByComparator byCreatedDateAsc() {
		OrderByComparator createDateASC = OrderByComparatorFactoryUtil.create(PEConstants.TABLE_PROCESS_AUDIT,
				PEConstants.COLUMN_CREATE_DATE, true);
		return createDateASC;
	}
	
	public void clearCache() {
		try{
		peProcessAuditPersistence.clearCache();
		}
		catch (Exception e){
			_log.error(e.getMessage());
		}
	}
}