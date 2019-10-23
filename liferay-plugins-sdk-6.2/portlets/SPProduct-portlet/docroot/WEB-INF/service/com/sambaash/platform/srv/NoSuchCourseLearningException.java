/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.sambaash.platform.srv;

import com.liferay.portal.NoSuchModelException;

/**
 * @author gauravvijayvergia
 */
public class NoSuchCourseLearningException extends NoSuchModelException {

	public NoSuchCourseLearningException() {
		super();
	}

	public NoSuchCourseLearningException(String msg) {
		super(msg);
	}

	public NoSuchCourseLearningException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCourseLearningException(Throwable cause) {
		super(cause);
	}

}