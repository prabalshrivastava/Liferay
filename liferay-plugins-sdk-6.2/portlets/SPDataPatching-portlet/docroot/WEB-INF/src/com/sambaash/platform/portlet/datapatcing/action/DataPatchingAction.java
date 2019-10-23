package com.sambaash.platform.portlet.datapatcing.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ResourceBlockLocalServiceUtil;
import com.liferay.portal.service.ResourceBlockServiceUtil;
import com.liferay.portal.service.ResourcePermissionServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.srv.roles.model.SPRoles;
import com.sambaash.platform.srv.roles.service.SPRolesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPLdapMapping;
import com.sambaash.platform.srv.spservices.service.SPLdapMappingLocalServiceUtil;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class LdapEsnSqlGenAction
 */
public class DataPatchingAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(DataPatchingAction.class.getName());

	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		super.doView(request, response);
	}

	private static void log(StringBuilder sb, String msg) {
		sb.append("<br>");
		sb.append(msg);
	}

	public void displayCountryDeptPerm(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		actionResponse.setRenderParameter("jspPage", "/html/countryDeptPerm.jsp");
	}

	public void displayEsnLdapMappingSQl(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		actionResponse.setRenderParameter("jspPage", "/html/esnLdapSqlGen.jsp");
	}

	public void displayRoleAssignment(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		actionResponse.setRenderParameter("jspPage", "/html/assignRoles.jsp");
	}

	public void displayPortetPerm(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		actionResponse.setRenderParameter("jspPage", "/html/portletPerm.jsp");
	}

	public void displayPermInherit(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		actionResponse.setRenderParameter("jspPage", "/html/dlPermInherit.jsp");
	}

	public void displayFeeFundingBulkuploadPage(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		actionResponse.setRenderParameter("jspPage", "/html/feeFundingBulkUpload.jsp");
	}

	public void displaymiscFeeBulkuploadPage(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		actionResponse.setRenderParameter("jspPage", "/html/miscfeeBulkUpload.jsp");
	}

	public void displayCourseDetailsUploadPage(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		actionResponse.setRenderParameter("jspPage", "/html/courseDetailsBulkUpload.jsp");
	}

	public void displayClosedDateUploadPage(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		actionResponse.setRenderParameter("jspPage", "/html/closedDateBulkUpload.jsp");
	}

	public void displayPreCourseCounselling(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		actionResponse.setRenderParameter("jspPage", "/html/preCourseCounsellingUpdate.jsp");
	}

	public void bulkUploadFeeFunding(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		FeeFundingBatchUploadHelper helper = new FeeFundingBatchUploadHelper(actionRequest);
		helper.bulkuploadFeeFunding();

		actionRequest.setAttribute("msgs", helper.getMsgs());
		actionRequest.setAttribute("errors", helper.getErrors());

		actionResponse.setRenderParameter("jspPage", "/html/feeFundingBulkUpload.jsp");
	}

	public void bulkUploadMiscFee(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		MiscFeeBatchUploadHelper helper = new MiscFeeBatchUploadHelper(actionRequest);
		helper.bulkupload();

		actionRequest.setAttribute("msgs", helper.getMsgs());
		actionRequest.setAttribute("errors", helper.getErrors());

		actionResponse.setRenderParameter("jspPage", "/html/miscfeeBulkUpload.jsp");
	}

	public void bulkUploadCourseDetails(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		CourseDetailsBatchUploadHelper helper = new CourseDetailsBatchUploadHelper(actionRequest);
		helper.bulkupload();

		actionRequest.setAttribute("msgs", helper.getMsgs());
		actionRequest.setAttribute("errors", helper.getErrors());

		actionResponse.setRenderParameter("jspPage", "/html/courseDetailsBulkUpload.jsp");
	}

	public void updatePreCourseCounselling(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		PreCourseCounsellingBatchUpdateHelper helper = new PreCourseCounsellingBatchUpdateHelper(actionRequest);
		helper.bulkupdate();

		actionRequest.setAttribute("msgs", helper.getMsgs());
		actionRequest.setAttribute("errors", helper.getErrors());

		actionResponse.setRenderParameter("jspPage", "/html/preCourseCounsellingUpdate.jsp");
	}

	public void bulkUploadClosedDate(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ClosedDateBatchUploadHelper helper = new ClosedDateBatchUploadHelper(actionRequest);
		helper.bulkupload();

		actionRequest.setAttribute("msgs", helper.getMsgs());
		actionRequest.setAttribute("errors", helper.getErrors());

		actionResponse.setRenderParameter("jspPage", "/html/closedDateBulkUpload.jsp");
	}

	public void inheritParentPermissions(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		StringBuilder sb = new StringBuilder();
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		// String operation =
		// ParamUtil.getString(actionRequest,"permissionOperation");
		inheritPermissions(folderId, themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), sb);
		actionRequest.setAttribute("log", sb.toString());
		actionResponse.setRenderParameter("jspPage", "/html/dlPermInherit.jsp");
	}

	private void inheritPermissions(final long folderId, long groupId, long companyId, StringBuilder sb)
			throws PortalException, SystemException, IOException {
		try {
			log(sb, "Process started for folder " + folderId + " operation = "
					+ SambaashConstants.PERMISSION_OPERATION_MERGE);
			if (folderId != 0) {
				try {
					DLFolder folder = DLFolderLocalServiceUtil.getDLFolder(folderId);
					log(sb, " name = " + folder.getName());
					// Ignore folders under root
					if (folder.getParentFolderId() != 0) {
						PermissionUtil.inhertParentPermissions(folder, true,
								SambaashConstants.PERMISSION_OPERATION_MERGE, null);
					} else {
						log(sb, "Skipping permisstion inheritance for folder " + folder.getName()
								+ ". This folder is directly under ROOT. So skipping");
					}
				} catch (Exception ex) {
					log(sb, "EXCEPTION while processing folder " + folderId);

				}
			} else {
				log(sb, "Skipping permisstion inheritance for folder " + folderId);
			}
			List<Folder> childFolders = DLAppServiceUtil.getFolders(groupId, folderId);
			for (Folder childFolder : childFolders) {
				DLFolder childDlF = DLFolderLocalServiceUtil.getDLFolder(childFolder.getFolderId());
				inheritPermissions(childDlF.getFolderId(), groupId, companyId, sb);
			}
			// Dont process for files directuly under root folder
			if (folderId != 0) {
				try {
					DLFolder folder = DLFolderLocalServiceUtil.getDLFolder(folderId);
					// Ignore files under public folder
					/*
					 * if(!(folder.getParentFolderId() == 0 &&
					 * folder.getName().equalsIgnoreCase("Public Folder"))
					 * ){}else{ log(sb,
					 * "Ignoring permissions for files under public folder"); }
					 */

					List<FileEntry> fes = DLAppServiceUtil.getFileEntries(folder.getGroupId(), folder.getFolderId());
					for (FileEntry fe : fes) {
						try {
							DLFileEntry dlFe = DLFileEntryLocalServiceUtil.getDLFileEntry(fe.getFileEntryId());
							PermissionUtil.inhertParentPermissions(dlFe, true,
									SambaashConstants.PERMISSION_OPERATION_MERGE, null);
						} catch (Exception ex) {
							log(sb, "EXCEPTION : while assigning permissions for file entry id " + fe.getFileEntryId());

						}
					}

				} catch (Exception ex) {
					log(sb, "EXCEPTION while assigning permissions " + ex);

				}
			} else {
				log(sb, "Skipping permisstion inheritance for files under root ");
			}
		} catch (Exception e) {
			log(sb, "EXCEPTION while assigning permissions " + e);
			_log.error(e);
		}
	}

	public void addCountryDeptPermissionsRolesFolders(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		StringBuilder sb = new StringBuilder();
		long feedTo = ParamUtil.getLong(actionRequest, "feedToVocId");
		boolean createFolders = ParamUtil.getBoolean(actionRequest, "createFolders");
		boolean assignPermission = ParamUtil.getBoolean(actionRequest, "assignPermission");
		boolean createRoles = ParamUtil.getBoolean(actionRequest, "createRoles");
		boolean createSpRoles = ParamUtil.getBoolean(actionRequest, "createSpRoles");

		log(sb, "User Input");
		log(sb, "feedToVocId = " + feedTo);
		log(sb, "createFolders = " + createFolders);
		log(sb, "assignPermission = " + assignPermission);
		log(sb, "createRoles = " + createRoles);

		if (feedTo != 0) {
			List<AssetCategory> list = AssetCategoryLocalServiceUtil.getVocabularyCategories(feedTo, -1, -1, null);
			for (AssetCategory assetCategory : list) {
				if (assetCategory.getParentCategoryId() == 0) {
					List<AssetCategory> depts = getChilds(list, assetCategory.getCategoryId());
					for (AssetCategory dept : depts) {
						String countryName = assetCategory.getName();
						String deptName = dept.getName();
						try {
							if (createRoles) {
								SambaashUtil.addCountryDeptRoles(0, themeDisplay.getCompanyId(), countryName, deptName);
							}
							String countryDeptFolderFormat = "%s-%s";
							String folderName = String.format(countryDeptFolderFormat, countryName, deptName);
							Folder folder = null;
							if (createFolders) {
								try {
									DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, folderName);
								} catch (NoSuchFolderException e) {
									long adminId = SambaashUtil.getAdminUserId();
									ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
									folder = DLAppLocalServiceUtil.addFolder(adminId, themeDisplay.getScopeGroupId(), 0,
											folderName, folderName, serviceContext);
									log(sb, "Folder created ,name= " + folderName);
									PermissionUtil.adDefaultFolderPermissionsForCountryDeptRoles(
											themeDisplay.getCompanyId(), folder.getFolderId(), folderName);
									log(sb, "Permissions assigned to new folder " + folderName);
								} catch (Exception ex) {
									log(sb, "Error while getting folder folder name = " + folderName);
								}
							}
							if (assignPermission) {
								try {
									folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0,
											folderName);
									if (Validator.isNotNull(folder)) {
										PermissionUtil.adDefaultFolderPermissionsForCountryDeptRoles(
												themeDisplay.getCompanyId(), folder.getFolderId(), folderName);
										log(sb, "Permissions assigned to " + folderName);
									}

								} catch (Exception ex) {
									log(sb, "Error while assigning permissions" + ex + " folderName=" + folderName);
								}
							}

							if (createSpRoles) {
								String adminRoleName = String.format(ESN_ADMIN_ROLE_FORMAT, countryName, deptName);
								Role role = SambaashUtil.addRoleIfNotExist(themeDisplay.getCompanyId(), adminRoleName);
								addToSPRoles(themeDisplay, assetCategory.getCategoryId(), dept.getCategoryId(),
										role.getRoleId());

								String docControlRoleName = String.format(ESN_DOC_CONTROL_ROLE_FORMAT, countryName,
										deptName);
								role = SambaashUtil.addRoleIfNotExist(themeDisplay.getCompanyId(), docControlRoleName);
								addToSPRoles(themeDisplay, assetCategory.getCategoryId(), dept.getCategoryId(),
										role.getRoleId());

								String userRoleName = String.format(ESN_USER_ROLE_FORMAT, countryName, deptName);
								role = SambaashUtil.addRoleIfNotExist(themeDisplay.getCompanyId(), userRoleName);
								addToSPRoles(themeDisplay, assetCategory.getCategoryId(), dept.getCategoryId(),
										role.getRoleId());
							}

						} catch (Exception ex) {
							log(sb, "Error while processing country dept folder" + ex + "Country name = " + countryName
									+ " Dept = " + deptName);

						}
					}
				}
			}
		}
		actionRequest.setAttribute("log", sb.toString());
		actionResponse.setRenderParameter("jspPage", "/html/countryDeptPerm.jsp");
	}

	private void addToSPRoles(ThemeDisplay themeDisplay, long categoryId1, long categoryId2, long role)
			throws Exception {
		// Check if it exists
		try {
			SPRoles temp = SPRolesLocalServiceUtil.findByRoleIdCategoryId1AndCategoryId2(themeDisplay.getScopeGroupId(),
					role, categoryId1, categoryId2);
			if (Validator.isNotNull(temp)) {
				return;
			}
		} catch (Exception ex) {
			// _log.error(ex);
		}

		String uuid = PortalUUIDUtil.generate();
		long pKey = CounterLocalServiceUtil.increment("SPRoles.class");
		SPRoles spRoles = SPRolesLocalServiceUtil.createSPRoles(pKey);

		spRoles.setUuid(uuid);
		spRoles.setSpRoleId(pKey);
		spRoles.setGroupId(themeDisplay.getScopeGroupId());
		spRoles.setCompanyId(themeDisplay.getCompanyId());
		spRoles.setUserId(themeDisplay.getUserId());
		spRoles.setUserName(themeDisplay.getUser().getFirstName() + " " + themeDisplay.getUser().getLastName());
		spRoles.setCreateDate(Calendar.getInstance().getTime());
		spRoles.setModifiedDate(Calendar.getInstance().getTime());
		spRoles.setCategoryId1(categoryId1);
		spRoles.setCategoryId2(categoryId2);
		spRoles.setDepartmentCategoryId(categoryId2);
		spRoles.setCountryCategoryId(categoryId1);
		spRoles.setRoleId(role);

		SPRolesLocalServiceUtil.addSPRoles(spRoles);
	}

	private void logFeedToData(StringBuilder sb, long feedTo) {
		if (Validator.isNotNull(feedTo)) {
			List<AssetCategory> list = null;
			try {
				list = AssetCategoryLocalServiceUtil.getVocabularyCategories(feedTo, -1, -1, null);
				for (AssetCategory assetCategory : list) {
					if (assetCategory.getParentCategoryId() == 0) {
						log(sb, "<h3>" + assetCategory.getName() + "</h3>");
						List<AssetCategory> depts = getChilds(list, assetCategory.getCategoryId());

						for (AssetCategory dept : depts) {
							String deptName = dept.getName();
							log(sb, deptName);
						}
					}
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		}
	}

	static String ESN_USER_ROLE_FORMAT = "%s-%s-User";
	static String ESN_ADMIN_ROLE_FORMAT = "%s-%s-Admin";
	static String ESN_DOC_CONTROL_ROLE_FORMAT = "%s-%s-Doc_Control";

	public void addPortletPermissions(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		StringBuilder sb = new StringBuilder();
		long feedTo = ParamUtil.getLong(actionRequest, "feedToVocId");
		String portletId = ParamUtil.getString(actionRequest, "portletId");
		String selResource = portletId;
		String actionKey = ParamUtil.getString(actionRequest, "actionKey");

		boolean assignToCountryDeptUser = ParamUtil.getBoolean(actionRequest, "countryDeptUser");
		boolean assignToCountryDeptAdmin = ParamUtil.getBoolean(actionRequest, "countryDeptAdmin");
		boolean assignToCountryDeptDocControl = ParamUtil.getBoolean(actionRequest, "countryDeptDocControl");

		log(sb, "User Input");
		log(sb, "feedToVocId = " + feedTo);
		logFeedToData(sb, feedTo);
		log(sb, "portletId = " + portletId);
		try {
			List<String> list = ResourceActionsUtil.getResourceActions(portletId, null);
			log(sb, "Available Action Keys" + list);
		} catch (Exception ex) {

		}
		log(sb, "actionKey = " + actionKey);
		log(sb, "assignToCountryDeptUser = " + assignToCountryDeptUser);
		log(sb, "assignToCountryDeptAdmin = " + assignToCountryDeptAdmin);
		log(sb, "assignToCountryDeptDocControl = " + assignToCountryDeptDocControl);

		int scope = ResourceConstants.SCOPE_COMPANY;
		if (feedTo != 0 && Validator.isNotNull(portletId)
				&& (assignToCountryDeptAdmin || assignToCountryDeptDocControl || assignToCountryDeptUser)) {
			List<AssetCategory> list = AssetCategoryLocalServiceUtil.getVocabularyCategories(feedTo, -1, -1, null);
			for (AssetCategory assetCategory : list) {
				if (assetCategory.getParentCategoryId() == 0) {
					List<AssetCategory> depts = getChilds(list, assetCategory.getCategoryId());
					for (AssetCategory dept : depts) {
						String countryName = assetCategory.getName();
						String deptName = dept.getName();
						log(sb, "Processing for countryName=" + countryName + "deptName = " + deptName);
						try {
							Role admin = null, user = null, docControl = null;
							if (assignToCountryDeptAdmin) {
								admin = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),
										String.format(ESN_ADMIN_ROLE_FORMAT, countryName, deptName));
							}
							if (assignToCountryDeptUser) {
								user = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),
										String.format(ESN_USER_ROLE_FORMAT, countryName, deptName));
							}
							if (assignToCountryDeptDocControl) {
								docControl = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),
										String.format(ESN_DOC_CONTROL_ROLE_FORMAT, countryName, deptName));
							}

							if (ResourceBlockLocalServiceUtil.isSupported(selResource)) {

								if (assignToCountryDeptAdmin) {
									updateActions_6Blocks(admin, themeDisplay.getScopeGroupId(), selResource, actionKey,
											true, scope, new String[] {});
								}
								if (assignToCountryDeptUser) {
									updateActions_6Blocks(user, themeDisplay.getScopeGroupId(), selResource, actionKey,
											true, scope, new String[] {});
								}
								if (assignToCountryDeptDocControl) {
									updateActions_6Blocks(docControl, themeDisplay.getScopeGroupId(), selResource,
											actionKey, true, scope, new String[] {});
								}

							} else {
								if (assignToCountryDeptAdmin) {
									updateAction_6(admin, themeDisplay.getScopeGroupId(), selResource, actionKey, true,
											scope, new String[] {});
								}
								if (assignToCountryDeptUser) {
									updateAction_6(user, themeDisplay.getScopeGroupId(), selResource, actionKey, true,
											scope, new String[] {});
								}
								if (assignToCountryDeptDocControl) {
									updateAction_6(docControl, themeDisplay.getScopeGroupId(), selResource, actionKey,
											true, scope, new String[] {});
								}
							}

						} catch (Exception ex) {
							log(sb, "Error while processingr" + ex + "Country name = " + countryName + " Dept = "
									+ deptName);

						}
					}
				}
			}
		} else {
			log(sb, "User input is not valid");
		}
		actionRequest.setAttribute("log", sb.toString());
		actionResponse.setRenderParameter("jspPage", "/html/portletPerm.jsp");
	}

	protected void updateAction_6(Role role, long groupId, String selResource, String actionId, boolean selected,
			int scope, String[] groupIds) throws Exception {

		long companyId = role.getCompanyId();
		long roleId = role.getRoleId();

		if (selected) {
			if (scope == ResourceConstants.SCOPE_COMPANY) {
				ResourcePermissionServiceUtil.addResourcePermission(groupId, companyId, selResource, scope,
						String.valueOf(role.getCompanyId()), roleId, actionId);
			} else if (scope == ResourceConstants.SCOPE_GROUP_TEMPLATE) {
				ResourcePermissionServiceUtil.addResourcePermission(groupId, companyId, selResource,
						ResourceConstants.SCOPE_GROUP_TEMPLATE, String.valueOf(GroupConstants.DEFAULT_PARENT_GROUP_ID),
						roleId, actionId);
			} else if (scope == ResourceConstants.SCOPE_GROUP) {
				ResourcePermissionServiceUtil.removeResourcePermissions(groupId, companyId, selResource,
						ResourceConstants.SCOPE_GROUP, roleId, actionId);

				for (String curGroupId : groupIds) {
					ResourcePermissionServiceUtil.addResourcePermission(groupId, companyId, selResource,
							ResourceConstants.SCOPE_GROUP, curGroupId, roleId, actionId);
				}
			}
		} else {

			// Remove company, group template, and group permissions

			ResourcePermissionServiceUtil.removeResourcePermissions(groupId, companyId, selResource,
					ResourceConstants.SCOPE_COMPANY, roleId, actionId);

			ResourcePermissionServiceUtil.removeResourcePermissions(groupId, companyId, selResource,
					ResourceConstants.SCOPE_GROUP_TEMPLATE, roleId, actionId);

			ResourcePermissionServiceUtil.removeResourcePermissions(groupId, companyId, selResource,
					ResourceConstants.SCOPE_GROUP, roleId, actionId);
		}
	}

	protected void updateActions_6Blocks(Role role, long scopeGroupId, String selResource, String actionId,
			boolean selected, int scope, String[] groupIds) throws Exception {

		long companyId = role.getCompanyId();
		long roleId = role.getRoleId();

		if (selected) {
			if (scope == ResourceConstants.SCOPE_GROUP) {
				ResourceBlockServiceUtil.removeAllGroupScopePermissions(scopeGroupId, companyId, selResource, roleId,
						actionId);
				ResourceBlockServiceUtil.removeCompanyScopePermission(scopeGroupId, companyId, selResource, roleId,
						actionId);

				for (String groupId : groupIds) {
					ResourceBlockServiceUtil.addGroupScopePermission(scopeGroupId, companyId,
							GetterUtil.getLong(groupId), selResource, roleId, actionId);
				}
			} else {
				ResourceBlockServiceUtil.removeAllGroupScopePermissions(scopeGroupId, companyId, selResource, roleId,
						actionId);
				ResourceBlockServiceUtil.addCompanyScopePermission(scopeGroupId, companyId, selResource, roleId,
						actionId);
			}
		} else {
			ResourceBlockServiceUtil.removeAllGroupScopePermissions(scopeGroupId, companyId, selResource, roleId,
					actionId);
			ResourceBlockServiceUtil.removeCompanyScopePermission(scopeGroupId, companyId, selResource, roleId,
					actionId);
		}
	}

	private List<AssetCategory> getChilds(List<AssetCategory> list, long parentId) {
		List<AssetCategory> depts = new ArrayList<AssetCategory>();
		if (Validator.isNotNull(list)) {
			for (AssetCategory assetCategory : list) {
				if (assetCategory.getParentCategoryId() == parentId) {
					depts.add(assetCategory);
				}
			}
		}
		return depts;
	}

	public boolean getBoolean(String str) {
		boolean result = false;
		str = GetterUtil.getString(str).trim();
		if ("yes".equalsIgnoreCase(str) || "y".equalsIgnoreCase(str) || "true".equals(str)) {
			result = true;
		}
		return result;
	}

	public void assignRoles(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		StringBuilder errorRows = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		StringBuilder usersNotFound = new StringBuilder();
		int notFound = 0;
		int successCount = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HSSFWorkbook writeBook = new HSSFWorkbook();
		HSSFSheet writeSheet = writeBook.createSheet("NotFound");
		int writeRowNum = 0;
		Row writeRow = writeSheet.createRow(writeRowNum++);
		Cell cell1 = writeRow.createCell(0);
		cell1.setCellValue("ScreenName");
		Cell cell2 = writeRow.createCell(1);
		cell2.setCellValue("Country");
		Cell cell3 = writeRow.createCell(2);
		cell3.setCellValue("Department");
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			File[] files = uploadPortletRequest.getFiles("filesToUpload");
			File file = files[0];
			Workbook wb = null;
			if (file.getName().endsWith(EXCEL.EXTENSION)) {
				wb = readFileXlsx(new FileInputStream(file));
			} else if (file.getName().endsWith(EXCEL.EXTENSION_OLD)) {
				wb = readFileXls(new FileInputStream(file));
			} else {
				throw new Exception();
			}

			Sheet sheet = wb.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				User user = null;
				Role adminRole = null;
				Role userRole = null;
				Role docControlRole = null;
				Role eventsGrpsRole = null;
				Row row = sheet.getRow(i);
				if (Validator.isNotNull(row)) {
					try {
						Cell cell = row.getCell(0);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String screenName = cell.getStringCellValue();
						if (Validator.isNull(screenName)) {
							log(sb, "Screen Name is empty At Row no " + (i + 1));
							log(errorRows, "Screen Name = <EMPTY> " + " Row No " + (i + 1));
							continue;
						}
						try {
							user = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(),
									screenName.toLowerCase());
							if (Validator.isNull(user)) {
								// log(errorRows,"NOT FOUND - USER" + "
								// ScreenName = " + screenName.toLowerCase() + "
								// Row No " + (i + 1));
								// log(usersNotFound,screenName);
								// notFound ++;
							}
						} catch (NoSuchUserException ex) {
							try {
								user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(),
										screenName.toLowerCase());
							} catch (Exception ex1) {

							}
						} catch (Exception ex) {
							// log(sb,"Exception while getting user " +
							// ex.getMessage());
							// log(errorRows,"NOT FOUND - USER" + " ScreenName =
							// " + screenName.toLowerCase() + " Row No " + (i +
							// 1));
							// log(usersNotFound,screenName);

						}
						if (Validator.isNull(user)) {
							if (screenName.contains(" ")) {
								try {
									user = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(),
											screenName.replace(" ", ".").toLowerCase());
								} catch (Exception e) {

								}

							}
						}

						cell = row.getCell(1);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String countryName = cell.getStringCellValue();
						if (Validator.isNull(countryName)) {
							sb.append("<br/>Country is empty At Row no " + (i + 1));
							log(errorRows, "<br/>Country = <EMPTY>" + " Row No " + (i + 1));
						}
						cell = row.getCell(2);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String deptName = cell.getStringCellValue();
						if (Validator.isNull(deptName)) {
							sb.append("<br/>Department is empty At Row no " + (i + 1));
							log(errorRows, "<br/>Department = <EMPTY>" + " Row No " + (i + 1));
						}

						if (Validator.isNull(user)) {
							notFound++;
							int writeCellNum = 0;
							log(usersNotFound, screenName + " " + countryName + " " + deptName);
							writeRow = writeSheet.createRow(writeRowNum++);
							cell1 = writeRow.createCell(writeCellNum++);
							cell1.setCellValue(screenName);
							cell2 = writeRow.createCell(writeCellNum++);
							cell2.setCellValue(countryName);
							cell3 = writeRow.createCell(writeCellNum++);
							cell3.setCellValue(deptName);
							continue;
						}
						if (Validator.isNull(countryName) || Validator.isNull(deptName)) {
							continue;
						}

						cell = row.getCell(3);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						boolean assignAdminRole = getBoolean(cell.getStringCellValue());

						cell = row.getCell(4);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						boolean assignDocRole = GetterUtil.getBoolean(getBoolean(cell.getStringCellValue()));

						cell = row.getCell(5);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						boolean assignUserRole = GetterUtil.getBoolean(getBoolean(cell.getStringCellValue()));

						cell = row.getCell(6);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						boolean assigneventGrps = GetterUtil.getBoolean(getBoolean(cell.getStringCellValue()));

						cell = row.getCell(7);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						assigneventGrps = assigneventGrps || getBoolean(cell.getStringCellValue());

						String adminRoleName = String.format(ESN_ADMIN_ROLE_FORMAT, countryName, deptName);
						try {
							adminRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), adminRoleName);
						} catch (Exception ex) {
							log(errorRows, "Error while getting admin role " + adminRoleName + " row no " + (i + 1));
						}

						String docControleRoleName = String.format(ESN_DOC_CONTROL_ROLE_FORMAT, countryName, deptName);
						try {
							docControlRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),
									docControleRoleName);
						} catch (Exception e) {
							log(errorRows, "Error while getting docControlRole role " + docControleRoleName + " row no "
									+ (i + 1));
						}

						String userRoleName = String.format(ESN_USER_ROLE_FORMAT, countryName, deptName);
						try {
							userRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), userRoleName);
						} catch (Exception e) {
							log(errorRows,
									"Error while getting userRoleName role " + userRoleName + " row no " + (i + 1));
						}

						String eventMediaGrpsRoleName = "Create Access";
						try {
							eventsGrpsRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),
									eventMediaGrpsRoleName);

						} catch (Exception e) {
							log(errorRows,
									"Error while getting  role  Events Blogs, Media & Groups" + " row no " + (i + 1));

						}

						List<Long> roleIds = new ArrayList<Long>();

						if (assignAdminRole) {
							if (Validator.isNotNull(adminRole)) {
								roleIds.add(adminRole.getRoleId());
							} else {
								log(errorRows, " Admin role " + adminRoleName
										+ " is null. So cannot be assigned. row no = " + (i + 1));
							}
						}
						if (assignDocRole) {
							if (Validator.isNotNull(docControlRole)) {
								roleIds.add(docControlRole.getRoleId());
							} else {
								log(errorRows, " docControlRole role " + docControleRoleName
										+ " is null. So cannot be assigned. row no = " + (i + 1));
							}
						}
						if (assignUserRole) {
							if (Validator.isNotNull(userRole)) {
								roleIds.add(userRole.getRoleId());
							} else {
								log(errorRows, " User role " + userRoleName
										+ " is null. So cannot be assigned. row no = " + (i + 1));
							}
						}
						if (assigneventGrps) {
							if (Validator.isNotNull(eventsGrpsRole)) {
								roleIds.add(eventsGrpsRole.getRoleId());
							} else {
								log(errorRows, "  role " + eventMediaGrpsRoleName
										+ " is null. So cannot be assigned. row no = " + (i + 1));
							}
						}
						long[] temp = new long[roleIds.size()];
						for (int j = 0; j < roleIds.size(); j++) {
							temp[j] = roleIds.get(j);
						}

						log(sb, "User " + screenName + " . Roles will be added " + roleIds);
						if (temp.length > 0) {
							RoleLocalServiceUtil.addUserRoles(user.getUserId(), temp);
							successCount++;
							log(sb, "User " + screenName + " . Roles added ");
						}
					} catch (Exception ex) {
						log(errorRows, "Exception " + ex.getMessage());

					}
				}
			}
		} catch (Exception ex) {
			log(errorRows, "Exception " + ex.getMessage());
		}
		errorRows.insert(0, "Total Users not found<br> " + notFound);
		errorRows.insert(0, "Successfully assigned count<br> " + successCount);
		actionRequest.setAttribute("usersNotFound", usersNotFound.toString());
		actionRequest.setAttribute("erors", sb.toString());
		actionRequest.setAttribute("log", errorRows.toString());
		actionResponse.setRenderParameter("jspPage", "/html/assignRoles.jsp");
		try {
			FileOutputStream out = new FileOutputStream(new File("/usrs/portal61/user_not_found.xls"));
			writeBook.write(out);
			out.close();

		} catch (FileNotFoundException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		}
	}

	public void upload(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		StringBuilder sb = new StringBuilder();
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			File[] files = uploadPortletRequest.getFiles("filesToUpload");
			File file = files[0];
			Workbook wb = null;
			if (file.getName().endsWith(EXCEL.EXTENSION)) {
				wb = readFileXlsx(new FileInputStream(file));
			} else if (file.getName().endsWith(EXCEL.EXTENSION_OLD)) {
				wb = readFileXls(new FileInputStream(file));
			} else {
				throw new Exception();
			}

			Sheet sheet = wb.getSheetAt(0);
			List<EsnLdapMappingBean> list = new ArrayList<EsnLdapMappingBean>();
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (Validator.isNotNull(row)) {
					try {
						Cell cell = row.getCell(0);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String ldapCompany = cell.getStringCellValue();
						if (Validator.isNull(ldapCompany)) {
							sb.append("<br/>Ldap Company is empty Row no " + (i + 1));
							continue;
						}
						cell = row.getCell(1);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String ldapCountry = cell.getStringCellValue();
						if (Validator.isNull(ldapCountry)) {
							sb.append("<br/>Ldap Country is empty Row no " + (i + 1));
							continue;
						}
						cell = row.getCell(2);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String ldapDept = cell.getStringCellValue();
						if (Validator.isNull(ldapDept)) {
							sb.append("<br/>Ldap Department is empty Row no " + (i + 1));
							continue;
						}
						cell = row.getCell(3);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String esnCountry = cell.getStringCellValue();
						if (Validator.isNull(esnCountry)) {
							sb.append("<br/>Esn Country is empty Row no " + (i + 1));
							continue;
						}
						cell = row.getCell(4);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String esnDept = cell.getStringCellValue();
						if (Validator.isNull(esnDept)) {
							sb.append("<br/>Esn Department is empty Row no " + (i + 1));
							continue;
						}

						EsnLdapMappingBean bean = new EsnLdapMappingBean();
						bean.setEsnCountry(esnCountry.trim());
						bean.setEsnDept(esnDept.trim());
						bean.setLdapCompany(ldapCompany.trim());
						bean.setLdapCountry(ldapCountry.trim());
						bean.setLdapDept(ldapDept.trim());
						bean.setRowNo(i + 1);

						boolean duplicate = false;
						for (EsnLdapMappingBean temp : list) {
							if (temp.equals(bean)) {
								duplicate = true;
								sb.append("<br/> Duplicate Detected. Row Nums " + (i + 1) + ", " + temp.getRowNo()
										+ " So  entry at row " + (i + 1) + "will be eliminated");
							}
						}
						if (!duplicate) {
							list.add(bean);
						}

					} catch (Exception e) {
						_log.error(e);
					}
				}
			}

			StringBuilder sqls = new StringBuilder();
			String INSERT_FORMAT = "INSERT INTO SPEsnLdapMapping (%s) select %s from SPEsnLdapMapping;";

			List<AssetCategory> assets = AssetCategoryLocalServiceUtil.getAssetCategories(-1, -1);
			boolean isFirst = true;
			for (EsnLdapMappingBean temp : list) {
				try {
					Map<String, String> map = new LinkedHashMap<String, String>();
					if (isFirst) {
						// map.put("esnLdapMappingId", "1");
					} else {
					}
					map.put("esnLdapMappingId", "max(esnLdapMappingId) + 1");
					map.put("groupId", "0");
					map.put("companyId", "10154");
					map.put("userId", "10196");
					map.put("userName", "'Administrator Sambaash'");
					map.put("createDate", "CURDATE()");
					map.put("modifiedDate", "CURDATE()");
					AssetCategory esnCountry = null;
					for (AssetCategory catg : assets) {
						if (catg.getName().equals(temp.getEsnCountry()) && catg.getVocabularyId() == 13303) {
							esnCountry = catg;
							break;
						}
					}
					if (Validator.isNull(esnCountry)) {
						sb.append("<br/> Country asset category not found for esn country " + temp.getEsnCountry()
								+ " Department " + temp.getEsnDept());
						continue;
					}
					map.put("esnCountryId", esnCountry.getCategoryId() + "");
					AssetCategory deptCatg = null;
					for (AssetCategory catg : assets) {
						if (catg.getName().equals(temp.getEsnDept())
								&& catg.getParentCategoryId() == esnCountry.getCategoryId()) {
							deptCatg = catg;
							break;
						}
					}
					if (Validator.isNull(deptCatg)) {
						sb.append("<br/> Department asset category not found for esn Department " + temp.getEsnDept()
								+ " Country = " + temp.getEsnCountry());
						continue;
					}

					SPLdapMapping esn = SPLdapMappingLocalServiceUtil.findByCountryDepartmentAndLegalEntity(
							temp.getLdapCountry(), temp.getLdapDept(), temp.getLdapCompany());
					if (esn != null) {
						sb.append("<br/> Esn mapping exists for ldap company = " + temp.getLdapCompany()
								+ " ldap country = " + temp.getLdapCountry() + " ldap dept = " + temp.getLdapDept());
						sb.append("so sql will not be generated");
						continue;
					}

					map.put("esnDepartmentId", deptCatg.getCategoryId() + "");

					map.put("esnCountry", "'" + temp.getEsnCountry() + "'");
					map.put("esnDepartment", "'" + temp.getEsnDept() + "'");
					map.put("esnCountryDepartmentId", "0");
					map.put("ldapCountry", "'" + temp.getLdapCountry() + "'");
					map.put("ldapDepartment", "'" + temp.getLdapDept() + "'");
					map.put("ldapCompany", "'" + temp.getLdapCompany() + "'");
					map.put("defaultRoleId", "0");

					String keys = "";
					String values = "";
					for (String key : map.keySet()) {
						if (keys.isEmpty()) {
							keys = key;
						} else {
							keys = keys + "," + key;
						}
						if (values.isEmpty()) {
							values = map.get(key);
						} else {
							values = values + "," + map.get(key);
						}
					}
					String insert = String.format(INSERT_FORMAT, keys, values);
					sqls.append(insert);
					sqls.append("<br/>");
					sqls.append("<br/>");

				} catch (Exception ex) {

					sb.append("<br/> error while processing esn country = " + temp.getEsnCountry() + " dept ="
							+ temp.getEsnDept());
				}
			}

			actionRequest.setAttribute("log", sb.toString());
			actionRequest.setAttribute("sqls", sqls.toString());

		} catch (Exception e) {
			_log.error(e);
		}
		actionResponse.setRenderParameter("jspPage", "/html/esnLdapSqlGen.jsp");
	}

	public static HSSFWorkbook readFileXls(InputStream inputStream) throws IOException {
		return new HSSFWorkbook(inputStream);
	}

	public static XSSFWorkbook readFileXlsx(InputStream inputStream) throws IOException {
		return new XSSFWorkbook(inputStream);
	}
}

