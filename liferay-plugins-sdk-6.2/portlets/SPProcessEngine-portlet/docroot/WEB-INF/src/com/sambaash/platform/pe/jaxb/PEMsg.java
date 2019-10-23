package com.sambaash.platform.pe.jaxb;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public class PEMsg extends SingleOutputNodeImpl implements PEDisplayable {

	@Override
	public void fillOutput(PEOutput output) {
		output.setMsg(updateTokens(output.getDataSource()));
	}

	public String getHtml() {
		return html;
	}

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.MSG;
	}

	@Override
	public PENodeType getNodeType() {
		return PENodeType.DISPLAYABLE;
	}

	@Override
	public boolean isDataSubmittable() {
		return false;
	}

	@Override
	public boolean isDisplayable() {
		return true;
	}

	@Override
	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		updateTokens(ds);
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		output.setNextNodeId(getNextNodeId());

		PEAuditHelper audit = PEAuditHelper.getAuditHelper(processState, ds);
		audit.logMsgNode(PEAuditConstants.DONE_BY_PE, getNodeId(), html);

		return output;
	}

	private String updateTokens(PEDataSource ds) {
		return ds.replaceTokensInData(html);
	}

	public void setHtml(String html) {
		this.html = html;
	}

	@Override
	public String toString() {
		return "Msg [html=" + html + ", toString()=" + super.toString() + "]";
	}



	@Override
	public boolean canProceedToNextStep(PEDataSource dataSource) {
		return false;
	}

	private String html;
	private static Log _log = LogFactoryUtil.getLog(PEMsg.class);
}