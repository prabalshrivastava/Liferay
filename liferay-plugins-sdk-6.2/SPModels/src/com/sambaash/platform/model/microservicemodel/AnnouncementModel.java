package com.sambaash.platform.model.microservicemodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
public class AnnouncementModel extends MicroServiceModel{
	
	public ArrayList<String> columnList(){
		return  new ArrayList<String>(Arrays.asList("AnnouncementCategory","BroadcastDateTime","Message"));
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("AnnouncementCategory", "Category");
		        put("BroadcastDateTime", "Broadcast DateTime");
		        put("Message", "Message");        
		    }
		};
	}
}