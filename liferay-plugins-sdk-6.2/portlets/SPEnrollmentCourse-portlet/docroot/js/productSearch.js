var productSearch = function(config){
	//TODO:declare it globally
	//var AArray = A.Array;
	
	this.init = function(config){
	  	this.pns = config.pns;
	  	this.ajaxUrl = config.ajaxUrl;
	  	this.idProduct = "#productId";
	  	this.loadMoreNode = A.one("#loadMore");
	  	this.searchTextNode = A.one("#searchText");
	  	this.productsNode = A.one("#productsSection");
	  	this.sampleProductRowNode = A.one("#sampleProductRow");
	  	this.start = -1;
	  	this.pageSize = 10;
	  	// initially loading 
	  	this.loadMoreProducts();
	}
	
	this.initializeSearch = function(){
		var instance = this;
		instance.searchTextNode.on("keypress",function(ev){
			// click on enter
			if(ev.keyCode ==  13){
				//TODO: check old and new value, and if there is change load the new results
				instance.searchCriteriaChanged = true;
				instance.loadMoreProducts();
			}
		})
	}
	
	
	this.initializeLoadMore = function(){
		var instance = this;
		instance.loadMoreNode.on("click",instance.loadMoreProducts);
	}
	this.loadMoreProducts = function(){
		var instance = this;
		if(instance.requestUnderProcess){
			return;
		}
		instance.requestUnderProcess = true;
		var contentId =  instance.productsNode.get('id');
		startPreLoader(contentId);
		data = {};
		// if there is change in search criteria, start must be reinitialized to -1
		if(instance.searchCriteriaChanged){
			data.start = -1;
		}else{
			data.start = instance.start;
		}
		data.action = "fetchProducts";
		data.pageSize = instance.pageSize;
		data.searchText = instance.searchTextNode.val();
		A.io.request(instance.ajaxUrl,{
            dataType: 'json',
            method: 'POST',
            data: data,
            on: {
            complete: function(){
            	instance.searchCriteriaChanged = false;
            	instance.requestUnderProcess = false;
            	stopPreLoader(contentId);
            },
            success: function() {
                var data=this.get('responseData');
                if(data.error){
                	alert(data.error);
                }else{
                	// move the cursor
                	instance.start = instance.start + data.products.length;
                	// check if there are more products to load or not.
                	if(data.products.length == 0 || data.products.length < instance.pageSize){
                		instance.loadMoreNode.set('text', "No more Products");
                		instance.loadMoreNode.addClass("normalText");
                		// since there are no products load, unregister the click event of load more
                		instance.loadMoreNode.detach("click");
                	}else{
                		// initialize it.. click event  might have detached earlier
            			instance.initializeLoadMore();
                	}
                	// success response - render the products
                	instance.renderProducts(data.products);
                }
              },
             failure : function(){
		    	instance.requestUnderProcess = false;
		    }
            }
        });
	}
	
	this.renderProducts = function(products){
		if(!products){
			return;
		}
		var instance = this;
		// iterate products array and create product row for each product jsob object
		AArray.each(products,function(product){
			instance.renderProduct(product);
		});
		
	}
	this.renderProduct = function(product){
		var instance = this;
		if(product && product.productId){
			// clone the node - true indicates deep cloning
			var newRow = instance.sampleProductRowNode.cloneNode(true);
			newRow.one(instance.idProduct).val(product.productId);
			newRow.one("#productCode").set('text',product.productCode);
			newRow.one("#productName").set('text',product.productName);
			newRow.one("#createdDate").set('text',product.createdDate);
			instance.productsNode.appendChild(newRow);
		}
	}
	this.initalizeProductClick = function(productNode){
		var instance = this;
		var productId = productNode.one(instance.idProduct).val();
		var set = instance.applicantnSet = instance.applicantnSet ? instance.applicantnSet : {};
		//TODO: check this functionality with debugger. it must not create new applicants object, if it is already created
		if(!set[productId]){
			var config = {};
			config.pns = instance.pns;
			config.ajaxUrl = instance.ajaxUrl;
			config.productId = productId;
			config.applicantsNode = productNode.one("#applicantsSection");
			// generate unique id. used while displaying preloader and any other activity
			var newId = config.applicantsNode.get('id') + productId;
			config.applicantsNode.set("id",newId);
			
			var applicantsObj = new applicants(config);
			set[productId] = applicantsObj;
		}
		
		//TODO: show/hide applicants sections
	}
	this.init(config);
}

var applicants = function(config){
	
	this.init = function(config){
		this.pns = config.pns;
		this.ajaxUrl = config.ajaxUrl;
		this.productId = config.prodcutId;
		this.applicantsNode = config.applicantsNode.one("#applicants");
		this.start = -1;
		this.pageSize = 10;
		this.idApplicant = "applicantId";
		this.loadMoreNode = this.applicantsNode.one("#loadMore");
		this.sampleApplicantRowNode = A.one("#sampleApplicant");

		//initially load some applicants, thereafter on click of load more load applicants
		this.loadMoreApplicants();
		
	}
	this.initializeLoadMore = function(){
		var instance = this;
		instance.loadMoreNode.on("click",instance.loadMoreApplicants);
	}
	this.loadMoreApplicants = function(){
		var instance = this;
		if(instance.requestUnderProcess){
			return;
		}
		instance.requestUnderProcess = true;
		var contentId =  instance.applicantsNode.get('id');
		startPreLoader(contentId);
		data = {};
		data.action = "fetchApplicants";
		data.start = instance.start;
		data.pageSize = instance.pageSize;
		// mandatory - to load product corresponding applicants
		data.productId = instance.productId;
		A.io.request(instance.ajaxUrl,{
            dataType: 'json',
            method: 'POST',
            data: data,
            on: {
            complete: function(){
            	// this is called before success and failure methods. So right place for any post processing of request.
            	instance.requestUnderProcess = false;
            	stopPreLoader(contentId);
            },
            success: function() {
            	
                var data=this.get('responseData');
                if(data.error){
                	alert(data.error);
                }else{
                	// move the cursor
                	instance.start = instance.start + data.products.length;
                	// check if there are more products to load or not.
                	if(data.applicants.length == 0 || data.applicants.length < instance.pageSize){
                		instance.loadMoreNode.set('text', "No more Products");
                		instance.loadMoreNode.addClass("normalText");
                		// since there are no products load, unregister the click event of load more
                		instance.loadMoreNode.detach("click");
                	}else{
                		// initialize it.... as there are more products load
            			instance.initializeLoadMore();
                	}
                	// success response - render the products
                	instance.renderApplicants(data.applicants);
                }
              },
		    failure : function(){
		    }
            }
        });
	}
	this.renderApplicants = function(applicants){
		if(!applicants){
			return;
		}
		var instance = this;
		// iterate products array and create product row for each product jsob object
		AArray.each(applicants,function(applicant){
			instance.renderApplicant(applicant);
		});
		
	}
	this.renderApplicant = function(applicant){
		var instance = this;
		if(applicant && applicant.processStateId){
			// clone the node - true indicates deep cloning
			var newRow = instance.sampleApplicantRowNode.cloneNode(true);
			//newRow.one(instance.idApplicant).set('text',applicant.applicantId);
			newRow.one("#name").set('text',product.name);
			newRow.one("#status").set('text',product.status);
			newRow.one("#processStateId").val(product.processStateId);
			//TODO: onclick of this row, load applicant detail screen
			instance.applicantsNode.appendChild(newRow);
		}
	}
	this.init(config);
}