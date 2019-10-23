
<!-- Piwik -->
<script type="text/javascript">
	var pk_custom_getCookie =  function(cname) {
	    var name = cname + "=";
	    var ca = document.cookie.split(';');
	    for(var i = 0; i < ca.length; i++) {
	        var c = ca[i];
	        while (c.charAt(0) == ' ') {
	            c = c.substring(1);
	        }
	        if (c.indexOf(name) == 0) {
	            return c.substring(name.length, c.length);
	        }
	    }
	    return "";
	};

  var _paq = _paq || [];
  /* tracker methods like "setCustomDimension" should be called before "trackPageView" */
  var getPiwikCustomVarVal = function () { //var visitorid = this.getVisitorId(); alert(visitorid);

  	var setCookie = function(cname, cvalue) {
	    var d = new Date();
	    d.setTime(d.getTime() + ( 30 * 60 * 1000));
	    var expires = "expires="+d.toUTCString();
	    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
	    console.log("Setting cookie " + cname + "  " + cvalue);
	};
	// call this method, in case if it's a new visit.
	var setVisitCV = function(){
		var tracker = Piwik.getAsyncTracker();
   		var now = new Date().getTime();
   		var ts = tracker.getVisitorId() + "_" + now;
		tracker.setCustomVariable(3, "visitId", ts , "visit");
		console.log("Setting custom variable " + ts);
	};
	var generateUniqueId = function() {
                var id = '';
                var chars = 'abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ';
                var charLen = chars.length;
                var i;

                for (i = 0; i < 16; i++) {
                    id += chars.charAt(Math.floor(Math.random() * charLen));
                }
                return id;
            };
//	var tracker = Piwik.getAsyncTracker();
    var ck = pk_custom_getCookie("pk_c_v_info");
    var setNewVal = false;
    // no cookie, so it's first visit/earlier visit expired
    if(ck == null || ck == ""){
         console.log("Cookie does not exist.So custom variable will be set");
         //setVisitCV();
         setNewVal = true;
    }else{
    	var t = ck.split(",");
    	// if the visitor is same, then look for visit timeline.. piwik considers new visit if visit made to site is 30min from last interaction
    	var time = parseInt(t[2]);//last visit time
    	var now = new Date().getTime();
    	// Piwik creates new visit if last visit is direct and current visit from campaign
    	if(now-time > ( 30 * 60 * 1000)){
    		    console.log("Either now-time > 30 min or last visit is direct and current visit from campaign. so custom variable wil be set");
    		 	//setVisitCV();
    		 	setNewVal = true;
    	}
    }
   // set cookie now
   var cookieVal ;
   var newValToSet = "";
   if(setNewVal){
   	   newValToSet = generateUniqueId() + "_" +  new Date().getTime() ;
	   cookieVal = newValToSet.replace("_",",") + "," + new Date().getTime() ;
   }else{
       var t = ck.split(",");
       newValToSet = t[0] + "_" + t[1];
	   cookieVal = t[0] + "," + t[1] + "," + new Date().getTime() ;
   }
   /**
      t - is array
      [0] - visitor id
      [1] - time stamp when first cookie created or custom variable is set. the same value persisted until next new visit.
      [2] - time stamp every time visit takes.. this is used to calculate idle time from last visit to current vistit. if diff is more than 30min, it's new visit
      [3] - campaign name

   */
   setCookie("pk_c_v_info",cookieVal);
   return newValToSet;
  };
  _paq.push(["setDomains", ["*.www.lithan.com"]]);
  _paq.push(['setCustomVariable', 1, 'spUserId', '${themeDisplay.getUser().getUserId()}']);
  _paq.push(['setCustomVariable', 3, 'visitorId', getPiwikCustomVarVal()]);
  _paq.push(['trackPageView']);
  _paq.push(['enableHeartBeatTimer']);
  (function() {
    var u="//analytics.sambaash.com/";
    _paq.push(['setTrackerUrl', u+'piwik.php']);
    _paq.push(['setSiteId', '4']);
    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
    g.type='text/javascript'; g.async=true; g.defer=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
  })();

  		// STEP 1 : Add listener here.. STEP 2,3 can be found in formloader.js
		var eventMethod = window.addEventListener ? "addEventListener"
				: "attachEvent";
		var eventer = window[eventMethod];
		var messageEvent = eventMethod == "attachEvent" ? "onmessage" : "message";

		eventer(messageEvent, function(msg) {
			//STEP4 : send info
			console.log("analytics parent received message!: ", msg);
			if(msg.data == 'spformloaded'){
				if(Piwik){
					var ck = pk_custom_getCookie("pk_c_v_info");
			    	var t = ck.split(",");
				    var ts = t[0] + "_" + t[1] ; // same value which we set in custom vairable.. this is used to link visit table and process state table.
				    console.log("Timestamp"+ts);
					var vinfo = {};
					vinfo["src"] = "spparentwindow";
					vinfo["visitorId"] = ts;
					vinfo["url"] = window.location.href;

					var iframes = document.getElementsByTagName('iframe');
					for (i = 0; i < iframes.length; i++) {
						var iframe = iframes[i];
						if(iframe.contentWindow){
							iframe.contentWindow.postMessage(vinfo,"*");
						}
					}
				}
			}
		}, false);



</script>
<noscript><p><img src="//analytics.sambaash.com/piwik.php?idsite=4;rec=1" style="border:0;" alt="" /></p></noscript>
<!-- End Piwik Code -->