package com.sambaash.platform.pe;

import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
public interface ProcessEngine {

	PEOutput executeByProcessStateId(long processStateId, long requestedStatusTypeId, PortletRequest request, PortletResponse response) throws SystemException;
	PEOutput executeByProcessStateId(long processStateId, long requestedStatusTypeId, PERequestData requestData) throws SystemException;
	PEOutput executeByEntityIdProcessId(long entityClassId,long entityId, long processId, long requestedStatusTypeId, PortletRequest request, PortletResponse response) throws SystemException;
	PEOutput executeByEntityIdProcessId(long entityClassId,long entityId, long processId, long requestedStatusTypeId,PERequestData requestData) throws SystemException;
	PEOutput execute(PEProcessState processState, long requestedStatusTypeId, PERequestData requestData) throws SystemException;
	PEOutput execute(PEProcessState processState, long requestedStatusTypeId, PERequestData requestData, PortletRequest request, PortletResponse response) throws SystemException;
	PEOutput approve(long processStatusId, PortletRequest request, PortletResponse response) throws SystemException;
	PEOutput reject(long processStatusId, PortletRequest request, PortletResponse response) throws SystemException;
	void executeAsApprover(PEProcessStatePK pk, PortletRequest request, PortletResponse response);
}
