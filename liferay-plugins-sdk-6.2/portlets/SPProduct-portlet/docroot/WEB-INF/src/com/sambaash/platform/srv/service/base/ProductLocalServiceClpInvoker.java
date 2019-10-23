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

package com.sambaash.platform.srv.service.base;

import com.sambaash.platform.srv.service.ProductLocalServiceUtil;

import java.util.Arrays;

/**
 * @author gauravvijayvergia
 * @generated
 */
public class ProductLocalServiceClpInvoker {
	public ProductLocalServiceClpInvoker() {
		_methodName0 = "addProduct";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.model.Product"
			};

		_methodName1 = "createProduct";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteProduct";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteProduct";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.model.Product"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchProduct";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getProduct";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getProducts";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getProductsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateProduct";

		_methodParameterTypes15 = new String[] {
				"com.sambaash.platform.srv.model.Product"
			};

		_methodName172 = "getBeanIdentifier";

		_methodParameterTypes172 = new String[] {  };

		_methodName173 = "setBeanIdentifier";

		_methodParameterTypes173 = new String[] { "java.lang.String" };

		_methodName178 = "clearCache";

		_methodParameterTypes178 = new String[] {  };

		_methodName179 = "create";

		_methodParameterTypes179 = new String[] {  };

		_methodName180 = "getPEEntityList";

		_methodParameterTypes180 = new String[] {
				"java.lang.Integer", "java.lang.Integer"
			};

		_methodName181 = "getPEEntity";

		_methodParameterTypes181 = new String[] { "java.lang.Long" };

		_methodName182 = "getEntity";

		_methodParameterTypes182 = new String[] {
				"com.sambaash.platform.srv.model.Product"
			};

		_methodName183 = "customProductName";

		_methodParameterTypes183 = new String[] {
				"com.sambaash.platform.srv.model.Product"
			};

		_methodName184 = "getPEEntityFields";

		_methodParameterTypes184 = new String[] {  };

		_methodName185 = "getPEEntityFieldValue";

		_methodParameterTypes185 = new String[] {
				"java.lang.Long", "java.lang.String"
			};

		_methodName186 = "findByProductNameCountryId";

		_methodParameterTypes186 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName187 = "findByGroupIdAndCourseId";

		_methodParameterTypes187 = new String[] { "long", "long" };

		_methodName188 = "isQualificationTypeProduct";

		_methodParameterTypes188 = new String[] {
				"com.sambaash.platform.srv.model.Product"
			};

		_methodName189 = "isQualificationTypeCourse";

		_methodParameterTypes189 = new String[] {
				"com.sambaash.platform.srv.model.Course"
			};

		_methodName190 = "findByStatus";

		_methodParameterTypes190 = new String[] { "int", "int", "int" };

		_methodName191 = "getActiveProducts";

		_methodParameterTypes191 = new String[] {  };

		_methodName192 = "getPEEntityList";

		_methodParameterTypes192 = new String[] { "java.util.List" };

		_methodName193 = "getSpecializationCatgIds";

		_methodParameterTypes193 = new String[] {
				"com.sambaash.platform.srv.model.Product"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ProductLocalServiceUtil.addProduct((com.sambaash.platform.srv.model.Product)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ProductLocalServiceUtil.createProduct(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ProductLocalServiceUtil.deleteProduct(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ProductLocalServiceUtil.deleteProduct((com.sambaash.platform.srv.model.Product)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ProductLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ProductLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ProductLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ProductLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ProductLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ProductLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ProductLocalServiceUtil.fetchProduct(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ProductLocalServiceUtil.getProduct(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ProductLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ProductLocalServiceUtil.getProducts(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ProductLocalServiceUtil.getProductsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ProductLocalServiceUtil.updateProduct((com.sambaash.platform.srv.model.Product)arguments[0]);
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return ProductLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			ProductLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			ProductLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return ProductLocalServiceUtil.create();
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return ProductLocalServiceUtil.getPEEntityList((java.lang.Integer)arguments[0],
				(java.lang.Integer)arguments[1]);
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return ProductLocalServiceUtil.getPEEntity((java.lang.Long)arguments[0]);
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return ProductLocalServiceUtil.getEntity((com.sambaash.platform.srv.model.Product)arguments[0]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return ProductLocalServiceUtil.customProductName((com.sambaash.platform.srv.model.Product)arguments[0]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return ProductLocalServiceUtil.getPEEntityFields();
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return ProductLocalServiceUtil.getPEEntityFieldValue((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return ProductLocalServiceUtil.findByProductNameCountryId((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return ProductLocalServiceUtil.findByGroupIdAndCourseId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return ProductLocalServiceUtil.isQualificationTypeProduct((com.sambaash.platform.srv.model.Product)arguments[0]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return ProductLocalServiceUtil.isQualificationTypeCourse((com.sambaash.platform.srv.model.Course)arguments[0]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return ProductLocalServiceUtil.findByStatus(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return ProductLocalServiceUtil.getActiveProducts();
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return ProductLocalServiceUtil.getPEEntityList((java.util.List<java.lang.Long>)arguments[0]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return ProductLocalServiceUtil.getSpecializationCatgIds((com.sambaash.platform.srv.model.Product)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName172;
	private String[] _methodParameterTypes172;
	private String _methodName173;
	private String[] _methodParameterTypes173;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
	private String _methodName182;
	private String[] _methodParameterTypes182;
	private String _methodName183;
	private String[] _methodParameterTypes183;
	private String _methodName184;
	private String[] _methodParameterTypes184;
	private String _methodName185;
	private String[] _methodParameterTypes185;
	private String _methodName186;
	private String[] _methodParameterTypes186;
	private String _methodName187;
	private String[] _methodParameterTypes187;
	private String _methodName188;
	private String[] _methodParameterTypes188;
	private String _methodName189;
	private String[] _methodParameterTypes189;
	private String _methodName190;
	private String[] _methodParameterTypes190;
	private String _methodName191;
	private String[] _methodParameterTypes191;
	private String _methodName192;
	private String[] _methodParameterTypes192;
	private String _methodName193;
	private String[] _methodParameterTypes193;
}