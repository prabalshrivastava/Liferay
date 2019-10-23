package com.sambaash.platform.taglib.ui;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.taglib.util.IncludeTag;


public class SPSocialShareTag extends IncludeTag {

	 private String cssClass  = StringPool.BLANK;
	 private String title  = StringPool.BLANK;
	 private String description  = StringPool.BLANK;
	 private String type  = StringPool.BLANK;
	 private String url  = StringPool.BLANK;
	 private String metadata  = StringPool.BLANK;
	 private String prefix  = StringPool.BLANK;
	 private String fileEntryId  ;
	 

	@Override
	protected void cleanUp() {
		  cssClass  = StringPool.BLANK;
		  title  = StringPool.BLANK;
		  description  = StringPool.BLANK;
		  type  = StringPool.BLANK;
		  url  = StringPool.BLANK;
		  fileEntryId  = "0";
		  prefix  = StringPool.BLANK;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("sp-ui:socialshare:cssClass", cssClass);
		request.setAttribute("sp-ui:socialshare:title", title);
		request.setAttribute("sp-ui:socialshare:description", description);
		request.setAttribute("sp-ui:socialshare:type", type);
		request.setAttribute("sp-ui:socialshare:fileEntryId", fileEntryId);
		request.setAttribute("sp-ui:socialshare:url", url);
		request.setAttribute("sp-ui:socialshare:metadata", metadata);
		request.setAttribute("sp-ui:socialshare:prefix", prefix);
	}

	private static final String _PAGE =
		"/html/sambaash/platform/taglib/sp-ui/socialshare/socialshare.jsp";


	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(String fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}