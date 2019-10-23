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

package com.sambaash.platform.srv.processbuilder.service.base;

import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;

import java.util.Arrays;

/**
 * @author nareshchebolu
 * @generated
 */
public class FormBuilderLocalServiceClpInvoker {
	public FormBuilderLocalServiceClpInvoker() {
		_methodName62 = "getBeanIdentifier";

		_methodParameterTypes62 = new String[] {  };

		_methodName63 = "setBeanIdentifier";

		_methodParameterTypes63 = new String[] { "java.lang.String" };

		_methodName67 = "getUrlTemplateFormSchema";

		_methodParameterTypes67 = new String[] {  };

		_methodName68 = "getUrlTemplateFormSchemas";

		_methodParameterTypes68 = new String[] {  };

		_methodName69 = "getUrlTemplateFormsList";

		_methodParameterTypes69 = new String[] {  };

		_methodName70 = "getUrlTemplateFormStorageList";

		_methodParameterTypes70 = new String[] {  };

		_methodName71 = "getUrlTemplateLoadFormWithStorageId";

		_methodParameterTypes71 = new String[] {  };

		_methodName72 = "getUrlTemplateLoadFormWithOutStorageId";

		_methodParameterTypes72 = new String[] {  };

		_methodName73 = "getUrlTemplateAttachmentSInfo";

		_methodParameterTypes73 = new String[] {  };

		_methodName74 = "getUrlFormLoad";

		_methodParameterTypes74 = new String[] { "long", "long", "long", "long" };

		_methodName75 = "getUrlFormSchema";

		_methodParameterTypes75 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName76 = "getUrlFormSchemas";

		_methodParameterTypes76 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String"
			};

		_methodName77 = "getUrlFormsList";

		_methodParameterTypes77 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String"
			};

		_methodName78 = "getUrlFormStorageList";

		_methodParameterTypes78 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName79 = "getUrlLoadFormWithStorageId";

		_methodParameterTypes79 = new String[] {
				"long", "long", "long", "boolean", "java.util.Map"
			};

		_methodName80 = "getUrlLoadFormWithOutStorageId";

		_methodParameterTypes80 = new String[] { "long", "java.util.Map" };

		_methodName81 = "getUrlLockForm";

		_methodParameterTypes81 = new String[] {  };

		_methodName82 = "getUrlAddFormData";

		_methodParameterTypes82 = new String[] {  };

		_methodName83 = "getUrlAddFormDataMultipart";

		_methodParameterTypes83 = new String[] {  };

		_methodName84 = "getUrlAddFormDataMultipartBulkUpload";

		_methodParameterTypes84 = new String[] {  };

		_methodName85 = "getUrlAttachmentPrefix";

		_methodParameterTypes85 = new String[] {  };

		_methodName86 = "getUrlAttachmentSInfo";

		_methodParameterTypes86 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName87 = "constructAttachmentUrl";

		_methodParameterTypes87 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName88 = "getAttachmentSInfo";

		_methodParameterTypes88 = new String[] { "long", "long" };

		_methodName89 = "submitFormData";

		_methodParameterTypes89 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName90 = "submitFormData";

		_methodParameterTypes90 = new String[] {
				"long", "java.lang.Boolean", "long"
			};

		_methodName91 = "submitFormDataMultipart";

		_methodParameterTypes91 = new String[] {
				"long", "java.lang.String", "long", "java.util.Map"
			};

		_methodName92 = "submitFormDataMultipartMultipleFiles";

		_methodParameterTypes92 = new String[] {
				"long", "java.lang.String", "long", "java.util.Map"
			};

		_methodName93 = "submitFormDataMultipartBulkRegistration";

		_methodParameterTypes93 = new String[] {
				"long", "long", "long", "long", "java.io.File"
			};

		_methodName94 = "getFormSchema";

		_methodParameterTypes94 = new String[] { "long", "long" };

		_methodName95 = "getFormSchemas";

		_methodParameterTypes95 = new String[] { "long", "java.lang.String" };

		_methodName96 = "getFormStorages";

		_methodParameterTypes96 = new String[] { "java.lang.String" };

		_methodName97 = "getFormsList";

		_methodParameterTypes97 = new String[] { "long" };

		_methodName98 = "getFormsListV2";

		_methodParameterTypes98 = new String[] {  };

		_methodName99 = "getV2FormsArrayData";

		_methodParameterTypes99 = new String[] {
				"java.lang.String", "java.util.Map"
			};

		_methodName100 = "getV2FormsData";

		_methodParameterTypes100 = new String[] {
				"java.lang.String", "java.util.Map"
			};

		_methodName103 = "createFormCopy";

		_methodParameterTypes103 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			FormBuilderLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlTemplateFormSchema();
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlTemplateFormSchemas();
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlTemplateFormsList();
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlTemplateFormStorageList();
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlTemplateLoadFormWithStorageId();
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlTemplateLoadFormWithOutStorageId();
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlTemplateAttachmentSInfo();
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlFormLoad(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlFormSchema((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlFormSchemas((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlFormsList((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlFormStorageList((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlLoadFormWithStorageId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Boolean)arguments[3]).booleanValue(),
				(java.util.Map<java.lang.String, java.lang.String>)arguments[4]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlLoadFormWithOutStorageId(((Long)arguments[0]).longValue(),
				(java.util.Map<java.lang.String, java.lang.String>)arguments[1]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlLockForm();
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlAddFormData();
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlAddFormDataMultipart();
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlAddFormDataMultipartBulkUpload();
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlAttachmentPrefix();
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getUrlAttachmentSInfo((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return FormBuilderLocalServiceUtil.constructAttachmentUrl((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getAttachmentSInfo(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return FormBuilderLocalServiceUtil.submitFormData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return FormBuilderLocalServiceUtil.submitFormData(((Long)arguments[0]).longValue(),
				(java.lang.Boolean)arguments[1],
				((Long)arguments[2]).longValue());
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return FormBuilderLocalServiceUtil.submitFormDataMultipart(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.Map<java.lang.String, java.io.File>)arguments[3]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return FormBuilderLocalServiceUtil.submitFormDataMultipartMultipleFiles(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.Map<java.lang.String, java.util.List<java.io.File>>)arguments[3]);
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return FormBuilderLocalServiceUtil.submitFormDataMultipartBulkRegistration(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(), (java.io.File)arguments[4]);
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getFormSchema(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getFormSchemas(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getFormStorages((java.lang.String)arguments[0]);
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getFormsList(((Long)arguments[0]).longValue());
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getFormsListV2();
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getV2FormsArrayData((java.lang.String)arguments[0],
				(java.util.Map<java.lang.String, java.lang.String>)arguments[1]);
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return FormBuilderLocalServiceUtil.getV2FormsData((java.lang.String)arguments[0],
				(java.util.Map<java.lang.String, java.lang.String>)arguments[1]);
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			return FormBuilderLocalServiceUtil.createFormCopy((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName93;
	private String[] _methodParameterTypes93;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName103;
	private String[] _methodParameterTypes103;
}