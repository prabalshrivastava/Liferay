
(function hideReturnFullPage(){
	// to hide the link return to full page. Return to full page displays when portlet is maximized state.
	// all trademarks portlets by default displays in max state and there is no thing like going back to full page. So hiding it.
	AUI().use('aui-node','aui-base',function(A){
		A.on("domready",function(){
			try{
				var nodeFP = A.one(".portlet-icon-back");
				if(nodeFP){
					nodeFP.addClass('hide');
				}
			}catch(error){
				
			}
		})
	});
})();