/**
 * 
 */
package com.liferay.saml.credential;

import com.liferay.portal.model.Group;

import org.opensaml.xml.security.Criteria;

/**
 * @author W. Berks
 *
 */
public final class GroupCriteria implements Criteria {
	
	public GroupCriteria(Group group) {
		this.group = group;
	}

	public long getCompanyId() {
		return this.group.getCompanyId();
	}
	
	public Group getGroup() {
		return this.group;
	}

	public long getGroupId() {
		return this.group.getGroupId();
	}

	private Group group;
}
