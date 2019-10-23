/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.contactus.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.contactus.model.SPContactUs;
import com.sambaash.platform.srv.contactus.service.base.SPContactUsLocalServiceBaseImpl;

/**
 * The implementation of the s p contact us local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.SPContactUsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.SPContactUsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.SPContactUsLocalServiceUtil
 */
public class SPContactUsLocalServiceImpl extends SPContactUsLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.SPContactUsLocalServiceUtil} to access the s p contact us local service.
     */
    
    public void create(String name, String emailAddress, String category,
            String comment, String countryName, long contactNumber,
            String lastName, String company, String jobTitle,
            String companyUrl, long noofemployee, String rate,
            String typeofenquiry, String emLocationOffice)
            throws SystemException {

        // create a primary key
        long contactusId = CounterLocalServiceUtil.increment(SPContactUs.class
                .getName());
        SPContactUs contactUs = spContactUsPersistence.create(contactusId);
        contactUs.setSpContactUsId(contactusId);
        contactUs.setName(name);
        contactUs.setEmailAddress(emailAddress);
        contactUs.setCategory(category);
        contactUs.setComment(comment);
        contactUs.setContactNumber(contactNumber);
        contactUs.setLastName(lastName);
        contactUs.setCompany(company);
        contactUs.setJobTitle(jobTitle);
        contactUs.setCompanyUrl(companyUrl);
        contactUs.setNoOfEmployee(noofemployee);
        contactUs.setRate(rate);
        contactUs.setTypeOfEnquiry(typeofenquiry);
        contactUs.setCountryName(countryName);
        contactUs.setLocation(emLocationOffice);

        // persist the contactUs object
        contactUs = spContactUsPersistence.update(contactUs);

    }
    
}