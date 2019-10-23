package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.handlers.PEApiHandler;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

public class PEApiNode extends SingleOutputNodeImpl {
	
	private String url;
	private PEHeader header;
	private String method = "GET";  // default to get
	private boolean asynchronous;
	private String responseMapping;
	private boolean encode = true;  // encode url by default
	
	@XmlElement(name ="responseMapping")
	public String getResponseMapping() {
		return responseMapping;
	}

	public void setResponseMapping(String responseMapping) {
		this.responseMapping = responseMapping;
	}

	public String getUrl() {
		return url;
	}

	@XmlElement(name ="url")
	public void setUrl(String url) {
		this.url = url;
	}

	public PEHeader getHeader() {
		return header;
	}

	@XmlElement(name ="header")
	public void setHeader(PEHeader header) {
		this.header = header;
	}

	public String getMethod() {
		return method;
	}

	@XmlElement(name ="method")
	public void setMethod(String method) {
		this.method = method;
	}

	public boolean isAsynchronous() {
		return asynchronous;
	}

	@XmlElement(name ="asynchronous")
	public void setAsynchronous(boolean asynchronous) {
		this.asynchronous = asynchronous;
	}

	public boolean isEncode() {
		return encode;
	}

	@XmlElement(name ="encode")
	public void setEncode(boolean encode) {
		this.encode = encode;
	}

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.API;
	}

	@Override
	public PENodeType getNodeType() {
		return PENodeType.BACKEND_ACTION;
	}

	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		PEProcessableNodeOutput output = null;
		try {
			PEApiHandler handler = new PEApiHandler(this, ds);
			output = handler.process();
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

}