<%@page import="com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.sambaash.platform.pe.helpers.PEProcessHelper"%>
<%@page import="com.sambaash.platform.pe.PEDataSource"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.sambaash.platform.pe.helpers.PEJSPDisplayHelper" %>
<%@ page import="com.sambaash.platform.pe.constants.PEConstants" %>
<%@ page import="com.sambaash.platform.pe.PEOutput" %>
<%@ page import="com.liferay.compat.portal.kernel.util.HttpUtil" %>
<%@ include file="init.jsp" %>

<%
	PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);
	long formId = output.getId();
	long processStateId = 0;
	if (output.getProcessState() != null && output.getProcessState().getUserIdProcess() != 0) {
		processStateId = output.getProcessState().getSpPEProcessStateId();
	}
	PEDataSource datasource = output.getDataSource();

	Map<String,String>params = new HashMap<String,String>();
	params.put("thankyouMessage", "2");
	
	if(themeDisplay.isSignedIn() && !PEProcessHelper.isAgent(themeDisplay.getUser(), datasource.getProcess()) &&
				!PEProcessHelper.isSupervisor(themeDisplay.getUser(), datasource.getProcess()) ){
		params.put("firstName", user.getFirstName());
		params.put("lastName", user.getLastName());
		params.put("emailAddress" , user.getEmailAddress());
	}
	
	String formUrl = "";
	if (output.getStorageId() > 0) {
		if (!PEProcessHelper.isApplicant(themeDisplay.getUser(), output.getProcessState())){
			params.put("processParam", "786");
		}	
		formUrl = FormBuilderLocalServiceUtil.getUrlLoadFormWithStorageId(themeDisplay.getUserId(), formId, output.getStorageId(), output.isCanEdit(), params);	
	}else {
		formUrl =  FormBuilderLocalServiceUtil.getUrlLoadFormWithOutStorageId(formId, params);
	}
	
	String decodedUrl = HttpUtil.decodeURL(formUrl);
