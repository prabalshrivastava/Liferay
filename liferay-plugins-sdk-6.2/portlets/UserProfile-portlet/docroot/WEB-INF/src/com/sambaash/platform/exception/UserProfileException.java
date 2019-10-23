package com.sambaash.platform.exception;

/**
 * @XMLException
 **/

@SuppressWarnings("serial")
public class UserProfileException extends Exception
{

	public UserProfileException()
	{
		super();
	}

	public UserProfileException(String message)
	{
		super(message);
	}

	public UserProfileException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public UserProfileException(Throwable cause)
	{
		super(cause);
	}

}