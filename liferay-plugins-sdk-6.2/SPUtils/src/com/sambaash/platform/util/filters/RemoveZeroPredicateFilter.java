package com.sambaash.platform.util.filters;

import com.liferay.portal.kernel.util.PredicateFilter;

public class RemoveZeroPredicateFilter implements PredicateFilter<Long> {

	@Override
	public boolean filter(Long value) {
		boolean filter = false;
		if(value != 0){
			filter = true;
		}
		return filter;
	}

}
