package com.sambaash.platform.portlet.spms.util;

/**
**/
public class UIHelper {
/**
	public static void copyBean(Object paramObject1, Object paramObject2,
			PortletRequest paramPortletRequest) throws Exception {
		copyBean(paramObject1, paramObject2, paramPortletRequest, null);
	}

	public static void copyBean(Object paramObject1, Object paramObject2,
			PortletRequest paramPortletRequest, String paramString) {
		HttpServletRequest localHttpServletRequest = PortalUtil
				.getHttpServletRequest(paramPortletRequest);
		ArrayList localArrayList = new ArrayList();
		paramString = (paramString == null) ? "" : paramString;
		Method[] arrayOfMethod = paramObject2.getClass().getMethods();

		for (int i = 0; i < arrayOfMethod.length; ++i) {
			String str1 = arrayOfMethod[i].getName();

			if (!(str1.startsWith("set")))
				continue;
			String str2 = String.valueOf(str1.charAt(3)).toLowerCase() +
					str1.substring(4);
			Class localClass = null;
			try {
				localClass = PropertyUtils.getPropertyType(paramObject2, str2);
			} catch (Exception localException) {
			}

			if (localClass == null)
				continue;
			Object localObject;

			if (localClass.getName().endsWith("Date")) {
				localObject = ParamUtil.getDate(localHttpServletRequest, str2,
						new SimpleDateFormat("yyyy-MM-dd"), null);

				if (localObject == null) {
					int j = ParamUtil.getInteger(localHttpServletRequest, str2 +
							"_day", -1);
					int k = ParamUtil.getInteger(localHttpServletRequest, str2 +
							"_month", -1);
					int l = ParamUtil.getInteger(localHttpServletRequest, str2 +
							"_year", -1);

					if ((j > 0) && (k >= 0) && (l > 0))
						localArrayList.add(str2);
				} else {
					localArrayList.add(str2);
				}
			} else {
				localObject = localHttpServletRequest
						.getParameterValues(paramString + str2);

				if ((localObject == null))
					continue;
				localArrayList.add(str2);
			}
		}

		String[] arrayOfString = new String[localArrayList.size()];
		localArrayList.toArray(arrayOfString);
		copyBean(paramObject1, paramObject2, arrayOfString);
	}

	public static void copyBean(Object paramObject1, Object paramObject2,
			String[] paramArrayOfString) {
		for (int i = 0; i < paramArrayOfString.length; ++i) {
			String str = paramArrayOfString[i];
			try {
				Class localClass = PropertyUtils.getPropertyType(paramObject2,
						str);
				Object localObject;

				if (localClass.getName().endsWith("Date")) {
					localObject = (Date)getValue(paramObject2, str);
					BeanUtils.setProperty(paramObject1, str, localObject);
				} else {
					localObject = BeanUtils.getProperty(paramObject2, str);
					BeanUtils.setProperty(paramObject1, str, localObject);
				}
			} catch (Exception localException) {
				_log.error("problem setting the property " + str + " " +
						localException.getMessage());
			}
		}
	}

	public static String firstCharectorToUpper(String paramString) {
		if ((paramString == null) || (paramString.equals("")))
			return paramString;
		return paramString.substring(0, 1).toUpperCase() +
				paramString.substring(1);
	}

	private static void setObject(String paramString, Method paramMethod,
			Object paramObject, String[] paramArrayOfString) {
		if (paramArrayOfString == null)
			return;
		String str1 = paramArrayOfString[0];
		try {
			if (paramString.equals("int")) {
				if (paramArrayOfString.length >= 2)
					paramMethod
							.invoke(paramObject, new Object[] { Integer
									.valueOf(Integer
											.parseInt(paramArrayOfString[1])) });
				else
					paramMethod.invoke(paramObject, new Object[] { Integer
							.valueOf(Integer.parseInt(str1)) });
			} else if (paramString.equals("long")) {
				paramMethod.invoke(paramObject, new Object[] { Long
						.valueOf(Long.parseLong(str1)) });
			} else if (paramString.equals("boolean")) {
				paramMethod.invoke(paramObject, new Object[] { Boolean
						.valueOf(Boolean.parseBoolean(str1)) });
			} else if (paramString.equals("float")) {
				paramMethod.invoke(paramObject, new Object[] { Float
						.valueOf(Float.parseFloat(str1)) });
			} else {
				String str2 = "";

				for (int i = 0; i < paramArrayOfString.length; ++i) {
					if (paramArrayOfString[i] == "")
						continue;
					str2 = str2 +
							((str2.equals("")) ? paramArrayOfString[i]
									: new StringBuilder().append(",").append(
											paramArrayOfString[i]).toString());
				}

				paramMethod.invoke(paramObject, new Object[] { str2 });
			}
		} catch (Exception localException) {
		}
	}

	public static Object getObject(PortletRequest paramPortletRequest,
			Class paramClass) {
		Object localObject = null;
		HttpServletRequest localHttpServletRequest = PortalUtil
				.getHttpServletRequest(paramPortletRequest);
		try {
			localObject = paramClass.newInstance();
		} catch (Exception localException1) {
			_log.error(localException1.getMessage());
			return localObject;
		}

		Method[] arrayOfMethod = paramClass.getMethods();

		for (int i = 0; i < arrayOfMethod.length; ++i) {
			String str1 = arrayOfMethod[i].getName();

			if (!(str1.startsWith("set")))
				continue;
			Class[] arrayOfClass = arrayOfMethod[i].getParameterTypes();

			if (arrayOfClass.length > 1)
				continue;
			String str2 = String.valueOf(str1.charAt(3)).toLowerCase() +
					str1.substring(4);
			String str3 = arrayOfClass[0].getName();

			if (str3.endsWith("Date")) {
				int j = ParamUtil.getInteger(localHttpServletRequest, str2 +
						"_day");
				int k = ParamUtil.getInteger(localHttpServletRequest, str2 +
						"_month");
				int l = ParamUtil.getInteger(localHttpServletRequest, str2 +
						"_year");
				Calendar localCalendar = Calendar.getInstance();
				localCalendar.set(l, k, j, 0, 0, 0);
				try {
					if (localCalendar != null)
						arrayOfMethod[i].invoke(localObject,
								new Object[] { localCalendar.getTime() });
					else
						setDateField(localHttpServletRequest, localObject,
								arrayOfMethod[i], str2);
				} catch (Exception localException2) {
					_log.error(localException2.getMessage());
				}
			} else {
				String[] arrayOfString = localHttpServletRequest
						.getParameterValues(str2);
				setObject(str3, arrayOfMethod[i], localObject, arrayOfString);
			}
		}

		return localObject;
	}

	public static Object getValue(Object paramObject, String paramString) {
		Object localObject = null;
		try {
			if (paramObject != null) {
				Method localMethod = paramObject.getClass().getMethod(
						"get" + firstCharectorToUpper(paramString),
						(Class[])null);
				localObject = localMethod.invoke(paramObject, (Object[])null);
			}
		} catch (Exception localException) {
		}

		return localObject;
	}

	public static boolean isInList(String paramString,
			String[] paramArrayOfString) {
		boolean isInList = false;
		int i = 0;

		for (int j = 0; j < paramArrayOfString.length; ++j) {
			if (!(paramString.equals(paramArrayOfString[j])))
				continue;
			i = 1;
			isInList = true;
			break;
		}

		return isInList;
	}

	public static String lf2br(String paramString) {
		return paramString.replace("\n", "<br>");
	}

	private static void setDateField(
			HttpServletRequest paramHttpServletRequest, Object paramObject,
			Method paramMethod, String paramString)
			throws IllegalAccessException, InvocationTargetException {
		int i = ParamUtil.getInteger(paramHttpServletRequest, paramString +
				"_day", -1);
		int j = ParamUtil.getInteger(paramHttpServletRequest, paramString +
				"_month", -1);
		int k = ParamUtil.getInteger(paramHttpServletRequest, paramString +
				"_year", -1);

		if ((i < 0) || (j < 0) || (k < 0))
			return;
		GregorianCalendar localGregorianCalendar = new GregorianCalendar(k, j,
				i);
		int l = ParamUtil.getInteger(paramHttpServletRequest, paramString +
				"_hour");
		int i1 = ParamUtil.getInteger(paramHttpServletRequest, paramString +
				"_minute");
		int i2 = ParamUtil.getInteger(paramHttpServletRequest, paramString +
				"_amPm");

		if (i2 == 1)
			l += 12;

		if ((l > 0) && (i1 > 0) && (i2 >= 0)) {
			localGregorianCalendar.set(10, l);
			localGregorianCalendar.set(12, i1);
		}

		paramMethod.invoke(paramObject, new Object[] { localGregorianCalendar
				.getTime() });
	}

	private static Log _log = LogFactory.getLog(UIHelper.class);**/

}