package com.sambaash.platform.activityhub.helper;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;

import org.apache.commons.lang.time.DateUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserConstants;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.URLUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.sambaash.platform.activityhub.constants.SPActivityHubConstants;
import com.sambaash.platform.activityhub.indexer.SPConversationIndexer;
import com.sambaash.platform.activityhub.notification.SPActivityHubNotificationConstants;
import com.sambaash.platform.srv.model.Conversation;
import com.sambaash.platform.srv.model.ConversationUser;
import com.sambaash.platform.srv.model.LogActivity;
import com.sambaash.platform.srv.model.Note;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.service.ConversationLocalServiceUtil;
import com.sambaash.platform.srv.service.ConversationUserLocalServiceUtil;
import com.sambaash.platform.srv.service.LogActivityLocalServiceUtil;
import com.sambaash.platform.srv.service.NoteLocalServiceUtil;
import com.sambaash.platform.srv.service.persistence.ConversationUtil;
import com.sambaash.platform.util.SambaashUtil;


public class SPActivityHubHelper {

	public static final Log _log = LogFactoryUtil
			.getLog(SPActivityHubHelper.class);
	
	public static SPActivityHubHelper getInstance(){
		return new SPActivityHubHelper();
	}
	
	public static JSONObject saveConversation(PortletRequest request){
		
		JSONObject data = JSONFactoryUtil.createJSONObject();
		
		Conversation conversation;
		ConversationUser conversationUser;
		long spConversationId;
		long spConversationUserId;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			// insert into conversaation table
			spConversationId = CounterLocalServiceUtil.increment(Conversation.class.getName());
			conversation = ConversationUtil.create(spConversationId);
			
			String message = ParamUtil.getString(request, SPActivityHubConstants.MESSAGE);
			String entityId = ParamUtil.getString(request, SPActivityHubConstants.ENTITY_ID);
			String entityClassId = ParamUtil.getString(request, SPActivityHubConstants.ENTITY_CLASS_ID);
			String entityClassName = ParamUtil.getString(request, SPActivityHubConstants.ENTITY_CLASS_NAME);
			String associatedWith = ParamUtil.getString(request, SPActivityHubConstants.ASSOCIATED_WITH);
			String uploadsFileEntryId = ParamUtil.getString(request, SPActivityHubConstants.UPLOADS_FILE_ENTRY_ID);
			String sentToUserId = ParamUtil.getString(request, SPActivityHubConstants.SENT_TO_USER_ID);
			String restricted = ParamUtil.getString(request, SPActivityHubConstants.RESTRICTED);
			
			
			
			if (uploadsFileEntryId.startsWith("0,")){
				uploadsFileEntryId = uploadsFileEntryId.substring(2);
			}
			
			
			conversation.setMessage(message);
			conversation.setEntityId(Long.valueOf(entityId));
			conversation.setEntityClassId(Long.valueOf(entityClassId));
			conversation.setEntityClassName(entityClassName);
			conversation.setSentByUserId(themeDisplay.getUserId());
			conversation.setFileEntryId(uploadsFileEntryId);
			conversation.setRestricted(GetterUtil.getInteger(restricted));
			
			conversation.setStatus(1);
			if (Validator.isNull(associatedWith)){
				conversation.setAssociatedWith(0);
			}else {
				conversation.setAssociatedWith(Long.valueOf(associatedWith));
			}
			
			// fetch the parent conversation
			Conversation parentConversation = ConversationLocalServiceUtil.fetchByentityClassIdEntityIdParentConverstationId(Long.valueOf(entityClassId), Long.valueOf(entityId), 0);
			if (Validator.isNotNull(parentConversation)){
				conversation.setParentConverstationId(parentConversation.getSpConversationId());
			}else{
				conversation.setParentConverstationId(0);
			}
			
			SambaashUtil.fillAudit(conversation, themeDisplay, conversation.isNew());			
			
			
			
			// insert into conversationUser table
			if (Validator.isNotNull(sentToUserId)){
			List<String> sentToUserIdList = Arrays.asList(sentToUserId.split(","));
				for (String sentToUserIdStr : sentToUserIdList){
					if (Validator.isNotNull(sentToUserIdStr)){
						spConversationUserId = CounterLocalServiceUtil.increment(ConversationUser.class.getName());
						conversationUser = ConversationUserLocalServiceUtil.createConversationUser(spConversationUserId);
			
						conversationUser.setEntityClassId(Long.valueOf(entityClassId));
						conversationUser.setEntityId(Long.valueOf(entityId));
						conversationUser.setStatus(1);
						conversationUser.setSpConversationId(spConversationId);
						conversationUser.setSentToUserId(GetterUtil.getLong(sentToUserIdStr));
						ConversationUserLocalServiceUtil.updateConversationUser(conversationUser);
					}
				}
			}else{
				spConversationUserId = CounterLocalServiceUtil.increment(ConversationUser.class.getName());
				conversationUser = ConversationUserLocalServiceUtil.createConversationUser(spConversationUserId);
		
				conversationUser.setEntityClassId(Long.valueOf(entityClassId));
				conversationUser.setEntityId(Long.valueOf(entityId));
				conversationUser.setStatus(1);
				conversationUser.setSpConversationId(spConversationId);
				conversationUser.setSentToUserId(0);
				ConversationUserLocalServiceUtil.updateConversationUser(conversationUser);
			}
			
			
			conversation.setCurrentPlId(themeDisplay.getPlid());
			ConversationLocalServiceUtil.updateConversation(conversation);
			
			data.put("msg", "Message sent");
			
			sendNotification(request, themeDisplay, conversation);
			
		} catch (SystemException e) {
			_log.error(e);
			data.put("error", "Error while sending message");
		}

		
		return data;
		
	}
	
	public static JSONObject saveNote(PortletRequest request){
		
		JSONObject data = JSONFactoryUtil.createJSONObject();
		
		Note note;
		long spNoteId;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			// insert into SPNote table
			spNoteId = CounterLocalServiceUtil.increment(Note.class.getName());
			note = NoteLocalServiceUtil.createNote(spNoteId);
			
			String noteTitle = ParamUtil.getString(request, SPActivityHubConstants.NOTE_TITLE);
			String noteContent = ParamUtil.getString(request, SPActivityHubConstants.NOTE_CONTENT);
			String entityId = ParamUtil.getString(request, SPActivityHubConstants.ENTITY_ID);
			String entityClassId = ParamUtil.getString(request, SPActivityHubConstants.ENTITY_CLASS_ID);
			String entityClassName = ParamUtil.getString(request, SPActivityHubConstants.ENTITY_CLASS_NAME);
			String associatedWith = ParamUtil.getString(request, SPActivityHubConstants.ASSOCIATED_WITH);
			String uploadsFileEntryId = ParamUtil.getString(request, SPActivityHubConstants.UPLOADS_FILE_ENTRY_ID);

			
			
			
			if (uploadsFileEntryId.startsWith("0,")){
				uploadsFileEntryId = uploadsFileEntryId.substring(2);
			}
			
			note.setNoteTitle(noteTitle);
			note.setNoteContent(noteContent);
			note.setEntityId(Long.valueOf(entityId));
			note.setEntityClassId(Long.valueOf(entityClassId));
			note.setEntityClassName(entityClassName);
			note.setSavedByUserId(themeDisplay.getUserId());
			note.setFileEntryId(uploadsFileEntryId);
			
			note.setStatus(1);
			if (Validator.isNull(associatedWith)){
				note.setAssociatedWith(0);
			}else {
				note.setAssociatedWith(Long.valueOf(associatedWith));
			}
			
			// fetch the parent note
			Note parentNote = NoteLocalServiceUtil.fetchByentityClassIdEntityIdParentNoteId(Long.valueOf(entityClassId), Long.valueOf(entityId), 0);
			if (Validator.isNotNull(parentNote)){
				note.setParentNoteId(parentNote.getSpNoteId());
			}else{
				note.setParentNoteId(0);
			}
			
			SambaashUtil.fillAudit(note, themeDisplay, note.isNew());			

			
			NoteLocalServiceUtil.updateNote(note);
			
			data.put("msg", "Note added");
			
		} catch (SystemException e) {
			_log.error(e);
			data.put("error", "Error while sending message");
		}

		
		return data;
		
	}
	
	
	public static JSONObject saveLogActivity(PortletRequest request){
		
		JSONObject data = JSONFactoryUtil.createJSONObject();
		
		LogActivity logActivity;
		long spLogActivityId;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			// insert into SPNote table
			spLogActivityId = CounterLocalServiceUtil.increment(LogActivity.class.getName());
			logActivity = LogActivityLocalServiceUtil.createLogActivity(spLogActivityId);
			
			String activityType = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_TYPE);
			String activityOutcome = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_OUTCOME);
			String activityDate = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_DATE);
			String activityTime = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_TIME);
			String activityTitle = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_TITLE);
			String activityContent = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_CONTENT);
			String entityId = ParamUtil.getString(request, SPActivityHubConstants.ENTITY_ID);
			String entityClassId = ParamUtil.getString(request, SPActivityHubConstants.ENTITY_CLASS_ID);
			String entityClassName = ParamUtil.getString(request, SPActivityHubConstants.ENTITY_CLASS_NAME);
			String associatedWith = ParamUtil.getString(request, SPActivityHubConstants.ASSOCIATED_WITH);
			String uploadsFileEntryId = ParamUtil.getString(request, SPActivityHubConstants.UPLOADS_FILE_ENTRY_ID);

			
			
			
			if (uploadsFileEntryId.startsWith("0,")){
				uploadsFileEntryId = uploadsFileEntryId.substring(2);
			}
			
			logActivity.setActivityTitle(activityTitle);
			logActivity.setActivityContent(activityContent);
			logActivity.setEntityId(Long.valueOf(entityId));
			logActivity.setEntityClassId(Long.valueOf(entityClassId));
			logActivity.setEntityClassName(entityClassName);
			logActivity.setSavedByUserId(themeDisplay.getUserId());
			logActivity.setFileEntryId(uploadsFileEntryId);
			logActivity.setActivityType(activityType);
			logActivity.setActivityOutcome(activityOutcome);
			logActivity.setActivityDate(getDate4rDDMMYYYY(activityDate));
			logActivity.setActivityTime(activityTime);
			
			logActivity.setStatus(1);
			if (Validator.isNull(associatedWith)){
				logActivity.setAssociatedWith(0);
			}else {
				logActivity.setAssociatedWith(Long.valueOf(associatedWith));
			}
			
			// fetch the parent note
			LogActivity parentLogActivity = LogActivityLocalServiceUtil.fetchByentityClassIdEntityIdParentLogActivityId(Long.valueOf(entityClassId), Long.valueOf(entityId), 0);
			if (Validator.isNotNull(parentLogActivity)){
				logActivity.setParentLogActivityId(parentLogActivity.getSpLogActivityId());
			}else{
				logActivity.setParentLogActivityId(0);
			}
			
			SambaashUtil.fillAudit(logActivity, themeDisplay, logActivity.isNew());	
			
			logActivity.setCreateDate(getDateTime4rDDMMYYYY(activityDate + " " + activityTime));

			
			LogActivityLocalServiceUtil.updateLogActivity(logActivity);
			
			data.put("msg", "Log Activity added");
			
		} catch (SystemException e) {
			_log.error(e);
			data.put("error", "Error while sending message");
		}

		
		return data;
		
	}
	
	public static Date getDate4rDDMMYYYY(String str){
		if(Validator.isNotNull(str)){
			try{
				String format = "dd/MM/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				Date date = df.parse(str);
				return date;
			}catch(Exception ex){
				_log.error("Error while format String to date. String=" + str);
			}
			
		}
		return null;
	}
	
	public static Date getDateTime4rDDMMYYYY(String str){
		if(Validator.isNotNull(str)){
			try{
				String format = "dd/MM/yyyy HH:mm";
				SimpleDateFormat df = new SimpleDateFormat(format);
				Date date = df.parse(str);
				return date;
			}catch(Exception ex){
				_log.error("Error while format String to date. String=" + str);
			}
			
		}
		return null;
	}
	
	
	public static void sendNotification(PortletRequest request, ThemeDisplay themeDisplay, Conversation conversation){
		try {
			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
			User user = UserLocalServiceUtil.getUser(conversation.getSentByUserId());
			payloadJSON.put(Field.USER_ID, themeDisplay.getUserId());
			payloadJSON.put(SPActivityHubNotificationConstants.USER_NAME, user.getFullName());
			payloadJSON.put(SPActivityHubNotificationConstants.ACTIVITYHUB_LINK, displayConversationURL(themeDisplay, conversation));
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

			Date now = new Date();
			List<ConversationUser> convUserList = ConversationUserLocalServiceUtil.findByspConversationId(conversation.getSpConversationId());
			
			for (ConversationUser convUser : convUserList) {
				if (convUser.getSentToUserId() > 0){
					UserNotificationEventLocalServiceUtil
							.addUserNotificationEvent(convUser.getSentToUserId(), SPActivityHubConstants.PORTLET_ID,
									now.getTime(), themeDisplay.getUserId(),
									payloadJSON.toString(), false, serviceContext);
				}
			}
		} catch (Exception e) {
			_log.error("Error while sending notification", e);
		}
	}
	
	public static String displayConversationURL(ThemeDisplay themeDisplay,Conversation conversation) {
		try {
			if (conversation.getEntityClassName().contains("ProcessState")){
				if (conversation.getEntityId() == 0){
					Layout selectedLayout = LayoutLocalServiceUtil.getLayout(conversation.getCurrentPlId());
					String friendlyUrl = selectedLayout.getFriendlyURL() + "?convUuid="+conversation.getUuid();
					return friendlyUrl;
				}else{
					User loggedInUser = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
					String applUrl = PEEngineLocalServiceUtil.getApplicationDisplayFriendlyUrl(loggedInUser, conversation.getEntityId(), themeDisplay);
					String friendlyUrl = applUrl + "?convUuid="+conversation.getUuid();
					return friendlyUrl;
				}
			}
		}
		catch (Exception e){
			_log.error(e);
		}
		return null;
		
	}
	
	public static String getDateStrddMMYYYY(Date date){
		if(Validator.isNotNull(date)){
			try{
				String format = "dd/MM/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				return df.format(date);
			}catch(Exception ex){
				_log.error("Error while format date to String=" + date);
			}
		}
		return StringPool.BLANK;
	}
	

	public static List<Document> convertToList(Hits results) {

		Document[]docs = results.getDocs();
		List<Document> list = ListUtil.fromArray(docs);

		return list;
	}
	
	public static JSONObject searchConversation(PortletRequest request) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		

		Hits results = null;
		try {
			results = search(Conversation.class.getName(),request, -1, -1);
			if (Validator.isNotNull(results)){
				responseData.put("total", results.getLength());
			}
			
			
		
		List<Document> docsList = convertToList(results);

		
		JSONArray conversations = JSONFactoryUtil.createJSONArray();

		long conversationId;
		JSONObject conversationJson;
		
		for (Document doc : docsList) {
			conversationJson = JSONFactoryUtil.createJSONObject();

			conversationId = GetterUtil.getLong(doc.get(SPActivityHubConstants.SP_CONVERSATION_ID));
			
			conversationJson.put("convId", conversationId);
			
			conversationJson.put("msg", doc.get(SPActivityHubConstants.MESSAGE));
			conversationJson.put("createDate", changeDateFormat(doc.getDate(SPActivityHubConstants.CREATE_DATE)));	
			
			Conversation conversation =  ConversationLocalServiceUtil.getConversation(conversationId);
			
			String caption = conversationCaption(conversation, themeDisplay.getUserId());
			conversationJson.put("caption", caption);
			
			conversationJson.put("uuid", doc.get(SPActivityHubConstants.CONV_UUID));
			
			//attachment details - begin
			if (!doc.get(SPActivityHubConstants.FILE_ENTRY_ID).equalsIgnoreCase("0")){
				List<String> fileEntryIdArr = Arrays.asList(conversation.getFileEntryId().split(","));
				JSONArray attachmentsArr = JSONFactoryUtil.createJSONArray();
				for(String fileEntryId : fileEntryIdArr){
					JSONObject attachmentsObj = JSONFactoryUtil.createJSONObject();
					if (Long.valueOf(fileEntryId) > 0){
						FileEntry fileEntry;
						fileEntry = DLAppServiceUtil.getFileEntry(Long.valueOf(fileEntryId));
						String url = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), null, "");
						attachmentsObj.put("fileName", fileEntry.getTitle());
						attachmentsObj.put("downloadUrl", url);
						attachmentsObj.put("fileSize", fileEntry.getSize()+" KB");
						attachmentsArr.put(attachmentsObj);
					}
				}
				conversationJson.put("attachments", attachmentsArr);
				conversationJson.put("numberOfAttachments", attachmentsArr.length());
			}
			//attachment details - end
			
			
			//user profile images - begin			
			if (Validator.isNotNull(doc.get(SPActivityHubConstants.SENT_TO_USER_ID))){
				List<String> sentToUserIdArr = Arrays.asList(doc.get(SPActivityHubConstants.SENT_TO_USER_ID).split(","));
				JSONArray convosRecipients = JSONFactoryUtil.createJSONArray();
				for(String sentToUserId : sentToUserIdArr){
					sentToUserId = sentToUserId.replace(" ", "");
					if (Long.valueOf(sentToUserId) > 0){
					User user = UserLocalServiceUtil.getUser(GetterUtil.getLong(sentToUserId));
					convosRecipients.put(UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, user.getPortraitId()));	//fetch the profile URL
					}
				}
				conversationJson.put("numberOfRecipients", sentToUserIdArr.size());
				conversationJson.put("recipientProfileImagePath", convosRecipients);
			}
			//user profile images - end
			
			conversations.put(conversationJson);
			
		}

		responseData.put("conversations", conversations);
		
		} catch (Exception e1) {
			_log.error(e1);
			responseData.put("error", "Unable to get the results");
		}
		return responseData;
	}
	
	public static String checkInternalOrExternal(PortletRequest request, User user){
		String result = StringPool.BLANK;
		PortletPreferences portletPreferences = request.getPreferences();
		try {
			String internalRoleIds = GetterUtil.getString(portletPreferences.getValue(SPActivityHubConstants.PREF_INTERNAL_ROLE_IDS, "0")).replace(" ", "");
			String externalRoleIds = GetterUtil.getString(portletPreferences.getValue(SPActivityHubConstants.PREF_EXTERNAL_ROLE_IDS, "0")).replace(" ", "");
		
			String[] internalRoleIdsArr = internalRoleIds.split(StringPool.COMMA);
			String[] externalRoleIdsArr = externalRoleIds.split(StringPool.COMMA);
		
			List<Role> roles = user.getRoles();
		
			for (Role role : roles){
				if (ArrayUtil.contains(internalRoleIdsArr,String.valueOf(role.getRoleId()))){
					result = "Internal";
					return result;
				}
			}
		
			for (Role role : roles){
				if (ArrayUtil.contains(externalRoleIdsArr,String.valueOf(role.getRoleId()))){
					result = "External";
					return result;
				}
			}
		} catch (Exception e){
			_log.error(e);
		}
		
		return result;

	}
	
	public static Hits search(String className, PortletRequest request, int start, int end) throws SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		

		SearchContext searchContext = new SearchContext();
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setCompanyId(themeDisplay.getCompanyId());

		Sort sort = SortFactoryUtil.create(Field.CREATE_DATE, Sort.LONG_TYPE, true);
		Sort[] sorts = new Sort[] { sort };

		searchContext.setSorts(sorts);

		List<BooleanClause> bcs = new ArrayList<BooleanClause>();

		BooleanClause bc = null;
		
		
		//Filter for Active conversations. By default active conversations must be displayed.
		String activeStatus = "1";
		bc = null;
		if(Validator.isNotNull(activeStatus) && !activeStatus.equalsIgnoreCase("-1")){
			bc = getBC4ExactTerm(SPActivityHubConstants.STATUS, String.valueOf(activeStatus), searchContext);
		}
		
		if(bc != null){
			bcs.add(bc);
		}
		
		//filter for entityId and entityClassId
		bc = getBCEntity(request, searchContext);
		if(bc != null){
			bcs.add(bc);
		}
      
		long loggedInUserId = themeDisplay.getUserId();
		if (className.equalsIgnoreCase(Conversation.class.getName())){
		//check for internal or external user 
			String userType = checkInternalOrExternal(request, themeDisplay.getUser());
			if (userType.equalsIgnoreCase("Internal")){
				if (loggedInUserId >= 0) {
					bcs.add(getBC4Terms(
						new String[] { "sentToUserId", "sentByUserId" },
						String.valueOf(loggedInUserId), searchContext));
				}
			}else if (userType.equalsIgnoreCase("External")){
				bc = null;
				if(Validator.isNotNull(loggedInUserId) && loggedInUserId > 0){
					bc = getBC4ExactTerm(SPActivityHubConstants.ASSOCIATED_WITH, String.valueOf(loggedInUserId), searchContext);
				}
					
				if(bc != null){
					bcs.add(bc);
				}
			
				bc = null;
				if(Validator.isNotNull(loggedInUserId) && loggedInUserId > 0){
					bc = getBC4ExactTerm(SPActivityHubConstants.RESTRICTED, "0", searchContext);
				}
					
				if(bc != null){
					bcs.add(bc);
				}
			}
		}else if (className.equalsIgnoreCase(Note.class.getName()) || className.equalsIgnoreCase(LogActivity.class.getName())){
			bc = null;
			if(Validator.isNotNull(loggedInUserId) && loggedInUserId > 0){
				bc = getBC4ExactTerm(SPActivityHubConstants.SAVED_BY_USER_ID, String.valueOf(loggedInUserId), searchContext);
			}
				
			if(bc != null){
				bcs.add(bc);
			}
		}
		
		String text = ParamUtil.getString(request, "searchText");
		if (Validator.isNotNull(text)) {
			bc = getSearchTextQuery(searchContext, text);
			if (bc != null) {
				bcs.add(bc);
			}
		}

		if (bcs.size() > 0) {
			searchContext.setBooleanClauses(bcs.toArray(new BooleanClause[bcs.size()]));
		}

		/** End -- Preparing search context */

		// Let's make search

		Hits results = search(className, searchContext);

		

		return results;
	}
	
	
	
	public static BooleanClause getBC4Terms(String fields[], String val, SearchContext searchContext) throws PortalException, SystemException {
		BooleanClause bc = null;
		
		if (fields != null && fields.length > 0) {
			BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
			for (String field : fields) {
				try {
					if (field.equalsIgnoreCase(SPActivityHubConstants.SENT_TO_USER_ID)){
						String emailAddress = UserLocalServiceUtil.getUser(GetterUtil.getLong(val)).getEmailAddress();
						String[] searchableFields = { SPActivityHubConstants.SENT_TO_USER_EMAIL_SEARCHABLE };
						bq.addTerms(searchableFields, SPConversationIndexer.getSearchableString(emailAddress), true);
						String searchableFields2 = SPActivityHubConstants.SENT_TO_USER_ID;
						bq.addTerm(searchableFields2, "\"" + 0 +"\"");
					}else{
						bq.addTerm(field, "\"" + val +"\"");
					}
				} catch (ParseException e) {
					_log.error("Error while adding term to boolean clause ",e);
				}
			}
			bc = BooleanClauseFactoryUtil.create(searchContext, bq,
					BooleanClauseOccur.MUST.getName());
		}
		
		return bc;
	} 
	
	private static BooleanClause getSearchTextQuery(SearchContext searchContext, String text)
			throws SystemException, ParseException {
		// optional search text
		BooleanClause bc = null;
		if (Validator.isNotNull(text)) {
			BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);
			String[] searchableFields = { "searchableContent" };
			query.addTerms(searchableFields, SPConversationIndexer.getSearchableString(text), true);
			if (query.hasClauses()) {
				bc = BooleanClauseFactoryUtil.create(searchContext, query, BooleanClauseOccur.MUST.getName());
			}
		}
		return bc;
	}
	
	
	private static BooleanClause getBCEntity(PortletRequest request,
			SearchContext searchContext) {
		BooleanClause bc = null;
		String entityIdStr = ParamUtil.getString(request, SPActivityHubConstants.ENTITY_ID);
		String entityClassIdStr = ParamUtil.getString(request, SPActivityHubConstants.ENTITY_CLASS_ID);
		long entityId = 0;
		BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);
		if (Validator.isNotNull(entityClassIdStr)) {
			long entityClassId = GetterUtil.getLong(entityClassIdStr);
			if (entityClassId > 0) {
				query.addRequiredTerm(SPActivityHubConstants.ENTITY_CLASS_ID, entityClassId);
			}
		}
		if (Validator.isNotNull(entityIdStr)) {
			entityId = GetterUtil.getLong(entityIdStr);
		}

		query.addRequiredTerm(SPActivityHubConstants.ENTITY_ID, entityId);
		
		bc = BooleanClauseFactoryUtil.create(searchContext, query,BooleanClauseOccur.MUST.getName());
		return bc;
	}
	
	public static BooleanClause getBC4ExactTerm(String field, String val, SearchContext searchContext) {
		BooleanClause bc = null;

		if (Validator.isNotNull(field)) {
			BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
			bq.addExactTerm(field, "\"" + val +"\"");
			bc = BooleanClauseFactoryUtil.create(searchContext, bq,
					BooleanClauseOccur.MUST.getName());
		}

		return bc;
	}
	
	
	public static Hits search(String className, SearchContext searchContext) {

		Indexer indexer = IndexerRegistryUtil.getIndexer(className);
		Hits results = null;
		try {
			results = indexer.search(searchContext);
			_log.debug("Search Query " + results.getQuery());
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}

		return results;
	}
	
	public static JSONObject searchNote(PortletRequest request) {

		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		

		Hits results = null;
		try {
			results = search(Note.class.getName(), request, -1, -1);
			if (Validator.isNotNull(results)){
				responseData.put("total", results.getLength());
			}
		
		List<Document> docsList = convertToList(results);

		
		JSONArray notes = JSONFactoryUtil.createJSONArray();

		long noteId;
		JSONObject noteJson;
		
		for (Document doc : docsList) {
			noteJson = JSONFactoryUtil.createJSONObject();

			noteId = GetterUtil.getLong(doc.get(SPActivityHubConstants.SP_NOTE_ID));
			
			noteJson.put("noteId", noteId);
			noteJson.put("noteTitle", doc.get(SPActivityHubConstants.NOTE_TITLE));
			noteJson.put("noteContent", doc.get(SPActivityHubConstants.NOTE_CONTENT));
			noteJson.put("createDate", changeDateFormat(doc.getDate(SPActivityHubConstants.CREATE_DATE)));	
			
			Note note =  NoteLocalServiceUtil.getNote(noteId);
			
			String caption = noteCaption(note);
			noteJson.put("caption", caption);
			
			//attachment details - begin
			if (!doc.get(SPActivityHubConstants.FILE_ENTRY_ID).equalsIgnoreCase("0")){
				List<String> fileEntryIdArr = Arrays.asList(note.getFileEntryId().split(","));
				JSONArray attachmentsArr = JSONFactoryUtil.createJSONArray();
				for(String fileEntryId : fileEntryIdArr){
					JSONObject attachmentsObj = JSONFactoryUtil.createJSONObject();
					if (Long.valueOf(fileEntryId) > 0){
						FileEntry fileEntry;
						fileEntry = DLAppServiceUtil.getFileEntry(Long.valueOf(fileEntryId));
						String url = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), null, "");
						attachmentsObj.put("fileName", fileEntry.getTitle());
						attachmentsObj.put("downloadUrl", url);
						attachmentsObj.put("fileSize", fileEntry.getSize()+" KB");
						attachmentsArr.put(attachmentsObj);
					}
				}
				noteJson.put("attachments", attachmentsArr);
				noteJson.put("numberOfAttachments", attachmentsArr.length());
			}
			//attachment details - end

			
			notes.put(noteJson);
			
		}

		responseData.put("notes", notes);
		
		} catch (Exception e1) {
			_log.error(e1);
			responseData.put("error", "Unable to get the results");
		}
		return responseData;
	}
	
	public static JSONObject searchLogActivity(PortletRequest request) {

		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		Hits resultsLogActivty = null;
		Hits resultsNote = null;
		Hits resultsConversation = null;
		List<Document> finalResultList = new ArrayList<Document>();
		try {
			resultsLogActivty = search(LogActivity.class.getName(), request, -1, -1);
			resultsNote = search(Note.class.getName(), request, -1, -1);
			resultsConversation = search(Conversation.class.getName(), request, -1, -1);
			
			
		
		List<Document> docsListLogActivity = convertToList(resultsLogActivty);
		List<Document> docsListNote = convertToList(resultsNote);
		List<Document> docsListConversation = convertToList(resultsConversation);

		finalResultList.addAll(docsListLogActivity);
		finalResultList.addAll(docsListNote);
		finalResultList.addAll(docsListConversation);
		
		if (Validator.isNotNull(finalResultList)){
			responseData.put("total", finalResultList.size());
		}
		
		
		Comparator<Document> comparator = new Comparator<Document>() {

			@Override
			public int compare(Document o1, Document o2) {
				try {
					return o1.getDate(SPActivityHubConstants.CREATE_DATE).compareTo(o2.getDate(SPActivityHubConstants.CREATE_DATE));
				} catch (java.text.ParseException e) {
					_log.error(e);
					return 0;
				}
				
			}
		};
		

		
		Collections.sort(finalResultList, comparator);
		Collections.reverse(finalResultList);
		
		JSONArray logActivities = JSONFactoryUtil.createJSONArray();

		long logActivityId = 0;
		JSONObject logActivityJson;
		List<String> fileEntryIdArr = new ArrayList<String>();
		
		for (Document doc : finalResultList) {
			logActivityJson = JSONFactoryUtil.createJSONObject();

			if(doc.get(SPActivityHubConstants.CLASS_NAME).equalsIgnoreCase(Conversation.class.getName())){
				logActivityId = GetterUtil.getLong(doc.get(SPActivityHubConstants.SP_CONVERSATION_ID));
				logActivityJson.put("logActivityTitle", StringPool.BLANK);
				logActivityJson.put("logActivityContent", doc.get(SPActivityHubConstants.MESSAGE));
				logActivityJson.put("logActivityOutcome", StringPool.BLANK);
				logActivityJson.put("logActivityType", StringPool.BLANK);
				logActivityJson.put("logActivityDate", StringPool.BLANK);
				logActivityJson.put("logActivityTime", StringPool.BLANK);
				Conversation conversation =  ConversationLocalServiceUtil.getConversation(logActivityId);
				String caption = conversationCaption(conversation, themeDisplay.getUserId());
				logActivityJson.put("caption", caption);
				fileEntryIdArr = Arrays.asList(conversation.getFileEntryId().split(","));
			}else if(doc.get(SPActivityHubConstants.CLASS_NAME).equalsIgnoreCase(Note.class.getName())){
				logActivityId = GetterUtil.getLong(doc.get(SPActivityHubConstants.SP_NOTE_ID));
				logActivityJson.put("logActivityTitle", doc.get(SPActivityHubConstants.NOTE_TITLE));
				logActivityJson.put("logActivityContent", doc.get(SPActivityHubConstants.NOTE_CONTENT));
				logActivityJson.put("logActivityOutcome", StringPool.BLANK);
				logActivityJson.put("logActivityType", StringPool.BLANK);
				logActivityJson.put("logActivityDate", StringPool.BLANK);
				logActivityJson.put("logActivityTime", StringPool.BLANK);
				Note note =  NoteLocalServiceUtil.getNote(logActivityId);
				String caption = noteCaption(note);
				logActivityJson.put("caption", caption);
				fileEntryIdArr = Arrays.asList(note.getFileEntryId().split(","));
			}else if(doc.get(SPActivityHubConstants.CLASS_NAME).equalsIgnoreCase(LogActivity.class.getName())){
				logActivityId = GetterUtil.getLong(doc.get(SPActivityHubConstants.SP_LOG_ACTIVITY_ID));
				logActivityJson.put("logActivityTitle", doc.get(SPActivityHubConstants.LOG_ACTIVITY_TITLE));
				logActivityJson.put("logActivityContent", doc.get(SPActivityHubConstants.LOG_ACTIVITY_CONTENT));
				logActivityJson.put("logActivityOutcome", doc.get(SPActivityHubConstants.LOG_ACTIVITY_OUTCOME));
				logActivityJson.put("logActivityType", doc.get(SPActivityHubConstants.LOG_ACTIVITY_TYPE));
				if (!doc.get(SPActivityHubConstants.LOG_ACTIVITY_DATE).equalsIgnoreCase("")){
					logActivityJson.put("logActivityDate", getDateStrddMMYYYY(doc.getDate(SPActivityHubConstants.LOG_ACTIVITY_DATE)));
				}else{
					logActivityJson.put("logActivityDate", StringPool.BLANK);
				}
				
				logActivityJson.put("logActivityTime", doc.get(SPActivityHubConstants.LOG_ACTIVITY_TIME));
				LogActivity logActivity =  LogActivityLocalServiceUtil.getLogActivity(logActivityId);
				String caption = logActivityCaption(logActivity);
				logActivityJson.put("caption", caption);
				fileEntryIdArr = Arrays.asList(logActivity.getFileEntryId().split(","));
			}
				
			
			logActivityJson.put("classNameResult", doc.get(SPActivityHubConstants.CLASS_NAME));
			logActivityJson.put("logActivityId", logActivityId);
			
			
			logActivityJson.put("createDate", changeDateFormat(doc.getDate(SPActivityHubConstants.CREATE_DATE)));	
			
			
			
			//attachment details - begin
			if (!doc.get(SPActivityHubConstants.FILE_ENTRY_ID).equalsIgnoreCase("0")){
				
				JSONArray attachmentsArr = JSONFactoryUtil.createJSONArray();
				for(String fileEntryId : fileEntryIdArr){
					JSONObject attachmentsObj = JSONFactoryUtil.createJSONObject();
					if (Long.valueOf(fileEntryId) > 0){
						FileEntry fileEntry;
						fileEntry = DLAppServiceUtil.getFileEntry(Long.valueOf(fileEntryId));
						String url = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), null, "");
						attachmentsObj.put("fileName", fileEntry.getTitle());
						attachmentsObj.put("downloadUrl", url);
						attachmentsObj.put("fileSize", fileEntry.getSize()+" KB");
						attachmentsArr.put(attachmentsObj);
					}
				}
				logActivityJson.put("attachments", attachmentsArr);
				logActivityJson.put("numberOfAttachments", attachmentsArr.length());
			}
			//attachment details - end

			
			logActivities.put(logActivityJson);
			
		}

		responseData.put("logActivities", logActivities);
		
		} catch (Exception e1) {
			_log.error(e1);
			responseData.put("error", "Unable to get the results");
		}
		return responseData;
	}


	

	public static JSONObject deleteConversation(PortletRequest request){
		
		JSONObject data = JSONFactoryUtil.createJSONObject();


		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			String convId = ParamUtil.getString(request, SPActivityHubConstants.CONV_ID);
			Conversation conversation = ConversationLocalServiceUtil.fetchConversation(Long.valueOf(convId));
			conversation.setStatus(0);
			
			SambaashUtil.fillAudit(conversation, themeDisplay, conversation.isNew());			
			ConversationLocalServiceUtil.updateConversation(conversation);
			
			List<ConversationUser> conversationUserList = ConversationUserLocalServiceUtil.findByspConversationId(Long.valueOf(convId));
			for(ConversationUser conversationUser : conversationUserList){
				conversationUser.setStatus(0);
				ConversationUserLocalServiceUtil.updateConversationUser(conversationUser);
			}
			

			
		} catch (SystemException e) {
			_log.error(e);
			data.put("error", "Error while deleting message");
		}

		data.put("msg", "Conversation Deleted");
		
		return data;
		
	}
	
	public static JSONObject deleteNote(PortletRequest request){
		
		JSONObject data = JSONFactoryUtil.createJSONObject();


		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			String noteId = ParamUtil.getString(request, SPActivityHubConstants.NOTE_ID);
			
			if(Validator.isNull(noteId)){
				noteId = request.getAttribute(SPActivityHubConstants.NOTE_ID).toString();
			}
			
			Note note = NoteLocalServiceUtil.fetchNote(Long.valueOf(noteId));
			note.setStatus(0);
			
			SambaashUtil.fillAudit(note, themeDisplay, note.isNew());			
			NoteLocalServiceUtil.updateNote(note);
			
		
			
		} catch (SystemException e) {
			_log.error(e);
			data.put("error", "Error while deleting note");
		}

		data.put("msg", "Note Deleted");
		
		return data;
		
	}
	
	public static JSONObject deleteLogActivity(PortletRequest request){
		
		JSONObject data = JSONFactoryUtil.createJSONObject();


		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			String logActivityId = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_ID);
			String classNameToUpdate = ParamUtil.getString(request, SPActivityHubConstants.CLASS_NAME_TO_UPDATE);

			if(classNameToUpdate.contains("Note")){
				request.setAttribute(SPActivityHubConstants.NOTE_ID, logActivityId);
				return deleteNote(request);
			}
			
			LogActivity logActivity = LogActivityLocalServiceUtil.fetchLogActivity(Long.valueOf(logActivityId));
			logActivity.setStatus(0);
			
			SambaashUtil.fillAudit(logActivity, themeDisplay, logActivity.isNew());			
			LogActivityLocalServiceUtil.updateLogActivity(logActivity);
			
		
			
		} catch (SystemException e) {
			_log.error(e);
			data.put("error", "Error while deleting activity");
		}

		data.put("msg", "Note Deleted");
		
		return data;
		
	}
	
	public static JSONObject restrictConversation(PortletRequest request){
		
		JSONObject data = JSONFactoryUtil.createJSONObject();


		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			String convId = ParamUtil.getString(request, SPActivityHubConstants.CONV_ID);
			Conversation conversation = ConversationLocalServiceUtil.fetchConversation(Long.valueOf(convId));
			conversation.setRestricted(1);
			
			SambaashUtil.fillAudit(conversation, themeDisplay, conversation.isNew());			
			ConversationLocalServiceUtil.updateConversation(conversation);
			
		} catch (SystemException e) {
			_log.error(e);
			data.put("error", "Error while restricting message");
		}

		data.put("msg", "Conversation Restricted");
		
		return data;
		
	}
	
	public static JSONObject updateNote(PortletRequest request){
		
		JSONObject data = JSONFactoryUtil.createJSONObject();

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			
			
			String noteId = ParamUtil.getString(request, SPActivityHubConstants.NOTE_ID);
			String noteTitle = ParamUtil.getString(request, SPActivityHubConstants.NOTE_TITLE);
			String noteContent = ParamUtil.getString(request, SPActivityHubConstants.NOTE_CONTENT);
			String uploadsFileEntryId = ParamUtil.getString(request, SPActivityHubConstants.UPLOADS_FILE_ENTRY_ID);
			String oldFileEntryId = StringPool.BLANK;

			if (Validator.isNull(noteId)){
				noteId = request.getAttribute(SPActivityHubConstants.NOTE_ID).toString();
				noteTitle = request.getAttribute(SPActivityHubConstants.NOTE_TITLE).toString();
				noteContent = request.getAttribute(SPActivityHubConstants.NOTE_CONTENT).toString();
				
			}
			Note note = NoteLocalServiceUtil.fetchNote(Long.valueOf(noteId));
			
			
			if (uploadsFileEntryId.startsWith("0,")){
				uploadsFileEntryId = uploadsFileEntryId.substring(2);
			}
			
			if (!note.getFileEntryId().equalsIgnoreCase("0")){
				oldFileEntryId = note.getFileEntryId();
				note.setFileEntryId(oldFileEntryId+","+uploadsFileEntryId);
			}else{
				note.setFileEntryId(uploadsFileEntryId);
			}
			
			note.setNoteTitle(noteTitle);
			note.setNoteContent(noteContent);
			note.setSavedByUserId(themeDisplay.getUserId());
			
			
			
			SambaashUtil.fillAudit(note, themeDisplay, note.isNew());			

			
			NoteLocalServiceUtil.updateNote(note);
			
			data.put("msg", "Note updated");
			
		} catch (SystemException e) {
			_log.error(e);
			data.put("error", "Error while updating note");
		}

		
		return data;
		
	}

		
	public static JSONObject updateLogActivity(PortletRequest request){
		
		JSONObject data = JSONFactoryUtil.createJSONObject();

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			
			
			String logActivityId = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_ID);
			String logActivityTitle = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_TITLE);
			String logActivityContent = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_CONTENT);
			String logActivityOutcome = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_OUTCOME);
			String uploadsFileEntryId = ParamUtil.getString(request, SPActivityHubConstants.UPLOADS_FILE_ENTRY_ID);
			String classNameToUpdate = ParamUtil.getString(request, SPActivityHubConstants.CLASS_NAME_TO_UPDATE);
			String logActivityDate = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_DATE);
			String logActivityTime = ParamUtil.getString(request, SPActivityHubConstants.LOG_ACTIVITY_TIME);
			
			String oldFileEntryId = StringPool.BLANK;

			if(classNameToUpdate.contains("Note")){
				request.setAttribute(SPActivityHubConstants.NOTE_ID, logActivityId);
				request.setAttribute(SPActivityHubConstants.NOTE_TITLE, logActivityTitle);
				request.setAttribute(SPActivityHubConstants.NOTE_CONTENT, logActivityContent);
				return updateNote(request);
			}
			
			LogActivity logActivity = LogActivityLocalServiceUtil.fetchLogActivity(Long.valueOf(logActivityId));
			
			
			if (uploadsFileEntryId.startsWith("0,")){
				uploadsFileEntryId = uploadsFileEntryId.substring(2);
			}
			
			if (!logActivity.getFileEntryId().equalsIgnoreCase("0")){
				oldFileEntryId = logActivity.getFileEntryId();
				logActivity.setFileEntryId(oldFileEntryId+","+uploadsFileEntryId);
			}else{
				logActivity.setFileEntryId(uploadsFileEntryId);
			}
			
			logActivity.setActivityTitle(logActivityTitle);
			logActivity.setActivityContent(logActivityContent);
			logActivity.setSavedByUserId(themeDisplay.getUserId());
			logActivity.setActivityOutcome(logActivityOutcome);
			logActivity.setActivityDate(getDate4rDDMMYYYY(logActivityDate));
			logActivity.setActivityTime(logActivityTime);
			
			
			
			SambaashUtil.fillAudit(logActivity, themeDisplay, logActivity.isNew());			
			logActivity.setCreateDate(getDateTime4rDDMMYYYY(logActivityDate + " " + logActivityTime));
			
			LogActivityLocalServiceUtil.updateLogActivity(logActivity);
			
			data.put("msg", "Activity updated");
			
		} catch (SystemException e) {
			_log.error(e);
			data.put("error", "Error while updating note");
		}

		
		return data;
		
	}

	public static String conversationCaption(Conversation conversation, Long loggedInUserId){
		String result = " sent a message ";
		String placeholder1 = StringPool.BLANK;
		String placeholder2 = StringPool.BLANK;
		User user;
		try {
			if (loggedInUserId == conversation.getSentByUserId()){
				placeholder1 = "You";
				/*if(conversation.getAssociatedWith() > 0){
					user = UserLocalServiceUtil.getUser(conversation.getAssociatedWith());
					placeholder2 = "to "+user.getFullName().replace("'", "");
				}else {*/
					List<ConversationUser> conversationUserList = ConversationUserLocalServiceUtil.findByspConversationId(conversation.getSpConversationId());
					if (conversationUserList.size() > 1){
						placeholder2 = "to group";
					}else if (conversationUserList.size() == 1 && conversationUserList.get(0).getSentToUserId() > 0){
						user = UserLocalServiceUtil.getUser(conversationUserList.get(0).getSentToUserId());
						placeholder2 = "to "+user.getFullName().replace("'", "");
					}else if (conversationUserList.size() == 1 && conversationUserList.get(0).getSentToUserId() == 0){
						if (conversation.getAssociatedWith() != loggedInUserId && conversation.getAssociatedWith() > 0){
							user = UserLocalServiceUtil.getUser(conversation.getAssociatedWith());
							placeholder2 = "to "+user.getFullName().replace("'", "");
						}
					}
				//}
			}else {
				user = UserLocalServiceUtil.getUser(conversation.getSentByUserId());
				placeholder1 = user.getFullName().replace("'", "");
				//if(conversation.getAssociatedWith() > 0){
					/*if (loggedInUserId == conversation.getAssociatedWith()){
						placeholder2 = "to you";
					}else {*/
						List<ConversationUser> conversationUserList = ConversationUserLocalServiceUtil.findByspConversationId(conversation.getSpConversationId());
						if (conversationUserList.size() > 1){
							placeholder2 = "to group";
						}else if (conversationUserList.size() == 1 && conversationUserList.get(0).getSentToUserId() > 0){
							if (loggedInUserId == conversationUserList.get(0).getSentToUserId()){
								placeholder2 = "to you"; 
							}else{
								user = UserLocalServiceUtil.getUser(conversationUserList.get(0).getSentToUserId());
								placeholder2 = "to "+user.getFullName().replace("'", "");
							}
						}else if (conversationUserList.size() == 1 && conversationUserList.get(0).getSentToUserId() == 0 && conversation.getAssociatedWith() > 0){
							if (loggedInUserId == conversation.getAssociatedWith()){
								placeholder2 = "to you";
							}else if (conversation.getAssociatedWith() != conversation.getSentByUserId() && conversation.getAssociatedWith() > 0){
								user = UserLocalServiceUtil.getUser(conversation.getAssociatedWith());
								placeholder2 = "to "+user.getFullName().replace("'", "");
							}
						}
					//}
				//}
			}
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}
		
		result = placeholder1 + result + placeholder2;
		return result;
	}
	
	public static String noteCaption(Note note){
		String result = "You added a note ";
		String placeholder1 = StringPool.BLANK;
		User user;
		try {
			if (note.getAssociatedWith() > 0){
				user = UserLocalServiceUtil.getUser(note.getAssociatedWith());
				placeholder1 = "about "+user.getFullName().replace("'", "");
			}
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}
		
		result = result + placeholder1;
		return result;
	}
	
	public static String logActivityCaption(LogActivity logActivty){
		String activityType = StringPool.BLANK;
		if (logActivty.getActivityType().toLowerCase().contains("call")){
			activityType = "call";
		}else{
			activityType = logActivty.getActivityType().toLowerCase();
		}
		String result = "You logged a "+ activityType;
		String placeholder1 = StringPool.BLANK;
		User user;
		try {
			if (logActivty.getAssociatedWith() > 0){
				user = UserLocalServiceUtil.getUser(logActivty.getAssociatedWith());
				placeholder1 = " with "+user.getFullName().replace("'", "");
			}
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}
		
		result = result + placeholder1;
		return result;
	}
	
	private static String changeDateFormat(Date dateInput){
		String result = StringPool.BLANK;
		Date date = new Date();
		if (DateUtils.isSameDay(date, dateInput)){
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			result = sdf.format(dateInput);
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("MMM dd");
			result = sdf.format(dateInput);
			sdf = new SimpleDateFormat("HH:mm");
			result = result.concat(" at "+sdf.format(dateInput));
		}
		return result;
	}
	
	
	public String loadUsers(PortletRequest request, ThemeDisplay themedisplay) { 
		JSONArray array = JSONFactoryUtil.createJSONArray();
		try {
			PortletPreferences portletPreferences = request.getPreferences();
			
			String internalRoleIds = GetterUtil.getString(portletPreferences.getValue(SPActivityHubConstants.PREF_INTERNAL_ROLE_IDS, "0")).replace(" ", "");
				
			String[] internalRoleIdsArr = internalRoleIds.split(StringPool.COMMA);
				
			List<User> userList = new ArrayList<User>();
			for (String internalRoleId : internalRoleIdsArr) {
				long roleId = GetterUtil.getLong(internalRoleId);
				if (roleId > 0) {
					List<User> list = UserLocalServiceUtil.getRoleUsers(roleId);
					userList.addAll(list);
				}
			}			
			
			for (User user : userList) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				String logoUrl = UserConstants.getPortraitURL(themedisplay.getPathImage(), true, user.getPortraitId());					String userNameData = user.getFullName();
				String codeStr = user.getEmailAddress();
				obj.put("code", codeStr);
				obj.put("userName", userNameData);
				obj.put("userImg", logoUrl);
				obj.put("key", user.getUserId());
				array.put(obj);
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		
		if (array.length() > 0) {
			return JSONFactoryUtil.looseSerialize(array);
		} else {
			return StringPool.BLANK;
		}
	}
}