%>
<jsp:include page="/html/formData.jsp"></jsp:include>
<div class="row">
	<div id="datadisplay">
	</div>
	<script type="text/javascript">
		var A;
		var pns ="<portlet:namespace/>";
		AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',function(A1) {
			A = A1;
			var eventMethod = window.addEventListener ? "addEventListener"
					: "attachEvent";
			var eventer = window[eventMethod];
			var messageEvent = eventMethod == "attachEvent" ? "onmessage" : "message";
		
			eventer(messageEvent, function(b) {
				if (FormBuilderCommunicator.shouldHandleEvent(b)) {
					FormBuilderCommunicator.handleEvent(b);
				}else {
					console.log("parent received message!: ", b.data);
					if(b.data && b.data["htmlFormId"] && b.data["htmlFormId"] > 0){
						submitFormData(b.data);
					}
					try{
						var obj = JSON.parse(b.data);
						if(obj.src == 'formloader'){
							var iframe = document.getElementById("formIframe");
							iframe.height = obj.height + "px";
							stopPreLoader("mainContainer");
						}
					} catch(err){
						console.log("Not a json response for form height.");
					}					
				}
			}, false);

		});

	</script>
	<script type="text/javascript">
	startPreLoader("mainContainer");
	function iframeLoaded() {
	  /*var iFrameID = document.getElementById('formIframe');
	  if (iFrameID) {
			// here you can make the height, I delete it first, then I make it again
			iFrameID.height = "";
			iFrameID.height = iFrameID.contentWindow.document.body.scrollHeight + "px";
	  }*/
	}

	var FormBuilderCommunicator = (function () {
	    var iframe;
	    var datamap = {};

	    var _getVar = function(name) {
	            if (datamap.hasOwnProperty(name)) {
	                return datamap[name];
	            } else {
	                // simulate return data first
	                //return null;
	                var retVal;
	                if (name==='classNameId') {
	                    retVal = <%= datasource.getProcessState().getEntityClassId()%>;
	                } else if (name==='classPk') {
	                	retVal = <%= datasource.getProcessState().getEntityId() %>;
	                }
                    if (retVal != undefined) datamap[name] = retVal;
	                return retVal;
	            }
	        };

	    var _validateInventory = function(payLoad, callBack) {
	        var wsUrl = '/api/jsonws/SPShopping-portlet.spshopping/has-enough-inventory';
	            wsUrl += '/class-name-id/' + _getVar('classNameId');
	            wsUrl += '/class-pk/' + _getVar('classPk');
	            wsUrl += '/inventory-needed/' + payLoad.neededInventory;
//	        console.log('_validateInventory URL: '+wsUrl);
	        _doGet(wsUrl, function(data){
	            var respObj = {
	              name : "response_validateInventory_"+payLoad.itemId,
	              value: data
	            };
	            console.log('sending validateInventory response: '+ JSON.stringify(respObj));
	            _post('setVar', respObj);
	          });
	    }

	    var _getRemainingInventory = function(payLoad, callBack) {
	        var wsUrl = '/api/jsonws/SPShopping-portlet.spshopping/remaining-inventory';
	            wsUrl += '/class-name-id/' + _getVar('classNameId');
	            wsUrl += '/class-pk/' + _getVar('classPk');
	        console.log('_getRemainingInventory URL: '+wsUrl);
	        _doGet(wsUrl, function(data){
	            var respObj = {
	              name : "response_getRemainingInventory_"+payLoad.itemId,
	              value: data
	            };
	            console.log('sending getRemainingInventory response: '+ JSON.stringify(respObj));
	            _post('setVar', respObj);
	          });
	    }

	    var _doGet = function (url, callback) {
	        var xhr = new XMLHttpRequest();
	        xhr.open("GET", url, true);
	        xhr.onload = function () {
	          console.log('got response:'+xhr.responseText);
	          if (callback) {
	              callback(JSON.parse(xhr.responseText));
	          }
	        };
	        xhr.send();
	              /*jQuery.ajax({
	                  type: "GET",
	                  url: url,
	                  crossDomain: true,
	                  success : function(data) {
	                      if (callback) {
	                        callback(data);
	                      }
	                  }
	              });*/
	          };

	    var _handleEvent = function (event) {
	            try
	            {
	                var msg = event.data;
	                if (msg && msg.payLoad) {
	                	console.log('FormBuilderCommunicator handling message '+ event.data + ' from '+ event.origin );

	                  var payLoad = msg.payLoad;
	                  if (msg.type==='getVar') {
	                    _post("setVar", {"name":payLoad.name, "value": _getVar(payLoad.name)});
	                  } else if (msg.type==='validateInventory') {
	                    _validateInventory(msg.payLoad);
	                  } else if (msg.type==='getRemainingInventory') {
	                    _getRemainingInventory(msg.payLoad);
	                  }

	                } else {
	                  console.log("Ignoring message not for FormBuilderCommunicator: "+event.data);
	                }
	            } catch (e) {
	                if (console && console.log) {
	                    console.log('Error parsing event data: '+e);
	                }
	            }
	        };
	        
	    var _post = function(eventType, payLoad, callback) {
	        var msg = {
	            type: eventType,
	            payLoad: payLoad
	        }
	        if (iframe) iframe.contentWindow.postMessage(msg, '*');
	    };

	    var _shouldHandleEvent = function(event) {
	    	try {
		        var msg = event.data;
		        console.log('FormBuilderCommunicator shouldHandleEvent: '+JSON.stringify(event.data));
		        return (msg && msg.payLoad);	    		
	    	} catch (e) {
	    		console.log('error:'+e);
	    		return false;
	    	}
	    };

	    var _setIFrame = function (f) {
	      iframe = f;
	    };

	    var _methods = {
	        getData: _getVar,
	        post: _post,
	        handleEvent: _handleEvent,
	        shouldHandleEvent: _shouldHandleEvent,
	        setIFrame : _setIFrame
	    };

	    return _methods;
	})();
	
	</script>
	<div class="iframe-process">
		<iframe frameborder="0" id="formIframe"  scrolling="no" src="<%= decodedUrl %>" height="850px">
		</iframe>
	</div>

	<script type="text/javascript">
	document.getElementById('formIframe').onload= function() {
		FormBuilderCommunicator.setIFrame(this);
    };
	</script>	
</div>