package com.sambaash.platform.portlet.votingncomment.wrapper;

import java.util.List;
public class CommentJsonListBo {

	private List<CommentJsonBo> items;

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

}
