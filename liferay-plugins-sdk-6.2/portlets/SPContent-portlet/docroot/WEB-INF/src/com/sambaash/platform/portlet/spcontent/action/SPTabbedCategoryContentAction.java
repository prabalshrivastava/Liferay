package com.sambaash.platform.portlet.spcontent.action;

import static com.sambaash.platform.portlet.spcontent.Constant.ALL_CONTENT;
import static com.sambaash.platform.portlet.spcontent.Constant.BLOG_CONTENT;
import static com.sambaash.platform.portlet.spcontent.Constant.CHALLENGE_CONTENT;
import static com.sambaash.platform.portlet.spcontent.Constant.EVENT_CONTENT;
import static com.sambaash.platform.portlet.spcontent.Constant.JOURNAL_CONTENT;
import static com.sambaash.platform.portlet.spcontent.Constant.TAB_CONFIGURATION;
import static com.sambaash.platform.portlet.spcontent.Constant.TAB_CONTENT_INDEX;
import static com.sambaash.platform.portlet.spcontent.Constant.TAB_CONTENT_TITLE;
import static com.sambaash.platform.portlet.spcontent.Constant.TAB_CONTENT_TYPE;
import static com.sambaash.platform.portlet.spcontent.Constant.USER_CONTENT;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.spcontent.StatusMessage;
import com.sambaash.platform.portlet.spcontent.WebKeys;
import com.sambaash.platform.portlet.spcontent.config.TabConfiguration;
import com.sambaash.platform.portlet.spcontent.config.TabConfigurations;
import com.sambaash.platform.portlet.spcontent.helper.CategorizedDocumentSearchHelper;
import com.sambaash.platform.portlet.spcontent.helper.JournalArticleHelper;
import com.sambaash.platform.portlet.spcontent.util.ActionUtil;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;

/**
 * Portlet implementation class SPTabbedCategoryContentAction
 */
public class SPTabbedCategoryContentAction extends MVCPortlet {
 
	public void displayTabbedCategoryContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException, PortalException {
		
		String contentType = ParamUtil.getString(actionRequest, TAB_CONTENT_TYPE);
		int tabIndex = ParamUtil.getInteger(actionRequest, TAB_CONTENT_INDEX);
		String contentTitle = ParamUtil.getString(actionRequest, TAB_CONTENT_TITLE);
		
		String tabConfigJson = ActionUtil.getPreferenceValue(actionRequest.getPreferences(), TAB_CONFIGURATION, "");
		TabConfigurations tabConfigs = null;
		try {
			tabConfigs = JSONFactoryUtil.looseDeserialize(tabConfigJson, TabConfigurations.class);			
		} catch (Exception e) {
			// no configuration yet
			SessionErrors.add(actionRequest.getPortletSession(), StatusMessage.MISSING_CONFIG_ERROR);
			return;
		}
		
		if (ALL_CONTENT.equalsIgnoreCase(contentType)) {
			int i=0;
			for (TabConfiguration t: tabConfigs.getTabs()) {
				findContents(actionRequest, t.type, t.title, i++);
			}
		} else {
			findContents(actionRequest, contentType, tabConfigs.getTabs()[tabIndex].title);			
		}
		
		actionRequest.setAttribute(TAB_CONTENT_TYPE, contentType);
		actionRequest.setAttribute(TAB_CONTENT_INDEX, tabIndex);
		actionRequest.setAttribute(TAB_CONTENT_TITLE, contentTitle);
		actionRequest.setAttribute(TAB_CONFIGURATION, tabConfigs);
	}

	protected void findContents(ActionRequest actionRequest, String contentType, String uiTitle)
			throws SystemException, SearchException, ParseException {
		findContents(actionRequest, contentType, uiTitle, -1); // -1 means not looping but getting specific tab content
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void findContents(ActionRequest actionRequest, String contentType, String uiTitle, int tabIndex)
			throws SystemException, SearchException, ParseException {
		List<Document> docList = null;
		
		if (JOURNAL_CONTENT.equalsIgnoreCase(contentType)) {
			JournalArticleHelper helper = new JournalArticleHelper(actionRequest);
			helper.setCurrentTabIndex(tabIndex);
			List<String> contentList = helper.searchArticleContentsByCategory(actionRequest);		
			actionRequest.setAttribute(WebKeys.JOURNAL_CONTENT_LIST, contentList);
		} else if(BLOG_CONTENT.equalsIgnoreCase(contentType)) {
			CategorizedDocumentSearchHelper helper = new CategorizedDocumentSearchHelper(actionRequest, BlogsEntry.class);
			helper.setCurrentTabIndex(tabIndex);
			docList = helper.searchDocumentsByCategory();
			actionRequest.setAttribute(WebKeys.BLOG_CONTENT_LIST, docList);
		} else if(EVENT_CONTENT.equalsIgnoreCase(contentType)) {
			CategorizedDocumentSearchHelper helper = new CategorizedDocumentSearchHelper(actionRequest, CalendarBooking.class);
			helper.setCurrentTabIndex(tabIndex);
			docList = helper.searchDocumentsByCategory();
			actionRequest.setAttribute(WebKeys.EVENT_CONTENT_LIST, docList);			
		} else if(USER_CONTENT.equalsIgnoreCase(contentType)) {
			CategorizedDocumentSearchHelper helper = new CategorizedDocumentSearchHelper(actionRequest, User.class);
			helper.setCurrentTabIndex(tabIndex);
			docList = helper.searchDocumentsByCategory();
			actionRequest.setAttribute(WebKeys.USER_CONTENT_LIST, docList);		
		} else if(CHALLENGE_CONTENT.equalsIgnoreCase(contentType)) {
			CategorizedDocumentSearchHelper helper = new CategorizedDocumentSearchHelper(actionRequest, SPChallenge.class);
			helper.setCurrentTabIndex(tabIndex);
			docList = helper.searchDocumentsByCategory();
			actionRequest.setAttribute(WebKeys.CHALLENGE_CONTENT_LIST, docList);
		}
		if (docList != null) {
			for (Document d: docList) {
				d.addText("_ui_title", uiTitle);
			}
		}
	}

	// Resource URL handler
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		ActionUtil.serveResource(resourceRequest, resourceResponse);
	}

}
