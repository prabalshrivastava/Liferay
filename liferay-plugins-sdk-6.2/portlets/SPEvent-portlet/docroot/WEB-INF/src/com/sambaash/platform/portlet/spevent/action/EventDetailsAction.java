package com.sambaash.platform.portlet.spevent.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.spevent.SPEventConstants;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class EventDetailsAction
 */
public class EventDetailsAction extends MVCPortlet {
	
	private static Log logger = LogFactoryUtil.getLog(EventDetailsAction.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		Long eventId = SambaashUtil.getLongOriginalServletRequestParam(renderRequest, SPEventConstants.EVENT_ID);
		
		if (logger.isDebugEnabled()) {
			logger.debug("EventId = " + eventId);
		}
		
		try {
			if (Validator.isNotNull(eventId)) {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
						.getAttribute(WebKeys.THEME_DISPLAY);
				try {
					Indexer indexer = IndexerRegistryUtil
							.getIndexer(CalendarBooking.class.getName());
					SearchContext searchContext = new SearchContext();
					searchContext.setCompanyId(themeDisplay.getCompanyId());
					searchContext.setGroupIds(new long[]{themeDisplay.getScopeGroupId()});
					searchContext.setStart(-1);
					searchContext.setEnd(-1);
					BooleanQuery query = BooleanQueryFactoryUtil
							.create(searchContext);
					query.addRequiredTerm(Field.ENTRY_CLASS_PK, eventId);
					BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext, query, BooleanClauseOccur.MUST.getName());
					searchContext.setBooleanClauses(new BooleanClause[]{clause});
					Hits hits = indexer.search(searchContext);
					Document[] docs = hits.getDocs();
					if (logger.isDebugEnabled()) {
						logger.debug("event query = " + hits.getQuery().toString());
					}
					if (ArrayUtil.isEmpty(docs)) {
						logger.warn("Event not found with eventId = " + eventId);
						return;
					}
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("document", docs[0]);
					renderRequest.setAttribute(
							SPEventConstants.ATTRIB_RESULT_MAP, map);
				} catch (SearchException e) {
					logger.error("Error while getting results" , e);
				}
			}
		} finally {
			super.doView(renderRequest, renderResponse);
		}
	}

}
