package com.sambaash.platform.portlet.spgroup.wrapper;

import java.util.List;
public class CommentJsonListBo {

	public CommentJsonListBo() {
	}

	public CommentJsonListBo(List<CommentJsonBo> items) {
		this.items = items;
	}

	public List<CommentJsonBo> getItems() {
		return items;
	}

	public void setItems(List<CommentJsonBo> items) {
		this.items = items;
	}

	private List<CommentJsonBo> items;

}