package com.sambaash.platform.pe.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEEntity;
import com.sambaash.platform.pe.PEEntityClassRegister;
import com.sambaash.platform.pe.PEEntityField;
import com.sambaash.platform.pe.constants.PEConstants;

public class PEEntityHelper {

	public static List<PEEntity> getEntities(long classNameId) {
		return getEntities(classNameId, -1, -1);
	}

	public static List<PEEntity> getEntities(long classNameId, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		return getEntities(classNameId, -1, -1, resourceRequest, resourceResponse);
	}

	@SuppressWarnings({ "unchecked", "rawtypes", })
	public static PEEntity getEntity(long classNameId, long classPK, PortletRequest request, PortletResponse response) {
		PEEntity peEntity = null;

		// get Server from registry
		String server = PEEntityClassRegister.getServerCall(classNameId);
		if (server.isEmpty() || server == null) {
			// get util class from registry
			Class util = PEEntityClassRegister.getUtilClass(classNameId);
			try {
				// get the entity retrieve method
				Method method = util.getMethod("getPEEntity", Long.class);
				try {
					// invoke the method
					peEntity = (PEEntity) method.invoke(null, classPK);
					peEntity.setClassNameId(classNameId);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					_log.error(e);
				}
			} catch (Exception e) {
				_log.error(e);
			}
		} else {
			// microservice call
			// PortletRequest ggg = new PortletRequest();
			// SystemLocalServiceUtil.fetchRecord(request, response);
		}
		return peEntity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", })
	public static PEEntity getEntity(long classNameId, long classPK) {
		PEEntity peEntity = null;

		// get Server from registry
		String server = PEEntityClassRegister.getServerCall(classNameId);

		if (server.isEmpty() || server == null) {
			// get util class from registry
			Class util = PEEntityClassRegister.getUtilClass(classNameId);
			try {
				// get the entity retrieve method
				Method method = util.getMethod("getPEEntity", Long.class);
				try {
					// invoke the method
					peEntity = (PEEntity) method.invoke(null, classPK);
					peEntity.setClassNameId(classNameId);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					_log.error(e);
				}
			} catch (Exception e) {
				_log.error(e);
			}
		} else {
			// microservice call
			// PortletRequest ggg = new PortletRequest();
			// SystemLocalServiceUtil.fetchRecord(request, response);
		}

		return peEntity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", })
	public static List<PEEntity> getEntities(long classNameId, int start, int end) {
		// get util class from registry
		Class util = PEEntityClassRegister.getUtilClass(classNameId);
		try {
			// get the list method
			Method listMethod = util.getMethod("getPEEntityList", Integer.class, Integer.class);
			try {
				// invoke the list method
				List<PEEntity> list = (List<PEEntity>) listMethod.invoke(null, start, end);
				for (PEEntity peEntity : list) {
					peEntity.setClassNameId(classNameId);
				}
				return list;
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				_log.error(e);
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return new ArrayList<PEEntity>();
	}

	@SuppressWarnings({ "unchecked", "rawtypes", })
	public static List<PEEntity> getEntities(long classNameId, int start, int end, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		// get util class from registry
		Class util = PEEntityClassRegister.getUtilClass(classNameId);

		String server = PEEntityClassRegister.getServerCall(classNameId);

		if (server.isEmpty() || server == null) {
			try {
				// get the list method
				Method listMethod = util.getMethod("getPEEntityList", Integer.class, Integer.class);
				try {
					// invoke the list method
					List<PEEntity> list = (List<PEEntity>) listMethod.invoke(null, start, end);
					for (PEEntity peEntity : list) {
						peEntity.setClassNameId(classNameId);
					}
					return list;
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					_log.error(e);
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}

		return new ArrayList<PEEntity>();
	}

	@SuppressWarnings({ "unchecked", "rawtypes", })
	public static List<PEEntity> getEntities(long classNameId, List<Long> entityIds) {
		// get util class from registry
		Class util = PEEntityClassRegister.getUtilClass(classNameId);
		try {
			// get the list method
			Method listMethod = util.getMethod("getPEEntityList", List.class);
			try {
				// invoke the list method
				List<PEEntity> list = (List<PEEntity>) listMethod.invoke(null, entityIds);
				for (PEEntity peEntity : list) {
					peEntity.setClassNameId(classNameId);
				}
				return list;
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				_log.error(e);
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return new ArrayList<PEEntity>();
	}

	@SuppressWarnings({ "unchecked", "rawtypes", })
	public static List<PEEntityField> getPEEntityFields(long classNameId) {
		// get util class from registry
		Class util = PEEntityClassRegister.getUtilClass(classNameId);
		List<PEEntityField> fieldsFrmEntity = null;
		try {
			// get the list method
			Method listMethod = util.getMethod("getPEEntityFields");
			try {
				// invoke the list method
				fieldsFrmEntity = (List<PEEntityField>) listMethod.invoke(null);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				_log.error(e);
			}
		} catch (Exception e) {
			_log.error(e);
		}
		if (fieldsFrmEntity == null) {
			fieldsFrmEntity = new ArrayList<PEEntityField>();
		}
		List<PEEntityField> fields = new ArrayList<PEEntityField>();
		fields.add(getPeEntityFieldPK(classNameId));
		fields.addAll(fieldsFrmEntity);

		return fields;
	}

	private static PEEntityField getPeEntityFieldPK(long classNameId) {
		PEEntityField field = new PEEntityField();
		field.setId(PEConstants.FIELD_ENTITY_ID);
		field.setName(PEEntityClassRegister.getDisplayName(classNameId));
		field.setType(PEConstantsGlobal.FIELD_TYPE_SELECT);

		Map<String, String> map = new LinkedHashMap<>();
		List<PEEntity> list = getEntities(classNameId);
		for (PEEntity entity : list) {
			String name = Validator.isNotNull(entity.getName1()) ? entity.getName1() : entity.getName();
			map.put(String.valueOf(entity.getId()), name);
		}

		field.setValues(map);

		return field;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", })
	public static String getPEEntityFieldValue(long classNameId, long classPK, String fieldId) {
		if (PEConstants.FIELD_ENTITY_ID.equalsIgnoreCase(fieldId)) {
			return String.valueOf(classPK);
		}
		// get util class from registry
		Class util = PEEntityClassRegister.getUtilClass(classNameId);
		try {
			// get the list method
			Method listMethod = util.getMethod("getPEEntityFieldValue", Long.class, String.class);
			try {
				// invoke the list method
				String value = (String) listMethod.invoke(null, classPK, fieldId);
				return value;
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				_log.error(e);
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return StringPool.BLANK;
	}

	public static String ENTITY_PROPERTY_PREFIX = "entity.";

	public static boolean isEntityProperty(String property) {
		return GetterUtil.getString(property).startsWith(ENTITY_PROPERTY_PREFIX);
	}

	public static String stripEntityPropery(String property) {
		return property.replaceFirst(ENTITY_PROPERTY_PREFIX, StringPool.BLANK);
	}

	private static Log _log = LogFactoryUtil.getLog(PEEntityHelper.class);

}
