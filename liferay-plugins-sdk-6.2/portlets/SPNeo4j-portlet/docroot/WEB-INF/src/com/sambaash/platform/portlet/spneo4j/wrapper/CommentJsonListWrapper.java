package com.sambaash.platform.portlet.spneo4j.wrapper;

import java.util.List;
public class CommentJsonListWrapper {

	public CommentJsonListWrapper() {
	}

	public CommentJsonListWrapper(List<CommentJsonWrapper> items) {
		this.items = items;
	}

	public List<CommentJsonWrapper> getItems() {
		return items;
	}

	public void setItems(List<CommentJsonWrapper> items) {
		this.items = items;
	}

	private List<CommentJsonWrapper> items;

}