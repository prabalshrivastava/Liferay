package com.sambaash.platform.portlet.spevent.util;

import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.portlet.BaseFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;

public class EventFreindlyURLMapper extends BaseFriendlyURLMapper{

	public String buildPath(LiferayPortletURL portletURL) {
		// TODO Auto-generated method stub
		
		String friendlyURLPath = null;// ;

        String CMD = GetterUtil.getString(portletURL.getParameter("CMD"));
        if(CMD.equalsIgnoreCase("view_event")){
        	
        	String cmd = portletURL.getParameter("CMD");
            String eventId = portletURL.getParameter("eventId");
            
            friendlyURLPath = StringPool.SLASH
            		+ getMapping() 
            		+ StringPool.SLASH
            		+ CMD 
            		+ StringPool.SLASH
            		+ eventId;

            portletURL.addParameterIncludedInPath("p_p_id");
            portletURL.addParameterIncludedInPath("p_p_lifecycle");
            portletURL.addParameterIncludedInPath("p_p_state");
            portletURL.addParameterIncludedInPath("p_p_mode");
            portletURL.addParameterIncludedInPath("p_p_col_id");
            portletURL.addParameterIncludedInPath("p_p_col_count");
            portletURL.addParameterIncludedInPath("CMD");
            portletURL.addParameterIncludedInPath("eventId"); 
            portletURL.addParameterIncludedInPath("redirect");
            portletURL.addParameterIncludedInPath("struts_action");
        } else if(CMD.equalsIgnoreCase("edit_event")){
        	
        	String cmd = portletURL.getParameter("CMD");
            String day = portletURL.getParameter("day");
            String month = portletURL.getParameter("month");
            String year = portletURL.getParameter("year");           
            String redirect = GetterUtil.getString(portletURL.getParameter("redirect"));
            
            friendlyURLPath = StringPool.SLASH
            		+ getMapping() 
            		+ StringPool.SLASH
            		+ CMD 
            		+ StringPool.SLASH
            		+ day
            		+ StringPool.SLASH
            		+ month
            		+ StringPool.SLASH
            		+year;
        	
//        	<portlet:param name="struts_action" value="/calendar/edit_event" />
//			<portlet:param name="redirect" value="<%= currentURL %>" />
//			<portlet:param name="backURL" value="<%= currentURL %>" />
//			<portlet:param name="month" value="<%= String.valueOf(selMonth) %>" />
//			<portlet:param name="day" value="<%= String.valueOf(selDay) %>" />
//			<portlet:param name="year" value="<%= String.valueOf(selYear) %>" />
//			<portlet:param name="CMD" value="edit_event" />
            
            portletURL.addParameterIncludedInPath("p_p_id");
            portletURL.addParameterIncludedInPath("p_p_lifecycle");
            portletURL.addParameterIncludedInPath("p_p_state");
            portletURL.addParameterIncludedInPath("p_p_mode");
            portletURL.addParameterIncludedInPath("p_p_col_id");
            portletURL.addParameterIncludedInPath("p_p_col_count");
            portletURL.addParameterIncludedInPath("CMD");
            portletURL.addParameterIncludedInPath("day"); 
            portletURL.addParameterIncludedInPath("month"); 
            portletURL.addParameterIncludedInPath("year"); 
            portletURL.addParameterIncludedInPath("struts_action");
            portletURL.addParameterIncludedInPath("redirect");
            portletURL.addParameterIncludedInPath("backURL");		
        }
        
//        else if(CMD.equalsIgnoreCase("view")){
//        	portletURL.addParameterIncludedInPath("p_p_id");
//            portletURL.addParameterIncludedInPath("p_p_lifecycle");
//            portletURL.addParameterIncludedInPath("p_p_state");
//            portletURL.addParameterIncludedInPath("p_p_mode");
//            portletURL.addParameterIncludedInPath("p_p_col_id");
//        	
//        }else{
//        	portletURL.addParameterIncludedInPath("p_p_id");
//            portletURL.addParameterIncludedInPath("p_p_lifecycle");
//            portletURL.addParameterIncludedInPath("p_p_state");
//            portletURL.addParameterIncludedInPath("p_p_mode");
//            portletURL.addParameterIncludedInPath("p_p_col_id");
//        }
		
        return friendlyURLPath;
	}
	
	public String getMapping() { return _MAPPING;
    }

    public String getPortletId() { return _PORTLET_ID;
    }

	public void populateParams(String friendlyURLPath, Map<String, String[]> parameterMap,
	        Map<String, Object> requestContext) {
		// TODO Auto-generated method stub
		addParameter(parameterMap, "p_p_id", _PORTLET_ID);
        addParameter(parameterMap, "p_p_lifecycle", "0");
        addParameter(parameterMap, "p_p_mode", PortletMode.VIEW);
        
        

        int x = friendlyURLPath.indexOf("/", 1);
        int y = friendlyURLPath.indexOf("/", x + 1);

        if (y == -1) {
            y = friendlyURLPath.length();
        }

        String cmd = friendlyURLPath.substring(x + 1, y);
        addParameter(parameterMap, "CMD", cmd);

         x = friendlyURLPath.indexOf("/", y);
         y = friendlyURLPath.indexOf("/", x + 1);

        if (y == -1) {
            y = friendlyURLPath.length();
        }
        
        
        String eventId = friendlyURLPath.substring(x + 1, y);

        x = friendlyURLPath.indexOf("/", y);
        y = friendlyURLPath.indexOf("/", x + 1);

       if (y == -1) {
           y = friendlyURLPath.length();
       }
        
        if(cmd.equals("view_event")){
            addParameter(parameterMap, "CMD", "view_event");
            addParameter(parameterMap, "eventId", eventId);
            addParameter(parameterMap, "struts_action", "/html/spevent/view");
        }else if(cmd.equals("edit_event")){
        	
        	
        	addParameter(parameterMap, "struts_action", "/calendar/edit_event");
        	addParameter(parameterMap, "redirect", "/calendar" );
        }
		
	}
	
    public String getParameterValue(RenderRequest req, String key) {
        String paramValue = "";
    //    java.util.Enumeration e = req.getParameterNames();
        try{
        //while (e.hasMoreElements()) {
          //    String key = (String) e.nextElement();

                  if (req.getParameterValues(key) instanceof String[]) {

                      paramValue = req.getParameterValues(key)[0];

                  }

                  }catch(Exception ex) {

                     
                  }
          //  }
        return paramValue;
    }
	
    private static final String _MAPPING = "event";


    private static final String _PORTLET_ID = "8";

}
