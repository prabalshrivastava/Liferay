package com.sambaash.platform.pe.helpers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
public class PEAuditStatusRetriveHelper implements PEAuditConstants {

	public PEAuditStatusRetriveHelper(PEProcessState processState) throws SystemException {
		this.processState = processState;
		configure();
	}

	public void configure() throws SystemException {

		// audit records fetched in ascending order by createDate

		auditList = PEProcessAuditLocalServiceUtil.findStatusTypeAudits(processState.getSpPEProcessStateId());
		map = new LinkedHashMap<Long, PEProcessAudit>();
		// loop through all completed status types
		for (PEProcessAudit audit : auditList) {
			//latest record always overwrites old in this map.. so this map always contains latest records 
			map.put(GetterUtil.getLong(audit.getField2()), audit);
		}
	}

	public PEProcessAudit getAuditRecord(long statusTypeId) {
		PEProcessAudit audit = map.get(statusTypeId);
		return audit;
	}

	private PEProcessState processState = null;

	private List<PEProcessAudit> auditList = null;

	private Map<Long, PEProcessAudit> map = null;

}