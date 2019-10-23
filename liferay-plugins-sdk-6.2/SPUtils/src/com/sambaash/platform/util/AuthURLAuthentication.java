/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sambaash.platform.util;

import javax.portlet.PortletException;

/**
 *
 * @author sambaash
 */
public class AuthURLAuthentication extends PortletException {

	private static final long serialVersionUID = 1L;

	public AuthURLAuthentication(Throwable cause) {
        super(cause);
    }

    public AuthURLAuthentication(String text, Throwable cause) {
        super(text, cause);
    }

    public AuthURLAuthentication(String text) {
        super(text);
    }

    public AuthURLAuthentication() {
    }

}