class EsnLdapMappingBean {
	private String esnCountry;
	private String esnDept;
	private String ldapCountry;
	private String ldapDept;
	private String ldapCompany;
	private int rowNo;

	public String getEsnCountry() {
		return esnCountry;
	}

	public void setEsnCountry(String esnCountry) {
		this.esnCountry = esnCountry;
	}

	public String getEsnDept() {
		return esnDept;
	}

	public void setEsnDept(String esnDept) {
		this.esnDept = esnDept;
	}

	public String getLdapCountry() {
		return ldapCountry;
	}

	public void setLdapCountry(String ldapCountry) {
		this.ldapCountry = ldapCountry;
	}

	public String getLdapDept() {
		return ldapDept;
	}

	public void setLdapDept(String ldapDept) {
		this.ldapDept = ldapDept;
	}

	public String getLdapCompany() {
		return ldapCompany;
	}

	public void setLdapCompany(String ldapCompany) {
		this.ldapCompany = ldapCompany;
	}

	public boolean equals(Object obj) {
		boolean equals = false;
		if (Validator.isNotNull(obj)) {
			EsnLdapMappingBean temp = (EsnLdapMappingBean) obj;

			if (this.getLdapCompany().equalsIgnoreCase(temp.getLdapCompany())
					&& this.getLdapCountry().equalsIgnoreCase(temp.getLdapCountry())
					&& this.getLdapDept().equalsIgnoreCase(temp.getLdapDept())) {
				equals = true;
			}
		}
		return equals;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
}
