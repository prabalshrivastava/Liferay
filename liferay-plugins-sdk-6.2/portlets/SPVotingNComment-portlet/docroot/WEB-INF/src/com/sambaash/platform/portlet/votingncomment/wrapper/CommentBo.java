package com.sambaash.platform.portlet.votingncomment.wrapper;

import com.liferay.portlet.messageboards.model.MBMessage;

import com.sambaash.platform.portlet.votingncomment.util.Tool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class CommentBo {

	private MBMessage _comment;

	private Long portraitId;
	private String screenName;

	private List<CommentBo> childCommentBos = new ArrayList<CommentBo>();
	private Long childCount;

	public CommentBo(MBMessage comment) {
		_comment = comment;
	}

	public Long getCommentId() {
		return _comment.getMessageId();
	}
	public Long getAssetEntryId() {
		return _comment.getClassPK();
	}
	public Long getUserId() {
		return _comment.getUserId();
	}
	public String getContent() {
		return _comment.getBody();
	}
	public Long getParentId() {
		return _comment.getParentMessageId();
	}
	public Date getCreateDate() {
		return _comment.getCreateDate();
	}
	public List<CommentBo> getChildCommentBos() {
		return childCommentBos;
	}
	public void setChildCommentBos(List<CommentBo> childCommentBos) {
		this.childCommentBos = childCommentBos;
	}
	public Long getChildCount() {
		return childCount;
	}
	public void setChildCount(Long childCount) {
		this.childCount = childCount;
	}

	public String getDisplayDate() {
		return Tool.getTimeDifferent(getCreateDate(), new Date());
	}

	public Long getPortraitId() {
		return portraitId;
	}

	public void setPortraitId(Long portraitId) {
		this.portraitId = portraitId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

}
