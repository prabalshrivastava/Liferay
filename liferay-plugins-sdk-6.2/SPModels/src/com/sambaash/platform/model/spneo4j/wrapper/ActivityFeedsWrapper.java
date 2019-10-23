package com.sambaash.platform.model.spneo4j.wrapper;

import java.util.ArrayList;
import java.util.List;

public class ActivityFeedsWrapper {

	List<ActivityFeedGraphWrapper> activityFeedGraphWrappers = new ArrayList<ActivityFeedGraphWrapper>();
	
	int activityFeedsCount;

	public List<ActivityFeedGraphWrapper> getActivityFeedGraphWrappers() {
		return activityFeedGraphWrappers;
	}

	public void setActivityFeedGraphWrappers(
			List<ActivityFeedGraphWrapper> activityFeedGraphWrappers) {
		this.activityFeedGraphWrappers = activityFeedGraphWrappers;
	}

	public int getActivityFeedsCount() {
		return activityFeedsCount;
	}

	public void setActivityFeedsCount(int activityFeedsCount) {
		this.activityFeedsCount = activityFeedsCount;
	}
	
}
