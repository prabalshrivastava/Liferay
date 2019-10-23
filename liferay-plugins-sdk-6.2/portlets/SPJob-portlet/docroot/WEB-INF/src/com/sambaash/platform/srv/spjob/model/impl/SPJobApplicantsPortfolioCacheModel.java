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

package com.sambaash.platform.srv.spjob.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPJobApplicantsPortfolio in entity cache.
 *
 * @author harini
 * @see SPJobApplicantsPortfolio
 * @generated
 */
public class SPJobApplicantsPortfolioCacheModel implements CacheModel<SPJobApplicantsPortfolio>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{jobApplyId=");
		sb.append(jobApplyId);
		sb.append(", porfolioId=");
		sb.append(porfolioId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", extra1=");
		sb.append(extra1);
		sb.append(", extra2=");
		sb.append(extra2);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPJobApplicantsPortfolio toEntityModel() {
		SPJobApplicantsPortfolioImpl spJobApplicantsPortfolioImpl = new SPJobApplicantsPortfolioImpl();

		spJobApplicantsPortfolioImpl.setJobApplyId(jobApplyId);
		spJobApplicantsPortfolioImpl.setPorfolioId(porfolioId);
		spJobApplicantsPortfolioImpl.setUserId(userId);
		spJobApplicantsPortfolioImpl.setCreatedBy(createdBy);
		spJobApplicantsPortfolioImpl.setUpdatedBy(updatedBy);

		if (createDate == Long.MIN_VALUE) {
			spJobApplicantsPortfolioImpl.setCreateDate(null);
		}
		else {
			spJobApplicantsPortfolioImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spJobApplicantsPortfolioImpl.setModifiedDate(null);
		}
		else {
			spJobApplicantsPortfolioImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (extra1 == null) {
			spJobApplicantsPortfolioImpl.setExtra1(StringPool.BLANK);
		}
		else {
			spJobApplicantsPortfolioImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			spJobApplicantsPortfolioImpl.setExtra2(StringPool.BLANK);
		}
		else {
			spJobApplicantsPortfolioImpl.setExtra2(extra2);
		}

		spJobApplicantsPortfolioImpl.resetOriginalValues();

		return spJobApplicantsPortfolioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobApplyId = objectInput.readLong();
		porfolioId = objectInput.readLong();
		userId = objectInput.readLong();
		createdBy = objectInput.readLong();
		updatedBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		extra1 = objectInput.readUTF();
		extra2 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jobApplyId);
		objectOutput.writeLong(porfolioId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(updatedBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (extra1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra1);
		}

		if (extra2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra2);
		}
	}

	public long jobApplyId;
	public long porfolioId;
	public long userId;
	public long createdBy;
	public long updatedBy;
	public long createDate;
	public long modifiedDate;
	public String extra1;
	public String extra2;
}