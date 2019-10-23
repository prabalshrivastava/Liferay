package com.sambaash.platform.pe.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.bookmarks.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.course.enroll.CourseEnrollContractHelper;
import com.sambaash.platform.pe.course.enroll.CourseEnrollDataAdapter;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.helpers.PEApplicantFileUploadHelper;
import com.sambaash.platform.pe.jaxb.PEPreview;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.model.CourseEnrollContract;
public class PEPreviewHandler extends PESingleOutputNodeHandler {

	public PEPreviewHandler(PEPreview node, PEDataSource ds) {
		super(node, ds);
	}

	@SuppressWarnings("deprecation")
	@Override
	public PEProcessableNodeOutput process() throws SystemException {
		
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		try {
		
		_log.debug("In preview handler nodeId = " + node.getNodeId());
		PEPreview previewNode = (PEPreview)node;
		
		PEProcessStateDataAdapter processStateDataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
		
		storeNodeData(previewNode, processStateDataAdapter, "enableEsign", previewNode.getEnableEsign());
		storeNodeData(previewNode, processStateDataAdapter, "enablePreview", previewNode.getEnablePreview());
		processStateDataAdapter.store("esignApiKey", previewNode.getEsignApiKey());
		processStateDataAdapter.store("esignApiUrl", previewNode.getEsignApiUrl());
		storeNodeData(previewNode, processStateDataAdapter, "previewJspNode", previewNode.getPreviewJspNode());
		
		if (previewNode.getPreviewId().equalsIgnoreCase("Custom")){
			if (previewNode.getCustomId().equalsIgnoreCase("Esign")){
				
				 mergeDoc(ds, processStateDataAdapter, previewNode);
			}
		}
		
//		output.setNextNodeId(node.getNextNodeId());
		proceedToNextNode(output, node.getNextNodeId(), false);
		
		}
		catch (Exception e){
			output = new PEProcessableNodeOutput();
			output.setError(PEErrors.AUDIT_PREVIEW);
		}
		return output;
	}
	
	
	private static void storeNodeData(PEPreview previewNode, PEProcessStateDataAdapter dataAdapter, String dataKey, String dataValue) {
		storeNodeData(previewNode.getNodeId(), dataAdapter, dataKey, dataValue);
	}

	public static final void storeNodeData(long nodeId, PEProcessStateDataAdapter dataAdapter, String dataKey, String dataValue) {
		String key = String.format("%s_%d", dataKey, nodeId);
		dataAdapter.store(key, dataValue);
	}
	
	public static String retrieveNodeData(PEPreview previewNode, PEProcessStateDataAdapter dataAdapter, String dataKey) {
		return retrieveNodeData(previewNode.getNodeId(), dataAdapter, dataKey);
	}

	public static final String retrieveNodeData(long nodeId, PEProcessStateDataAdapter dataAdapter, String dataKey) {
		String key = String.format("%s_%d", dataKey, nodeId);
		return dataAdapter.getDataFromProcessState(key);
	}
	
	public static final String mergeDoc(PEDataSource ds, PEProcessStateDataAdapter processStateDataAdapter, PEPreview previewNode){
		
		try {
			CourseEnrollContractHelper contractHelper = CourseEnrollContractHelper.getContractHelper(ds);
			List<CourseEnrollContract> contractDocList = contractHelper.getContractTemplates();
			CourseEnrollDataAdapter dataAdapter = CourseEnrollDataAdapter.getCourseEnrollAdapter(ds);
			PDFMergerUtility PDFmerger = new PDFMergerUtility();
			String destFilePath = getFilePath(ds, "Contract_"+ ds.getProcessState().getSpPEProcessStateId());
			PDFmerger.setDestinationFileName(destFilePath);
			PDDocument doc1 = null;

			for (CourseEnrollContract contractDoc : contractDocList) {
				if (dataAdapter.isStudentMinor()) {
					if (!contractDoc.getDocType().equalsIgnoreCase("advisoryNoteMajor")) {
						String filePath = contractHelper.getContractFilePath(contractDoc);
						File file1 = new File(filePath);
						doc1 = PDDocument.load(file1);
						PDFmerger.addSource(file1);
						doc1.close();

					}
				} else {
					if (!contractDoc.getDocType().equalsIgnoreCase("advisoryNoteMinor")) {
						String filePath = contractHelper.getContractFilePath(contractDoc);
						File file1 = new File(filePath);
						doc1 = PDDocument.load(file1);
						PDFmerger.addSource(file1);
						doc1.close();
					}
				}

			}
			PDFmerger.mergeDocuments();
			File mergedFile = new File(destFilePath);

			long fileEntryId = saveDocument("Contract", ds.getLoggedInUserId(),ds.getCompanyId(), mergedFile, ds.getRequestData().getScopeGroupId());

			// ds.setMergedContractFileEntryId(fileEntryId);
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
			String previewFileURL = DLUtil.getPreviewURL(fileEntry,fileEntry.getFileVersion(), null, "");
			// ds.setMergedContractUrl(previewFileURL);
			storeNodeData(previewNode, processStateDataAdapter,"previewFileUrl", previewFileURL);
			return previewFileURL;
		} catch (Exception e) {
			_log.error(e.getMessage());
			return null;
		}
	}
	
