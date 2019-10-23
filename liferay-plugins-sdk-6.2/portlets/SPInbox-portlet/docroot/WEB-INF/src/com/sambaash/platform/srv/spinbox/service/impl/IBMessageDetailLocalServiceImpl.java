/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.sambaash.platform.srv.spinbox.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.sambaash.platform.portlet.spinbox.comparator.IBMessageDetailReceiveDateComparator;
import com.sambaash.platform.portlet.spinbox.helper.InboxUtil;
import com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;
import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;
import com.sambaash.platform.srv.spinbox.service.base.IBMessageDetailLocalServiceBaseImpl;

/**
 * The implementation of the i b message detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.portlet.spinbox.srv.service.IBMessageDetailLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.portlet.spinbox.srv.service.base.IBMessageDetailLocalServiceBaseImpl
 * @see com.sambaash.platform.portlet.spinbox.srv.service.IBMessageDetailLocalServiceUtil
 */
public class IBMessageDetailLocalServiceImpl
	extends IBMessageDetailLocalServiceBaseImpl {
	

	public IBMessageDetail addMessageDetail(long messageId, long receiverId,
			String receiveBy, Date receiveDate, String category,
			boolean archived, Date updateDate, String updateBy,
			String receiverMsgStatus, String senderMsgStatus, String status ,long processId, long corpProfileId)
			throws PortalException, SystemException {

		long msgDetailId = counterLocalService.increment();
		IBMessageDetail msgDetail = ibMessageDetailPersistence
				.create(msgDetailId);

		msgDetail.setMessageId(messageId);
		msgDetail.setReceiverId(receiverId);
		msgDetail.setReceiveBy(receiveBy);
		msgDetail.setReceiveDate(receiveDate);
		msgDetail.setCategory(category);
		msgDetail.setArchived(archived);
		msgDetail.setUpdateDate(updateDate);
		msgDetail.setUpdateBy(updateBy);
		msgDetail.setReceiverMsgStatus(receiverMsgStatus);
		msgDetail.setSenderMsgStatus(senderMsgStatus);
		msgDetail.setStatus(status);
		msgDetail.setProcessId(processId);
		msgDetail.setCorpProfileId(corpProfileId);

		ibMessageDetailPersistence.update(msgDetail, false);

		return msgDetail;
	}


	public IBMessageDetail findByReceiverIdmessageId(long receiverId, long msgId)
			throws SystemException {
		try {
			return ibMessageDetailPersistence.findByReceiverIdmessageId(receiverId, msgId);
		} catch (NoSuchIBMessageDetailException e) {
		}
		return null;
	}
	public List<IBMessageDetail> findByReceId(long receiverId, boolean archived)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceId(receiverId, archived);
	}

	public List<IBMessageDetail> findByReceId(long receiverId,
			boolean archived, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceId(receiverId, archived,
				start, end);
	}

	public List<IBMessageDetail> findByReceId(long receiverId,
			boolean archived, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceId(receiverId, archived,
				start, end, orderByComparator);
	}

	public List<IBMessageDetail> findByReceIdAndRms(long receiverId,
			boolean archived, java.lang.String receiverMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdAndRms(receiverId,
				archived, receiverMsgStatus);
	}

	public List<IBMessageDetail> findByReceIdAndRms(long receiverId,
			boolean archived, java.lang.String receiverMsgStatus, int start,
			int end) throws SystemException {
		return ibMessageDetailPersistence.findByReceIdAndRms(receiverId,
				archived, receiverMsgStatus, start, end);
	}

	public List<IBMessageDetail> findByReceIdAndRms(long receiverId,
			boolean archived, java.lang.String receiverMsgStatus, int start,
			int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdAndRms(receiverId,
				archived, receiverMsgStatus, start, end, orderByComparator);
	}

	public List<IBMessageDetail> findByReceIdAndSms(long receiverId,
			boolean archived, java.lang.String senderMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdAndSms(receiverId,
				archived, senderMsgStatus);
	}

	public List<IBMessageDetail> findByReceIdAndSms(long receiverId,
			boolean archived, java.lang.String senderMsgStatus, int start,
			int end) throws SystemException {
		return ibMessageDetailPersistence.findByReceIdAndSms(receiverId,
				archived, senderMsgStatus, start, end);
	}

	public List<IBMessageDetail> findByReceIdAndSms(long receiverId,
			boolean archived, java.lang.String senderMsgStatus, int start,
			int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdAndSms(receiverId,
				archived, senderMsgStatus, start, end, orderByComparator);
	}

	public List<IBMessageDetail> findByReceIdRmsAndSms(long receiverId,
			boolean archived, java.lang.String receiverMsgStatus,
			java.lang.String senderMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdRmsAndSms(receiverId,
				archived, receiverMsgStatus, senderMsgStatus);
	}

	public List<IBMessageDetail> findByReceIdRmsAndSms(long receiverId,
			boolean archived, java.lang.String receiverMsgStatus,
			java.lang.String senderMsgStatus, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdRmsAndSms(receiverId,
				archived, receiverMsgStatus, senderMsgStatus, start, end);
	}

	public List<IBMessageDetail> findByReceIdRmsAndSms(long receiverId,
			boolean archived, java.lang.String receiverMsgStatus,
			java.lang.String senderMsgStatus, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdRmsAndSms(receiverId,
				archived, receiverMsgStatus, senderMsgStatus, start, end,
				orderByComparator);
	}

	public List<IBMessageDetail> findByReceIdAndCty(long receiverId,
			boolean archived, java.lang.String category)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdAndCty(receiverId,
				archived, category);
	}

	public List<IBMessageDetail> findByReceIdAndCty(long receiverId,
			boolean archived, java.lang.String category, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdAndCty(receiverId,
				archived, category, start, end);
	}

	public List<IBMessageDetail> findByReceIdAndCty(long receiverId,
			boolean archived, java.lang.String category, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdAndCty(receiverId,
				archived, category, start, end, orderByComparator);
	}

	public List<IBMessageDetail> findByReceIdCtyAndRms(long receiverId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdCtyAndRms(receiverId,
				archived, category, receiverMsgStatus);
	}

	public List<IBMessageDetail> findByReceIdCtyAndRms(long receiverId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdCtyAndRms(receiverId,
				archived, category, receiverMsgStatus, start, end);
	}

	public List<IBMessageDetail> findByReceIdCtyAndRms(long receiverId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdCtyAndRms(receiverId,
				archived, category, receiverMsgStatus, start, end,
				orderByComparator);
	}

	public List<IBMessageDetail> findByReceIdCtyAndSms(long receiverId,
			boolean archived, java.lang.String category,
			java.lang.String senderMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdCtyAndSms(receiverId,
				archived, category, senderMsgStatus);
	}

	public List<IBMessageDetail> findByReceIdCtyAndSms(long receiverId,
			boolean archived, java.lang.String category,
			java.lang.String senderMsgStatus, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdCtyAndSms(receiverId,
				archived, category, senderMsgStatus, start, end);
	}

	public List<IBMessageDetail> findByReceIdCtyAndSms(long receiverId,
			boolean archived, java.lang.String category,
			java.lang.String senderMsgStatus, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdCtyAndSms(receiverId,
				archived, category, senderMsgStatus, start, end,
				orderByComparator);
	}

	public List<IBMessageDetail> findByReceIdCtyRmsAndSms(long receiverId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdCtyRmsAndSms(receiverId,
				archived, category, receiverMsgStatus, senderMsgStatus);
	}

	public List<IBMessageDetail> findByReceIdCtyRmsAndSms(long receiverId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus,
			java.lang.String senderMsgStatus, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdCtyRmsAndSms(receiverId,
				archived, category, receiverMsgStatus, senderMsgStatus, start,
				end);
	}

	public List<IBMessageDetail> findByReceIdCtyRmsAndSms(long receiverId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus,
			java.lang.String senderMsgStatus, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByReceIdCtyRmsAndSms(receiverId,
				archived, category, receiverMsgStatus, senderMsgStatus, start,
				end, orderByComparator);
	}

	// for corporate user

	public List<IBMessageDetail> findByCorpId(long corpProfileId,
			boolean archived)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpId(corpProfileId, archived);
	}

	public List<IBMessageDetail> findByCorpId(long corpProfileId,
			boolean archived, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpId(corpProfileId, archived,
				start, end);
	}

	public List<IBMessageDetail> findByCorpId(long corpProfileId,
			boolean archived, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpId(corpProfileId, archived,
				start, end, orderByComparator);
	}

	public List<IBMessageDetail> findByCorpIdAndRms(long corpProfileId,
			boolean archived, java.lang.String receiverMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdAndRms(corpProfileId,
				archived, receiverMsgStatus);
	}

	public List<IBMessageDetail> findByCorpIdAndRms(long corpProfileId,
			boolean archived, java.lang.String receiverMsgStatus, int start,
			int end) throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdAndRms(corpProfileId,
				archived, receiverMsgStatus, start, end);
	}

	public List<IBMessageDetail> findByCorpIdAndRms(long corpProfileId,
			boolean archived, java.lang.String receiverMsgStatus, int start,
			int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdAndRms(corpProfileId,
				archived, receiverMsgStatus, start, end, orderByComparator);
	}

	public List<IBMessageDetail> findByCorpIdAndSms(long corpProfileId,
			boolean archived, java.lang.String senderMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdAndSms(corpProfileId,
				archived, senderMsgStatus);
	}

	public List<IBMessageDetail> findByCorpIdAndSms(long corpProfileId,
			boolean archived, java.lang.String senderMsgStatus, int start,
			int end) throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdAndSms(corpProfileId,
				archived, senderMsgStatus, start, end);
	}

	public List<IBMessageDetail> findByCorpIdAndSms(long corpProfileId,
			boolean archived, java.lang.String senderMsgStatus, int start,
			int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdAndSms(corpProfileId,
				archived, senderMsgStatus, start, end, orderByComparator);
	}

	public List<IBMessageDetail> findByCorpIdRmsAndSms(long corpProfileId,
			boolean archived, java.lang.String receiverMsgStatus,
			java.lang.String senderMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdRmsAndSms(corpProfileId,
				archived, receiverMsgStatus, senderMsgStatus);
	}

	public List<IBMessageDetail> findByCorpIdRmsAndSms(long corpProfileId,
			boolean archived, java.lang.String receiverMsgStatus,
			java.lang.String senderMsgStatus, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdRmsAndSms(corpProfileId,
				archived, receiverMsgStatus, senderMsgStatus, start, end);
	}

	public List<IBMessageDetail> findByCorpIdRmsAndSms(long corpProfileId,
			boolean archived, java.lang.String receiverMsgStatus,
			java.lang.String senderMsgStatus, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdRmsAndSms(corpProfileId,
				archived, receiverMsgStatus, senderMsgStatus, start, end,
				orderByComparator);
	}

	public List<IBMessageDetail> findByCorpIdAndCty(long corpProfileId,
			boolean archived, java.lang.String category)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdAndCty(corpProfileId,
				archived, category);
	}

	public List<IBMessageDetail> findByCorpIdAndCty(long corpProfileId,
			boolean archived, java.lang.String category, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdAndCty(corpProfileId,
				archived, category, start, end);
	}

	public List<IBMessageDetail> findByCorpIdAndCty(long corpProfileId,
			boolean archived, java.lang.String category, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdAndCty(corpProfileId,
				archived, category, start, end, orderByComparator);
	}

	public List<IBMessageDetail> findByCorpIdCtyAndRms(long corpProfileId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdCtyAndRms(corpProfileId,
				archived, category, receiverMsgStatus);
	}

	public List<IBMessageDetail> findByCorpIdCtyAndRms(long corpProfileId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdCtyAndRms(corpProfileId,
				archived, category, receiverMsgStatus, start, end);
	}

	public List<IBMessageDetail> findByCorpIdCtyAndRms(long corpProfileId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdCtyAndRms(corpProfileId,
				archived, category, receiverMsgStatus, start, end,
				orderByComparator);
	}

	public List<IBMessageDetail> findByCorpIdCtyAndSms(long corpProfileId,
			boolean archived, java.lang.String category,
			java.lang.String senderMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdCtyAndSms(corpProfileId,
				archived, category, senderMsgStatus);
	}

	public List<IBMessageDetail> findByCorpIdCtyAndSms(long corpProfileId,
			boolean archived, java.lang.String category,
			java.lang.String senderMsgStatus, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdCtyAndSms(corpProfileId,
				archived, category, senderMsgStatus, start, end);
	}

	public List<IBMessageDetail> findByCorpIdCtyAndSms(long corpProfileId,
			boolean archived, java.lang.String category,
			java.lang.String senderMsgStatus, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdCtyAndSms(corpProfileId,
				archived, category, senderMsgStatus, start, end,
				orderByComparator);
	}

	public List<IBMessageDetail> findByCorpIdCtyRmsAndSms(long corpProfileId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdCtyRmsAndSms(
				corpProfileId, archived, category, receiverMsgStatus,
				senderMsgStatus);
	}

	public List<IBMessageDetail> findByCorpIdCtyRmsAndSms(long corpProfileId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus,
			java.lang.String senderMsgStatus, int start, int end)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdCtyRmsAndSms(
				corpProfileId, archived, category, receiverMsgStatus,
				senderMsgStatus, start, end);
	}

	public List<IBMessageDetail> findByCorpIdCtyRmsAndSms(long corpProfileId,
			boolean archived, java.lang.String category,
			java.lang.String receiverMsgStatus,
			java.lang.String senderMsgStatus, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		return ibMessageDetailPersistence.findByCorpIdCtyRmsAndSms(
				corpProfileId, archived, category, receiverMsgStatus,
				senderMsgStatus, start, end, orderByComparator);
	}

	public List<IBMessageDetail> getAvailableMDListByReceiveId(User user, long receiverId, boolean archived, String category,
			String receiverMsgStatus, String senderMsgStatus, int start, int end, String comparator,long scopeGroupId) throws SystemException{
		
		if(Validator.isNull(comparator)){
			List<IBMessageDetail> availableMDWithoutCategoryList = new ArrayList<IBMessageDetail>();
			List<IBMessageDetail> allAvailableMDWithoutCategoryList =  this.findByReceIdAndRms(receiverId, archived, receiverMsgStatus, -1, -1, new IBMessageDetailReceiveDateComparator());

			if (start<0 && end<0) {
				return allAvailableMDWithoutCategoryList;
			}

			if (end>allAvailableMDWithoutCategoryList.size()) {
				end = allAvailableMDWithoutCategoryList.size();
			}

			for (int i=start; i<end; i++) {
				availableMDWithoutCategoryList.add(allAvailableMDWithoutCategoryList.get(i));
			}
			return availableMDWithoutCategoryList;
		}
		
		return getAvailableMDListByReceiveId(user, receiverId, archived, category, receiverMsgStatus, senderMsgStatus, start, end, new IBMessageDetailReceiveDateComparator(),scopeGroupId);
	}
	public List<IBMessageDetail> getAvailableMDListByReceiveId(User user, long receiverId, boolean archived, String category,
			String receiverMsgStatus, String senderMsgStatus, int start, int end, OrderByComparator orderByComparator,long scopeGroupId) throws SystemException{

		List<IBMessageDetail> availableMDWithCategoryList = new ArrayList<IBMessageDetail>();
		if (Validator.isNotNull(category)) {
			if (Validator.isNotNull(receiverMsgStatus) && Validator.isNotNull(senderMsgStatus)) {
				if (InboxUtil.checkAccessForService(user, InboxUtil.getTechComponentByMsgCategory(category,scopeGroupId))) {
					availableMDWithCategoryList = this.findByReceIdCtyRmsAndSms(receiverId, archived, category, receiverMsgStatus, senderMsgStatus, start, end, orderByComparator);
				}
			}else if (Validator.isNotNull(receiverMsgStatus) && Validator.isNull(senderMsgStatus)) {
				if (InboxUtil.checkAccessForService(user, InboxUtil.getTechComponentByMsgCategory(category,scopeGroupId))) {
					availableMDWithCategoryList = this.findByReceIdCtyAndRms(receiverId, archived, category, receiverMsgStatus, start, end, orderByComparator);
				}
			}else if (Validator.isNull(receiverMsgStatus) && Validator.isNotNull(senderMsgStatus)) {
				if (InboxUtil.checkAccessForService(user, InboxUtil.getTechComponentByMsgCategory(category,scopeGroupId))) {
					availableMDWithCategoryList = this.findByReceIdCtyAndSms(receiverId, archived, category, senderMsgStatus, start, end, orderByComparator);
				}
			}else if (Validator.isNull(receiverMsgStatus) && Validator.isNull(senderMsgStatus)) {
				if (InboxUtil.checkAccessForService(user, InboxUtil.getTechComponentByMsgCategory(category,scopeGroupId))) {
					availableMDWithCategoryList = this.findByReceIdAndCty(receiverId, archived, category, start, end, orderByComparator);
				}
			}

			return availableMDWithCategoryList;
		}else{
			List<IBMessageDetail> availableMDWithoutCategoryList = new ArrayList<IBMessageDetail>();
			List<IBMessageDetail> allMDWithoutCategoryList = new ArrayList<IBMessageDetail>();

			List<IBMessageDetail> allAvailableMDWithoutCategoryList = new ArrayList<IBMessageDetail>();

			if (Validator.isNotNull(receiverMsgStatus) && Validator.isNotNull(senderMsgStatus)) {
				allMDWithoutCategoryList = this.findByReceIdRmsAndSms(receiverId, archived, receiverMsgStatus, senderMsgStatus, -1, -1, orderByComparator);
			}else if (Validator.isNotNull(receiverMsgStatus) && Validator.isNull(senderMsgStatus)) {
				allMDWithoutCategoryList = this.findByReceIdAndRms(receiverId, archived, receiverMsgStatus, -1, -1, orderByComparator);
			}else if (Validator.isNull(receiverMsgStatus) && Validator.isNotNull(senderMsgStatus)) {
				allMDWithoutCategoryList = this.findByReceIdAndSms(receiverId, archived, senderMsgStatus, -1, -1, orderByComparator);
			}else if (Validator.isNull(receiverMsgStatus) && Validator.isNull(senderMsgStatus)) {
				allMDWithoutCategoryList = this.findByReceId(receiverId, archived, -1, -1, orderByComparator);
			}
			for (IBMessageDetail md : allMDWithoutCategoryList) {
				if (InboxUtil.checkAccessForService(user, InboxUtil.getTechComponentByMsgCategory(md.getCategory(),scopeGroupId))) {
					allAvailableMDWithoutCategoryList.add(md);
				}
			}

			if (start<0 && end<0) {
				return allAvailableMDWithoutCategoryList;
			}

			if (end>allAvailableMDWithoutCategoryList.size()) {
				end = allAvailableMDWithoutCategoryList.size();
			}

			for (int i=start; i<end; i++) {
				availableMDWithoutCategoryList.add(allAvailableMDWithoutCategoryList.get(i));
			}
			return availableMDWithoutCategoryList;
		}
	}

	public List<IBMessageDetail> getAvailableMDListByCorpProfileId(User user, long corpProfileId, boolean archived, String category,
			String receiverMsgStatus, String senderMsgStatus, int start, int end, OrderByComparator orderByComparator,long scopeGroupId) throws SystemException{

		List<IBMessageDetail> availableMDWithCategoryList = new ArrayList<IBMessageDetail>();
		if (Validator.isNotNull(category)) {
			if (Validator.isNotNull(receiverMsgStatus) && Validator.isNotNull(senderMsgStatus)) {
				if (InboxUtil.checkAccessForService(user, InboxUtil.getTechComponentByMsgCategory(category,scopeGroupId))) {
					availableMDWithCategoryList = this.findByCorpIdCtyRmsAndSms(corpProfileId, archived, category, receiverMsgStatus, senderMsgStatus, start, end, orderByComparator);
				}
			}else if (Validator.isNotNull(receiverMsgStatus) && Validator.isNull(senderMsgStatus)) {
				if (InboxUtil.checkAccessForService(user, InboxUtil.getTechComponentByMsgCategory(category,scopeGroupId))) {
					availableMDWithCategoryList = this.findByCorpIdCtyAndRms(corpProfileId, archived, category, receiverMsgStatus, start, end, orderByComparator);
				}
			}else if (Validator.isNull(receiverMsgStatus) && Validator.isNotNull(senderMsgStatus)) {
				if (InboxUtil.checkAccessForService(user, InboxUtil.getTechComponentByMsgCategory(category,scopeGroupId))) {
					availableMDWithCategoryList = this.findByCorpIdCtyAndSms(corpProfileId, archived, category, senderMsgStatus, start, end, orderByComparator);
				}
			}else if (Validator.isNull(receiverMsgStatus) && Validator.isNull(senderMsgStatus)) {
				if (InboxUtil.checkAccessForService(user, InboxUtil.getTechComponentByMsgCategory(category,scopeGroupId))) {
					availableMDWithCategoryList = this.findByCorpIdAndCty(corpProfileId, archived, category, start, end, orderByComparator);
				}
			}

			return availableMDWithCategoryList;
		}else{
			List<IBMessageDetail> availableMDWithoutCategoryList = new ArrayList<IBMessageDetail>();
			List<IBMessageDetail> allMDWithoutCategoryList = new ArrayList<IBMessageDetail>();

			List<IBMessageDetail> allAvailableMDWithoutCategoryList = new ArrayList<IBMessageDetail>();

			if (Validator.isNotNull(receiverMsgStatus) && Validator.isNotNull(senderMsgStatus)) {
				allMDWithoutCategoryList = this.findByCorpIdRmsAndSms(corpProfileId, archived, receiverMsgStatus, senderMsgStatus, -1, -1, orderByComparator);
			}else if (Validator.isNotNull(receiverMsgStatus) && Validator.isNull(senderMsgStatus)) {
				allMDWithoutCategoryList = this.findByCorpIdAndRms(corpProfileId, archived, receiverMsgStatus, -1, -1, orderByComparator);
			}else if (Validator.isNull(receiverMsgStatus) && Validator.isNotNull(senderMsgStatus)) {
				allMDWithoutCategoryList = this.findByCorpIdAndSms(corpProfileId, archived, senderMsgStatus, -1, -1, orderByComparator);
			}else if (Validator.isNull(receiverMsgStatus) && Validator.isNull(senderMsgStatus)) {
				allMDWithoutCategoryList = this.findByCorpId(corpProfileId, archived, -1, -1, orderByComparator);
			}
			for (IBMessageDetail md : allMDWithoutCategoryList) {
				if (InboxUtil.checkAccessForService(user, InboxUtil.getTechComponentByMsgCategory(md.getCategory(),scopeGroupId))) {
					allAvailableMDWithoutCategoryList.add(md);
				}
			}
			if (start<0 && end<0) {
				return allAvailableMDWithoutCategoryList;
			}

			if (end>allAvailableMDWithoutCategoryList.size()) {
				end = allAvailableMDWithoutCategoryList.size();
			}

			for (int i=start; i<end; i++) {
				availableMDWithoutCategoryList.add(allAvailableMDWithoutCategoryList.get(i));
			}
			return availableMDWithoutCategoryList;
		}

	}

	public List<IBMessageDetail> findByMessageId(long messageId) throws SystemException {
		return ibMessageDetailPersistence.findByMessageId(messageId);
	}

	public List<IBMessageDetail> findByMessageId(long messageId, int start, int end) throws SystemException {
		return ibMessageDetailPersistence.findByMessageId(messageId, start, end);
	}

	public List<IBMessageDetail> findByMessageId(long messageId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return ibMessageDetailPersistence.findByMessageId(messageId, start, end, orderByComparator);
	}


}