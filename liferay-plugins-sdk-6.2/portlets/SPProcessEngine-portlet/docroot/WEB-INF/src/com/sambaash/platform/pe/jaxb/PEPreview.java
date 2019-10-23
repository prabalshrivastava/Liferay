package com.sambaash.platform.pe.jaxb;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.handlers.PEPreviewHandler;
import com.sambaash.platform.pe.handlers.PENodeHandler;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.xml.bind.annotation.XmlElement;

public class PEPreview extends PEActionNode {

	private static Log _log = LogFactoryUtil.getLog(PEPreview.class);

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.PREVIEW;
	}

	@Override
	public PENodeType getNodeType() {
		return PENodeType.BACKEND_ACTION;
	}

	@Override
	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		PEProcessableNodeOutput output = null;
		try {
			PENodeHandler handler = new PEPreviewHandler(this, ds);
			output = handler.process();
		} catch (Exception ex) {
			_log.error(ex.getMessage());
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

	public String getPreviewId() {
		return previewId;
	}

	@XmlElement(name = "previewId")
	public void setPreviewId(String previewId) {
		this.previewId = previewId;
	}

	public String getCustomId() {
		return customId;
	}

	@XmlElement(name = "customId")
	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getEnablePreview() {
		return enablePreview;
	}

	@XmlElement(name = "enablePreview")
	public void setEnablePreview(String enablePreview) {
		this.enablePreview = enablePreview;
	}

	public String getEnableEsign() {
		return enableEsign;
	}

	@XmlElement(name = "enableEsign")
	public void setEnableEsign(String enableEsign) {
		this.enableEsign = enableEsign;
	}

	public String getEsignApiKey() {
		return esignApiKey;
	}

	@XmlElement(name = "esignApiKey")
	public void setEsignApiKey(String esignApiKey) {
		this.esignApiKey = esignApiKey;
	}

	public String getEsignApiUrl() {
		return esignApiUrl;
	}

	@XmlElement(name = "esignApiUrl")
	public void setEsignApiUrl(String esignApiUrl) {
		this.esignApiUrl = esignApiUrl;
	}

	public String getPreviewJspNode() {
		return previewJspNode;
	}

	@XmlElement(name = "previewJspNode")
	public void setPreviewJspNode(String previewJspNode) {
		this.previewJspNode = previewJspNode;
	}

	private String previewId;
	private String customId;
	private String enablePreview;
	private String enableEsign;
	private String esignApiKey;
	private String esignApiUrl;
	private String previewJspNode;

}