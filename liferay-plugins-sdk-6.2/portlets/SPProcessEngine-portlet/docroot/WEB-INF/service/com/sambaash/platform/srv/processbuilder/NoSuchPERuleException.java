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

package com.sambaash.platform.srv.processbuilder;

import com.liferay.portal.NoSuchModelException;

/**
 * @author nareshchebolu
 */
public class NoSuchPERuleException extends NoSuchModelException {

	public NoSuchPERuleException() {
		super();
	}

	public NoSuchPERuleException(String msg) {
		super(msg);
	}

	public NoSuchPERuleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPERuleException(Throwable cause) {
		super(cause);
	}

}