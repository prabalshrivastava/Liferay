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

package com.sambaash.platform.srv.spjob.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author harini
 * @generated
 */
public class SPJobApplicantsPortfolioPK implements Comparable<SPJobApplicantsPortfolioPK>,
	Serializable {
	public long jobApplyId;
	public long porfolioId;

	public SPJobApplicantsPortfolioPK() {
	}

	public SPJobApplicantsPortfolioPK(long jobApplyId, long porfolioId) {
		this.jobApplyId = jobApplyId;
		this.porfolioId = porfolioId;
	}

	public long getJobApplyId() {
		return jobApplyId;
	}

	public void setJobApplyId(long jobApplyId) {
		this.jobApplyId = jobApplyId;
	}

	public long getPorfolioId() {
		return porfolioId;
	}

	public void setPorfolioId(long porfolioId) {
		this.porfolioId = porfolioId;
	}

	@Override
	public int compareTo(SPJobApplicantsPortfolioPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (jobApplyId < pk.jobApplyId) {
			value = -1;
		}
		else if (jobApplyId > pk.jobApplyId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (porfolioId < pk.porfolioId) {
			value = -1;
		}
		else if (porfolioId > pk.porfolioId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPJobApplicantsPortfolioPK)) {
			return false;
		}

		SPJobApplicantsPortfolioPK pk = (SPJobApplicantsPortfolioPK)obj;

		if ((jobApplyId == pk.jobApplyId) && (porfolioId == pk.porfolioId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(jobApplyId) + String.valueOf(porfolioId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("jobApplyId");
		sb.append(StringPool.EQUAL);
		sb.append(jobApplyId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("porfolioId");
		sb.append(StringPool.EQUAL);
		sb.append(porfolioId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}