	public static String getFilePath(PEDataSource ds, String prefix) {
		String fileName = prefix + ".pdf"; // + ds.getApplicant().getUserId() + "_" + System.currentTimeMillis() +".pdf";
		StringBundler sb = new StringBundler(5);

		sb.append(SystemProperties.get(SystemProperties.TMP_DIR));
		sb.append("/liferay/");
		sb.append(fileName);
		
		return sb.toString();
	}
	
	
	public static long saveDocument(String folderName,long userId, long liferayCompanyId, File document, long groupId) throws UploadException, FileNotFoundException{
    	FileInputStream in = new FileInputStream(document);
    	long size = document.length();
    	return saveDocument(folderName,userId, groupId, liferayCompanyId,document, document.getName(), StringPool.BLANK, document.getName(), in, size);
    }

    public static long saveDocument(String folderName, long userId, long groupId, long liferayCompanyId, File file, String documentName, 
    		String documentDescription, String documentTitle, InputStream is, long size) throws UploadException{
    	
    	try {
    		
    		//get default folder storage
            DLFolder folder = getDefaultGroupFolder(folderName, userId, liferayCompanyId, groupId);
           
            String changeLog = StringPool.BLANK;
            ServiceContext serviceContext = new ServiceContext();
            try{
        		if (is == null) {
        			is = new UnsyncByteArrayInputStream(new byte[0]);
        			size = 0;
        		}

	            DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId, groupId, folder.getFolderId(), 
						   documentName, null, documentTitle, documentDescription, changeLog,
			0, null, file, is, size, serviceContext);

	            //add role...
				long guestRoleId = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(), RoleConstants.GUEST).getRoleId();
				if (!ResourcePermissionLocalServiceUtil.hasResourcePermission(fileEntry.getCompanyId(), DLFileEntry.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getFileEntryId()), guestRoleId, ActionKeys.VIEW)) {
					String[] actionIds = {ActionKeys.VIEW};
					ResourcePermissionLocalServiceUtil.setResourcePermissions(fileEntry.getCompanyId(), DLFileEntry.class.getName(),
							ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getFileEntryId()), guestRoleId, actionIds);

				}
	            //end add role...
				_log.debug(fileEntry.getUuid());
	            return fileEntry.getFileEntryId();
            }catch(DuplicateFileException e) {
            	_log.warn("Throw DuplicateFileException");
            	DLFolder folder1 = getDefaultGroupFolder(folderName, userId, liferayCompanyId, groupId);
            	DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folder1.getFolderId(), documentName);
            	DLFileEntryLocalServiceUtil.deleteFileEntry(fileEntry);
            	
            	return saveDocument( folderName,userId, groupId, liferayCompanyId, file, documentName,
            			documentDescription, documentTitle, null, 0);//delete file and save again
            }

        } catch (Exception e) {
        	_log.error(e.getMessage());
            throw new UploadException(e);
        }
    }

    public static DLFolder getDefaultGroupFolder(String folderName, long userId, long liferayCompanyId, long groupId) throws UploadException, NoSuchFolderException {
        return getDefaultGroupFolder(folderName, userId, liferayCompanyId, false, groupId);
    }

    @SuppressWarnings("deprecation")
	private static DLFolder getDefaultGroupFolder(String yourfolderName, long userId, long companyId, boolean checkExistance, long groupId) throws UploadException, NoSuchFolderException {
        long parentFolderId = 0L;
        String folderName = yourfolderName;
        String folderDescription="";
        ServiceContext serviceContext = new ServiceContext();

        //create folder if not exists
        try {

        	DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);

            //add role...
			long guestRoleId = RoleLocalServiceUtil.getRole(dlFolder.getCompanyId(), RoleConstants.GUEST).getRoleId();
        	if (!ResourcePermissionLocalServiceUtil.hasResourcePermission(dlFolder.getCompanyId(), DLFolder.class.getName(),
        			ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(dlFolder.getFolderId()), guestRoleId, ActionKeys.ACCESS)) {
    			String[] actionIds = {ActionKeys.ACCESS};
    			ResourcePermissionLocalServiceUtil.setResourcePermissions(dlFolder.getCompanyId(), DLFolder.class.getName(),
    					ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(dlFolder.getFolderId()), guestRoleId, actionIds);
        	}
            //end add role...
			return dlFolder;

        } catch (NoSuchModelException e) {
            _log.debug("Default folder does not exists");

            if (checkExistance) {
                throw new NoSuchFolderException(e);
            }
        } catch (Exception e) {
            throw new UploadException(e);
        }

        try {

        	DLFolder dlFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, ParamUtil.getBoolean(serviceContext, "mountPoint"),
    				parentFolderId, folderName, folderDescription, serviceContext);

            //add role...
			long guestRoleId = RoleLocalServiceUtil.getRole(dlFolder.getCompanyId(), RoleConstants.GUEST).getRoleId();
        	if (!ResourcePermissionLocalServiceUtil.hasResourcePermission(dlFolder.getCompanyId(), DLFolder.class.getName(),
        			ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(dlFolder.getFolderId()), guestRoleId, ActionKeys.ACCESS)) {
    			String[] actionIds = {ActionKeys.ACCESS};
    			ResourcePermissionLocalServiceUtil.setResourcePermissions(dlFolder.getCompanyId(), DLFolder.class.getName(),
    					ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(dlFolder.getFolderId()), guestRoleId, actionIds);
        	}
            //end add role...

            return dlFolder;

        } catch (Exception ex) {
            throw new UploadException(ex);
        }
    }


	private static Log _log = LogFactoryUtil.getLog(PEPreviewHandler.class);

}