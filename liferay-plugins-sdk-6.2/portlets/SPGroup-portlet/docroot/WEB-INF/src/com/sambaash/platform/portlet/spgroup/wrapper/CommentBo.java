package com.sambaash.platform.portlet.spgroup.wrapper;

import com.liferay.portlet.messageboards.model.MBMessage;

import com.sambaash.platform.portlet.spgroup.util.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class CommentBo {

	public CommentBo(MBMessage comment) {
		_comment = comment;
	}

	public long getAssetEntryId() {
		return _comment.getClassPK();
	}

	public List<CommentBo> getChildCommentBos() {
		return childCommentBos;
	}

	public long getChildCount() {
		return childCount;
	}

	public long getCommentId() {
		return _comment.getMessageId();
	}

	public String getContent() {
		return _comment.getBody();
	}

	public Date getCreateDate() {
		return _comment.getCreateDate();
	}

	public String getDisplayDate() {
		return Util.getTimeDifferent(getCreateDate(), new Date());
	}

	public String getFullName() {
		return fullName;
	}

	public long getParentId() {
		return _comment.getParentMessageId();
	}

	public long getPortraitId() {
		return portraitId;
	}

	public String getScreenName() {
		return screenName;
	}

	public String getTitle() {
		return _comment.getSubject();
	}

	public long getUserId() {
		return _comment.getUserId();
	}

	public String getViewDiscussionURL() {
		return viewDiscussionURL;
	}

	public void setChildCommentBos(List<CommentBo> childCommentBos) {
		this.childCommentBos = childCommentBos;
	}

	public void setChildCount(long childCount) {
		this.childCount = childCount;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPortraitId(long portraitId) {
		this.portraitId = portraitId;
		portraitUrl = null;
		getPortraitUrl();
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public void setViewDiscussionURL(String viewDiscussionURL) {
		this.viewDiscussionURL = viewDiscussionURL;
	}

	public String getPortraitUrl() {
		if (portraitUrl==null) {
			portraitUrl = Util.getUserPortraitUrl(portraitId);
		}
		return portraitUrl;
	}
	
	private MBMessage _comment;
	private List<CommentBo> childCommentBos = new ArrayList<CommentBo>();
	private long childCount;
	private String fullName;
	private long portraitId;
	private String portraitUrl;
	private String screenName;
	private String viewDiscussionURL;

}