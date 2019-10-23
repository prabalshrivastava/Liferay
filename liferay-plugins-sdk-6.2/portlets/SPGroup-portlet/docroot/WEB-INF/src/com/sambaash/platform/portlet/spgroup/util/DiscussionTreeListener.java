package com.sambaash.platform.portlet.spgroup.util;

import com.liferay.portlet.messageboards.model.MBMessage;

public interface DiscussionTreeListener {
	void onDiscussionContentTraversed(MBMessage message, int level);

//	void onDiscussionTraversed(MBMessage discussion, int level);

	void onMissingDiscussion(long discussionId, int level);
}
