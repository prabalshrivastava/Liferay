class SPAjax extends SPEventAware {
    constructor() {
        super();
    };
    
    request (method, url, params) {
        let self = this;
        let http = new XMLHttpRequest();
        http.open(method, url, true);
        http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        http.onreadystatechange = function() {
            let response;
            let responseTxt; 
            try {
                responseTxt = http.responseText;
                if (responseTxt) response = self.isObject(responseTxt) ? responseTxt : JSON.parse(responseTxt);
            } catch (e) {
                self.debug(e);
            }
            
            let reply = {requestUrl:url, requestParams: params};
            if (http.readyState == 4 && http.status == 200) {
                reply.data = response; 
                self.emit('success', reply);
            } else if(http.status !== 200) {
                reply.error = responseTxt;
//                self.debug('Error in posting: '+url);
                self.emit('failed', reply);
            }
        }
        http.send(params);
    };
        
    get (url, params) {
         this.request("GET", url, params);
    };
    
    post (url, params) {
        this.request("POST", url, params);
    };

    delete (url, params) {
        this.request("DELETE", url, params);
    };
} 
