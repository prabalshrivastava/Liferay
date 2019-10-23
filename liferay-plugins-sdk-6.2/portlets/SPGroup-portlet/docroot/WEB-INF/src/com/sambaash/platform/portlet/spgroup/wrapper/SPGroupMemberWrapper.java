package com.sambaash.platform.portlet.spgroup.wrapper;

import com.sambaash.platform.portlet.spgroup.util.Util;

public class SPGroupMemberWrapper {

	public String getPic() {
		if (pic==null) {
			pic = Util.getUserPortraitUrl(portraitId);
		}
		return pic;
	}

	public long getPortraitId() {
		return portraitId;
	}

	public int getRole() {
		return role;
	}

	public String getScreenName() {
		return screenName;
	}

	public long getSpGroupId() {
		return spGroupId;
	}

	public long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setPortraitId(long portraitId) {
		this.portraitId = portraitId;
		pic = null;
		getPic();
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public void setSpGroupId(long spGroupId) {
		this.spGroupId = spGroupId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private long portraitId;
	private int role;
	private String screenName;
	private long spGroupId;
	private long userId;
	private String userName;
	private String pic;
}