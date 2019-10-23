package com.sambaash.platform.pe.actions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.jaxb.PECustomActionNode;
import com.sambaash.platform.srv.processbuilder.service.PESupervisorLocalServiceUtil;

/**
 *  This custom action is used to assign supervisor to application based on configuration.
 *  
 *  Configuration allows multiple parameters and filter type (AND / OR ) among those parameters.
 *  Configuration format:
 *  
 * [ 
 *  {
 *    "mapping" : [ {
 *    				"paramName":"country",  
 *    				"columnName" : "filter1"
 *    			  },
 *    			 {
 *    				"paramName":"countryId",
 *    				"columnName" : "filter2"
 *    			 }
 *    
 *    			],
 *    "conditionType" : "OR"
 *    
 *  }
 *  
 *  ]
 *  
 *  Now in above case, if country or countryid matches against PESupervisor table then corresponding supervisor will be assigned
 *  
 *  NOTE :: paramName can be one of the below values. ( Please check ds.getData method)
 *  		1. One of the fields in form - ( it must be saved to process state and give corresponding name)
 *  		2. Entity field
 *          3. Request Parameter
 *  
 * 
 * @author nareshchebolu
 *
 */

public class PEAssignSupervisorAction extends PECustomActionImpl{

	
	public PEAssignSupervisorAction(PEDataSource ds,
			PECustomActionNode actionNode) {
		super(ds, actionNode);
	}

	@Override
	public PEActionResult perform() {
		try {
				JSONArray configArray = JSONFactoryUtil.createJSONArray(actionNode.getConfiguration());
				final int configArrayLength = configArray.length();
				
				outer:for(int i = 0 ; i < configArrayLength; i++){
					
					List<Entry<String, String>> conditonList = new ArrayList<Entry<String, String>>();
					JSONObject configObj = configArray.getJSONObject(i);
					JSONArray mapping = JSONFactoryUtil.createJSONArray(configObj.getString("mapping"));
					final int length = mapping.length();
					for(int j = 0 ; j < length; j++){
						JSONObject  entry = mapping.getJSONObject(j);
						String paramName = entry.getString("paramName");
						String columnName = entry.getString("columnName");
						conditonList.add(new java.util.AbstractMap.SimpleEntry<String, String>(columnName, ds.getData(paramName)));
					}
					String condtionType = configObj.getString("conditionType");
					long supervisor = PESupervisorLocalServiceUtil.getSupervisor(conditonList, condtionType);
					if(supervisor > 0){
						ds.getProcessState().setUserIdSupervisor(supervisor);
						// able to find supervisor. So no need to check for other configs. So break the loop
						break outer;
					}
				}
		} catch (JSONException e) {
			_log.error("Error while parsing Configuration data for Supervisor custom aciton. Configuration data= "+actionNode.getConfiguration(),e);
		} catch (SystemException e) {
			_log.error("Error while assignin supervisor",e);
		}
		return getActionResultSuccess();
	}
	
	private static final Log _log = LogFactoryUtil.getLog(PEAssignSupervisorAction.class);

}
