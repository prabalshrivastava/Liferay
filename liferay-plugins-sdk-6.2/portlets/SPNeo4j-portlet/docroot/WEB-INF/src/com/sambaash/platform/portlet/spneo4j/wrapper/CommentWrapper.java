package com.sambaash.platform.portlet.spneo4j.wrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.sambaash.platform.constant.ClassConstant;
import com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper;
import com.sambaash.platform.portlet.spneo4j.util.Util;

public class CommentWrapper {
	private List<CommentWrapper> childCommentWrappers = new ArrayList<CommentWrapper>();
	private Long childCount;
	private String firstName;
	private String lastName;
	private Long portraitId;
	private String screenName;

	private Long assetEntryId;
	private Long commentId;
	private String content;
	private String parentContent;
	private Date createDate;
	private Long parentId;
	private Long userId;
	private Long commentClassId;

	public CommentWrapper(AssetEntityGraphWrapper comment) {
		assetEntryId = comment.getReferenceId();
		commentId = comment.getClassPK();
		content = comment.getContent();
		parentContent = StringUtils.isEmpty(comment.getReferenceTitle()) ? content : comment.getReferenceTitle();
		createDate = comment.getCreateDate();
		parentId = comment.getParentId();
		userId = comment.getUserId();		
		commentClassId = ClassConstant.classNameId(comment.getClassName());
	}
	
	public CommentWrapper(MBMessage comment) {
		assetEntryId = comment.getClassPK();
		commentId = comment.getMessageId();
		content = comment.getBody();
		String body = HtmlUtil.stripHtml(comment.getBody());
		String subject = HtmlUtil.stripHtml(comment.getSubject());
		parentContent = StringUtils.isNotBlank(body) && !body.equals(subject)
				? String.format("%s [ %s ]", subject, body)
				: StringUtils.isNotBlank(subject) ? subject
				: body; 
		createDate = comment.getCreateDate();
		parentId = comment.getParentMessageId();
		userId = comment.getUserId();
	}
	
	public Long getAssetEntryId() {
		return assetEntryId;
	}

	public List<CommentWrapper> getChildCommentWrappers() {
		return childCommentWrappers;
	}

	public Long getChildCount() {
		return childCount;
	}

	public Long getCommentId() {
		return commentId;
	}

	public String getContent() {
		return content;
	}

	public String getParentContent() {
		return parentContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getDisplayDate() {
		return Util.getTimeDifferent(getCreateDate(), new Date());
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Long getParentId() {
		return parentId;
	}

	public Long getPortraitId() {
		return portraitId;
	}

	public String getScreenName() {
		return screenName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setChildCommentWrappers(List<CommentWrapper> childCommentWrappers) {
		this.childCommentWrappers = childCommentWrappers;
	}

	public void setChildCount(Long childCount) {
		this.childCount = childCount;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPortraitId(Long portraitId) {
		this.portraitId = portraitId;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	public Long getCommentClassId() {
		return commentClassId;
	}
}