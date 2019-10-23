package com.sambaash.platform.portlet.pe.datapatching;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Callable;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.portlet.pe.helper.PESimpleXSLFile;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;

public class PEDataPatchingConversionHelper {

	private PortletRequest request;
	private PortletResponse response;
	
	private List<Map<String,String>> resultList = new Vector<Map<String,String>>();
	
	private static Log _log = LogFactoryUtil
			.getLog(PEDataPatchingConversionHelper.class.getName());
	
	public PEDataPatchingConversionHelper(PortletRequest request,PortletResponse response){
		this.request = request;
		this.response =  response;
	}
	
	public void convert() throws PortalException, SystemException, InterruptedException{
		String configStr = ParamUtil.getString(request, "config");
		JSONObject config = JSONFactoryUtil.createJSONObject(configStr);
		
		JSONArray  processList = JSONFactoryUtil.createJSONArray(config.getString("processList"));
		long targetProcessId = config.getLong("targetProcessId");
		int length = processList.length();
		//ExecutorService executorService = Executors.newFixedThreadPool(300);
		try{
			for(int index = 0 ; index < length ; index++){
				JSONObject processConfig = processList.getJSONObject(index);
				String pIdsStr = processConfig.getString("processIds");
				long processIds[] = GetterUtil.getLongValues(pIdsStr.split(StringPool.COMMA));
				for (long id : processIds) {
					_log.debug("Started Processing for ProcessId " + id);
					long start  = System.currentTimeMillis();
					if(id > 0){
						List<PEProcessState> processStates ;
						try {
							processStates = PEProcessStateLocalServiceUtil.findByProcessId(id);
							_log.debug("Indentifed applications counts for above process " + processStates.size());
						} catch (SystemException e) {
							_log.error(e);
							continue;
						}
						List<Callable<Map<String,String>>> tasks = new LinkedList<Callable<Map<String,String>>>();
						for (PEProcessState processState : processStates) {
							LeadToOpportunityTask task = new LeadToOpportunityTask(request, processState, processConfig, targetProcessId);
							tasks.add(task);
							resultList.add(task.call());
						}
					}
				}
				
			}
			
		}catch(Exception ex){
			_log.error(ex);
		}finally{
		//	executorService.shutdownNow();
		}
	}
	
	
	public String exportResults() throws FileNotFoundException, IOException{
		String path = generateName();
		PESimpleXSLFile file = PESimpleXSLFile.createXslFile(path);
		Map<String,String>header = new LinkedHashMap<String, String>();
		header.put(PEConstantsGlobal.PROCESS_STATE_ID ,"Process State Id");
		header.put(PEConstantsGlobal.PROCESS_ID ," Process Id");
		header.put("processName"," Process Name");
		header.put("remarks","Remarks");
		header.put("newProcessStateId","New Process State Id");
		file.writeHeader(header);
		file.writeRows(resultList);
		file.saveFile();
		
		return path;
	}
	
	public static String generateName() {
		String tmp = "results_" + System.currentTimeMillis() +  ".xlsx";
		return System.getProperty("java.io.tmpdir") + File.separator + tmp;
	}
}

